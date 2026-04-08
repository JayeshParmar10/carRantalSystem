<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Product</title>

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
        padding: 30px 40px;
        border-radius: 12px;
        box-shadow: 0 8px 20px rgba(0,0,0,0.1);
        width: 350px;
    }

    .form-container h2 {
        text-align: center;
        margin-bottom: 20px;
        color: #333;
    }

    label {
        font-weight: bold;
        display: block;
        margin-top: 15px;
        margin-bottom: 5px;
        color: #555;
    }

    input[type="text"],
    input[type="file"] {
        width: 100%;
        padding: 8px;
        border: 1px solid #ccc;
        border-radius: 6px;
        font-size: 14px;
    }

    input[type="text"]:focus {
        border-color: #4CAF50;
        outline: none;
    }

    button {
        width: 100%;
        margin-top: 20px;
        padding: 10px;
        background-color: #4CAF50;
        color: white;
        border: none;
        border-radius: 6px;
        font-size: 16px;
        cursor: pointer;
        transition: 0.3s;
    }

    button:hover {
        background-color: #45a049;
    }
</style>

</head>
<body>

<div class="form-container">
    <h2>Add Product</h2>

    <form action="UploadProductServlet" method="post" enctype="multipart/form-data">
        <label>Product Name</label>
        <input type="text" name="name" required>

		<label>Price</label>
        <input type="text" name="price" required>
        
        <label>Image</label>
        <input type="file" name="image" required>

		
       <!--  <label>description</label>
        <input type="text" name="description" required>
        --> 

        <button type="submit">Add Product</button>
    </form>
</div>

</body>
</html>