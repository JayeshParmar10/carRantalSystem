package new_teddy_project.userfile;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/OrderSuccess")
public class OrderSuccessServlet extends HttpServlet {

    // Handle POST request from PaymentMethodServlet
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String total = request.getParameter("total");
        String paymentMethod = request.getParameter("payment_method");

        out.println("<html><head><title>Order Success</title>");
        out.println("<style>");
        out.println("body{font-family:Arial;text-align:center;background: linear-gradient(135deg, #EBF4DD, #A98B76);padding:50px}");
        out.println(".box{background:white;padding:40px;border-radius:10px;box-shadow:0 0 10px #ccc;display:inline-block}");
        out.println("a{background:#547792;color:white;padding:10px 20px;text-decoration:none;border-radius:5px}");
        out.println("</style></head><body>");

        out.println("<div class='box'>");
        out.println("<h1>✅ Order Placed Successfully!</h1>");
        out.println("<p>Your teddy will arrive soon 🧸</p>");
        out.println("<p><b>Payment Method:</b> " + paymentMethod + "</p>");
        out.println("<p><b>Total Paid:</b> ₹" + total + "</p>");
        out.println("<br>");
        out.println("<a href='homepage.jsp'>Continue Shopping</a>");
        out.println("</div>");

        out.println("</body></html>");
    }

    // Optional: also handle GET
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}