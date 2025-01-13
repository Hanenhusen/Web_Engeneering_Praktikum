import bean.Person;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns ={ "/InteractWithJSP" })
public class InteractWithJSP extends HttpServlet {
   // Person person = new Person("ron", "lo", 133);



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Person person = new Person();
        person.setLastName("sada");
        person.setFirstName("ds");
        person.setAge(4);
        request.setAttribute("Person", person);

        RequestDispatcher dispatcher = request.getRequestDispatcher("DataViewerServlet.jsp");



        dispatcher.forward(request, response);

    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Person person = new Person();
        person.setLastName("sada");
        person.setFirstName("ds");
        person.setAge(4);
        request.setAttribute("Person", person);

        RequestDispatcher dispatcher = request.getRequestDispatcher("DataViewerServlet.jsp");



        dispatcher.forward(request, response);

     /**   try {}catch(ServletException se){
            se.printStackTrace();
        } catch(IOException ioe){
            ioe.printStackTrace();
        }

        dispatcher.forward(request, response);**/


      /**  PrintWriter out=response.getWriter();
         request.setAttribute("lastName", person.getLastName());
         request.setAttribute("firstName", person.getFirstName());
         request.setAttribute("age", person.getAge());


         request.setAttribute("Person", person);


         RequestDispatcher dispatcher = request.getRequestDispatcher("./DataViewerServlet.jsp");

        try {
            dispatcher.forward(request, response);
        }catch(ServletException se){
            se.printStackTrace();
        } catch(IOException ioe){
            ioe.printStackTrace();
        }

        dispatcher.forward(request, response);**/

    }
}
