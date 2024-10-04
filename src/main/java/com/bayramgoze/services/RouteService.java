package com.bayramgoze.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bayramgoze.entites.Airport;
import com.bayramgoze.entites.Route;
import com.bayramgoze.model.RouteDto;
import com.bayramgoze.model.SearchRouteDto;
import com.bayramgoze.repository.AirportRepository;
import com.bayramgoze.repository.RouteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RouteService {

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private AirportRepository airportRepository;

    // Yeni rota ekleme metodu
    public Route addRoute(RouteDto routeDto) {
        Optional<Airport> sourceAirport = airportRepository.findById(routeDto.getSourceAirportId());
        Optional<Airport> destinationAirport = airportRepository.findById(routeDto.getDestinationAirportId());
                

        Route route = new Route();
        route.setSourceAirport(sourceAirport.get());
        route.setDestinationAirport(destinationAirport.get());
        route.setDistance(routeDto.getDistance());

        return routeRepository.save(route);
    }

    // İki havaalanına göre rota arama metodu
    public List<Route> searchRoute(SearchRouteDto searchRouteDto) {
    	
        Optional<Airport> sourceAirport = airportRepository.findById(searchRouteDto.getSourceAirportId());
               
        Optional<Airport> destinationAirport = airportRepository.findById(searchRouteDto.getDestinationAirportId());

        return routeRepository.findBySourceAirportAndDestinationAirport(sourceAirport.get().getName(), destinationAirport.get().getName());
    }
}
