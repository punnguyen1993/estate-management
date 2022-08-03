package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.dto.request.AssginStaffsOfCustomerRequest;
import com.laptrinhjavaweb.dto.request.DeleteRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    List<CustomerDTO> findAll();
    List<CustomerDTO> findAll(Pageable pageable);
    CustomerDTO findById(Long id);
    List<CustomerDTO> findByDetail(CustomerDTO customerDTO, Pageable pageable);
    void save(CustomerDTO customerDTO, Long customerId);
    void assignStaffsForCustomer(AssginStaffsOfCustomerRequest request);
    void deleteByIdIn(DeleteRequest deleteBuildingRequest);

    int countTotalSearchingItem(CustomerDTO customerDTO);
    int countAll();
}
