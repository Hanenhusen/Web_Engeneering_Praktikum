<%--
  Created by IntelliJ IDEA.
  User: arkbb
  Date: 12.05.2022
  Time: 17:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import= "bean.Person" %>

<html>
<head>
    <%--<% Person p = new Person("David", "Duke", 71);
      request.setAttribute ("person", p);

    %> --%>




   </head>
   <jsp:useBean id="Person" class="bean.Person" scope="request"/>
   <div><jsp:setProperty name="Person" property="lastName" value="l" />
       <jsp:setProperty name="Person" property="firstName" value="p"/>
       <jsp:setProperty name="Person" property="age" value="2" />
    <jsp:getProperty name="Person" property="lastName" />
    <jsp:getProperty name="Person" property="firstName"/>
    <jsp:getProperty name="Person" property="age" />

       </div>
   </br> </br>
   <%--
   <  <%= p.getLastName() %>
    <%= p.getFirstName() %>
    <%= p.getAge() %> --%>




</body>
</html>
