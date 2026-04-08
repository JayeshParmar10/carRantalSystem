package new_teddy_project.userfile;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connection.DataBaseConnection;

@WebServlet("/LoginPage")
public class LoginPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginPage() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		// cookies
		// Cookie ck=new Cookie("name",username);

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/teddyshop", "root",
					"Jayesh@1008");

			PreparedStatement preparedstatement = con
					.prepareStatement("SELECT * FROM teddyshop.user where email_address=? and user_password = ?");
			preparedstatement.setString(1, username);
			preparedstatement.setString(2, password);

			ResultSet result = preparedstatement.executeQuery();
			PrintWriter print = response.getWriter();

			if (result.next()) {

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
				psSession.setString(4, "login");
				psSession.setString(5, username);

				// session.setAttribute("session_name",result.getString("full_name"));
				// response.setContentType("text/html");

				psSession.executeUpdate();

				/*
				 * HttpSession session = request.getSession(); session.setAttribute("username",
				 * username); session.setAttribute("password", password);
				 * 
				 * DataBaseConnection dbconnection = new DataBaseConnection(); Connection
				 * consession = dbconnection.getConnction();
				 * 
				 * PreparedStatement psSession = consession.prepareStatement(
				 * "INSERT INTO teddyshop.session_tracking " +
				 * "(session_id, create_time, last_access_time, action, email) VALUES (?,?,?,?,?)"
				 * );
				 * 
				 * psSession.setString(1, session.getId()); psSession.setString(2,
				 * String.valueOf(session.getCreationTime())); psSession.setString(3,
				 * String.valueOf(session.getLastAccessedTime())); psSession.setString(4,
				 * "Login"); psSession.setString(5, username);
				 */

				psSession.executeUpdate();

				RequestDispatcher rd = request.getRequestDispatcher("/homepage.jsp");
				rd.include(request, response);

				// cookies
//				print.print("Welcome "+username);
//				response.addCookie(ck);

			} else {
				response.setContentType("text/html");
				print.println("<h2 style = 'color:red'> Invailid Your Email and Password</h2>");

				RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
				rd.include(request, response);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		response.getWriter().append(("  "));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/teddyshop", "root",
					"Jayesh@1008");

			PreparedStatement ps = con.prepareStatement("SELECT * FROM user WHERE email_address=? AND user_password=?");

			ps.setString(1, username);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				HttpSession session = request.getSession();

				session.setAttribute("sessionLoginId", rs.getInt("id"));
				session.setAttribute("session_name", rs.getString("full_name"));
				session.setAttribute("username", username);

				/* ADMIN LOGIN */

				if (username.equals("admin@gmail.com") && password.equals("admin")) {

					response.sendRedirect("admin.jsp");

				} else {

					response.sendRedirect("homepage.jsp");

				}

			} else {

				out.println("<h3 style='color:red;text-align:center'>Invalid Email or Password</h3>");

				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.include(request, response);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}