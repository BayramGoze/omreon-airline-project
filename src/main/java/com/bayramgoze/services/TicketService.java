package com.bayramgoze.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ETag;
import org.springframework.stereotype.Service;

import com.bayramgoze.entites.Flight;
import com.bayramgoze.entites.Ticket;
import com.bayramgoze.model.TicketDto;
import com.bayramgoze.repository.FlightRepository;
import com.bayramgoze.repository.TicketRepository;

@Service
public class TicketService {
@Autowired
private TicketRepository ticketRepository;
@Autowired
private FlightRepository flightRepository;

public Ticket purchaseTicket(TicketDto purchaseTicket) 
{ 
	Optional<Flight> flight= flightRepository.findById(purchaseTicket.getFlightId());
int soldTickets = flight.get().getSoldTickets();
if (soldTickets >= (flight.get().getCapacity() * 0.10) * ((soldTickets / (flight.get().getCapacity() * 0.10)) + 1)) {
    flight.get().setPrice(flight.get().getPrice() * 1.10); // %10 fiyat arttır
}
//Kartı maskele
String maskedCard = CreditCardUtils.maskCreditCard(purchaseTicket.getCreditCardNumber());

Ticket ticket = new Ticket();
ticket.setFlight(flight.get());
ticket.setPassengerName(purchaseTicket.getPassengerName());
ticket.setStatus(1);
ticket.setPnrNumber(TicketUtils.GeneratePnr());
ticket.setCreditCardNumber(maskedCard);

flight.get().setSoldTickets(flight.get().getSoldTickets() + 1); // Satılan bilet sayısını arttır
flightRepository.save(flight.get()); // Güncelle

return ticketRepository.save(ticket);
}

public Ticket cancelTicket(String pnrNumber) {
	Optional<Ticket> ticket = ticketRepository.findByPnrNumber(pnrNumber);
	if(ticket.isPresent()) {
		ticket.get().setStatus(0);
		return ticketRepository.save(ticket.get());	
	}	
	return null;
}

public Ticket getTicketByPnrNumber(String pnrNumber) {
	Optional<Ticket> ticket = ticketRepository.findByPnrNumber(pnrNumber);
	return ticket.get();
}

}
