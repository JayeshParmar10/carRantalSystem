package admin;

import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/DeleteProductServlet")
public class DeleteProductServlet extends HttpServlet {

protected void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {

String id = request.getParameter("id");

try{

Class.forName("com.mysql.cj.jdbc.Driver");
Connection con = DriverManager.getConnection(
"jdbc:mysql://localhost:3306/teddyshop","root","Jayesh@1008");

PreparedStatement ps = con.prepareStatement(
"delete from add_products where id=?");

ps.setString(1,id);

ps.executeUpdate();

response.sendRedirect("AdminViewProducts");

}catch(Exception e){
e.printStackTrace();
}

}
}