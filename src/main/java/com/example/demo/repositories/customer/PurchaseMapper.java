package com.example.demo.repositories.customer;

import com.example.demo.entities.Purchase;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PurchaseMapper implements RowMapper<Purchase> {
    @Override
    public Purchase mapRow(ResultSet rs, int rowNumber) throws SQLException {
        Purchase purchase = new Purchase();
        purchase.setId(rs.getLong("ID"));
        purchase.setProductId(rs.getLong("PRODUCT_ID"));
        return purchase;
    }
}
