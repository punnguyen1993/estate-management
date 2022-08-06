package com.laptrinhjavaweb.dto;


import java.util.ArrayList;
import java.util.List;

public class TransactionTypeDTO extends AbstractDTO {

    private static final long serialVersionUID = -1343170790975070602L;

    private String name;
    private String code;
    private List<TransactionDTO> transactionDTO = new ArrayList<>();
    private Long customerId;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TransactionDTO> getTransactionDTO() {
        return transactionDTO;
    }

    public void setTransactionDTO(List<TransactionDTO> transactionDTO) {
        this.transactionDTO = transactionDTO;
    }
}
