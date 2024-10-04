package com.bayramgoze.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bayramgoze.entites.Route;
import com.bayramgoze.model.RouteDto;
import com.bayramgoze.model.SearchRouteDto;
import com.bayramgoze.services.RouteService;

import java.util.List;

@RestController
@RequestMapping("/routes")
public class RouteController {

    @Autowired
    private RouteService routeService;

    // Rota ekleme (POST isteği)
    @PostMapping
    public ResponseEntity<Route> addRoute(@RequestBody RouteDto routeDto) {
        Route route = routeService.addRoute(routeDto);
        return ResponseEntity.ok(route);
    }

    // Rota arama (POST)
    @PostMapping("/searchRoute")
    public ResponseEntity<List<Route>> searchRoute(@RequestBody SearchRouteDto searchRouteDto) {
        List<Route> routes = routeService.searchRoute(searchRouteDto);
        if (routes.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(routes);
        }
    }
}
