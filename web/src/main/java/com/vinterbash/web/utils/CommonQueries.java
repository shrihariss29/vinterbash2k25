package com.vinterbash.web.utils;

public class CommonQueries {
	public static String INSERT_ORGANIZER =  "INSERT INTO organizers (organizer_id, ORGANIZER_NAME, password, year_of_passing, qualification, contact_number)\r\n"
			+ "VALUES (:organizerId, :organizerName, :password, :yearOfPassing, :qualification, :contactNumber);";
	public static String VALIDATE_ORGANIZER = "SELECT password FROM organizers WHERE organizer_id = :organizerId";
	public static String INSERT_RESULT = "INSERT INTO result ( schoolName, eventName, eventPlace, eventPoints) VALUES (:schoolName,:eventName,:eventPlace, :eventPoints)";
	public static String LEADERBOARD = "SELECT schoolName, eventName, eventPlace, eventPoints FROM result";
}
