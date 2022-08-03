package com.laptrinhjavaweb.repository;

import com.laptrinhjavaweb.entity.CustomerEntity;
import com.laptrinhjavaweb.repository.custom.CustomerRepositoryCustom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository<CustomerEntity, Long>, CustomerRepositoryCustom {
    void deleteById_In(Long[] customerIds);

    Page<CustomerEntity> findByUsers_Id(Long id, Pageable pageable);
    int countByUsers_Id(Long userId);
}
