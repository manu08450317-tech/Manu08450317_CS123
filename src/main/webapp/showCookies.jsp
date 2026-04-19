<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Active Cookies</title>
</head>
<body>
    <h2>Active Cookie List</h2>
    <%
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie c : cookies) {
                out.println("Name: " + c.getName() + "<br>");
                out.println("Value: " + c.getValue() + "<br>");
                out.println("Max Age: " + c.getMaxAge() + " seconds<br><br>");
            }
        } else {
            out.println("<p>No active cookies found.</p>");
        }
    %>
    <br><a href="addCookie.jsp">Add Another Cookie</a>
</body>
</html>
