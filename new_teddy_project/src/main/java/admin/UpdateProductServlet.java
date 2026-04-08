package admin;

import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/UpdateProductServlet")
public class UpdateProductServlet extends HttpServlet {

protected void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {

String id = request.getParameter("id");
String name = request.getParameter("name");
String price = request.getParameter("price");
String image = request.getParameter("image");

try{

Class.forName("com.mysql.cj.jdbc.Driver");
Connection con = DriverManager.getConnection(
"jdbc:mysql://localhost:3306/teddyshop","root","Jayesh@1008");

PreparedStatement ps = con.prepareStatement(
"update add_products set name=?,price=?,image=? where id=?");

ps.setString(1,name);
ps.setString(2,price);
ps.setString(3,image);
ps.setString(4,id);

ps.executeUpdate();

response.sendRedirect("AdminViewProducts");

}catch(Exception e){
e.printStackTrace();
}

}
}