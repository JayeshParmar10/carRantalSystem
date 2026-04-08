package new_teddy_project.userfile;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/PaymentMethodServlet")
public class PaymentMethodServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		// Get total amount from previous page
		String totalStr = request.getParameter("total");

		out.println("<html>");
		out.println("<head>");
		out.println("<title>Payment Methods</title>");

		out.println("<style>");
		out.println("body {");
		out.println("    font-family: Arial, sans-serif;");
		out.println("    background: linear-gradient(135deg, #EBF4DD, #A98B76);"); // new gradient
		out.println("    display: flex;");
		out.println("    justify-content: center;");
		out.println("    align-items: center;");
		out.println("    height: 100vh;");
		out.println("    margin: 0;");
		out.println("}");

		out.println(".container {");
		out.println("    background: white;");
		out.println("    padding: 30px;");
		out.println("    border-radius: 10px;");
		out.println("    box-shadow: 0 8px 20px rgba(0,0,0,0.25);"); // stronger shadow
		out.println("    width: 420px;");
		out.println("    transition: transform 0.3s ease, box-shadow 0.3s ease;");
		out.println("}");
		out.println(".container:hover {");
		out.println("    transform: translateY(-5px);"); // subtle lift effect
		out.println("    box-shadow: 0 12px 30px rgba(0,0,0,0.3);");
		out.println("}");

		out.println("h2 { text-align:center; margin-bottom:10px; color: #333; }");

		out.println(".payment-methods label {");
		out.println("    display: block;");
		out.println("    margin-bottom: 8px;");
		out.println("    cursor: pointer;");
		out.println("    font-weight: bold;");
		out.println("}");

		out.println(".payment-box {");
		out.println("    margin-top: 15px;");
		out.println("    padding: 10px;");
		out.println("    border: 1px solid #ddd;");
		out.println("    border-radius: 6px;");
		out.println("    background: #fafafa;");
		out.println("    display: none;");
		out.println("    transition: all 0.3s ease;");
		out.println("}");

		out.println("input, textarea {");
		out.println("    width: 100%;");
		out.println("    padding: 8px;");
		out.println("    margin-top: 6px;");
		out.println("    border-radius: 4px;");
		out.println("    border: 1px solid #ccc;");
		out.println("    transition: border-color 0.3s ease, box-shadow 0.3s ease;");
		out.println("}");
		out.println("input:focus, textarea:focus {");
		out.println("    border-color: #007bff;");
		out.println("    box-shadow: 0 0 8px rgba(0,123,255,0.4);");
		out.println("}");

		out.println("button {");
		out.println("    width: 100%;");
		out.println("    margin-top: 20px;");
		out.println("    padding: 12px;");
		out.println("    border: none;");
		out.println("    background: #007bff;");
		out.println("    color: white;");
		out.println("    font-size: 16px;");
		out.println("    font-weight: bold;");
		out.println("    border-radius: 5px;");
		out.println("    cursor: pointer;");
		out.println("    transition: all 0.3s ease;");
		out.println("    box-shadow: 0 4px 6px rgba(0,0,0,0.1);");
		out.println("}");
		out.println("button:hover {");
		out.println("    background: #0056b3;");
		// out.println(" transform: scale(1.05);"); // grow on hover
		// out.println(" box-shadow: 0 6px 12px rgba(0,0,0,0.2), 0 0 10px
		// rgba(0,123,255,0.6);"); // glow effect
		out.println("}");
		out.println("button:active {");
		out.println("    transform: scale(0.98);"); // press effect
		out.println("}");
		out.println("</style>");
		// Script to dynamically require visible fields only
		out.println("<script>");
		out.println("function showFields(method){");
		out.println("document.getElementById('upi').style.display='none';");
		out.println("document.getElementById('card').style.display='none';");
		out.println("document.getElementById('cod').style.display='none';");
		out.println(
				"document.querySelectorAll('#upi input, #card input, #cod input, #cod textarea').forEach(el => el.required=false);");

		out.println("if(method=='UPI'){");
		out.println("document.getElementById('upi').style.display='block';");
		out.println("document.querySelectorAll('#upi input').forEach(el => el.required=true);");
		out.println("}");

		out.println("if(method=='Debit Card' || method=='Credit Card'){");
		out.println("document.getElementById('card').style.display='block';");
		out.println("document.querySelectorAll('#card input').forEach(el => el.required=true);");
		out.println("}");

		out.println("if(method=='Cash on Delivery'){");
		out.println("document.getElementById('cod').style.display='block';");
		out.println("document.querySelectorAll('#cod input, #cod textarea').forEach(el => el.required=true);");
		out.println("}");
		out.println("}");
		out.println("</script>");

		out.println("</head>");
		out.println("<body>");
		out.println("<div class='container'>");
		out.println("<h2>Payment Page</h2>");
		out.println("<p><b>Total Amount:</b> ₹" + totalStr + "</p>");

		// Payment form
		out.println("<form action='OrderSuccess' method='post'>");

		// Payment method selection
		out.println("<div class='payment-methods'>");
		out.println(
				"<label><input type='radio' name='payment_method' value='UPI' onclick=\"showFields('UPI')\" required> UPI</label>");
		out.println(
				"<label><input type='radio' name='payment_method' value='Debit Card' onclick=\"showFields('Debit Card')\"> Debit Card</label>");
		out.println(
				"<label><input type='radio' name='payment_method' value='Credit Card' onclick=\"showFields('Credit Card')\"> Credit Card</label>");
		out.println(
				"<label><input type='radio' name='payment_method' value='Cash on Delivery' onclick=\"showFields('Cash on Delivery')\"> Cash on Delivery</label>");
		out.println("</div>");

		// UPI box
		out.println("<div id='upi' class='payment-box'>");
		out.println("<b>Pay using UPI</b><br><br>");
		out.println("<label>Enter UPI ID</label>");
		out.println("<input type='text' name='upi_id' placeholder='example@upi'>");
		out.println("<br><br>");
		out.println("<center>");
		out.println("<p>Scan QR Code</p>");
		out.println(
				"<img src='https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQBxsJ5pJp0XZauzO-gej1f6AgwZiwEYZwetQ&s'>");
		out.println("</center>");
		out.println("</div>");

		// Card box
		out.println("<div id='card' class='payment-box'>");
		out.println("<b>Card Details</b>");
		out.println("<input type='text' name='card_number' maxlength='16' placeholder='16 Digit Card Number'>");
		out.println("<input type='month' name='expiry'>");
		out.println("<input type='password' name='cvv' maxlength='3' placeholder='CVV'>");
		out.println("</div>");

		// Cash on Delivery box
		out.println("<div id='cod' class='payment-box'>");
		out.println("<b>Delivery Address</b>");
		out.println("<textarea name='address' placeholder='Enter Address'></textarea>");
		out.println("<input type='text' name='city' placeholder='City'>");
		out.println("<input type='text' name='pincode' maxlength='6' placeholder='Pincode'>");
		out.println("</div>");

		// Hidden total
		out.println("<input type='hidden' name='total' value='" + totalStr + "'>");

		// Submit button
		out.println("<button type='submit'>Confirm Payment</button>");

		out.println("</form>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	}
}