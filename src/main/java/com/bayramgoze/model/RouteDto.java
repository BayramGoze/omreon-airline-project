package com.bayramgoze.model;

public class RouteDto {
	 private Long sourceAirportId;
	 private Long destinationAirportId;
	 private double distance;
	 
	 
	    public Long getSourceAirportId() {
	        return sourceAirportId;
	    }

	    public void setSourceAirportId(Long sourceAirportId) {
	        this.sourceAirportId = sourceAirportId;
	    }

	    public Long getDestinationAirportId() {
	        return destinationAirportId;
	    }

	    public void setDestinationAirportId(Long destinationAirportId) {
	        this.destinationAirportId = destinationAirportId;
	    }

	    public double getDistance() {
	        return distance;
	    }

	    public void setDistance(double distance) {
	        this.distance = distance;
	    }
}
