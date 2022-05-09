package com.example.demo.controllers;

import com.example.demo.entities.Purchase;
import com.example.demo.repositories.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
public class PurchaseController {
    PurchaseRepository purchaseRepository;

    @Autowired
    PurchaseController(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    @GetMapping("/purchases")
    List<Purchase> purchasesById(@RequestParam Set<Long> ids) {
        return purchaseRepository.findByIdIn(ids);
    }
}
