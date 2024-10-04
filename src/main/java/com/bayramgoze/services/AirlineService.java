package com.bayramgoze.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bayramgoze.entites.Airline;
import com.bayramgoze.entites.Airport;
import com.bayramgoze.repository.AirlineRepository;

//@Service
//public class AirlineService {
//	@Autowired
//	private AirlineRepository airlineRepository;
//	
//	public Airline addAirline(Airline airline) {
//		return airlineRepository.save(airline);
//	}
//	
//	public List<Airline>getAllAirlines(){return airlineRepository.findAll();
//	}
//	public Airline getAirlineById(Long id) { return airlineRepository.findById(id).orElseThrow();
//	}
//	
//	 public List<Airline> searchAirlinesByName(String name) {
//	        return airlineRepository.findByNameContainingIgnoreCase(name);
//	    }
@Service
public class AirlineService {
    @Autowired
    private AirlineRepository airlineRepository;

    public Airline addAirline(Airline airline) {
        return airlineRepository.save(airline);
    }

    public List<Airline> getAllAirlines() {
        return airlineRepository.findAll();
    }

    public Airline getAirlineById(Long id) {
        return airlineRepository.findById(id)
            .orElseThrow();
    }

    public List<Airline> searchAirlinesByName(String name) {
        return airlineRepository.findByNameContainingIgnoreCase(name);
    }
//    public List<Airline> searchAirlinesByCode(String code) {
//        return airlineRepository.findByNameContainingIgnoreCase(code);
//    }
    public Optional<Airline> getAirlineByCode(String code) {
        return airlineRepository.findByCode(code);
    }
 // Havayolu sil
    public void deleteAirline(Long id) {
        airlineRepository.deleteById(id);
    }
    //Havayolu güncelle
    public Airline UpdateAirline(Long id, Airline airline) {
    	 Optional<Airline> airlineData = airlineRepository.findById(id);
    	 
    	 if(airlineData.isPresent()) {
    		 Airline existingAirline = airlineData.get();	
    		existingAirline.setName(airline.getName());
    		existingAirline.setCode(airline.getCode());	    		
    		return airlineRepository.save(existingAirline);
    	 }
    	 
    	 return null;
    	 
    }
}
