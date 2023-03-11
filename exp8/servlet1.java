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
public class NewServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String s = request.getParameter("gets");  
        Date today = new Date();
        Locale locale = US;
        DateFormat fmt = null;
        fmt = DateFormat.getDateInstance(FULL, locale);
        LocalTime t = LocalTime.now(ZoneId.of("US/Hawaii"));
        try (PrintWriter out = response.getWriter()) {  
            out.println("<!DOCTYPE html>");
            out.println("<html>");
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
            out.println("<form class=\"q1\" name=\"fm\">\n" +
            "<h2>Hey Men/Women,</h2>"+"The Time-Zone Selected is <b>"+s+" - ");            
        Cookie c = new Cookie("mine",s);
        response.addCookie(c);
            if(s.equals("HST")){
                out.println("Hawaii Standard Time ");
                t = LocalTime.now(ZoneId.of("US/Hawaii"));            }
            else if(s.equals("JST")){
                out.println("Japan Standard Time ");
                t = LocalTime.now(ZoneId.of("Japan"));            }
            else if(s.equals("IST")){
                out.println("India Standard Time");
                t = LocalTime.now(ZoneId.of("Asia/Kolkata"));            }
            else if(s.equals("IET")){
                out.println("Indiana Eastern Standard Time");
                t = LocalTime.now(ZoneId.of("America/Indianapolis"));            }
            else if(s.equals("BST")){
                out.println("Bangladesh Standard Time");
                t = LocalTime.now(ZoneId.of("Asia/Dhaka"));            }
            else if(s.equals("NST")){
                out.println("New Zealand Standard Time");
                t = LocalTime.now(ZoneId.of("Pacific/Auckland"));            }
            else if(s.equals("CTT")){
                out.println("China Taiwan Time");
                t = LocalTime.now(ZoneId.of("Asia/Shanghai"));            }
            else if(s.equals("CNT")){
                out.println("Canada Newfoundland Time");
                t = LocalTime.now(ZoneId.of("Canada/Newfoundland"));            }
            else if(s.equals("ACT")){
                out.println("Australia Central Time");
                t = LocalTime.now(ZoneId.of("Australia/Broken_Hill"));            }
            else if(s.equals("AET")){
                out.println("Australia Eastern Time");
                t = LocalTime.now(ZoneId.of("Australia/Currie"));            }
            out.println("</b><br><br> The Date is "+fmt.format(today)+"<br>Time is "+t+"<br>");            
              out.println("</form><br><form action=\"http://localhost:8080/Experiment8/NewServlet1\">"
                      + "\n"+"<button>Proceed</button> "
                      + "</form>");
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
