package com.example.demo.repositories.customer;

import com.example.demo.entities.Customer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

class CustomerMapper implements RowMapper<Customer> {
    @Override
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Customer c = new Customer();
        c.setId(rs.getLong("ID"));
        c.setFirstName(rs.getString("FIRST_NAME"));
        c.setLastName(rs.getString("LAST_NAME"));
        return c;
    }
}
