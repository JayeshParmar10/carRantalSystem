<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Confirm Payment</title>
<style>
body {
    font-family: Arial, sans-serif;
    background-color: #f0f2f5;
    margin: 0;
    padding: 0;
}

.container {
    max-width: 700px;
    margin: 50px auto;
     background: linear-gradient(135deg, #EBF4DD, #A98B76);
     padding: 30px;
    border-radius: 10px;
    box-shadow: 0 0 15px rgba(0,0,0,0.2);
}

h2, h3 {
    text-align: center;
}

.payment-methods {
    margin: 20px 0;
}

.payment-methods label {
    display: block;
    padding: 10px;
    background: #e9ecef;
    border-radius: 5px;
    margin-bottom: 10px;
    cursor: pointer;
    font-weight: bold;
}

.payment-methods input[type="radio"] {
    margin-right: 10px;
}

.payment-form {
    display: none;
    margin-top: 20px;
}

.payment-form input[type="text"],
.payment-form input[type="number"],
.payment-form input[type="month"],
.payment-form textarea {
    width: 100%;
    padding: 10px;
    margin: 8px 0;
    border-radius: 5px;
    border: 1px solid #ccc;
}

.payment-form img.qr {
    display: block;
    margin: 10px auto;
    width: 200px;
}

button {
    display: block;
    width: 100%;
    padding: 12px;
    background: #007bff;
    color: #fff;
    border: none;
    font-size: 16px;
    border-radius: 5px;
    cursor: pointer;
}

button:hover {
    background: #0056b3;
}
</style>
<script>
function showForm(method) {
    var forms = document.querySelectorAll('.payment-form');
    forms.forEach(f => f.style.display = 'none');
    if(method) {
        document.getElementById(method).style.display = 'block';
    }
}
</script>
</head>
<body>

<div class="container">
<h2>Confirm Payment</h2>
<h3>Product: <%= request.getParameter("name") %></h3>
<h3>Price: ₹<%= request.getParameter("price") %></h3>

<div class="payment-methods">
    <label><input type="radio" name="method" onclick="showForm('upi')"> UPI</label>
    <label><input type="radio" name="method" onclick="showForm('debit')"> Debit Card</label>
    <label><input type="radio" name="method" onclick="showForm('credit')"> Credit Card</label>
    <label><input type="radio" name="method" onclick="showForm('cod')"> Cash on Delivery</label>
</div>

<!-- UPI Payment -->
<form action="OrderSuccess" method="post" class="payment-form" id="upi">
    <input type="hidden" name="payment_method" value="UPI">
    <input type="hidden" name="name" value="<%= request.getParameter("name") %>">
    <input type="hidden" name="price" value="<%= request.getParameter("price") %>">
    <img class="qr" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSBEKbZ1O_CVhPQfXf5MxQAQcOgC1bJ8XUmBy4wvAVeIXu7kHnXKkl7cHiLxPQieHHBasA_UeLaROR7x-7zfe861pU&s&ec=121532766" alt="UPI QR Code">
    <p>Scan the QR code with your UPI app and complete payment.</p>
    <button type="submit">Confirm Payment</button>
</form>

<!-- Debit Card Payment -->
<form action="OrderSuccess" method="post" class="payment-form" id="debit">
    <input type="hidden" name="payment_method" value="Debit Card">
    <input type="hidden" name="name" value="<%= request.getParameter("name") %>">
    <input type="hidden" name="price" value="<%= request.getParameter("price") %>">
    <input type="text" name="card_number" placeholder="Card Number" required>
    <input type="month" name="expiry" placeholder="Expiry" required>
    <input type="number" name="cvv" placeholder="CVV" required>
    <button type="submit">Pay Now</button>
</form>

<!-- Credit Card Payment -->
<form action="OrderSuccess" method="post" class="payment-form" id="credit">
    <input type="hidden" name="payment_method" value="Credit Card">
    <input type="hidden" name="name" value="<%= request.getParameter("name") %>">
    <input type="hidden" name="price" value="<%= request.getParameter("price") %>">
    <input type="text" name="card_number" placeholder="Card Number" required>
    <input type="month" name="expiry" placeholder="Expiry" required>
    <input type="number" name="cvv" placeholder="CVV" required>
    <button type="submit">Pay Now</button>
</form>

<!-- Cash on Delivery -->
<form action="OrderSuccess" method="post" class="payment-form" id="cod">
    <input type="hidden" name="payment_method" value="Cash on Delivery">
    <input type="hidden" name="name" value="<%= request.getParameter("name") %>">
    <input type="hidden" name="price" value="<%= request.getParameter("price") %>">
    <textarea name="address" placeholder="Enter your delivery address" required></textarea>
    <button type="submit">Confirm Order</button>
</form>

</div>

</body>
</html>