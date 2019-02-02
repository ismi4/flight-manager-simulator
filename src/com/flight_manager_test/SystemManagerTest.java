package com.flight_manager_test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.flight_manager.Airline;
import com.flight_manager.Airport;
import com.flight_manager.Flight;
import com.flight_manager.Seat;
import com.flight_manager.SystemManager;

public class SystemManagerTest {

	SystemManager sysManagerTest;

	@Before
	public void setUp() {
		sysManagerTest = new SystemManager();
	}

	@After
	public void tearDown() {

	}

	@Test
	public void createAirport_nameIsInCorrectForm_returnsAirportObject() {

		String name = new String("ABC");
		assertNotNull(sysManagerTest.createAirport(name));

	}

	@Test
	public void createAirport_nameIsNotInCorrectForm_returnsNull() {

		String name = new String("ABCD");
		assertNull(sysManagerTest.createAirport(name));

	}

	@Test
	public void createAirline_nameIsInCorrectForm_returnsAirlineObject() {

		String name = new String("ABCD");
		assertNotNull(sysManagerTest.createAirline(name));

	}

	@Test
	public void createAirline_nameIsNotInCorrectForm_returnsNull() {

		String name = new String("ABCDEFGHIJK");
		assertNull(sysManagerTest.createAirline(name));

	}

	@Test
	public void createFlight_idAlreadyExists_returnsNull() {

		Airport airport = sysManagerTest.createAirport("ABC");
		Airline airline = sysManagerTest.createAirline("ABC");

		sysManagerTest.createFlight(airline, airport, "Test Flight", "Origin", "Destination", 1, 10);

		assertNull(sysManagerTest.createFlight(airline, airport, "Test Flight", "Origin", "Destination", 1, 10));

	}

	@Test
	public void createFlight_idDoesNotAlreadyExist_returnsFlightObject() {

		Airport airport = sysManagerTest.createAirport("ABC");
		Airline airline = sysManagerTest.createAirline("ABC");

		assertNotNull(sysManagerTest.createFlight(airline, airport, "Test Flight", "Origin", "Destination", 1, 10));

	}

	@Test
	public void createSeats_returnsListOfSeats() {

		Airport airport = sysManagerTest.createAirport("ABC");
		Airline airline = sysManagerTest.createAirline("ABC");
		Flight flight = sysManagerTest.createFlight(airline, airport, "Test Flight", "Origin", "Destination", 1, 1);

		ArrayList<Seat> testList = new ArrayList<Seat>();
		testList.add(new Seat("A", 1));
		testList.add(new Seat("B", 2));
		testList.add(new Seat("C", 3));
		testList.add(new Seat("D", 4));
		testList.add(new Seat("E", 5));
		testList.add(new Seat("F", 6));

		ArrayList<Seat> seatsFromMethod = flight.getSeats();

		boolean test = true;

		for (int i = 0; i < testList.size(); i++)
			if (!testList.get(i).equals(seatsFromMethod.get(i)))
				test = false;

		if (testList.size() != seatsFromMethod.size())
			test = false;

		assertTrue(test);

	}

	@Test
	public void bookSeat_seatDoesNotExist_returnsTrue() {

		Airport airport = sysManagerTest.createAirport("ABC");
		Airline airline = sysManagerTest.createAirline("ABC");
		sysManagerTest.createFlight(airline, airport, "Test Flight", "Origin", "Destination", 1, 10);

		assertFalse(sysManagerTest.bookSeat("ABC", "Test Flight", 100, "A"));

	}

	@Test
	public void bookSeat_seatExists_returnsTrue() {

		Airport airport = sysManagerTest.createAirport("ABC");
		Airline airline = sysManagerTest.createAirline("ABC");
		sysManagerTest.createFlight(airline, airport, "Test Flight", "Origin", "Destination", 1, 10);

		assertTrue(sysManagerTest.bookSeat("ABC", "Test Flight", 1, "A"));

	}

	@Test
	public void checkAirportName_nameIsValid_returnTrue() {

		assertTrue(sysManagerTest.checkAirportName("ABC"));

	}

	@Test
	public void checkAirportName_nameIsNotValid_moreLetters_returnFalse() {

		assertFalse(sysManagerTest.checkAirportName("ABCD"));

	}

	@Test
	public void checkAirportName_nameIsNotValid_digitInName_returnFalse() {

		assertFalse(sysManagerTest.checkAirportName("AB1"));

	}

	@Test
	public void checkAirportName_nameIsNotValid_nameAlreadyExists_returnFalse() {

		sysManagerTest.createAirport("ABC");
		assertFalse(sysManagerTest.checkAirportName("ABC"));

	}

	@Test
	public void checkAirlineName_nameIsValid_returnTrue() {

		assertTrue(sysManagerTest.checkAirlineName("ABCDE"));

	}

	@Test
	public void checkAirlineName_nameIsNotValid_moreLetters_returnFalse() {

		assertFalse(sysManagerTest.checkAirlineName("ABCDEFG"));

	}

	@Test
	public void checkAirlineName_nameIsNotValid_digitInName_returnFalse() {

		assertFalse(sysManagerTest.checkAirlineName("ABCD2"));

	}

	@Test
	public void checkAirlineName_nameAlreadyExists_digitInName_returnFalse() {

		sysManagerTest.createAirline("ABC");
		assertFalse(sysManagerTest.checkAirlineName("ABC"));

	}

	@Test
	public void checkFlightId_flightAlreadyExists_returnFalse() {

		Airport airport = sysManagerTest.createAirport("ABC");
		Airline airline = sysManagerTest.createAirline("ABC");
		Flight flight = sysManagerTest.createFlight(airline, airport, "Test Flight", "Origin", "Destination", 1, 10);

		assertFalse(sysManagerTest.checkFlightId(flight.getId()));
	}

	@Test
	public void checkFlightId_flightDoesNotAlreadyExists_returnTrue() {
		
		assertTrue(sysManagerTest.checkFlightId(1));

	}

	@Test
	public void getAirlineByName_airlineExists_returnsAirline() {
		Airline airline = sysManagerTest.createAirline("ABC");
		assertEquals(airline, sysManagerTest.getAirlineByName("ABC"));
	}

	@Test
	public void getAirlineByName_airlineDoesNotExist_returnsNull() {
		assertEquals(null, sysManagerTest.getAirlineByName("ABC"));
	}

	@Test
	public void getAirportByName_airportExists_returnsAirport() {

		Airport airport = sysManagerTest.createAirport("ABC");
		assertEquals(airport, sysManagerTest.getAirportByName("ABC"));

	}

	@Test
	public void getAirportByName_airportDoesNotExist_returnsNull() {
		assertEquals(null, sysManagerTest.getAirportByName("ABC"));
	}

}
