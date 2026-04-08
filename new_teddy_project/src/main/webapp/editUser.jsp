<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Profile</title>
    <style>
        body {
            font-family: Arial, sans-serif;
             background: linear-gradient(135deg, #EBF4DD, #A98B76);
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .form-container {
            background: white;
            padding: 25px;
            width: 350px;
            border-radius: 10px;
            box-shadow: 0px 4px 10px rgba(0,0,0,0.1);
        }

        .form-container h2 {
            text-align: center;
            margin-bottom: 20px;
            color: #333;
        }

        .form-group {
            margin-bottom: 15px;
        }

        .form-group label {
            display: block;
            margin-bottom: 5px;
            color: #555;
            font-size: 14px;
        }

        .form-group input {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 15px;
        }

        button {
            width: 100%;
            padding: 12px;
            background: #007bff;
            color: white;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
            margin-top: 10px;
            transition: 0.3s;
        }

        button:hover {
            background: #0056b3;
        }
    </style>
</head>
<body>

<div class="form-container">
    <form action="EditUser" method="post">

        <input type="hidden" name="userId" value="${id}">

        <h2>Edit Profile</h2>

        <div class="form-group">
            <label>Full Name</label>
            <input type="text" name="full_name" value="${full_name}" required>
        </div>

        <div class="form-group">
            <label>Email</label>
            <input type="email" name="email_address" value="${email_address}" required>
        </div>

        <div class="form-group">
            <label>Password</label>
            <input type="password" name="user_password" value="${user_password}">
        </div>

        <div class="form-group">
            <label>Confirm Password</label>
            <input type="password" name="confrm_password" value="${confrm_password}">
        </div>

        <div class="form-group">
            <label>Phone Number</label>
            <input type="text" name="phone_number" value="${phone_number}">
        </div>

        <button type="submit">Update</button>

    </form>
</div>

</body>
</html>