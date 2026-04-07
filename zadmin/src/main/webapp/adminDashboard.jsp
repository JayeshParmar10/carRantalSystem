<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
    if (session.getAttribute("admin") == null) {
        response.sendRedirect("adminLogin.jsp");
    }
%>

<h1>Admin Dashboard</h1>

<ul>
    <li><a href="addProduct.jsp">Add Product</a></li>
    <li><a href="ProductServlet?action=view">View / Update / Delete Products</a></li>
    <li><a href="OrderServlet">View Customer Orders</a></li>
    <li><a href="LogoutServlet">Logout</a></li>
</ul>

</body>
</html>