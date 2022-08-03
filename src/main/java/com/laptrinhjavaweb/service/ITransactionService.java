package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.TransactionDTO;
import com.laptrinhjavaweb.dto.TransactionTypeDTO;

import java.util.List;
import java.util.Map;

public interface ITransactionService {
    List<TransactionTypeDTO> findByCustomerId(Long customerId);
    void addTransaction(TransactionDTO transactionDTO);
    Map<String, String> getRestTransactionTypes(List<TransactionTypeDTO> transactionTypes);
}
