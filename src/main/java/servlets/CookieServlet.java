/*8a. Build a servlet program to create a cookie to get your name through text box and press submit button(
through HTML) to display the message by greeting Welcome back your name ! , you have visited this page
n times ( n = number of your visit ) along with the list of cookies and demonstrate the expiry of cookie also.


*/





package servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        Cookie[] cookies = request.getCookies();
        String userName = null;
        int visitCount = 0;

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("user")) {
                    userName = cookie.getValue();
                }
                if (cookie.getName().equals("visits")) {
                    try {
                        visitCount = Integer.parseInt(cookie.getValue());
                    } catch (NumberFormatException e) {
                        visitCount = 0;
                    }
                }
            }
        }

        out.println("<html><head><title>Cookie Demo</title></head><body>");

        if (userName != null) {
            visitCount++;
            out.println("<h2 style='color:blue'>Welcome back, " + userName + "!</h2>");
            out.println("<h3 style='color:magenta'>You have visited this page " + visitCount + " times.</h3>");

            // Update visit count cookie with expiry
            Cookie visitCookie = new Cookie("visits", String.valueOf(visitCount));
            visitCookie.setMaxAge(60); // expires in 1 minute
            response.addCookie(visitCookie);

            // Show all cookies
            out.println("<h3>Cookies List:</h3><ul>");
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    out.println("<li>" + cookie.getName() + " = " + cookie.getValue() + "</li>");
                }
            }
            out.println("</ul>");

            // Logout option
            out.println("<form action='CookieServlet' method='post'>");
            out.println("<input type='submit' value='Logout'>");
            out.println("</form>");
        } else {
            // If no cookie, redirect to index.html
            response.sendRedirect("index.html");
        }

        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userName = request.getParameter("userName");

        if (userName != null && !userName.isEmpty()) {
            // Create user cookie with expiry
            Cookie userCookie = new Cookie("user", userName);
            userCookie.setMaxAge(60); // expires in 1 minute
            response.addCookie(userCookie);

            // Initialize visit count cookie
            Cookie visitCookie = new Cookie("visits", "1");
            visitCookie.setMaxAge(60);
            response.addCookie(visitCookie);
        } else {
            // Logout: delete cookies
            Cookie userCookie = new Cookie("user", "");
            userCookie.setMaxAge(0);
            response.addCookie(userCookie);

            Cookie visitCookie = new Cookie("visits", "");
            visitCookie.setMaxAge(0);
            response.addCookie(visitCookie);
        }

        // Redirect back to GET
        response.sendRedirect("CookieServlet");
    }
}