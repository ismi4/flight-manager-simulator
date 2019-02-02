package com.flight_manager;

/**
 * Class that represents Airline
 * 
 * @version 1.0
 * @author Ismail
 *
 */
public class Airline {

	/**
	 * Name of the airline (can be max 5 letters length, cannot contain other
	 * characters than letters)
	 */
	private String name;

	/**
	 * Constructor for Airline
	 * 
	 * @param name Represents the name of the airline
	 * 
	 */
	public Airline(String name) {
		this.name = name;
	}

	/**
	 * Getter for Airline name
	 * 
	 * @return name of the Airline
	 */
	public String getName() {
		return name;
	}

	/**
	 * Overriden toString method
	 */
	@Override
	public String toString() {
		return "Airline [name=" + name + "]";
	}

}
