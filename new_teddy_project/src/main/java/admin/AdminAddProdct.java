package admin;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/addToCart")
public class AdminAddProdct extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	try { 
    			Class.forName("com.mysql.cj.jdbc.Driver");
        
    			DriverManager.getConnection("jdbc:mysql://localhost:3306/teddyshop", "root", "Jayesh@1008");
   	 		}
    	catch(Exception e) {
    		
    	}

        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String description = request.getParameter("description");

        HttpSession session = request.getSession();
        List<String> cart = (List<String>) session.getAttribute("cart");

        if (cart == null) {
            cart = new ArrayList<>();
        }

        cart.add(name);
        session.setAttribute("cart", cart);
        
        response.sendRedirect("home.jsp");
    }
}
    
    /*import code
     *     <img src="images/<%= rs.getString("image") %>">
    <h3><%= rs.getString("name") %></h3>
    <p>₹<%= rs.getDouble("price") %></p>

    <form action="addToCart" method="post">
        <input type="hidden" name="productName" value="<%= rs.getString("name") %>">
        <input type="hidden" name="price" value="<%= rs.getDouble("price") %>">
        <button>Add to Cart</button>
*/
     
