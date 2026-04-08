package new_teddy_project.userfile;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ContactServlet")
public class ContactServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String subject = request.getParameter("subject");
		String message = request.getParameter("message");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/teddyshop", "root",
					"Jayesh@1008");

			PreparedStatement ps = con
					.prepareStatement("INSERT INTO contact_us (name, email, subject, message) VALUES (?,?,?,?)");

			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, subject);
			ps.setString(4, message);

			int rows = ps.executeUpdate();

			PrintWriter out = response.getWriter();
			response.setContentType("text/html");

			if (rows > 0) {
				response.sendRedirect("contact.jsp?success=true");
				
				
			} else {
				response.sendRedirect("contact.jsp?error=true");
			}
			ps.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace(); // IMPORTANT: never leave catch empty
		}
	}
}