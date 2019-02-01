package com.flight_manager;

import java.util.Scanner;

public class TestFlightManager {

	static SystemManager sysManager = new SystemManager();
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
	
		menu();

	}

	public static void menu() {

		System.out.println("-----------------WELCOME TO AIRPLANE MANAGER-----------------");
		System.out.println("1. CREATE AIRPORT");
		System.out.println("2. CREATE AIRLINE");
		System.out.println("3. CREATE FLIGHT");
		System.out.println("4. BOOK A SEAT ON FLIGHT");
		System.out.println("-------------------------------------------------------------");

		int option = unosIntegera();

		while (option != 1 && option != 2 && option != 3 && option != 4) {
			System.out.println("Please, enter a valid menu input!");
			option = unosIntegera();
		}

		switch (option) {

		case 1:
			createAirport();
			menu();
			break;
		case 2:
			createAirline();
			menu();
			break;
		case 3:
			createFlight();
			menu();
			break;
		case 4:
			bookSeatOnFlight();
			menu();
			break;

		}

	}

	public static boolean createAirport() {

		System.out.println("-----------------AIRPORT CREATION-----------------");
		System.out.println("ENTER AN AIRPORT NAME: (THREE LETTERS STRICTLY!)");

		if (!sysManager.createAirport(input.next()).equals(null)) {
			System.out.println("-------------------------------------------------------------");
			System.out.println("AIRPORT HAS BEEN SUCCESSFULLY CREATED.");

			return true;
		}

		System.out.println("-------------------------------------------------------------");
		System.out.println("WE HAVE ENCOUNTERED AN ISSUE DURING CREATION.");

		return false;

	}

	public static boolean createAirline() {

		System.out.println("-----------------AIRLINE CREATION-----------------");
		System.out.println("ENTER AN AIRLINE NAME: (SIX LETTERS MAXIMUM!)");

		if (!sysManager.createAirline(input.next()).equals(null)) {
			System.out.println("-------------------------------------------------------------");
			System.out.println("AIRLINE HAS BEEN SUCCESSFULLY CREATED.");
			return true;
		}

		System.out.println("-------------------------------------------------------------");
		System.out.println("WE HAVE ENCOUNTERED AN ISSUE DURING CREATION.");
		return false;

	}

	public static boolean createFlight() {

		System.out.println("-----------------FLIGHT CREATION-----------------");

		System.out.println("ENTER AN AIRLINE NAME: ");
		String airlineName = input.next();

		System.out.println("ENTER AN AIRPORT NAME: ");
		String airportName = input.next();

		System.out.println("ENTER A FLIGHT NAME: ");
		String flightName = input.nextLine();

		System.out.println("ENTER ORIGIN: ");
		String origin = input.nextLine();

		System.out.println("ENTER DESTINATION: ");
		String destination = input.nextLine();

		System.out.println("ENTER ID: ");
		Integer id = unosIntegera();

		System.out.println("ENTER NUMBER OF SEATS PER ROW: ");
		Integer numberOfSeatsPerRow = unosIntegera();

		if (!sysManager.createFlight(sysManager.getAirlineByName(airlineName), sysManager.getAirportByName(airportName),
				flightName, origin, destination, id, numberOfSeatsPerRow).equals(null)
				&& !sysManager.createSeats(airlineName, id, numberOfSeatsPerRow).equals(null)) {
			System.out.println("FLIGHT HAS BEEN SUCCESSFULLY CREATED.");
			return true;
		}
		System.out.println("WE HAVE ENCOUNTERED AN ISSUE DURING CREATION.");
		return false;
	}

	public static boolean bookSeatOnFlight() {

		System.out.println("-----------------BOOKING SEAT ON FLIGHT-----------------");

		System.out.println("ENTER AN AIRLINE NAME: ");
		String airlineName = input.next();

		System.out.println("ENTER A FLIGHT NAME: ");
		String flightName = input.nextLine();

		System.out.println("ENTER A SEAT NUMBER: ");
		Integer seatNumber = unosIntegera();

		System.out.println("ENTER A ROW: (A, B, C, D, E, F ");
		String row = new String(input.next());

		if (sysManager.bookSeat(airlineName, flightName, seatNumber, row)) {
			System.out.println("YOU HAVE SUCCESSFULLY BOOKED YOUR FLIGHT.");
			return true;
		}

		System.out.println("WE HAVE ENCOUNTERED AN ISSUE DURING CREATION.");
		return false;

	}

	public static int unosIntegera() {

		int uneseniBroj = 0;

		while (true)
			try {
				uneseniBroj = input.nextInt();
				break;
			} catch (Exception e) {
				System.out.println("Please, enter a valid input!");
				input.nextLine();
				continue;
			}

		return uneseniBroj;

	}

}
