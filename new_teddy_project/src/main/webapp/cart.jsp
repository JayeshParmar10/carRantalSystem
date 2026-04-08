<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Your Cart</title>
<style>
body {
	font-family: Arial;
	margin: 40px;
	 background: linear-gradient(135deg, #EBF4DD, #A98B76);
       
}

.cart-box {
	border: 1px solid #ccc;
	padding: 15px;
	width: 400px;
	margin-bottom: 10px;
	position: relative;
}

.remove-btn {
	position: absolute;
	right: 10px;
	top: 10px;
	background: red;
	border: none;
	color: white;
	padding: 5px 10px;
	cursor: pointer;
}

.remove-btn:hover {
	background: #b30000;
}

.total {
	font-size: 20px;
	font-weight: bold;
	color: green;
}

button {
	padding: 10px 15px;
	background: #ff5e62;
	border: none;
	color: white;
	cursor: pointer;
}

button:hover {
	background: #e14c50;
}
</style>
</head>
<body>

	<h2>Your Cart</h2>

	<%
	// Initialize cartMap
	Map<String, Double> cartMap = (Map<String, Double>) session.getAttribute("cartMap");
	if (cartMap == null) {
		cartMap = new LinkedHashMap<>();
		session.setAttribute("cartMap", cartMap);
	}

	// Handle removal of an item
	String removeItem = request.getParameter("remove");
	if (removeItem != null) {
		cartMap.remove(removeItem);
		session.setAttribute("cartMap", cartMap);
		response.sendRedirect("cart.jsp");
		return;
	}

	// Add new item if present
	String name = request.getParameter("name");
	String priceStr = request.getParameter("price");
	if (name != null && priceStr != null) {
		double price = Double.parseDouble(priceStr.replace("₹", "").trim());
		cartMap.put(name, price);
		session.setAttribute("cartMap", cartMap);
	}

	// Calculate total
	double total = 0;
	for (double p : cartMap.values())
		total += p;
	%>

	<h3>Items in Cart:</h3>

	<%
	if (cartMap.isEmpty()) {
	%>
	<p>Your cart is empty</p>
	<%
	} else {
	for (Map.Entry<String, Double> entry : cartMap.entrySet()) {
		String pname = entry.getKey();
		double pprice = entry.getValue();
	%>
	<div class="cart-box">
		<p>
			<b>Product :</b>
			<%=pname%></p>
		<p>
			<b>Price :</b> ₹<%=pprice%></p>
		<form method="get" style="display: inline;">
			<input type="hidden" name="remove" value="<%=pname%>">
			<button type="submit" class="remove-btn">Remove</button>
		</form>
	</div>
	<%
	}
	}
	%>

	<h3 class="total">
		Total Amount : ₹<%=total%></h3>
	<br>
	<a href="ProductServlet">Continue Shopping</a>
	<br>
	<br>

	<%
	if (!cartMap.isEmpty()) {
	%>
	<form action="PaymentServlet" method="post">
		<button type="submit">Proceed to Payment</button>
	</form>
	<%
	}
	%>

</body>
</html>