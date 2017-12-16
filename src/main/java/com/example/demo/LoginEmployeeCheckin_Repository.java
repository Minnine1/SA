package com.example.demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface LoginEmployeeCheckin_Repository extends CrudRepository<LoginEmployeeCheckin,Long> {
    LoginEmployeeCheckin findByEmployeeIDAndPassword(
            @Param("employeeID") String employeeID,
            @Param("password") String password
    );
}
