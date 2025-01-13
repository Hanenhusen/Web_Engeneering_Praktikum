<%@ page import="java.util.Date" %>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: arkbb
  Date: 06.05.2022
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>




</head>
<body>
<form action="" method="post">

<p>Today's date: <%= (new Date()).toString()%></p>
    <p>  <%= 5*3 %></p>
<br/> <br/>
<%
    try {
        int num1 = Integer.parseInt(request.getParameter("num1"));
        int num2 = Integer.parseInt(request.getParameter("num2"));

%>
<label> Calculation: <% int result = num1 + num2;
    out.println(String.valueOf(result));
%> </label>
    <% } catch(NumberFormatException f){ %>
    <label>NO RESULTS!!!</label>
    <% } %>
<br/>
<input name="num1" id="num1" type="number"><br/>
<input name ="num2" id="num2" type="number"><br/>
<input type="submit" value="calculation"><br/>

</form>
<br>
<%! public static String encrypt(HttpServletRequest request) {
    StringBuffer result = new StringBuffer();
    String text = request.getParameter("password");
    String moving = request.getParameter("moving");
    if (moving != null && text != null) {
        int moving2 = Integer.valueOf(moving);
        for (int i = 0; i < text.length(); i++) {
            if (Character.isUpperCase(text.charAt(i))) {
                char ch = (char) (((int) text.charAt(i) +
                        moving2 - 65) % 26 + 65);
                result.append(ch);
            } else {
                char ch = (char) (((int) text.charAt(i) +
                        moving2 - 97) % 26 + 97);
                result.append(ch);
            }
        }
        return result.toString();
    } else
        return "error";
}%>




<form action="" method="post">

    <legend>Password generator</legend>
    <label>password
        <input name="password" id="password" type="text">
    </label>
    <br>
    <label>offset x
        <input name="moving" id="moving" type="number">
    </label>
    <br>
    <button type ="submit" onsubmit=<%String generation = encrypt(request);%> > generate a password </button>

</form>
<br>
<%= generation%>

<br>

<%= "the current HTTP Method: " + request.getMethod() %>
<%= application.getInitParameter("Praktikum")%>





</body>
</html>
