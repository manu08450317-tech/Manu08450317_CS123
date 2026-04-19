

/*10.b Build an Application to get Rollno, Studentname, Sub1, Sub2, Sub3, Sub4 and Sub5 through JSP
called index.jsp with client sided validation and submit to the servlet called ResultServlet and process all
the fields with server sided validation and display all the data along with result ( Pass if all subjects
greater than 40%) and Average marks through result.jsp with a link to move to the client side*/




package com.HTTP_REQ_RES;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ResultServlet")
public class ResultServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String rollno = request.getParameter("rollno");
        String studentname = request.getParameter("studentname");

        int[] marks = new int[5];
        boolean valid = true;

        try {
            for (int i = 0; i < 5; i++) {
                marks[i] = Integer.parseInt(request.getParameter("sub" + (i+1)));
                if (marks[i] < 0 || marks[i] > 100) {
                    valid = false;
                }
            }
        } catch (NumberFormatException e) {
            valid = false;
        }

        String message;
        if (rollno == null || rollno.trim().isEmpty() ||
            studentname == null || studentname.trim().isEmpty() || !valid) {
            message = "Invalid input. Please enter correct details.";
            request.setAttribute("error", message);
        } else {
            int total = 0;
            boolean pass = true;
            for (int m : marks) {
                total += m;
                if (m < 40) {
                    pass = false;
                }
            }
            double average = total / 5.0;
            message = pass ? "Result: PASS" : "Result: FAIL";

            request.setAttribute("rollno", rollno);
            request.setAttribute("studentname", studentname);
            request.setAttribute("marks", marks);
            request.setAttribute("average", average);
            request.setAttribute("message", message);
        }

        RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
        rd.forward(request, response);
    }
}
