package com.example.demo.repositories;

import com.example.demo.entities.Purchase;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Set;

public interface PurchaseRepository extends Repository<Purchase, Long> {
    List<Purchase> findByIdIn(Set<Long> ids);
}
