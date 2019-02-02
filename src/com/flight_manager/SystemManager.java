package com.flight_manager;

import java.util.ArrayList;

/**
 * Represents System Manager for Flight Management System
 * 
 * @version 1.0
 * @author Ismail
 *
 */
public class SystemManager {
	/**
	 * List of airports
	 */
	private ArrayList<Airport> listOfAirports;
/**
 * List of flights
 */
	private ArrayList<Flight> listOfFlights;
	/**
	 * List of airlines
	 */
	private ArrayList<Airline> listOfAirlines;

	/**
	 * Constructor for System Manager
	 */
	public SystemManager() {

		listOfAirports = new ArrayList<Airport>();
		listOfFlights = new ArrayList<Flight>();
		listOfAirlines = new ArrayList<Airline>();

	}

	/**
	 * Method that creates airport
	 * @param name Name of the Airport
	 * @return Airport
	 */
	public Airport createAirport(String name) {

		Airport a = new Airport(name);

		if (checkAirportName(a.getName())) {
			listOfAirports.add(a);
			return a;
		}

		return null;

	}

	/**
	 * Method for creating airline
	 * @param name Name of the Airline
	 * @return
	 */
	public Airline createAirline(String name) {

		Airline a = new Airline(name);

		if (checkAirlineName(a.getName())) {
			listOfAirlines.add(a);
			return a;
		}

		return null;

	}

	/**
	 * Method for creating flight
	 * @param airline airline which owns the flight
	 * @param airport from which airport flight takes off
	 * @param name name of the flight
	 * @param origin city where it takes off from
	 * @param destination city where the flight is going
	 * @param id unique id
	 * @param numberOfSeatsPerRow
	 * @return
	 */
	public Flight createFlight(Airline airline, Airport airport, String name, String origin, String destination,
			Integer id, Integer numberOfSeatsPerRow) {

		if (checkFlightId(id)) {
			Flight f = new Flight(airline, airport, origin, destination, id);
			listOfFlights.add(f);
			createSeats(airline.getName(), id, numberOfSeatsPerRow);
			return f;
		}

		return null;

	}

	/**
	 * Method that creates seates for one flight
	 * @param airline airline which owns the flight
	 * @param flightID unique id
	 * @param numberOfSeatsPerRow
	 */
	private void createSeats(String airline, Integer flightID, Integer numberOfSeatsPerRow) {

		ArrayList<Seat> seats = null;

		Integer numberOfRows = 6;
		Integer currentSeat = 1;

		for (int i = 0; i < listOfFlights.size(); i++)
			if (flightID.equals(listOfFlights.get(i).getId()))
				seats = listOfFlights.get(i).getSeats();

		for (int i = 1; i <= numberOfRows; i++) {
			for (Integer k = 0; k < numberOfSeatsPerRow; k++) {

				switch (i) {
				case 1:
					seats.add(new Seat("A", currentSeat));
					currentSeat++;
					break;
				case 2:
					seats.add(new Seat("B", currentSeat));
					currentSeat++;
					break;
				case 3:
					seats.add(new Seat("C", currentSeat));
					currentSeat++;
					break;
				case 4:
					seats.add(new Seat("D", currentSeat));
					currentSeat++;
					break;
				case 5:
					seats.add(new Seat("E", currentSeat));
					currentSeat++;
					break;
				case 6:
					seats.add(new Seat("F", currentSeat));
					currentSeat++;
					break;
				}

			}
		}

	}

	/**
	 * 
	 * @param airline airline which owns the flight
	 * @param flightName name of the flight
	 * @param seatNumber number of the seat
	 * @param row row of the seat
	 * @return true-succesful, false-not succesful
	 */
	public boolean bookSeat(String airline, String flightName, int seatNumber, String row) {

		for (int i = 0; i < listOfFlights.size(); i++)
			if (listOfFlights.get(i).getAirline().getName().equals(airline))
				for (int k = 0; k < listOfFlights.get(i).getSeats().size(); k++)
					if (listOfFlights.get(i).getSeats().get(k).getSeatNumber().equals(seatNumber)) {
						listOfFlights.get(i).getSeats().get(k).setAvailable(false);
						return true;
					}

		return false;
	}

	/**
	 * Method that checks if passed airport name is valid and does not already exist
	 * @param airportName
	 * @return
	 */
	public boolean checkAirportName(String airportName) {

		if (airportName.length() != 3)
			return false;

		for (int i = 0; i < airportName.length(); i++)
			if (!Character.isLetter(airportName.charAt(i)))
				return false;

		for (int i = 0; i < listOfAirports.size(); i++) {
			if (listOfAirports.get(i).getName().equals(airportName))
				return false;
		}

		return true;

	}

	/**
	 * Method that checks if passed airline name is valid and does not already exist
	 * @param airportName
	 * @return
	 */
	public boolean checkAirlineName(String airlineName) {

		if (airlineName.length() > 5)
			return false;

		for (int i = 0; i < airlineName.length(); i++)
			if (!Character.isLetter(airlineName.charAt(i)))
				return false;

		for (int i = 0; i < listOfAirlines.size(); i++) {
			if (listOfAirlines.get(i).getName().equals(airlineName))
				return false;
		}

		return true;

	}

	/**
	 * Method that checks if passed flight id does not already exist
	 * @param airportName
	 * @return
	 */
	public boolean checkFlightId(Integer id) {

		for (int i = 0; i < listOfFlights.size(); i++) {
			if (id.equals(listOfFlights.get(i).getId()))
				return false;
		}

		return true;

	}

	/**
	 * Method that returns Airline object with passed airline name
	 * @param airportName
	 * @return
	 */
	public Airline getAirlineByName(String airplaneName) {

		for (int i = 0; i < listOfAirlines.size(); i++)
			if (listOfAirlines.get(i).getName().equals(airplaneName))
				return listOfAirlines.get(i);

		return null;

	}
/**
 * Method that returns Airport object with passed airport name
 * @param airportName
 * @return
 */
	public Airport getAirportByName(String airportName) {

		for (int i = 0; i < listOfAirports.size(); i++)
			if (listOfAirports.get(i).getName().equals(airportName))
				return listOfAirports.get(i);

		return null;

	}


@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	SystemManager other = (SystemManager) obj;
	if (listOfAirlines == null) {
		if (other.listOfAirlines != null)
			return false;
	} else if (!listOfAirlines.equals(other.listOfAirlines))
		return false;
	if (listOfAirports == null) {
		if (other.listOfAirports != null)
			return false;
	} else if (!listOfAirports.equals(other.listOfAirports))
		return false;
	if (listOfFlights == null) {
		if (other.listOfFlights != null)
			return false;
	} else if (!listOfFlights.equals(other.listOfFlights))
		return false;
	return true;
}
	
	

}
