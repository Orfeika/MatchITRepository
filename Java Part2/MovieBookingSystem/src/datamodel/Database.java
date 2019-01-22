package datamodel;

import java.awt.List;
import java.sql.*;
import java.util.ArrayList;

import org.omg.CORBA.PUBLIC_MEMBER;

import com.sun.javafx.webkit.ThemeClientImpl;

/**
 * Database is a class that specifies the interface to the movie database. Uses
 * JDBC and the MySQL Connector/J driver.
 */
public class Database {
	/**
	 * The database connection.
	 */
	private Connection conn;

	public Connection getConn() {
		return conn;
	}

	/**
	 * Create the database interface object. Connection to the database is performed
	 * later.
	 */
	public Database() {
		conn = null;
	}

	/**
	 * Open a connection to the database, using the specified user name and
	 * password.
	 *
	 * @param userName The user name.
	 * @param password The user's password.
	 * @return true if the connection succeeded, false if the supplied user name and
	 *         password were not recognized. Returns false also if the JDBC driver
	 *         isn't found.
	 */
	public boolean openConnection(String userName, String password) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Lab02", userName, password);
		} catch (SQLException e) {
			System.err.println(e);
			e.printStackTrace();
			return false;
		} catch (ClassNotFoundException e) {
			System.err.println(e);
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * Close the connection to the database.
	 */
	public void closeConnection() {
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		conn = null;

		System.err.println("Database connection closed.");
	}

	/**
	 * Check if the connection to the database has been established
	 *
	 * @return true if the connection has been established
	 */
	public boolean isConnected() {
		return conn != null;
	}

	public Show getShowData(String mTitle, String mDate) throws SQLException {
		Integer mFreeSeats = 0;
		String mVenue = " ";

		/* --- TODO: add code for database query --- */
		String sql = "select *" + "from Shows " + "where movieName = ? " + " and dateShow = ?";

		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, mTitle);
		ps.setString(2, mDate);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			mFreeSeats = rs.getInt("avaliableseats");
			mVenue = rs.getString("theaterName");
		}

		return new Show(mTitle, mDate, mVenue, mFreeSeats);
	}

	public ArrayList<String> getFilmNames() throws SQLException {
		String sql = "select moviename " + "from Shows" + " group by movieName";
		ArrayList<String> filmNames = new ArrayList<>();
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			filmNames.add(rs.getString("moviename"));
		}
		return filmNames;

	}

	public ArrayList<String> getFilmDates(String filmName) throws SQLException {
		ArrayList<String> datesList = new ArrayList<>();
		String sql = "select dateShow " + "from Shows " + "where movieName  =?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, filmName);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			datesList.add(rs.getString("dateShow"));
		}
		return datesList;

	}

	public boolean login(String uname) {
		String sql = "SELECT username " + " FROM Users " + " WHERE username = ?;";

		PreparedStatement ps;

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, uname);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	public boolean bookTicket(String movieName, String date, String user) throws SQLException {
		PreparedStatement countNbrOfRows;
		PreparedStatement selectSelectedShowID;
		PreparedStatement updateFreeSeats;
		PreparedStatement bookTicket;

		String countNumberOfRows = "Select count(*) as count " + "from  Reservations;";
		String selectShowID = "Select showID " + "from Shows " + " Where movieName = ? AND dateShow = ?";
		String updateShow = "update Shows " + "set avaliableSeats = avaliableSeats -1 " + "where movieName =? "
				+ "and dateShow = ?;";
		String ticketReservation = "Insert into Reservations " + "Values(?, ?, ?)";
		try {
			conn.setAutoCommit(false);
			countNbrOfRows = conn.prepareStatement(countNumberOfRows);
			ResultSet rs = countNbrOfRows.executeQuery();
			int reservationNMBR = -1;
			if (rs.next()) {
				reservationNMBR = rs.getInt("count");
			}

			selectSelectedShowID = conn.prepareStatement(selectShowID);
			selectSelectedShowID.setString(1, movieName);
			selectSelectedShowID.setString(2, date);
			rs = selectSelectedShowID.executeQuery();
			int showID  = -1;
			if (rs.next()) {
				 showID = rs.getInt("ShowID");
			}
			
			updateFreeSeats = conn.prepareStatement(updateShow);
			updateFreeSeats.setString(1, movieName);
			updateFreeSeats.setString(2, date);
			updateFreeSeats.executeUpdate();

			bookTicket = conn.prepareStatement(ticketReservation);
			String booking = generateBookingNumber(movieName, date, reservationNMBR);
			bookTicket.setString(1, booking);
			bookTicket.setString(2, user);
			bookTicket.setInt(3, showID);
			bookTicket.executeUpdate();
			conn.commit();
		} catch (SQLException e) {

			e.printStackTrace();
			return false;
		}

		return true;
	}

	private String generateBookingNumber(String movieName, String filmDate, int nmbr) {
		StringBuilder sb = new StringBuilder();
		sb.append(getFirstLetters(movieName));
		sb.append('-');
		sb.append(filmDate.replace("-", ""));
		sb.append('-');
		sb.append(nmbr);
		return sb.toString();

	}

	private String getFirstLetters(String text) {
		String firstLetters = "";
		text = text.replaceAll("[.,]", ""); // Replace dots, etc (optional)
		for (String s : text.split(" ")) {
			firstLetters += s.charAt(0);
		}
		return firstLetters;
	}

}
