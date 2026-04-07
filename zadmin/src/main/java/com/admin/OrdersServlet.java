package com.admin;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/orders")
public class OrdersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.setContentType("text/html");
        resp.getWriter().println("<h1>Orders List</h1>");
        resp.getWriter().println("<ul>");
        resp.getWriter().println("<li>Order #1001 - Delivered</li>");
        resp.getWriter().println("<li>Order #1002 - Pending</li>");
        resp.getWriter().println("</ul>");
    }
}
