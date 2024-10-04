package com.bayramgoze.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bayramgoze.entites.Airline;
import com.bayramgoze.entites.Airport;
import com.bayramgoze.services.AirportService;

@RestController
@RequestMapping("/airports")
public class AirportController {

	@Autowired
	private AirportService airportService;
	
	@PostMapping
	public Airport addAirport(@RequestBody Airport airport) {
		return airportService.addAirport(airport);
	}
	
	@GetMapping
	public List<Airport> GetAllAirports(){
		return airportService.getAllAirports();
	}
	
	// Id'ye göre havalimanı arama API'si
    @GetMapping("/{id}")
    public ResponseEntity<Airport> getAirportById(@PathVariable Long id) {
        Optional<Airport> airport = airportService.getAirportById(id);

        // Eğer havalimanı bulunamazsa, 404 dön
        return airport.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @GetMapping("/name/{name}")
    public ResponseEntity<List<Airport>> getAirportsByName(@PathVariable String name) {
        List<Airport> airports = airportService.getAirportsByName(name);

        if (airports.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(airports);
        }
    }
	
	@DeleteMapping("{id}")
	public void DeleteAirlineById(@PathVariable Long id) {
		airportService.deleteAirport(id);
	}
	
	@PutMapping("/{id}")
	public Airport UpdateAirport(@PathVariable Long id, @RequestBody Airport airport) {
		return airportService.UpdateAirport(id, airport);
	}
}
