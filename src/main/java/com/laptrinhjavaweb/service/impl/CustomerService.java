package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.builder.CustomerSearchBuilder;
import com.laptrinhjavaweb.converter.CustomerConverter;
import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.dto.request.AssginStaffsOfCustomerRequest;
import com.laptrinhjavaweb.dto.request.DeleteRequest;
import com.laptrinhjavaweb.entity.CustomerEntity;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.repository.CustomerRepository;
import com.laptrinhjavaweb.repository.UserRepository;
import com.laptrinhjavaweb.security.utils.SecurityUtils;
import com.laptrinhjavaweb.service.ICustomerService;
import com.laptrinhjavaweb.utils.ValidateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerConverter customerConverter;
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<CustomerDTO> findAll(Pageable pageable) {
        Page<CustomerEntity> pageableCustomer;
        if(userHasRoleStaff()){
            pageableCustomer = customerRepository.findByUsers_Id(SecurityUtils.getPrincipal().getId(), pageable);
        }else {
            pageableCustomer = customerRepository.findAll(pageable);
        }

        List<CustomerEntity> customerEntities = pageableCustomer.getContent();
        List<CustomerDTO> result = new ArrayList<>();
        if(ValidateUtils.isValid(customerEntities)){
            for(CustomerEntity item: customerEntities){
                CustomerDTO customerDTO = customerConverter.convertEntityToDto(item);
                customerDTO.setStaffName(getStaffNames(userRepository.findByCustomers(item)));
                result.add(customerDTO);
            }
        }
        return result;
    }

    public List<CustomerDTO> findAll(){
        return null;
    }


    @Override
    public CustomerDTO findById(Long id){
        return customerConverter.convertEntityToDto(customerRepository.findById(id).orElse(null));
    }


    @Override
    public List<CustomerDTO> findByDetail(CustomerDTO customerDTO, Pageable pageable) {
        if(userHasRoleStaff()){
            customerDTO.setStaffId(SecurityUtils.getPrincipal().getId());
        }
        List<CustomerDTO> results = new ArrayList<>();
        CustomerSearchBuilder builder = customerConverter.convertDTOToBuilder(customerDTO);

        Integer firstResult = (int) pageable.getOffset();
        Integer maxResult = pageable.getPageSize();

        List<CustomerEntity> customerEntities = customerRepository.findByDetail(builder, firstResult, maxResult);
        customerEntities.forEach(customerEntity -> {
            CustomerDTO result = customerConverter.convertEntityToDto(customerEntity);
            result.setStaffName(getStaffNames(userRepository.findByCustomers(customerEntity)));
            results.add(result);
        });
        return results;
    }

    @Override
    public int countTotalSearchingItem(CustomerDTO customerDTO) {
        CustomerSearchBuilder builder = customerConverter.convertDTOToBuilder(customerDTO);
        int totalItems = customerRepository.countTotalDetailItems(builder);
        return totalItems;
    }

    @Override
    public int countAll() {
        int totalItems;
        if (userHasRoleStaff()) {
            Long staffId = SecurityUtils.getPrincipal().getId();
            totalItems = (customerRepository.countByUsers_Id(staffId));
        }else {
            totalItems = (int) customerRepository.count();
        }
        return totalItems;
    }


    @Override
    @Transactional
    public void save(CustomerDTO customerDTO, Long customerId) {
        CustomerEntity customer = customerConverter.convertDtoToEntity(customerDTO);
        if(customerId != null){
            customer.setUsers(new HashSet<>(userRepository.findByCustomers(customer)));
        }
        customerRepository.save(customer);
    }

    private String getStaffNames(List<UserEntity> userEntities) {
        StringBuilder names = new StringBuilder();
        if(ValidateUtils.isValid(userEntities)){
            for(UserEntity item: userEntities){
                if(names.length() > 1){
                    names.append(", ");
                }
                names.append(item.getFullName());
            }
            return names.toString();
        }
        return null;
    }

    @Override
    @Transactional
    public void assignStaffsForCustomer(AssginStaffsOfCustomerRequest request) {
        if(validateAssignmentCustomerRequest(request)){
            Optional<CustomerEntity> entity = customerRepository.findById(request.getCustomerId());
            if(entity.isPresent()){
                entity.get().setUsers(new HashSet<>(userRepository.findAllById(Arrays.asList(request.getStaffIds()))));
                customerRepository.saveAndFlush(entity.get());
            }
        }
    }

    private boolean validateAssignmentCustomerRequest(AssginStaffsOfCustomerRequest request) {
        return ValidateUtils.isValid(request.getCustomerId())
                /*&& ValidateUtils.isValid(Arrays.asList(request.getStaffIds()))*/;
    }

    @Override
    @Transactional
    public void deleteByIdIn(DeleteRequest deleteBuildingRequest) {
        if(ValidateUtils.isValid(Arrays.asList(deleteBuildingRequest.getCustomerIds()))){
            customerRepository.deleteById_In(deleteBuildingRequest.getCustomerIds());
        }
    }

    private boolean userHasRoleStaff() {
        return SecurityUtils.getAuthorities().contains("ROLE_staff");
    }

    public boolean isManager(){
        return SecurityUtils.getAuthorities().contains("ROLE_manager");
    }

}
