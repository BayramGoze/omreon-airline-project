package com.bayramgoze.services;

import java.util.List;
import java.util.Optional;import org.hibernate.property.access.internal.PropertyAccessStrategyIndexBackRefImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bayramgoze.entites.Airport;
import com.bayramgoze.repository.AirportRepository;

@Service
public class AirportService {
	 
	@Autowired
	private  AirportRepository airportRepository;

	 
	    // Tüm havalimanlarını listele
	    public List<Airport> getAllAirports() {
	        return airportRepository.findAll();
	    }

	    // Havalimanı ekle
	    public Airport addAirport(Airport airport) {
	        return airportRepository.save(airport);
	    }

	    // Havalimanı bul
	    public Optional<Airport> getAirportById(Long id) {
	        return airportRepository.findById(id);
	    }
	    
	 // İsme göre havalimanı arama metodu
	    public List<Airport> getAirportsByName(String name) {
	        return airportRepository.findByNameContainingIgnoreCase(name);
	    }

	    // Havalimanı sil
	    public void deleteAirport(Long id) {
	        airportRepository.deleteById(id);
	    }
	    
	    //Havalimanı güncelle
	    public Airport UpdateAirport(Long id, Airport airport) {
	    	 Optional<Airport> airportData = airportRepository.findById(id);
	    	 
	    	 if(airportData.isPresent()) {
	    		Airport existingAirport = airportData.get();	
	    		existingAirport.setName(airport.getName());
	    		existingAirport.setCode(airport.getCode());	    		
	    		return airportRepository.save(existingAirport);
	    	 }
	    	 
	    	 return null;
	    	 
	    }
}
