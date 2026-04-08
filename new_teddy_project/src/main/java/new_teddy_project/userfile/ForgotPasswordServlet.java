package new_teddy_project.userfile;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ForgotPasswordServlet")
public class ForgotPasswordServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String user_password = request.getParameter("user_password");
        String confrm_password = request.getParameter("confrm_password");
        

        Connection con = null;
        PreparedStatement ps = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/teddyshop", "root", "Jayesh@1008");

            String sql = "UPDATE `user` SET user_password =? , confrm_password =? WHERE email_address=?";
            ps = con.prepareStatement(sql);

            ps.setString(1, user_password);
            ps.setString(2, confrm_password);
            ps.setString(3, username);
           
            int rowsUpdated = ps.executeUpdate();

            if (rowsUpdated > 0) {
            	response.getWriter().println(
            	        "<div style='color: green; font-size: 20px; text-align: center; margin-top: 50px;'>"
            	        + "Password updated successfully!"
            	        + "</div>"
            	    );
            	/*  RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.forward(request, response);
                */
                response.sendRedirect("index.jsp");
            } else {
            	response.getWriter().println(
            	        "<div style='color: red; font-size: 20px; text-align: center; margin-top: 50px;'>"
            	        + "Email not found in database."
            	        + "</div>"
            	    ); }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            response.getWriter().println("Error: " + e.getMessage());
        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}