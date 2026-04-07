package adminupdate;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/bookshop", "root", "Jayesh@1008");

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM orders");

            out.println("<h2>Customer Orders</h2>");
            out.println("<table border=1>");
            out.println("<tr><th>ID</th><th>Customer</th><th>Product</th><th>Qty</th><th>Total</th></tr>");

            while (rs.next()) {
                out.println("<tr>");
                out.println("<td>"+rs.getInt("id")+"</td>");
                out.println("<td>"+rs.getString("customer_name")+"</td>");
                out.println("<td>"+rs.getString("product_name")+"</td>");
                out.println("<td>"+rs.getInt("quantity")+"</td>");
                out.println("<td>"+rs.getDouble("total")+"</td>");
                out.println("</tr>");
            }
            out.println("</table>");
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
