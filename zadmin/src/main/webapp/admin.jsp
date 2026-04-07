<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard</title>
    <style>
        body {
            margin: 0;
            font-family: Arial, sans-serif;
            background: #f4f4f4;
        }

        .sidebar {
            width: 220px;
            height: 100vh;
            background: #2c3e50;
            color: white;
            position: fixed;
            top: 0;
            left: 0;
            padding-top: 20px;
        }

        .sidebar h2 {
            text-align: center;
            margin-bottom: 30px;
        }

        .sidebar a {
            display: block;
            padding: 15px 20px;
            color: white;
            text-decoration: none;
            font-size: 16px;
            border-bottom: 1px solid rgba(255,255,255,0.1);
        }

        .sidebar a:hover {
            background: #1abc9c;
        }

        .content {
            margin-left: 220px;
            padding: 20px;
        }
    </style>
</head>
<body>

    <div class="sidebar">
        <h2>Admin Panel</h2>
        <a href="add-product.html">➕ Add Product</a>
        <a href="all-products">📦 All Products</a>
        <a href="orders">🧾 Orders</a>
        <a href="logout">🚪 Logout</a>
    </div>

    <div class="content">
        <h1>Welcome, Admin</h1>
        <p>Select an option from the sidebar.</p>
    </div>

</body>
</html>
