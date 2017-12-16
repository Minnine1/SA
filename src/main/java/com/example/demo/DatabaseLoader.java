package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class DatabaseLoader implements CommandLineRunner {

//	private final EmployeeRepository repository;
//	private final UniversityRepository universityRepository;
    private final Book_ticket_Repository book_ticket_repository ;
    private final LoginEmployeeCheckin_Repository loginEmployeeCheckin_repository;
    private final Checkin_Repository checkinRepository;



//	@Autowired
//	public DatabaseLoader(EmployeeRepository repository,UniversityRepository universityRepository) {
//		this.repository = repository;
//		this.universityRepository = universityRepository;
//	}
    @Autowired
    public DatabaseLoader(Book_ticket_Repository bookTicketRepository, LoginEmployeeCheckin_Repository loginEmployeeCheckinRepository, Checkin_Repository checkinRepository){
	    this.book_ticket_repository = bookTicketRepository;
	    this.loginEmployeeCheckin_repository = loginEmployeeCheckinRepository;
        this.checkinRepository = checkinRepository;
    }
//
//	@Override
//	public void run(String... strings) throws Exception {
//		this.repository.save(new Employee("Frodo", "Baggins", "ring bearer"));
//		this.repository.save(new Employee("E min", "fools", "Suranaree"));
//
//		this.universityRepository.save(new University("Sunararee University"));
//		this.universityRepository.save(new University("Rangsit University"));
//	}

    @Override
    public void run(String... strings) throws Exception{


        Checkin checkin1 = new Checkin();
        checkin1.setTime(Timestamp.valueOf("2017-10-04 24:00:00"));
        checkin1.setDate(Timestamp.valueOf("2017-10-04 24:00:00"));
        checkin1.setDateandtimeoftravel(Timestamp.valueOf("2017-10-04 24:00:00"));
        checkin1.setBroadingpass("aaaaaa");

        this.checkinRepository.save(checkin1);



        LoginEmployeeCheckin loginEmployeeCheckin1 = new LoginEmployeeCheckin();
        loginEmployeeCheckin1.setCheckin(checkin1);
        loginEmployeeCheckin1.setEmployeeID("sssss");
        loginEmployeeCheckin1.setPassword("sssss");
        this.loginEmployeeCheckin_repository.save(loginEmployeeCheckin1);

        Book_ticket book_ticket1 = new Book_ticket();
        
        book_ticket1.setIdCustomer("customer1");
        book_ticket1.setFlightTicket("abc1");
        book_ticket1.setName("Justin Timberlake");
        book_ticket1.setTime(Timestamp.valueOf("2017-10-03 23:00:00"));
        book_ticket1.setPrice(1000);
        book_ticket1.setSeat("A3");
        book_ticket1.setDate(Timestamp.valueOf("2017-10-03 23:30:30"));
        book_ticket1.setCheckin(checkin1);

        book_ticket1.setDepart("Korat");
        book_ticket1.setArrive("Korea");
        book_ticket1.setFlightNumber("SA 699");
        book_ticket1.setDateandtimeoftravel(Timestamp.valueOf("2017-10-03 23:30:30"));
        book_ticket1.setSeat("-");
        book_ticket1.setGate("-");
        book_ticket1.setSequenceNumber("54");
        book_ticket1.setSave(true);
        this.book_ticket_repository.save(book_ticket1);
      

        Checkin checkin2 = new Checkin();
        checkin2.setTime(Timestamp.valueOf("2017-10-04 24:00:00"));
        checkin2.setDate(Timestamp.valueOf("2017-10-04 24:00:00"));
        checkin2.setDateandtimeoftravel(Timestamp.valueOf("2017-10-04 24:00:00"));
        checkin2.setBroadingpass("bbbbb");
        this.checkinRepository.save(checkin2);


        LoginEmployeeCheckin loginEmployeeCheckin2 = new LoginEmployeeCheckin();
        loginEmployeeCheckin2.setCheckin(checkin2);
        loginEmployeeCheckin2.setEmployeeID("aaaaa");
        loginEmployeeCheckin2.setPassword("aaaaa");
        this.loginEmployeeCheckin_repository.save(loginEmployeeCheckin2);

        Book_ticket book_ticket2 = new Book_ticket();
        
        book_ticket2.setIdCustomer("customer2");
        book_ticket2.setFlightTicket("abc2");
        book_ticket2.setName("Warintorn Sakonwong");
        book_ticket2.setTime(Timestamp.valueOf("2017-10-03 12:30:00"));
        book_ticket2.setPrice(1000);
        book_ticket2.setSeat("A4");
        book_ticket2.setDate(Timestamp.valueOf("2017-10-03 12:30:30"));
        book_ticket2.setCheckin(checkin2);

        book_ticket2.setDepart("Chonburi");
        book_ticket2.setArrive("Korat");
        book_ticket2.setFlightNumber("SA 444");
        book_ticket2.setDateandtimeoftravel(Timestamp.valueOf("2017-10-03 12:30:00"));
        book_ticket2.setSeat("4");
        book_ticket2.setGate("3");
        book_ticket2.setSequenceNumber("54");
        book_ticket2.setSave(true);

        this.book_ticket_repository.save(book_ticket2);

    }

}