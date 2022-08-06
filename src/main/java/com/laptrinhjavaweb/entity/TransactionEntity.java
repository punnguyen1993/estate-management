package com.laptrinhjavaweb.entity;

import javax.persistence.*;

@Entity
@Table(name = "transaction")
public class TransactionEntity extends BaseEntity{

    private static final long serialVersionUID = 9211022828115142019L;


    private String note;
    private String code;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customerid", nullable = false)
    private CustomerEntity customer;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "typeid", nullable = false)
//    private TransactionTypeEntity type;
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "staffid", nullable = false)
//    private UserEntity user;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

}
