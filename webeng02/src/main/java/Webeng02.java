import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.time.LocalDateTime;
import java.lang.Object;
import javax.servlet.http.Cookie;


@WebServlet(urlPatterns ={ "/Webeng02" })
public class Webeng02 extends HttpServlet {

    private String QResponse = null;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        //brings back the type of action
        String method = request.getMethod();
        //everything after question mark in the URL
        String action = request.getParameter("action");
      //initilizes the names of header as constants
        Enumeration<String> headerNames = request.getHeaderNames();
       // String browserInformation = request.getHeaderNames(“User-Agent“);

        if (action != null) {

            switch (action) {

                case "home":

                    PrintWriter out = response.getWriter();
                    out.println("<!doctype html>");
                    out.println("<h2> Welcome <h2>");
                    out.println("<h2> Karabelli <h2>");
                    out.println("<h2> 836230 <h2>");
                    break;

                case "header":
                    String description = "...";
                    QResponse =
                            "<table>" +
                                    "<th>Name</th>"+
                                    "<th>Wert</th>" +
                                    "<th>Beschreibung</th>";
                    while(headerNames.hasMoreElements()) {
                        String h = headerNames.nextElement();
                        String hV = request.getHeader(h);
                        if (hV != null) {
                            switch (h) {
                                case "Accept-Encoding":
                                    description = "Welche komprimierten Formate der Browser unterstützt";
                                    break;
                                case "Accept-Language":
                                    description = "Welche Sprachen der Browser akzeptiert";
                                    break;
                            }
                        } else {
                            hV = "null";
                        }
                        QResponse +=
                                "<tr>" +
                                        "<td>" + h + "</td>" +
                                        "<td>" + hV + "</td>" +
                                        "<td>" + description + "</td>" +
                                        "</tr>";
                    }
                    QResponse+="</table>";

                    break;

                case "cookie":


                    Cookie[] keks = request.getCookies();
                    QResponse = "<tr>";
                    try{
                        for(Cookie cookie : keks){
                            QResponse+=
                                    "<td>" +
                                            "Cookie Name: " + cookie.getName() +
                                            " || Cookie Value: " + cookie.getValue() +
                                            " || Cookie life expectancy: " + cookie.getMaxAge() +
                                            "</td>";
                        }
                    }
                    catch(NullPointerException n){
                        QResponse+= "<td>zero cookies</td>";
                    }
                    QResponse += "</tr>";

                    break;



                  /*  response.setContentType("text/html");
                    PrintWriter pwriter = response.getWriter();

                HttpSession session = request.getSession();
                    System.out.println(session);
                    Cookie co = new Cookie("xyz","cookie");
                    co.setMaxAge(60*60*24);
                        response.addCookie(co);*/






                case "search":

                    response.sendRedirect("https://duckduckgo.com/");
                    break;
            }

            //include dispatching wird verwendet
            PrintWriter out = response.getWriter();
            RequestDispatcher rd = request.getRequestDispatcher("/Navigation");
            rd.include(request, response);

            out.println("<p>"+ QResponse + "</p>");

            Cookie Date = new Cookie ("Date", LocalDateTime.now().toString());


            response.addCookie(Date);
            }



    response.getWriter().append("Served at: ").append(request.getContextPath());


    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
