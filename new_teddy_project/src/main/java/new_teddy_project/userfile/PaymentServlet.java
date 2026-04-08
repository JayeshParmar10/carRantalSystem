package new_teddy_project.userfile;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;

@WebServlet("/PaymentServlet")
public class PaymentServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();

		// Get cart from session
		Map<String, Double> cartMap = (Map<String, Double>) session.getAttribute("cartMap");

		// Direct buy parameters
		String directName = request.getParameter("name");
		String directPriceStr = request.getParameter("price");

		Map<String, Double> paymentMap = new LinkedHashMap<>();

		// Determine if user bought direct product
		if (directName != null && directPriceStr != null) {
			double directPrice = Double.parseDouble(directPriceStr.replace("₹", "").trim());
			paymentMap.put(directName, directPrice);
		} else if (cartMap != null && !cartMap.isEmpty()) {
			paymentMap.putAll(cartMap);
		} else {
			out.println("<h2>Your cart is empty!</h2>");
			out.println("<a href='ProductServlet'>Continue Shopping</a>");
			return;
		}

		// Calculate total
		double total = 0;
		for (double price : paymentMap.values()) {
			total += price;
		}

		// Display payment page
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Payment Page</title>");

		out.println("<style>");
		out.println("body{font-family:Arial;background:#f2f2f2;margin:0;padding:0;}");
		out.println(".container{width:420px;margin:80px auto;background:white;padding:25px;border-radius:10px;box-shadow:0 4px 10px rgba(0,0,0,0.2);}");
		out.println("h2{text-align:center;color:#333;}");
		out.println("h3{color:#555;margin-top:15px;}");
		out.println(".product{padding:8px;border-bottom:1px solid #ddd;font-size:16px;}");
		out.println(".total{font-size:20px;font-weight:bold;color:#28a745;margin-top:15px;text-align:center;}");
		out.println("button{width:100%;padding:12px;margin-top:20px;background:#007bff;color:white;border:none;border-radius:5px;font-size:16px;cursor:pointer;}");
		out.println("button:hover{background:#0056b3;}");
		out.println("</style>");

		out.println("</head>");
		out.println("<body>");

		out.println("<div class='container'>");

		out.println("<h2>Payment Page</h2>");
		out.println("<h3>Products in your order:</h3>");

		for (Map.Entry<String, Double> entry : paymentMap.entrySet()) {
			out.println("<p class='product'>Product: " + entry.getKey() + " | Price: ₹" + entry.getValue() + "</p>");
		}

		out.println("<h3 class='total'>Total Price: ₹" + total + "</h3>");

		out.println("<form action='PaymentMethodServlet' method='post'>");
		out.println("<input type='hidden' name='total' value='" + total + "'>");
		out.println("<button type='submit'>Proceed to Payment</button>");
		out.println("</form>");

		out.println("</div>");

		out.println("</body>");
		out.println("</html>");
	}
}