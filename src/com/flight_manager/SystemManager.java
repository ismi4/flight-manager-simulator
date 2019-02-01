package com.flight_manager;

import java.util.ArrayList;
import java.util.List;

public class SystemManager {
	
	private ArrayList<Airport> listOfAirports;
	private ArrayList<Flight> listOfFlights;
	private ArrayList<Airline> listOfAirlines;
	
	public Airport createAirport(String name) {
		
		Airport a = new Airport(name);
		
		if(checkAirportName(a.getName())) {
			listOfAirports.add(a);
			return a;
		}
		
		return null;

	}
	
	public Airline createAirline(String name) {
		
		
		Airline a = new Airline(name);
		
		if(checkAirlineName(a.getName())) {
			listOfAirlines.add(a);
			return a;
		}
		
		return null;
		
	}
	
	public Flight createFlight(Airline airline, Airport airport, String name,String origin, String destination, Integer id, Integer numberOfSeatsPerRow) {
		
		Flight f = new Flight(airline, airport, origin, destination, id);
		
		if (checkFlightId(id)) {
			listOfFlights.add(f);
				return f;
		}
		
		return null;
		
	}
	
	public ArrayList<Seat> createSeats(String airline,Integer flightID, Integer numberOfSeatsPerRow) {
	
		Integer numberOfRows = 6;
		ArrayList<Seat> seats = new ArrayList<Seat>();
		
		Integer currentSeat = 1;
		
		for(int i = 1; i <= numberOfRows; i++) 
			for (Integer k = 0; k < numberOfSeatsPerRow; k++) {
				
				String currentRow = "";
				
				switch(i) {
				 case 1: currentRow += "A"; break;
				 case 2: currentRow += "B"; break;
				 case 3: currentRow += "C"; break;
				 case 4: currentRow += "D"; break;
				 case 5: currentRow += "E"; break;
				 case 6: currentRow += "F"; break;
				}
				
				seats.add(new Seat(currentRow, currentSeat));
				currentSeat++;
			}
		
		for (int i = 0; i < listOfFlights.size(); i++)
			if (flightID.equals(listOfFlights.get(i).getId())) 
				for (int k = 0; i < seats.size(); k++)
					listOfFlights.get(i).getSeats().add(seats.get(k));
				
		return seats;
				
		
		
		
	}
	
/*	public List<Flight> findAvailableFlights(String origin, String destination){
		// TODO implement
		return null;
	}*/
	
	public boolean bookSeat(String airline, String flightName,int seatNumber,String row) {
		
		for (int i = 0; i < listOfFlights.size(); i++) 
			if (listOfFlights.get(i).getAirline().equals(airline))
				for(int k = 0; k < listOfFlights.get(i).getSeats().size(); k++)
					if (listOfFlights.get(i).getSeats().get(k).getSeatNumber().equals(seatNumber) && listOfFlights.get(i).getSeats().get(k).getRow().equals(row) ) {
						listOfFlights.get(i).getSeats().get(k).setAvailable(false);
						return true;
					}
		
		return false;
	}
	
	
	private boolean checkAirportName(String airportName) {
		
		if (airportName.length() != 3)
			return false;
		
		for (int i = 0; i < 2; i++) 
			if (!Character.isLetter(airportName.charAt(i)))
				return false;
		
		for(int i = 0; i < listOfAirports.size(); i++) {
			if(listOfAirports.isEmpty())
				return true;
			else if (listOfAirports.get(i).getName().equals(airportName))
				return false;
		}
			
		return true;

	}
	
	private boolean checkAirlineName(String airlineName) {
		
		if (airlineName.length() > 5)
			return false;
		
		for (int i = 0; i < 2; i++) 
			if (!Character.isLetter(airlineName.charAt(i)))
				return false;
		
		for(int i = 0; i < listOfAirlines.size(); i++) {
			if (listOfAirlines.isEmpty())
				return true;
			else if (listOfAirlines.get(i).getName().equals(airlineName))
				return false;
		}
		
		return true;

	}
	
	private boolean checkFlightId(Integer id) {
		
		for (int i = 0; i < listOfFlights.size(); i++) {
			if (listOfFlights.isEmpty())
				return true;
			else if (id.equals(listOfFlights.get(i).getId()))
				return false;
		}
		
		return true;
		
	}
	
	public Airline getAirlineByName(String airplaneName) {
		
		for (int i = 0; i < listOfAirlines.size(); i++)
			if (listOfAirlines.get(i).getName().equals(airplaneName))
				return listOfAirlines.get(i);
		
		return null;
		
	}
	
	public Airport getAirportByName(String airportName) {
		
		for (int i = 0; i < listOfAirports.size(); i++)
			if (listOfAirports.get(i).getName().equals(airportName))
				return listOfAirports.get(i);
		
		return null;
		
	}

}
