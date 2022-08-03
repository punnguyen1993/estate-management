package com.laptrinhjavaweb.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "transactiontype")
public class TransactionTypeEntity extends BaseEntity{

    @Column(name = "name")
    private String name;
    @Column(name = "code")
    private String code;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
