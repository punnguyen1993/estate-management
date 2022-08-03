package com.laptrinhjavaweb.converter;

import com.laptrinhjavaweb.builder.CustomerSearchBuilder;
import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.entity.CustomerEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerConverter {
    @Autowired
    private ModelMapper modelMapper;


    public CustomerDTO convertEntityToDto(CustomerEntity customerEntity){
        CustomerDTO result = modelMapper.map(customerEntity, CustomerDTO.class);
        return result;
    }

    public CustomerEntity convertDtoToEntity(CustomerDTO customerDTO){
        CustomerEntity result = modelMapper.map(customerDTO, CustomerEntity.class);
        return result;
    }

    public CustomerSearchBuilder convertDTOToBuilder(CustomerDTO customerDTO) {
        CustomerSearchBuilder builder = new CustomerSearchBuilder.Builder()
                .setStaffId(customerDTO.getStaffId())
                .setNote(customerDTO.getNote())
                .setPhone(customerDTO.getPhone())
                .setFullName(customerDTO.getFullName())
                .setEmail(customerDTO.getEmail())
                .setDemand(customerDTO.getDemand())
                .setCompanyName(customerDTO.getCompanyName())
                .build();
        return builder;
    }
}
