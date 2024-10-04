package com.bayramgoze.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bayramgoze.entites.Airline;

@Repository
public interface AirlineRepository extends JpaRepository<Airline, Long> 
{ List<Airline> findByNameContainingIgnoreCase(String name);
Optional<Airline> findByCode(String code);
}

