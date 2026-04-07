package cook;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/firstpage")
public class FirstPage extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");

        // Create a cookie
        Cookie ck = new Cookie("name", username);
        
        // Make sure it’s available for the entire app
        ck.setPath("/");  
        
        // Optionally set expiry time (in seconds)
        ck.setMaxAge(60 * 60); // 1 hour
        
        // Add cookie before writing output
        response.addCookie(ck);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.print("Welcome " + username);

        // Create a form to go to second page
        out.print("<html><body>");
        out.print("<form action='/cooikies/secondpage' method='post'>");
        out.print("<input type='submit' value='Go'>");
        out.print("</form>");
        out.print("</body></html>");
    }
}

