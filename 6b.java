
6b. Build a servlet program to create a cookie to get your name through text box and press submit button(
through HTML) to display the message by greeting Welcome back your name ! , you have visited this page
n times ( n = number of your visit ) and demonstrate the expiry of cookie also.

  package com.cookieservlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    int count = 0; // count for loading times

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // Step 4: Create or retrieve cookies
        String userName = request.getParameter("userName");
        if (userName != null && !userName.isEmpty()) {
            // Create a new cookie
            Cookie userCookie = new Cookie("user", userName);
            // Step 5: Set cookie properties
            userCookie.setMaxAge(60); // Cookie expires in 1 minute
            response.addCookie(userCookie);
        }

        // Step 7: Read existing cookies
        Cookie[] cookies = request.getCookies();
        String existingUser = null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("user")) {
                    existingUser = cookie.getValue();
                    break;
                }
            }
        }

        // Step 8: Generate HTML response
        out.println("<html>");
        out.println("<head><title>Cookie Example</title></head>");
        out.println("<body>");
        if (existingUser != null && !existingUser.isEmpty()) {
            count++;
            out.println("<font color=blue><h2>Welcome back, " + existingUser + "!</h2></font>");
            out.println("<font color=magenta><h2>You have visited this page " + count + " times!</h2></font>");
            out.println("<form action='CookieServlet' method='post'>");
            out.println("<input type='submit' value='Logout'>");
            out.println("</form>");
        } else {
            out.println("<h2 style='color:red;'>Welcome Guest! You have been logged out or kindly login first time</h2>");
            out.println("<form action='CookieServlet' method='get'>");
            out.println("Enter your name: <input type='text' name='userName'>");
            out.println("<input type='submit' value='Submit'>");
            out.println("</form>");
        }
        out.println("</body></html>");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Correct Logout Logic: delete cookie
        Cookie cookie = new Cookie("user", "");
        cookie.setMaxAge(0); // delete cookie
        response.addCookie(cookie);

        // Redirect back to the servlet
        response.sendRedirect("CookieServlet");
    }
}
