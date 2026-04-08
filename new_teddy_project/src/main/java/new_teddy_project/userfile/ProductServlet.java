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

@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
           
        	Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/teddyshop", "root", "Jayesh@1008");

            PreparedStatement ps = con.prepareStatement("SELECT * FROM add_products");
            ResultSet rs = ps.executeQuery();

            out.println("<html><head><title>Teddy Collection</title>");
            out.println("<style>");
            out.println("body {");
            out.println("    font-family: Arial, sans-serif;");
            out.println("    margin: 0;");
            out.println("    padding: 0;");
            out.println("    background: linear-gradient(135deg, #EBF4DD, #A98B76, #ff6f91);"); // Gradient background
            out.println("    background-size: 400% 400%;");
            out.println("    animation: gradientBG 15s ease infinite;");
            out.println("}");
            out.println("@keyframes gradientBG {");
            out.println("    0% { background-position: 0% 50%; }");
            out.println("    50% { background-position: 100% 50%; }");
            out.println("    100% { background-position: 0% 50%; }");
            out.println("}");

            out.println("header {");
            out.println("    background: rgba(34,40,49,0.85);"); // semi-transparent to show gradient behind
            out.println("    color: white;");
            out.println("    text-align: center;");
            out.println("    padding: 20px;");
            out.println("    font-size: 28px;");
            out.println("    font-family: 'Georgia', serif;");
            out.println("}");

            out.println(".container {");
            out.println("    width: 90%;");
            out.println("    margin: 30px auto;");
            out.println("    display: grid;");
            out.println("    grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));");
            out.println("    gap: 25px;");
            out.println("}");

            out.println(".card {");
            out.println("    background: white;");
            out.println("    border-radius: 12px;");
            out.println("    box-shadow: 0 4px 12px rgba(0,0,0,0.1);");
            out.println("    padding: 15px;");
            out.println("    text-align: center;");
            out.println("    transition: 0.3s ease, transform 0.3s ease;");
            out.println("}");
            out.println(".card:hover { transform: translateY(-8px) scale(1.02); }"); // hover effect

            out.println(".card img { width: 100%; height: 220px; object-fit: cover; border-radius: 10px; }");
            out.println(".card h3 { margin: 10px 0 5px; color: #333; }");
            out.println(".price { color: #ff6f91; font-weight: bold; margin-bottom: 10px; }");

            out.println("button {");
            out.println("    background: #547792;");
            out.println("    border: none;");
            out.println("    padding: 10px 15px;");
            out.println("    color: white;");
            out.println("    border-radius: 6px;");
            out.println("    cursor: pointer;");
            out.println("    font-weight: bold;");
            out.println("    transition: 0.3s, transform 0.3s;");
            out.println("}");
            out.println("button:hover { background: #ff3e6c; transform: scale(1.05); }");

            out.println("</style></head><body>");
            out.println("<header>Teddy Collection 🧸</header>");
            out.println("<div class='container'>");

            // Your card loop here
            while (rs.next()) {
                String name = rs.getString("name");
                String price = rs.getString("price");
                String image = rs.getString("image");

                out.println("<form action='PaymentServlet' method='post' class='card'>");
                out.println("<img src='images/" + image + "'>");
                out.println("<h3>" + name + "</h3>");
                out.println("<p class='price'>₹" + price + "</p>");
                out.println("<input type='hidden' name='productName' value='" + name + "'>");
                out.println("<input type='hidden' name='price' value='" + price + "'>");
                out.println("<a href='cart.jsp?name=" + name + "&price=" + price + "'>");
                out.println("<button type='button'>Add to Cart</button>");
                out.println("</a>");
                out.println("</form>");
            }

            out.println("</div></body></html>");

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
            out.println("Error: " + e.getMessage());
        }
    }
}