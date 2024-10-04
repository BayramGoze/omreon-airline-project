package com.bayramgoze.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bayramgoze.entites.Airline;
import com.bayramgoze.entites.Flight;
import com.bayramgoze.repository.AirlineRepository;
import com.bayramgoze.repository.FlightRepository;

@RestController
@RequestMapping("/flights")
public class FlightController {
	 @Autowired
	    private AirlineRepository airlineRepository;

	    @Autowired
	    private FlightRepository flightRepository;

	    // Havayolu şirketine yeni bir uçuş ekleme
	    @PostMapping("/addFlightToAirline/{airlineId}")
	    public Flight addFlightToAirline(@PathVariable Long airlineId,  @RequestBody Flight flight) {
	        Optional<Airline> airline = airlineRepository.findById(airlineId);

	        flight.setAirline(airline.get());
	        return flightRepository.save(flight);
	    }

	    // Havayolu şirketine ait tüm uçuşları getirme
	    @GetMapping("/getFlightsByAirline/{airlineId}")
	    public List<Flight> getFlightsByAirline(@PathVariable Long airlineId) {
	    	Optional<Airline> airline = airlineRepository.findById(airlineId);   
	        
	        return flightRepository.findByAirline(airline.get());
	    }
}
