package new_teddy_project.userfile;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/MyOrderServlet")
public class MyOrderServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/teddyshop", "root", "Jayesh@1008");

            PreparedStatement ps = con.prepareStatement("SELECT * FROM orders");
            ResultSet rs = ps.executeQuery();

            out.println("<html><head><title>My Orders</title>");

            out.println("<style>");
            out.println("body{font-family:Arial;background:#f8f4f1;margin:0;padding:0;}");
            out.println("header{background:#222831;color:white;text-align:center;padding:20px;font-size:28px;}");
            out.println(".container{width:80%;margin:30px auto;}");
            out.println("table{width:100%;border-collapse:collapse;background:white;box-shadow:0 4px 10px rgba(0,0,0,0.1);}");
            out.println("th,td{padding:12px;border-bottom:1px solid #ddd;text-align:center;}");
            out.println("th{background:#547792;color:white;}");
            out.println("tr:hover{background:#f2f2f2;}");
            out.println("</style>");

            out.println("</head><body>");

            out.println("<header>My Orders 🧸</header>");
            out.println("<div class='container'>");

            out.println("<table>");
            out.println("<tr>");
            out.println("<th>Order ID</th>");
            out.println("<th>Product Name</th>");
            out.println("<th>Price</th>");
            out.println("<th>Order Date</th>");
            out.println("<th>Status</th>");
            out.println("</tr>");

            while (rs.next()) {

                out.println("<tr>");
                out.println("<td>" + rs.getInt("id") + "</td>");
                out.println("<td>" + rs.getString("product_name") + "</td>");
                out.println("<td>₹" + rs.getString("price") + "</td>");
                out.println("<td>" + rs.getString("order_date") + "</td>");
                out.println("<td>" + rs.getString("status") + "</td>");
                out.println("</tr>");
                
                
                /*String email = (String) request.getSession().getAttribute("userEmail");

PreparedStatement ps = con.prepareStatement(
"SELECT * FROM orders WHERE customer_email=?");

ps.setString(1, email);*/

            }

            out.println("</table>");
            out.println("</div>");
            out.println("</body></html>");

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
            out.println("Error: " + e.getMessage());
        }
    }
}