<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reset Password</title>

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
    font-size: 30px;
    color: #2F3E2F;
    margin-bottom: 25px;
    letter-spacing: 1px;
}

/* Labels */
label {
    display: block;
    text-align: left;
    margin-top: 10px;
    font-weight: bold;
    color: #3B2F2F;
}

/* Inputs */
input[type=text],
input[type=password] {
    width: 100%;
    padding: 14px;
    margin: 10px 0;
    border: 1px solid #ccc;
    border-radius: 10px;
    transition: border 0.3s, box-shadow 0.3s;
}

input[type=text]:focus,
input[type=password]:focus {
    border-color: #ff6f61;
    box-shadow: 0 0 10px rgba(255,111,97,0.5);
    outline: none;
}

/* Submit Button */
input[type=submit] {
    width: 70%;
    padding: 14px;
    background-color: #ff6f61;
    color: white;
    border: none;
    border-radius: 10px;
    cursor: pointer;
    font-size: 16px;
    margin-top: 10px;
    transition: background 0.3s, transform 0.2s;
}

input[type=submit]:hover {
    background-color: #d3544a;
    transform: scale(1.05);
}

/* Back to login */
.back-link {
    margin-top: 15px;
}

.back-link a {
    text-decoration: none;
    color: #ff6f61;
    font-size: 14px;
}

.back-link a:hover {
    color: #2F3E2F;
}

</style>

</head>
<body>

<div class="container">

<h2>Reset Password</h2>

<form action="ForgotPasswordServlet" method="post">

<label>Email</label>
<input type="text" name="username" placeholder="Enter Email" required>

<label>New Password</label>
<input type="password" name="user_password" placeholder="Enter New Password" required>

<label>Confirm Password</label>
<input type="password" name="confrm_password" placeholder="Confirm Password" required>

<input type="submit" value="Update Password">

</form>

<div class="back-link">
    <a href="Login.jsp">Back to Login</a>
</div>

</div>

</body>
</html>