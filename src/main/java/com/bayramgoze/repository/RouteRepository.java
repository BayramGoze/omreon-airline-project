package com.bayramgoze.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bayramgoze.entites.Airport;
import com.bayramgoze.entites.Route;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {

    // Kaynak ve varış havaalanına göre rota arama
	@Query("SELECT r FROM Route r WHERE LOWER(r.sourceAirport.name) = LOWER(:sourceName) AND LOWER(r.destinationAirport.name) = LOWER(:destinationName)")
    List<Route> findBySourceAirportAndDestinationAirport(@Param("sourceName") String sourceAirportName, @Param("destinationName") String destinationAirportName);
}


   
   

