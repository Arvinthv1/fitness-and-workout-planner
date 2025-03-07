import java.io.IOException; 
import java.io.PrintWriter; 
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.PreparedStatement; 
import java.sql.SQLException; 
  
         import javax.servlet.ServletException; 
import javax.servlet.annotation.WebServlet; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
@WebServlet("/register") 
public class RegisterServlet extends HttpServlet { 
    private final static String query = "insert into usersdetails(name, email, mobile, dob, city, gender, role) values(?, ?, ?, ?, ?, ?, ?)"; 
    @Override 
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws 
ServletException, IOException { 
        PrintWriter pw = res.getWriter(); 
        res.setContentType("text/html"); 
        pw.println("<link rel='stylesheet' href='css/bootstrap.css'></link>"); 
        String name = req.getParameter("userName"); 
        String email = req.getParameter("email"); 
        String mobile = req.getParameter("mobile"); 
        String dob = req.getParameter("dob"); 
        String city = req.getParameter("city"); 
        String gender = req.getParameter("gender"); 
        String role = req.getParameter("role"); 
        try { 
            Class.forName("com.mysql.cj.jdbc.Driver"); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } 
        try (Connection con = DriverManager.getConnection("jdbc:mysql:///fitness", "root", 
"snehamohan777"); 
             PreparedStatement ps = con.prepareStatement(query)) { 
            ps.setString(1, name); 
            ps.setString(2, email); 
            ps.setString(3, mobile); 
            ps.setString(4, dob); 
            ps.setString(5, city); 
            ps.setString(6, gender); 
            ps.setString(7, role); 
            int count = ps.executeUpdate(); 
            pw.println("<div class='card' style='margin:auto;width:300px;margin-top:100px'>"); 
            if (count == 1) { 
                pw.println("<h2 class='bg-danger text-light text-center'>Record Registered 
Successfully</h2>"); 
            } else { 
                pw.println("<h2 class='bg-danger text-light text-center'>Record Not Registered</h2>"); 
            } } catch (SQLException se) { 
            
 pw.println("<h2 class='bg-danger text-light text-center'>" + se.getMessage() + "</h2>"); 
            se.printStackTrace(); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } 
        pw.println("<a href='home.html'><button class='btn btn-outline
success'>Home</button></a>"); 
        pw.println("</div>"); 
        pw.close(); 
    } 
    @Override 
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws 
ServletException, IOException { 
        doGet(req, res); 
    } 
}
