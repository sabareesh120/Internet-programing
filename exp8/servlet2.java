import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.http.HttpServletResponse;
import java.text.*;
import static java.text.DateFormat.*;
import java.time.*;
import java.util.*;
import static java.util.Locale.*;
public class NewServlet1 extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {  
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            Cookie[] cookies = request.getCookies();
            String name = "";
            if (cookies == null) {
                out.println(
                    "<h1>You are new user, go to home page and submit your institute's name");
                return;
            }
            else {
                for (Cookie c : cookies) {
                    String tname = c.getName();
                    if (tname.equals("mine")) {
                        name = c.getValue();
                    }
                }
            }
            out.println("<head>\n" +
"        <link rel=\"stylesheet\" href=\"newcss.css\">");
            out.println("<title>Servlet NewServlet</title>");            
            out.println("</head>");
            out.println("<body id=\"bd\">\n" +
"        <div id=\"hd\">\n" +
"            <h1>Time-Zone Web-Application using Servlet</h1>\n" +
"        </div>\n" +
"       \n" +
"        <div id=\"mn\">\n");            
            out.println("<h2>Cookie has been Stored,</h2>"+"The Cookie Recorded <b>- "+name);     
              out.println("        </div></body>");
            out.println("</html>");
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
