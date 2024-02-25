<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Response Page</title>
</head>
<body>
<%
    String name = request.getParameter("name");
    boolean isValidInput = name != null && name.matches("^[a-zA-Z]*$");

    if (!isValidInput) {
%>
        <h2>You cannot use non-alphabetic characters.</h2>
<%
    } else {
%>
        <h2>Hello, <%= name %>! You clicked the button!</h2>
<%
    }
%>
    <!-- Back Link -->
    <a href="http://localhost:8081/Tal-Hasson/">Back to Home</a>
</body>
</html>
