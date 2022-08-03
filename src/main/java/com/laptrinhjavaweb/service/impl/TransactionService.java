package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.converter.TransactionConverter;
import com.laptrinhjavaweb.dto.TransactionDTO;
import com.laptrinhjavaweb.dto.TransactionTypeDTO;
import com.laptrinhjavaweb.entity.TransactionEntity;
import com.laptrinhjavaweb.enums.TransactionTypeEnum;
import com.laptrinhjavaweb.repository.TransactionRepository;
import com.laptrinhjavaweb.service.ITransactionService;
import com.laptrinhjavaweb.utils.ValidateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TransactionService implements ITransactionService {
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private TransactionConverter converter;

    @Override
    @Transactional
    public void addTransaction(TransactionDTO transactionDTO) {
        TransactionEntity transactionEntity = converter.convertDtoToEntity(transactionDTO);
        transactionRepository.saveAndFlush(transactionEntity);
    }

    @Override
    public Map<String, String> getRestTransactionTypes(List<TransactionTypeDTO> transactionTypes) {
        Map<String, String> result = new HashMap<>();
        TransactionTypeEnum[] typeEnums = TransactionTypeEnum.values();

        for (TransactionTypeEnum item : typeEnums) {
            boolean isTypeExist = false;
            String typeName = item.getTypeValue();
            String typeCode = item.toString();
            if(transactionTypes != null && !transactionTypes.isEmpty()){
                for(TransactionTypeDTO typeDTO : transactionTypes){
                    if(typeDTO.getName().equals(typeName)){
                        isTypeExist = true;
                        break;
                    }
                }
            }
            if(isTypeExist) continue;
            result.put(typeCode, typeName);
        }
        return result;

    }

    @Override
    public List<TransactionTypeDTO> findByCustomerId(Long customerId) {
        if(ValidateUtils.isValid(customerId)){
            List<TransactionEntity> transactionEntities = transactionRepository.findByCustomer_Id(customerId);
            if(transactionEntities != null && transactionEntities.size() > 0){
                List<TransactionTypeDTO> typeDTOS = getTransactionTypes(transactionEntities);
                return typeDTOS;
            }
        }
        return null;
    }

    private List<TransactionTypeDTO> getTransactionTypes(List<TransactionEntity> transactionEntities) {
        List<TransactionTypeDTO> typeDTOS = new ArrayList<>();
        for(TransactionTypeEnum item : TransactionTypeEnum.values()){
            TransactionTypeDTO typeDTO = new TransactionTypeDTO();
            typeDTO.setName(item.getTypeValue());
            typeDTO.setCode(item.toString());

            List<TransactionDTO> dtos = new ArrayList<>();
            for(TransactionEntity entity : transactionEntities){
                //sau khi cua code, xoa cho nay di
                if(entity.getCode() == null){
                    continue;
                }
                if(entity.getCode().equals(item.toString())){
                    TransactionDTO dto = new TransactionDTO();
                    dto.setNote(entity.getNote());
                    dto.setCreatedDate(entity.getCreatedDate());
                    dto.setCustomerId(entity.getCustomer().getId());
                    dtos.add(dto);
                }
            }
            if(dtos.size() < 1){
                continue;
            }
            typeDTO.setTransactionDTO(dtos);
            typeDTOS.add(typeDTO);
        }
        return typeDTOS;
    }


}
