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

@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProfileServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		String full_name = request.getParameter("full_name");
//        String email_address = request.getParameter("email_address");
//        String user_password =request.getParameter("user_password");
//        String confrm_password =request.getParameter("confrm_password");
//        String phone_number = request.getParameter("phone_number");

		String userid = request.getParameter("userid");
		String deleteid = request.getParameter("deleteid");

		try {

			HttpSession session = request.getSession();
			Integer loginId = (Integer) session.getAttribute("sessionLoginId");

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/teddyshop", "root",
					"Jayesh@1008");

			PreparedStatement ps2 = con.prepareStatement("SELECT * FROM teddyshop.user WHERE id = ?");
			ps2.setInt(1, loginId);

			ResultSet rs = ps2.executeQuery();
			// HttpSession session = request.getSession();
			// session.setAttribute("userid", userid);
			// session.setAttribute("email_address", cardnumber);

			String username = request.getParameter("username");

			DataBaseConnection dbconnection = new DataBaseConnection();
			Connection consession = dbconnection.getConnction();

			PreparedStatement psSession = consession.prepareStatement("INSERT INTO teddyshop.session_tracking "
					+ "(session_id, create_time, last_access_time, action, email) VALUES (?,?,?,?,?)");

			psSession.setString(1, session.getId());
			psSession.setString(2, String.valueOf(session.getCreationTime()));
			psSession.setString(3, String.valueOf(session.getLastAccessedTime()));
			psSession.setString(4, "Profile");
			psSession.setString(5, username);

			psSession.executeUpdate();

			if (rs.next()) {

				String full_name = rs.getString("full_name");
				String email_address = rs.getString("email_address");
				String user_password = rs.getString("user_password");
				String confrm_password = rs.getString("confrm_password");
				String phone_number = rs.getString("phone_number");

				PrintWriter out = response.getWriter();

				out.println("<html>");
				out.println("<head>");
				out.println("<title>User Profile</title>");

				out.println(
						"<link href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css' rel='stylesheet'>");

				out.println("<style>");

				out.println("*{margin:0;padding:0;box-sizing:border-box;font-family:'Segoe UI',sans-serif;}");

				out.println("body{");
				out.println(" height:100vh;");
				out.println(" display:flex;");
				out.println(" justify-content:center;");
				out.println(" align-items:center;");
				out.println(" background:linear-gradient(145deg,#646165,#8E977D);");
				out.println("}");

				out.println(".card{");
				out.println(" background:rgba(255,255,255,0.15);");
				out.println(" backdrop-filter:blur(15px);");
				out.println(" padding:40px;");
				out.println(" width:380px;");
				out.println(" border-radius:20px;");
				out.println(" text-align:center;");
				out.println(" color:white;");
				out.println(" box-shadow:0 8px 32px rgba(0,0,0,0.3);");
				out.println(" animation:fadeIn 0.6s ease-in-out;");
				out.println("}");

				out.println(".avatar{");
				out.println(" width:100px;");
				out.println(" height:100px;");
				out.println(" border-radius:50%;");
				out.println(" background:#fff;");
				out.println(" margin:0 auto 15px;");
				out.println(" display:flex;");
				out.println(" align-items:center;");
				out.println(" justify-content:center;");
				out.println(" font-size:40px;");
				out.println(" color:#764ba2;");
				out.println("}");

				out.println("h1{margin-bottom:10px;}");

				out.println("p{margin:8px 0;font-size:15px;}");

				out.println(".btn{");
				out.println(" display:inline-block;");
				out.println(" margin:10px 5px;");
				out.println(" padding:10px 20px;");
				out.println(" border-radius:30px;");
				out.println(" text-decoration:none;");
				out.println(" color:white;");
				out.println(" font-size:14px;");
				out.println(" transition:0.3s;");
				out.println("}");

				out.println(".update{background:#00c9a7;}");
				out.println(".update:hover{background:#00a88b;}");

				out.println(".delete{background:#ff4d6d;}");
				out.println(".delete:hover{background:#d63350;}");

				out.println(".logout{background:#ffc107;color:black;}");
				out.println(".logout:hover{background:#e0a800;}");

				out.println(
						"@keyframes fadeIn{from{opacity:0;transform:translateY(20px);}to{opacity:1;transform:translateY(0);}}");

				out.println("</style>");
				out.println("</head>");

				out.println("<body>");

				out.println("<div class='card'>");

				out.println("<div class='avatar'><i class='fa fa-user'></i></div>");

				out.println("<h1>" + full_name + "</h1>");
				out.println("<p><i class='fa fa-envelope'></i> " + email_address + "</p>");
				out.println("<p><i class='fa fa-phone'></i> " + phone_number + "</p>");

				out.println("<a class='btn update' href='EditUser?userid=" + loginId
						+ "'><i class='fa fa-edit'></i> Update</a>");

				// out.println("<a class='btn delete' onclick=\"return confirm('Are you sure you
				// want to delete your account?');\" href='MainPage?userid=" + loginId + "'><i
				// class='fa fa-trash'></i> Delete</a>");

				out.println("<br>");

				out.println("<a class='btn logout' href='LogoutServlet'><i class='fa fa-sign-out-alt'></i> Logout</a>");

				out.println("</div>");

				out.println("</body>");
				out.println("</html>");
				// RequestDispatcher rd = request.getRequestDispatcher("profile.jsp");
				// rd.include(request, response);

			} else {
				RequestDispatcher rd = request.getRequestDispatcher("EditUser");
				rd.include(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().println("Error: " + e.getMessage());
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
