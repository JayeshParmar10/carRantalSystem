	<%@ page language="java" contentType="text/html; charset=UTF-8"
	    pageEncoding="UTF-8"%>
	<!DOCTYPE html>
	<html>
	<head>
	<meta charset="UTF-8">
	<title>Teddy Shop Login</title>
	
	<style>
	    /* Full page background */
	    body {
	        font-family: Arial, sans-serif;
	        margin: 0;
	        padding: 0;
	        height: 100vh;
	        background: linear-gradient(135deg, #EBF4DD, #A98B76);
	        display: flex;
	        justify-content: center;
	        align-items: center;
	        animation: fadeInBody 1s ease-in;
	    }
	
	    @keyframes fadeInBody {
	        from { opacity: 0; }
	        to { opacity: 1; }
	    }
	
	    /* Container */
	    .container {
	        width: 400px;
	        padding: 20px 60px;
	        
	        background: rgba(255, 255, 255, 0.95);
	        border-radius: 15px;
	        box-shadow: 0px 12px 25px rgba(0,0,0,0.3);
	        text-align: center;
	        animation: slideDown 0.5s ease-out;
	    }
	
	    @keyframes slideDown {
	        from { transform: translateY(-50px); opacity: 0; }
	        to { transform: translateY(0); opacity: 1; }
	    }
	
	    /* Heading */
	    h2 {
	        font-family: 'Georgia', serif;
	        font-size: 32px;
	        color:  #2F3E2F;;
	        margin-bottom: 25px;
	        letter-spacing: 2px;
	        position: relative;
	        transition: color 0.3s;
	    }
	
	    h2:hover {
	        color: #d3544a;
	    }
	
	    /* Inputs */
	    input[type=email], input[type=password] {
	        width: 100%;
	        padding: 14px;
	        margin: 12px 0;
	        border: 1px solid #ccc;
	        border-radius: 10px;
	        transition: border 0.3s, box-shadow 0.3s;
	    }
	
	    input[type=email]:focus, input[type=password]:focus {
	        border-color: #ff6f61;
	        box-shadow: 0 0 10px rgba(255,111,97,0.5);
	        outline: none;
	    }
	
	    /* Submit Button */
	    input[type=submit] {
	        width: 60%;
	        padding: 14px;
	        background-color: #ff6f61;
	        color: white;
	        border: none;
	        border-radius: 10px;
	        cursor: pointer;
	        font-size: 16px;
	        transition: background 0.3s, transform 0.2s;
	    }
	
	    input[type=submit]:hover {
	        background-color: #d3544a;
	        transform: scale(1.05);
	    }
	
	    /* Links */
	    .register-link, .forgot-link {
	        margin-top: 12px;
	        font-size: 14px;
	    }
	
	    .register-link a, .forgot-link a {
	        text-decoration: none; /* Remove underline */
	        color: #ff6f61;
	        transition: color 0.3s;
	    }
	
	    .register-link a:hover, .forgot-link a:hover {
	        color: #2F3E2F;
	    }
	</style>
	
	</head>
	<body>
	
	<div class="container">
	    <h2>Teddy Shop</h2>
	
	    <form action="LoginPage" method="post">
	        <input type="email" name="username" placeholder="Enter Email" required>
	        <input type="password" name="password" placeholder="Enter Password" required>
	        <input type="submit" value="Login">
	    </form>
	
	    <div class="register-link">
	        <p>Don't have an account? <a href="Registration.jsp">Register Here</a></p>
	    </div>
	
	    <div class="forgot-link">
	        <a href="ForgotPassword.jsp">Forgot Password?</a>
	    </div>
	</div>
	
	</body>
	</html>