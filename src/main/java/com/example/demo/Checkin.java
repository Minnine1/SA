package com.example.demo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of={"id"})
public class Checkin {

    @Id @GeneratedValue(strategy= GenerationType.TABLE)
    Long id;
    @JsonFormat(pattern = "yyyy-mm-dd hh:mm:ss")
    private Timestamp date;
    @JsonFormat(pattern = "yyyy-mm-dd hh:mm:ss")
    private Timestamp time;
    @JsonFormat(pattern = "yyyy-mm-dd hh:mm:ss")
    private Timestamp dateandtimeoftravel;
    private String broadingpass;

    @OneToOne
    private Book_ticket book_ticket;
    
    
  
    public Checkin(Timestamp date, Timestamp time,Timestamp dateandtimeoftravel , String broadingpass , Book_ticket book_ticket ) {
        this.date = date;
        this.time = time;
        this.dateandtimeoftravel = dateandtimeoftravel;
        this.broadingpass = broadingpass;
        this.book_ticket = book_ticket;
        
    }

    @OneToMany(cascade = CascadeType.ALL ,mappedBy = "checkin",fetch = FetchType.LAZY)
    private Set<LoginEmployeeCheckin> loginEmployeeCheckinSet = new HashSet<>();
    
   


}