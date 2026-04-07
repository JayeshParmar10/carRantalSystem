package com.admin;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/add-product")
public class AddProductServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        String price = req.getParameter("price");
        String description = req.getParameter("description");

        // Here you would save the product in DB
        System.out.println("Product Added: " + name);

        resp.getWriter().println("<h2>Product Added Successfully!</h2>");
    }
}
