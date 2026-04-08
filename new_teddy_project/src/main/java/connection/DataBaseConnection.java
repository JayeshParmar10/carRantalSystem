package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnection {

	public Connection getConnction() {
		try {
			// Register the Driver class
			Class.forName("com.mysql.cj.jdbc.Driver");

			// create connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/teddyshop", "root",
					"Jayesh@1008");
			return con;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}