<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
	String fullName = (String) session.getAttribute("session_name");
    //String fullName = (String) session.getAttribute("full_name");
    if(fullName == null){
        response.sendRedirect("homapage.jsp");
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>TeddyShop - Home</title>

    <style>
        body {
            margin: 0;
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
        }

        /* Navbar */
        .navbar {
            background-color: #222831;
            padding: 15px 30px;
            display: flex;
            justify-content: space-between;
            align-items: center;
            color: white;
        }

        .navbar h2 {
            margin: 0;
        }

        .nav-links a {
            color: white;
            text-decoration: none;
            margin-left: 20px;
            font-size: 16px;
            transition: 0.3s;
        }

        .nav-links a:hover {
            text-decoration: underline;
        }

        /* Hero Section */
        .hero {
            text-align: center;
            padding: 80px 20px;
            background: linear-gradient(135deg, #EBF4DD, #A98B76);
       		color: #2F3E2F;
        }

        .hero h1 {
            font-size: 40px;
            margin-bottom: 10px;
        }

        .hero p {
            font-size: 18px;
        }

        /* Cards Section */
        .container {
            padding: 40px;
            display: flex;
            justify-content: center;
            gap: 30px;
            flex-wrap: wrap;
        }

        .card {
            background: palegoldenrod;
            width: 250px;
            padding: 20px;
            border-radius: 10px;
            text-align: center;
            box-shadow: 0px 4px 10px rgba(0,0,0,0.1);
            transition: 0.3s;
        }

        .card:hover {
            transform: translateY(-15px);
        }

        .card h3 {
            margin-bottom: 15px;
            color: #333;
        }

        .card a {
            text-decoration: none;
            background: royalblue;
            color: white;
            padding: 10px 15px;
            border-radius: 5px;
            display: inline-block;
        }

        .card a:hover {
            background: #e85d75;
        }

        /* Footer */
        .footer {
            background: #333;
            color: white;
            text-align: center;
            padding: 15px;
            margin-top: 40px;
        }
    </style>
</head>

<body>

<!-- Navbar -->
<div class="navbar">
    <h2>🧸 TeddyShop</h2>

    <div class="nav-links">
        <a href="ProfileServlet">Profile</a>
        <a href="ProductServlet">Products</a>
        <a href="MyOrderServlet">Order</a>
        <a href="contact.jsp">Contact Us</a>
        <a href="LogoutServlet">Logout</a>
    </div>
</div>

<!-- Hero Section -->
<div class="hero">
    <h1>Welcome, <%= fullName %> 👋</h1>
    <p>Find the cutest teddy bears for your Kids & loved ones!</p>
</div>

<!-- Feature Cards -->
<div class="container">

    <div class="card">
        <h3>👤 My Profile</h3>
        <p>View and edit your profile information.</p>
        <a href="ProfileServlet">Show</a>
    </div>

    <div class="card">
        <h3>🛍 Products</h3>
        <p>Browse our adorable teddy collection.</p>
        <a href="ProductServlet">Shop Now</a>
    </div>

    <div class="card">
        <h3>🛒 My Order</h3>
        <p>View items added to <br> My Order.</p>
        <a href="MyOrderServlet">View Order</a>
    </div>

    <div class="card">
        <h3>📞 Contact Us</h3>
        <p>Need help? Reach out to us anytime.</p>
        <a href="contact.jsp">Contact</a>
    </div>

</div>

<!-- Footer -->
<div class="footer">
    © 2026 TeddyShop | All Rights Reserved
</div>

</body>
</html>