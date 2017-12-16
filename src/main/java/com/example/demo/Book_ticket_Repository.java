package com.example.demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface Book_ticket_Repository extends CrudRepository<Book_ticket, String > {
//   Book_ticket findById_customerAndFlight_ticket (
//           @Param("id_customer")String id_customer,
//           @Param("flight_ticket")String flight_ticket
//   );

    Book_ticket findByFlightTicketAndIdCustomer(
            @Param("flightTicket") String flightTicket,
            @Param("idCustomer") String idCustomer
    );
}

