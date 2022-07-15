package com.transactional;

import com.transactional.dto.FlightBookingAcknowledgment;
import com.transactional.dto.FlightBookingRequest;
import com.transactional.service.FlightBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication

@RestController
@EnableTransactionManagement
public class TransactionFlightApplication {


	@Autowired
	private FlightBookingService service;
@PostMapping("/bookingTickets")
	public FlightBookingAcknowledgment bookingTickets(@RequestBody FlightBookingRequest flightBookingRequest){
	return service.bookingFlightTicket(flightBookingRequest);

	}
	public static void main(String[] args) {
		SpringApplication.run(TransactionFlightApplication.class, args);
	}

}
