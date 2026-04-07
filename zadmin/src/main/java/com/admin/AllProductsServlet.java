package com.admin;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/all-products")
public class AllProductsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.setContentType("text/html");
        resp.getWriter().println("<h1>All Products</h1>");
        resp.getWriter().println("<ul>");
        resp.getWriter().println("<li>Product 1 - $100</li>");
        resp.getWriter().println("<li>Product 2 - $200</li>");
        resp.getWriter().println("</ul>");
    }
}
