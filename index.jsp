<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Simple JSP App</title>
</head>
<body>
<h2>Welcome to the Simple JSP Web App!</h2>
<form action="response.jsp" method="post">
    <label for="name">Enter your name:</label>
    <input type="text" id="name" name="name" required="required"/>
    <input type="submit" value="Click Me!"/>
</form>
</body>
</html>
