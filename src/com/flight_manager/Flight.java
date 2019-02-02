package com.flight_manager;

import java.util.ArrayList;

/**
 * Class that represents Flight
 * 
 * @version 1.0
 * @author Ismail
 *
 */
public class Flight {
	/**
	 * unique ID
	 */
	private Integer id;

	/**
	 * which airline owns this flight
	 */
	private Airline airline;

	/**
	 * from which airport flight takes of
	 */
	@SuppressWarnings("unused")
	private Airport airport;

	/**
	 * all seats in this flight
	 */
	private ArrayList<Seat> seats;

	/**
	 * city where it takes off from
	 */
	private String origin;

	/**
	 * city where the flight is going
	 */
	private String destination;

	/**
	 * Constructor for Flight
	 * 
	 * @param airline     which airline owns this flight
	 * @param airport     from which airport flight takes of
	 * @param origin      city wher it takes off
	 * @param destination city where the flight is going
	 * @param id          unique id
	 */
	public Flight(Airline airline, Airport airport, String origin, String destination, Integer id) {
		this.airline = airline;
		this.airport = airport;
		this.origin = origin;
		this.destination = destination;
		this.id = id;
		seats = new ArrayList<Seat>();

	}

	/**
	 * Getter for unique id
	 * 
	 * @return unique id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Getter for Airline which owns this flight
	 * 
	 * @return
	 */
	public Airline getAirline() {
		return airline;
	}

	/**
	 * Getter for seats on this flight
	 * 
	 * @return ArrayList of seats on this flight
	 */
	public ArrayList<Seat> getSeats() {
		return seats;
	}

	@Override
	public String toString() {
		return "Flight [id=" + id + ", airline=" + airline + ", seats=" + seats + ", origin=" + origin
				+ ", destination=" + destination + "]";
	}

}
