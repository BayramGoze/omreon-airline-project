package com.bayramgoze.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bayramgoze.entites.Ticket;
import com.bayramgoze.model.TicketDto;
import com.bayramgoze.services.TicketService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/tickets")
public class TicketController {
	 	@Autowired
	    private TicketService ticketService;
	 
	 @PostMapping("/purchase")
	 public Ticket purchaseTicket(@RequestBody TicketDto ticketDto) {
	        return ticketService.purchaseTicket(ticketDto);
	    }
	 
	 @PutMapping("/cancelTicket/{pnrNumber}")
	 public Ticket cancelTicket(@PathVariable String pnrNumber) {
		 return ticketService.cancelTicket(pnrNumber);
	 }
	 
	 @GetMapping("/getTicketByPnrNumber/{pnrNumber}")
	 public Ticket getTicketByPnrNumber(@PathVariable String pnrNumber) {
		 return ticketService.getTicketByPnrNumber(pnrNumber);
	 }
}
