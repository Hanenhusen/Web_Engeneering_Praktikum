import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns ={ "/Navigation" })
public class Navigation extends HttpServlet {



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
     String url = request.getRequestURL().toString();
        out.println("<!doctype html><html><head></head><body>");
        out.println("<ul>");
        out.println("<li><a href=' "+ url+ "?action=home'> Starting Page</a>");
        out.println("<li><a href=' "+ url+ "?action=header'> header</a>");
        out.println("<li><a href=' "+ url+ "?action=cookie'>cookie</a>");
       out.println("<li><a href=' "+ url+ "?action=search'> Search</a>");
        out.println("</ul>");
       out.println("</body></html>");
        response.setContentType("text/html");


    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}