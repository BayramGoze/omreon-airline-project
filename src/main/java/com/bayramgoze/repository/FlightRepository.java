package com.bayramgoze.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bayramgoze.entites.Airline;
import com.bayramgoze.entites.Flight;
import com.bayramgoze.entites.Ticket;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
	List<Flight> findByAirline(Airline airline); 
}
