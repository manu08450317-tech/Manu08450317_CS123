<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Add Cookie</title>
</head>
<body>
    <h2>Cookie Management - Add Cookie</h2>
    <form action="addCookie.jsp" method="post">
        Cookie Name: <input type="text" name="cname" required><br/><br/>
        Cookie Domain: <input type="text" name="cdomain" required><br/><br/>
        Max Age (in seconds): <input type="number" name="cage" required><br/><br/>
        <input type="submit" value="Add Cookie">
    </form>

    <%
        String cname = request.getParameter("cname");
        String cdomain = request.getParameter("cdomain");
        String cageStr = request.getParameter("cage");

        if (cname != null && cdomain != null && cageStr != null) {
            int maxAge = Integer.parseInt(cageStr);

            // Create cookie
            Cookie cookie = new Cookie(cname, cdomain);
            cookie.setMaxAge(maxAge);
            response.addCookie(cookie);

            out.println("<h3>Cookie Information:</h3>");
            out.println("Name: " + cname + "<br>");
            out.println("Domain: " + cdomain + "<br>");
            out.println("Max Age: " + maxAge + " seconds<br>");
            out.println("<br><a href='showCookies.jsp'>Go to Active Cookie List</a>");
        }
    %>
</body>
</html>
