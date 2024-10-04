package com.bayramgoze.model;

public class SearchRouteDto {
	 private Long sourceAirportId;
	 private Long destinationAirportId;
	 
	 
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
}
