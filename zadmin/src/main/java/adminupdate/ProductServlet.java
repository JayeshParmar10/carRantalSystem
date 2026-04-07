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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet("/ProductPage")
public class ProductServlet extends HttpServlet {

    Connection con;

    public void init() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/bookshop",
                "root",
                "Jayesh@1008"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ADD PRODUCT
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO products(name, price, quantity) VALUES(?,?,?)"
            );
            ps.setString(1, request.getParameter("name"));
            ps.setDouble(2, Double.parseDouble(request.getParameter("price")));
            ps.setInt(3, Integer.parseInt(request.getParameter("quantity")));

            ps.executeUpdate();
            response.sendRedirect("adminDashboard.jsp");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // VIEW PRODUCTS
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("view".equals(action)) {

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            try {
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM products");

                out.println("<h2>Product List</h2>");
                out.println("<table border='1'>");
                out.println("<tr>");
                out.println("<th>ID</th><th>Name</th><th>Price</th><th>Quantity</th><th>Action</th>");
                out.println("</tr>");

                while (rs.next()) {
                    out.println("<tr>");
                    out.println("<td>" + rs.getInt("id") + "</td>");
                    out.println("<td>" + rs.getString("name") + "</td>");
                    out.println("<td>" + rs.getDouble("price") + "</td>");
                    out.println("<td>" + rs.getInt("quantity") + "</td>");
                    out.println("<td>");
                    out.println("<a href='DeleteProductServlet?id=" + rs.getInt("id") + "'>Delete</a>");
                    out.println("</td>");
                    out.println("</tr>");
                }

                out.println("</table>");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
