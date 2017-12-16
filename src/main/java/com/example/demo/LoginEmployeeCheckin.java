package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of={"id"})
public class LoginEmployeeCheckin {

    private @GeneratedValue(strategy= GenerationType.TABLE) @Id Long id;
    private String employeeID ;
    private String password;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "checkin")
    private Checkin checkin;



    public LoginEmployeeCheckin(String employee_id, String password) {
        this.employeeID = employee_id ;
        this.password = password;
    }

}
