package com.bayramgoze.repository;

import com.bayramgoze.entites.Airline;
import com.bayramgoze.entites.Airport;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends JpaRepository<Airport, Long> {
	List<Airport> findByNameContainingIgnoreCase(String name);
	Optional<Airport> findByCode(String code);
	}