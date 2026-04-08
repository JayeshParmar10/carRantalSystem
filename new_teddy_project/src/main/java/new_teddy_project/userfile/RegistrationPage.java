package new_teddy_project.userfile;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import connection.DataBaseConnection;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/RegistrationPage")
public class RegistrationPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegistrationPage() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		String full_name = request.getParameter("full_name");
		String email_address = request.getParameter("email_address");
		String user_password = request.getParameter("user_password");
		String confrm_password = request.getParameter("confrm_password");
		String phone_number = request.getParameter("phone_number");

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/teddyshop", "root",
					"Jayesh@1008");

			PreparedStatement preparedstatement = con.prepareStatement(
					"INSERT INTO teddyshop.user (full_name, email_address, user_password, confrm_password, phone_number)"
							+ " Values(?, ?,?,?,?)");
			preparedstatement.setString(1, full_name);
			preparedstatement.setString(2, email_address);
			preparedstatement.setString(3, user_password);
			preparedstatement.setString(4, confrm_password);
			preparedstatement.setString(5, phone_number);

			int count = preparedstatement.executeUpdate();
			if (count > 0) {

				HttpSession session = request.getSession();
				session.setAttribute("username", username);
				session.setAttribute("password", password);

				DataBaseConnection dbconnection = new DataBaseConnection();
				Connection consession = dbconnection.getConnction();

				PreparedStatement psSession = consession.prepareStatement("INSERT INTO teddyshop.session_tracking "
						+ "(session_id, create_time, last_access_time, action, email) VALUES (?,?,?,?,?)");

				psSession.setString(1, session.getId());
				psSession.setString(2, String.valueOf(session.getCreationTime()));
				psSession.setString(3, String.valueOf(session.getLastAccessedTime()));
				psSession.setString(4, "Registration");
				psSession.setString(5, email_address);

				psSession.executeUpdate();

				response.setContentType("text/html");
				out.println("<h2 style = 'color:Green'>User Registration Successfully</h2>");

				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.include(request, response);
			} else {
				response.setContentType("text/html");
				out.println("<h2 style = 'color:red'>User Not Registration Successfully</h2>");

				RequestDispatcher rd = request.getRequestDispatcher("registration.jsp");
				rd.include(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();

			response.setContentType("text/html");
			out.println("<h2 style = 'color:red'>Error " + e.getMessage() + "</h2>");

		}
	}

}
