package admin;

import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/AdminViewProducts")
public class AdminViewProducts extends HttpServlet {

protected void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {

response.setContentType("text/html");
PrintWriter out = response.getWriter();

out.println("<html>");
out.println("<head>");
out.println("<title>Admin Products</title>");

out.println("<style>");

out.println("body{font-family:Arial;background:linear-gradient(135deg,#EBF4DD,#A98B76);margin:0;padding:20px;}");

out.println("h2{text-align:center;color:#2F3E2F;}");

out.println(".container{display:flex;flex-wrap:wrap;justify-content:center;}");

out.println(".card{background:white;width:250px;margin:15px;padding:15px;border-radius:10px;box-shadow:0 6px 15px rgba(0,0,0,0.2);text-align:center;}");

out.println(".card img{width:100%;height:200px;border-radius:8px;}");

out.println(".name{font-size:18px;font-weight:bold;margin-top:10px;}");

out.println(".price{color:#27ae60;font-size:16px;margin:5px 0;}");

out.println(".btn{display:inline-block;padding:8px 14px;margin:5px;text-decoration:none;border-radius:5px;color:white;}");

out.println(".edit{background:#3498db;}");

out.println(".delete{background:#e74c3c;}");

out.println(".btn:hover{opacity:0.8;}");

out.println("</style>");

out.println("</head>");
out.println("<body>");

out.println("<h2>Admin Product List</h2>");
out.println("<div class='container'>");

try{

Class.forName("com.mysql.cj.jdbc.Driver");
Connection con = DriverManager.getConnection(
"jdbc:mysql://localhost:3306/teddyshop","root","Jayesh@1008");

PreparedStatement ps = con.prepareStatement("select * from add_products");
ResultSet rs = ps.executeQuery();

while(rs.next()){

int id = rs.getInt("id");
String name = rs.getString("name");
String price = rs.getString("price");
String image = rs.getString("image");

out.println("<div class='card'>");

out.println("<img src='images/" + image + "'>");

out.println("<div class='name'>"+name+"</div>");

out.println("<div class='price'>₹"+price+"</div>");

out.println("<a class='btn edit' href='editProduct.jsp?id="+id+"&name="+name+"&price="+price+"&image="+image+"'>Edit</a>");

out.println("<a class='btn delete' href='DeleteProductServlet?id="+id+"' onclick=\"return confirm('Delete this product?')\">Delete</a>");

out.println("</div>");

}

out.println("</div>");

}catch(Exception e){
e.printStackTrace();
}

out.println("</body>");
out.println("</html>");

}
}