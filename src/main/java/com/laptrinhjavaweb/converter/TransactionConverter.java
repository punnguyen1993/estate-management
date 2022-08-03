package com.laptrinhjavaweb.converter;

import com.laptrinhjavaweb.dto.TransactionDTO;
import com.laptrinhjavaweb.entity.TransactionEntity;
import com.laptrinhjavaweb.repository.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TransactionConverter {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CustomerRepository customerRepository;

    public TransactionDTO convertEntityToDto(TransactionEntity transactionEntity){
        return modelMapper.map(transactionEntity, TransactionDTO.class);
    }
    public TransactionEntity convertDtoToEntity(TransactionDTO transactionDTO){
        TransactionEntity entity = modelMapper.map(transactionDTO, TransactionEntity.class);
        entity.setCustomer(customerRepository.getOne(transactionDTO.getCustomerId()));
        return entity;
    }
}
