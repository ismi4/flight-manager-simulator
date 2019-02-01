package com.flight_manager_test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.flight_manager.Airline;
import com.flight_manager.Airport;
import com.flight_manager.Seat;
import com.flight_manager.SystemManager;

public class SystemManagerTest {

	SystemManager sysManagerTest;
	
	@Before
	public void setUp()  {
		sysManagerTest = new SystemManager();
	}

	@After
	public void tearDown()  {
		
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
		sysManagerTest.createFlight(airline, airport, "Test Flight", "Origin", "Destination", 1, 10);
		
		ArrayList<Seat> testList = new ArrayList<Seat>();
		ArrayList<Seat> seatsFromMethod = sysManagerTest.createSeats("ABC", 1, 1);
		
		boolean test = true;
		
		for (int i = 0; i < Math.min(testList.size(), seatsFromMethod.size()); i++ )
			if (!testList.get(i).equals(seatsFromMethod.get(i)))
					test = false;
		
		if (testList.size() != seatsFromMethod.size())
			test = false;
		
		assertTrue(test);
		
	}
	
	@Test
	public void bookSeat_seatDoesNotExist_returnsFalse() {
		
		Airport airport = sysManagerTest.createAirport("ABC");
		Airline airline = sysManagerTest.createAirline("ABC");
		sysManagerTest.createFlight(airline, airport, "Test Flight", "Origin", "Destination", 1, 10);
		
		assertFalse(sysManagerTest.bookSeat("ABC", "Test Flight", 10, "A"));
		
	}
	
	@Test
	public void bookSeat_seatExists_returnsTrue() {
		
		Airport airport = sysManagerTest.createAirport("ABC");
		Airline airline = sysManagerTest.createAirline("ABC");
		sysManagerTest.createFlight(airline, airport, "Test Flight", "Origin", "Destination", 1, 10);
		
		assertTrue(sysManagerTest.bookSeat("ABC", "Test Flight", 2, "A"));
		
	}

}
