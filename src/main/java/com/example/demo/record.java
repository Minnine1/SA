package com.example.demo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class record {
    private @GeneratedValue @Id
    Long id;

    public String idCustomer;
    private String flightTicket;
    private String name;
    public  String date;

    public record(Book_ticket b,String date) {
        this.idCustomer = b.idCustomer ;
        this.flightTicket=b.flightTicket;
        this.name=b.name;
        this.date=date;
    }


}
