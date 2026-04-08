<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
<title>View Products</title>

<style>
table{
border-collapse:collapse;
width:80%;
margin:auto;
}

th,td{
border:1px solid black;
padding:10px;
text-align:center;
}

img{
width:80px;
height:80px;
}
</style>

</head>

<body>

<h2 align="center">Product List</h2>

<table>

<tr>
<th>ID</th>
<th>Name</th>
<th>Price</th>
<th>Image</th>
<th>Action</th>
</tr>

<%
try{

Class.forName("com.mysql.cj.jdbc.Driver");

Connection con = DriverManager.getConnection(
"jdbc:mysql://localhost:3306/teddyshop","root","Jayesh@1008");

PreparedStatement ps = con.prepareStatement("SELECT * FROM products");

ResultSet rs = ps.executeQuery();

while(rs.next()){
%>

<tr>
<td><%=rs.getInt("id")%></td>
<td><%=rs.getString("name")%></td>
<td><%=rs.getString("price")%></td>

<td>
<img src="images/<%=rs.getString("image")%>">
</td>

<td>
<a href="deleteProduct?id=<%=rs.getInt("id")%>"
onclick="return confirm('Are you sure to delete?')">
Delete
</a>
</td>

</tr>

<%
}

rs.close();
ps.close();
con.close();

}catch(Exception e){
out.println(e);
}
%>

</table>

</body>
</html>