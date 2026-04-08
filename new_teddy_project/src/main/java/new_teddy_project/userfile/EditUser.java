package new_teddy_project.userfile;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
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
import java.sql.Statement;

import connection.DataBaseConnection;

@WebServlet("/EditUser")
public class EditUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditUser() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer userId = Integer.valueOf(request.getParameter("userid"));

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/teddyshop", "root",
					"Jayesh@1008");

			PreparedStatement ps = con.prepareStatement("SELECT * FROM user WHERE id = ?");
			ps.setInt(1, userId);

			ResultSet row = ps.executeQuery();
			if (row.next()) {
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();

				out.println("<html>");
				out.println("<head>");
				out.println("<style>");

				out.println("/* Full-page animated gradient background */");
				out.println("body {");
				out.println("    font-family: Arial, sans-serif;");
				out.println("    margin: 0;");
				out.println("    height: 100vh;");
				out.println("    display: flex;");
				out.println("    justify-content: center;");
				out.println("    align-items: center;");
				out.println("    background: linear-gradient(135deg, #EBF4DD, #EBF4DD, #A98B76, #A98B76);");
				out.println("    background-size: 400% 400%;");
				out.println("    animation: gradientBG 15s ease infinite;");
				out.println("}");

				out.println("@keyframes gradientBG {");
				out.println("    0% { background-position: 0% 50%; }");
				out.println("    50% { background-position: 100% 50%; }");
				out.println("    100% { background-position: 0% 50%; }");
				out.println("}");

				out.println("/* Form container with entrance animation */");
				out.println(".form-container {");
				out.println("    background: rgba(255,255,255,0.95);");
				out.println("    padding: 30px 35px;");
				out.println("    width: 400px;");
				out.println("    border-radius: 15px;");
				out.println("    box-shadow: 0 12px 25px rgba(0,0,0,0.25);");
				out.println("    animation: slideDown 0.5s ease-out;");
				out.println("}");

				out.println("@keyframes slideDown {");
				out.println("    from { transform: translateY(-50px); opacity: 0; }");
				out.println("    to { transform: translateY(0); opacity: 1; }");
				out.println("}");

				out.println(".form-container h2 {");
				out.println("    text-align: center;");
				out.println("    margin-bottom: 20px;");
				out.println("    color: #2F3E2F;");
				out.println("    font-family: 'Georgia', serif;");
				out.println("    letter-spacing: 2px;");
				out.println("    transition: color 0.3s;");
				out.println("}");
				out.println(".form-container h2:hover { color: #d3544a; }");

				out.println(".form-group { margin-bottom: 15px; }");
				out.println(".form-group label { display: block; margin-bottom: 5px; color: #555; font-size: 14px; }");
				out.println(
						".form-group input { width: 100%; padding: 12px; border: 1px solid #ccc; border-radius: 8px; font-size: 15px; transition: border 0.3s, box-shadow 0.3s; }");
				out.println(
						".form-group input:focus { border-color: #ff6f61; box-shadow: 0 0 10px rgba(255,111,97,0.5); outline: none; }");

				out.println(
						"button { width: 100%; padding: 12px; background: #ff6f61; color: white; border: none; border-radius: 10px; font-size: 16px; cursor: pointer; margin-top: 10px; transition: 0.3s; }");
				out.println("button:hover { background: #d3544a; transform: scale(1.05); }");

				out.println("</style>");
				out.println("</head>");

				out.println("<body>");
				out.println("<div class='form-container'>");
				out.println("<form action='EditUser' method='post'>");
				out.println("<input type='hidden' name='userId' value='" + userId + "'>");
				out.println("<h2>Edit Profile</h2>");

				out.println("<div class='form-group'>");
				out.println("<label>Full Name</label>");
				out.println("<input type='text' name='full_name' value='" + row.getString("full_name") + "' required>");
				out.println("</div>");

				out.println("<div class='form-group'>");
				out.println("<label>Email</label>");
				out.println("<input type='email' name='email_address' value='" + row.getString("email_address")
						+ "' required>");
				out.println("</div>");

				out.println("<div class='form-group'>");
				out.println("<label>Password</label>");
				out.println(
						"<input type='password' name='user_password' value='" + row.getString("user_password") + "'>");
				out.println("</div>");

				out.println("<div class='form-group'>");
				out.println("<label>Confirm Password</label>");
				out.println("<input type='password' name='confrm_password' value='" + row.getString("confrm_password")
						+ "'>");
				out.println("</div>");

				out.println("<div class='form-group'>");
				out.println("<label>Phone Number</label>");
				out.println("<input type='text' name='phone_number' value='" + row.getString("phone_number") + "'>");
				out.println("</div>");

				out.println("<button type='submit'>Update</button>");
				out.println("</form>");
				out.println("</div>");
				out.println("</body>");
				out.println("</html>");
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			String full_name = request.getParameter("full_name");
			String email_address = request.getParameter("email_address");
			String user_password = request.getParameter("user_password");
			String confrm_password = request.getParameter("confrm_password");
			String phone_number = request.getParameter("phone_number");
			Integer userId = Integer.valueOf(request.getParameter("userId"));

			String username = request.getParameter("email_address");
//			Integer loginid = Integer.valueOf(request.getParameter("loginid"));

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/teddyshop", "root",
					"Jayesh@1008");

			PreparedStatement ps2 = con.prepareStatement(
					"UPDATE user SET full_name=?, email_address=?, user_password=?, confrm_password=? ,phone_number=? WHERE id=?");

			ps2.setString(1, full_name);
			ps2.setString(2, email_address);
			ps2.setString(3, user_password);
			ps2.setString(4, confrm_password);
			ps2.setString(5, phone_number);
			ps2.setInt(6, userId);
			ps2.executeUpdate();

			request.setAttribute("message", "User updated successfully.");
			RequestDispatcher rd = request.getRequestDispatcher("/ProfileServlet");
			rd.forward(request, response);

			HttpSession session = request.getSession();
			session.setAttribute("loginId", userId);
			session.setAttribute("full_name", full_name);
			session.setAttribute("email_address", email_address);
			session.setAttribute("user_password", user_password);
			session.setAttribute("confrm_password", confrm_password);
			session.setAttribute("phone_number", phone_number);

			DataBaseConnection dbconnection = new DataBaseConnection();
			Connection consession = dbconnection.getConnction();

			PreparedStatement psSession = consession.prepareStatement("INSERT INTO teddyshop.session_tracking "
					+ "(session_id, create_time, last_access_time, action, email) VALUES (?,?,?,?,?)");

			psSession.setString(1, session.getId());
			psSession.setString(2, String.valueOf(session.getCreationTime()));
			psSession.setString(3, String.valueOf(session.getLastAccessedTime()));
			psSession.setString(4, "EditUser");
			psSession.setString(5, email_address);

			psSession.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
