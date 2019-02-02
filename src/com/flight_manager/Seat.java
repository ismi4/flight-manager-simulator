package com.flight_manager;

/**
 * Class that represents Seat
 * 
 * @version 1.0
 * @author Ismail
 *
 */
public class Seat {
	/**
	 * row ("A", "B", "C", "D", "E", "F")
	 */
	private String row;

	/**
	 * seat number ex. 1,5,16
	 */
	private Integer seatNumber;

	/**
	 * Status of the seat - available or not
	 */
	private boolean available;

	/**
	 * Constructor for Seat
	 * 
	 * @param row
	 * @param seatNumber
	 */
	public Seat(String row, Integer seatNumber) {
		this.row = row;
		this.seatNumber = seatNumber;
		this.available = true;
	}

	/**
	 * Getter for seat number
	 * 
	 * @return seat number
	 */
	public Integer getSeatNumber() {
		return seatNumber;
	}

	/**
	 * Setter for availability of the seat
	 * 
	 * @param available
	 */
	public void setAvailable(boolean available) {
		this.available = available;
	}

	/**
	 * Overriden toString method
	 */
	@Override
	public String toString() {
		return "Seat [row=" + row + ", seatNumber=" + seatNumber + ", available=" + available + "]";
	}

	@Override
	 public boolean equals(Object obj) {
	 if (this == obj)
	 return true;
	 if (obj == null)
	 return false;
	 if (getClass() != obj.getClass())
	 return false;
	 Seat other = (Seat) obj;
	 if (available != other.available)
	 return false;
	 if (row == null) {
	 if (other.row != null)
	 return false;
	 } else if (!row.equals(other.row))
	 return false;
	 if (seatNumber == null) {
	 if (other.seatNumber != null)
	 return false;
	 } else if (!seatNumber.equals(other.seatNumber))
	 return false;
	 return true;
	 }
}
