package com.laptrinhjavaweb.repository.custom;

import com.laptrinhjavaweb.builder.CustomerSearchBuilder;
import com.laptrinhjavaweb.entity.CustomerEntity;

import java.util.List;

public interface CustomerRepositoryCustom {
    List<CustomerEntity> findByDetail(CustomerSearchBuilder builder, int firstResult, int maxResult);
    int countTotalDetailItems(CustomerSearchBuilder builder);

}
