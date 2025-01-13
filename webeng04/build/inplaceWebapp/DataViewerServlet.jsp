<%--
  Created by IntelliJ IDEA.
  User: arkbb
  Date: 13.05.2022
  Time: 12:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import= "bean.Person" %>
<jsp:useBean id="Person" class="bean.Person" scope="request"/>
<jsp:getProperty name="Person" property="lastName" />
<jsp:getProperty name="Person" property="firstName"/>
<jsp:getProperty name="Person" property="age" />

<html>
<head>
    <title></title>
</head>
<body>

   <%-- <%= request.getAttribute("lastName") %>
    <%= request.getAttribute("firstName") %></br>
    <%= request.getAttribute("age") %></br>--%>
</br></br>
<% Person person = (Person) request.getAttribute("Person"); %>
<%= request.getAttribute("Person").toString() %>
        <%= person.getFirstName() %>
        <%= person.getLastName() %>
        <%= person.getAge() %>
    <form action="InteractWithJSP" method="post">
            <input type="submit" value="submit">
        </form>




</body>
</html>
