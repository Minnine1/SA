package com.example.demo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of={"id"})
@Entity
public class Book_ticket {


    public @Id String idCustomer;
    public String flightTicket;
    public String name;
    @JsonFormat(pattern = "yyyy-mm-dd hh:mm:ss")
    private Timestamp time;
    private Integer price;
    @JsonFormat(pattern = "yyyy-mm-dd hh:mm:ss")
    private Timestamp date;

    private String depart;
    private String arrive;
    private String flightNumber;
    @JsonFormat(pattern = "yyyy-mm-dd hh:mm:ss")
    private Timestamp dateandtimeoftravel;
    private String gate;
    private String seat;
    private String sequenceNumber;
    private Boolean save;
   


    private
    @GeneratedValue Long id;

    @OneToOne
    private Checkin checkin;


    public Book_ticket(String idCustomer , String flightTicket , String name, Timestamp time, Integer price
                        , Timestamp date,String depart,String arrive,String flightNumber ,Timestamp dateandtimeoftravel
                        ,String gate,String seat,String sequenceNumber ,Boolean save) {

        this.idCustomer = idCustomer;
        this.flightTicket = flightTicket;
        this.name = name;
        this.time = time;
        this.price = price;
        this.date = date;

        this.depart = depart;
        this.arrive = arrive;
        this.flightNumber = flightNumber;
        this.dateandtimeoftravel = dateandtimeoftravel;
        this.gate = gate;
        this.seat = seat;
        this.sequenceNumber=sequenceNumber;
        this.save = save;


    }


}