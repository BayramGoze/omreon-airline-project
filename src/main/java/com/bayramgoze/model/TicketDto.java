package com.bayramgoze.model;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public class TicketDto {
	private Long flightId;
	private String passengerName;
	private String creditCardNumber;
	
	public String getCreditCardNumber() {return creditCardNumber; }
	
	public String getPassengerName() {return passengerName; }
	
	public void SetPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	
	public Long getFlightId() {
		return flightId;
	}
	
}
