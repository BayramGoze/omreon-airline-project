package com.bayramgoze.controller;

import java.nio.charset.CoderMalfunctionError;
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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.bayramgoze.entites.Airline;
import com.bayramgoze.entites.Airport;
import com.bayramgoze.services.AirlineService;

//@RestController
//@RequestMapping("/airlines")
//public class AirlineController {
//	
//@Autowired
//private AirlineService airlineService;
//
////havayolu şirketi ekle
//@PostMapping
//public Airline addAirline(@RequestBody Airline airline) {
//	return airlineService.addAirline(airline);
//}
//
//@GetMapping
//public List<Airline> getAllAirlines(){
//	return airlineService.getAllAirlines();
//}
//
//@GetMapping("/{id}")
//public Airline getAirlineById(@PathVariable Long id) {
//	return airlineService.getAirlineById(id);
//} 

@RestController
@RequestMapping("/airlines")
public class AirlineController {
    @Autowired
    private AirlineService airlineService;

    // Havayolu şirketi ekleme
    @PostMapping
    public ResponseEntity<Airline> addAirline(@RequestBody Airline airline) {
        Airline createdAirline = airlineService.addAirline(airline);
        return new ResponseEntity<>(createdAirline, HttpStatus.CREATED);
    }

    // Tüm havayolu şirketlerini listeleme
    @GetMapping
    public ResponseEntity<List<Airline>> getAllAirlines() {
        List<Airline> airlines = airlineService.getAllAirlines();
        return new ResponseEntity<>(airlines, HttpStatus.OK);
    }

    // ID'ye göre havayolu şirketi arama
    @GetMapping("/{id}")
    public ResponseEntity<Airline> getAirlineById(@PathVariable Long id) {
        Airline airline = airlineService.getAirlineById(id);
        return new ResponseEntity<>(airline, HttpStatus.OK);
    }

    // İsme göre havayolu şirketi arama
    @GetMapping("/search")
    public ResponseEntity<List<Airline>> searchAirlinesByName1(@RequestParam String name) {
        List<Airline> airlines = airlineService.searchAirlinesByName(name);
        return new ResponseEntity<>(airlines, HttpStatus.OK);
    }
 // Koda göre havayolu arama
    @GetMapping("/code/{code}")
    public ResponseEntity<Airline> getAirlineByCode(@PathVariable String code) {
        Optional<Airline> airline = airlineService.getAirlineByCode(code);

        // Eğer havayolu bulunamazsa, 404 dön
        return airline.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.notFound().build());
    }
    //havayolu silme
    @DeleteMapping("/{id}")
	public void DeleteAirlineById(@PathVariable Long id) {
		airlineService.deleteAirline(id);
	}
    @PutMapping("/{id}")
	public Airline updateAirline(@PathVariable Long id, @RequestBody Airline airline) {
		return airlineService.UpdateAirline(id, airline);
	}
	
}

