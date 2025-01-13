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
public class Logout extends HttpServlet {


    // private String varName = "admin" ;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session =  request.getSession(false);

     //   String logtout=request.getParameter("logout");

      //  session.setAttribute("logout" );
         if(session != null) {
             session.invalidate();
             RequestDispatcher rd = request.getRequestDispatcher(response.encodeRedirectURL("./index.html"));
             rd.forward(request, response);
         }
         else{
             response.sendError(HttpServletResponse.SC_NOT_ACCEPTABLE, "ERROR!!!");

         }
    }
}