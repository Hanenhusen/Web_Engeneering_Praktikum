package presentation.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicInteger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


//@WebServlet(urlPatterns ={ "protected/Stats" })
public class Stats extends HttpServlet {


    private static AtomicInteger pageViews = new AtomicInteger(0);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();


        HttpSession session = request.getSession();
        String currentUsers = (String) session.getAttribute("username");








        out.println("<h1>Stats</h1>");
        out.println("<ul>");
        out.println("<li><a href='./index.html'>Startseite</a></li>");
        out.println("</ul>");
       out.println("<h2>the name of the current user: " +  currentUsers + "</h2>");
      out.println("<h2> Seitenaufrufe: " + pageViews.incrementAndGet() + "</h2>");


    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
