package com.bayramgoze.entites;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Flight {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	
	private String flightNumber;
	
	private String departure;
	
	private String arrival;
	
	private double price;

    private int capacity;

    private int soldTickets;

    @ManyToOne
    @JoinColumn(name = "airline_id")
    private Airline airline;
    
    // Getter ve Setter
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getFlightNumber() { return flightNumber; }
    public void setFlightNumber(String flightNumber) { this.flightNumber = flightNumber; }
    
    public String getDeparture() { return departure; }
    public void setDeparture(String departure) { this.departure = departure; }
    
    public String getArrival() { return arrival; }
    public void setArrival(String arrival) { this.arrival = arrival; }
    
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public Airline getAirline() { return airline; }
    public void setAirline(Airline airline) { this.airline = airline; }
    
    public int getSoldTickets() { return this.soldTickets;};
    
    public int getCapacity() { return this.capacity; }
    	
    }

