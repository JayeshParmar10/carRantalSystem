<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Product</title>

<style>

body{
    font-family: Arial, Helvetica, sans-serif;
    background: linear-gradient(135deg, #EBF4DD, #A98B76);
    margin:0;
    padding:0;
}

.container{
    width:400px;
    margin:80px auto;
    background:white;
    padding:30px;
    border-radius:10px;
    box-shadow:0 10px 25px rgba(0,0,0,0.2);
}

h2{
    text-align:center;
    margin-bottom:20px;
}

label{
    font-weight:bold;
}

input[type=text]{
    width:100%;
    padding:10px;
    margin-top:5px;
    margin-bottom:15px;
    border:1px solid #ccc;
    border-radius:5px;
}

input[type=submit]{
    width:100%;
    padding:12px;
    background:#3498db;
    color:white;
    border:none;
    border-radius:6px;
    font-size:16px;
    cursor:pointer;
}

input[type=submit]:hover{
    background:#2980b9;
}

.back{
    display:block;
    text-align:center;
    margin-top:15px;
    text-decoration:none;
    color:#555;
}

.back:hover{
    color:#000;
}

</style>

</head>
<body>

<%
String id=request.getParameter("id");
String name=request.getParameter("name");
String price=request.getParameter("price");
String image=request.getParameter("image");
%>

<div class="container">

<h2>Edit Product</h2>

<form action="UpdateProductServlet" method="post">

<input type="hidden" name="id" value="<%=id%>">

<label>Product Name</label>
<input type="text" name="name" value="<%=name%>">

<label>Price</label>
<input type="text" name="price" value="<%=price%>">

<label>Image</label>
<input type="text" name="image" value="<%=image%>">

<input type="submit" value="Update Product">

</form>

<a href="AdminViewProducts" class="back">← Back to Products</a>

</div>

</body>
</html>