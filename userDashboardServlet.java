import java.io.IOException; 
import javax.servlet.ServletException; 
import javax.servlet.annotation.WebServlet; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
import javax.servlet.http.HttpSession; 
 
@WebServlet("/userdashboard") 
public class userDashboardServlet extends HttpServlet { 
    private static final long serialVersionUID = 1L; 
    @Override 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws 
ServletException, IOException { 
        HttpSession session = request.getSession(); 
        String userName = (String) session.getAttribute("userName"); 
        if (userName == null || userName.isEmpty()) { 
            response.sendRedirect("login.html");  
            return; 
        } 
        request.setAttribute("userName", userName); 
        request.getRequestDispatcher("userdashboard.html").forward(request, response); 
    } 
    @Override 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws 
ServletException, IOException { 
        doGet(request, response);  
    } 
}
