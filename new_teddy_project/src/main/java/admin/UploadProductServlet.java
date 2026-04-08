package admin;


import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import new_teddy_project.userfile.DBConnection;

@WebServlet("/UploadProductServlet")
@MultipartConfig
public class UploadProductServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	
    	/*
    	 * InputStream inputStream = filePart.getInputStream();

PreparedStatement ps = con.prepareStatement(
    "INSERT INTO add_products (name, price, image) VALUES (?, ?, ?)"
);

ps.setString(1, name);
ps.setString(2, price);
ps.setBlob(3, inputStream);
ps.executeUpdate();


PreparedStatement ps = con.prepareStatement(
    "SELECT image FROM add_products WHERE id=?"
);
ps.setInt(1, id);

ResultSet rs = ps.executeQuery();

if (rs.next()) {
    Blob blob = rs.getBlob("image");
    byte[] imageBytes = blob.getBytes(1, (int) blob.length());

    response.setContentType("image/jpeg");
    response.getOutputStream().write(imageBytes);
    <img src="DisplayImageServlet?id=1">
}
    	 * */

        try {
        	  Class.forName("com.mysql.cj.jdbc.Driver");
             
        	  DriverManager.getConnection("jdbc:mysql://localhost:3306/teddyshop", "root", "Jayesh@1008");
        	  
        	String name = request.getParameter("name");
            String price = request.getParameter("price");
            String descrption = request.getParameter("descrption");
            Part filePart = request.getPart("image");
            String fileName = filePart.getSubmittedFileName();

            String uploadPath = getServletContext().getRealPath("") + "images";
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) uploadDir.mkdir();

            filePart.write(uploadPath + File.separator + fileName);

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO teddyshop.add_products (name, image, price, descrption) VALUES (?, ?, ?,?)");

            ps.setString(1, name);
            ps.setString(2, fileName);
            ps.setDouble(3, Double.parseDouble(price));
            ps.setString(4, descrption);
            ps.executeUpdate();

            response.sendRedirect("admin.jsp");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

