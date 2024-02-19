<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Response Page</title>
</head>
<body>
<%
    String name = request.getParameter("name");
%>
<h2>Hello, <%= name %>! You clicked the button!</h2>
</body>
</html>
