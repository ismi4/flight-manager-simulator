package com.flight_manager;

/**
 * Class that represents Airport
 * 
 * @version 1.0
 * @author Ismail
 *
 */
public class Airport {

	/**
	 * Name of the airport (can be max 3 letters length, cannot contain other
	 * characters than letters)
	 */
	private String name;

	/**
	 * Constructor for Airport
	 * 
	 * @param name Represents the name of the airport
	 * 
	 */
	public Airport(String name) {
		this.name = name;
	}

	/**
	 * Getter for Airport name
	 * 
	 * @return name of the Airport
	 */
	public String getName() {
		return name;
	}

	/**
	 * Overriden toString method
	 */
	@Override
	public String toString() {
		return "Airport [name=" + name + "]";
	}

}
