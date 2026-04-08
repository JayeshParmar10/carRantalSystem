<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Registration</title>

<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f2f2f2;
    }
    .container {
        width: 400px;
        margin: 50px auto;
        padding: 20px;
        background: linear-gradient(135deg, #EBF4DD, #A98B76);
        border-radius: 8px;
        box-shadow: 0 0 10px gray;
    }
    h2 {
        text-align: center;
        color: #333;
    }
    input[type=text], input[type=email], input[type=password] {
        width: 90%;
        padding: 10px;
        margin: 8px 0;
        border: 1px solid #ccc;
        border-radius: 4px;
    }
    input[type=submit] {
        width: 50%;
        margin-left:100px;
        padding: 10px;
        background-color: green;
        color: white;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }
    input[type=submit]:hover {
        background-color: darkgreen;
    }
</style>

</head>
<body>

<div class="container">
    <h2>User Registration</h2>

    <form action="RegistrationPage" method="post">
        
        <label>Full Name</label>
        <input type="text" name="full_name" required>

        <label>Email Address</label>
        <input type="email" name="email_address" required>

        <label>Password</label>
        <input type="password" name="user_password" required>

        <label>Confirm Password</label>
        <input type="password" name="confrm_password" required>

        <label>Phone Number</label>
        <input type="text" name="phone_number" required>

        <input type="submit" value="Register">
    </form>
</div>

</body>
</html>