package presentation.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;



//@WebServlet(urlPatterns ={ "/Auth" })
public class Auth extends HttpServlet {
    public Auth() {
        super();
    }

   // private String varName = "admin" ;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out=response.getWriter();
        String username = null;
        if(request.getParameter("username")!=null) {
             username = request.getParameter("username");
        }
        response.setContentType("text/html");
        //String pass = request.getParameter("pass");
        // String varName = null;

      if(username != null) {
          if (username.length() != 0) {
              HttpSession session = request.getSession();
              session.setAttribute("username", username);

              out.print("login successful: " + username);

              RequestDispatcher rd = request.getRequestDispatcher(response.encodeRedirectURL("./protected/index.html"));
              rd.forward(request, response);
          } else {
              response.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
              response.getWriter().println("<h1> no username was used <h1>");
          }
      }



      /*  HttpSession session =  request.getSession(false);

     //   String logtout=request.getParameter("logout");

      //  session.setAttribute("logout" );
         if(session != null) {
             session.invalidate();
             RequestDispatcher rd = request.getRequestDispatcher(response.encodeRedirectURL("./index.html"));
             rd.forward(request, response);
         }
         else{
             response.sendError(HttpServletResponse.SC_NOT_ACCEPTABLE, "ERROR!!!");

         }*/
    }
}
