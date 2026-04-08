package new_teddy_project.userfile;


import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/teddyshop",
                "root",
                "Jayesh@1008"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
		return null;
      }
}