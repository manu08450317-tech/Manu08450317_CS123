/*6c. Build a servlet program to check the given number is prime number or not using HTML with step by
step procedure.*/




package PrimeServlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PrimeServlet")
public class PrimeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            // Get the number from the form
            int number = Integer.parseInt(request.getParameter("number"));

            // Prime check logic
            boolean isPrime = true;
            if (number <= 1) {
                isPrime = false;
            } else {
                for (int i = 2; i <= Math.sqrt(number); i++) {
                    if (number % i == 0) {
                        isPrime = false;
                        break;
                    }
                }
            }

            // Generate HTML response
            out.println("<html><head><title>Prime Result</title></head><body>");
            out.println("<div style='margin:20px; padding:20px; border:1px solid #ccc;'>");
            out.println("<h2>Prime Number Result</h2>");
            out.println("<p>Number: " + number + "</p>");
            if (isPrime) {
                out.println("<p style='color:green;'>" + number + " is a Prime Number</p>");
            } else {
                out.println("<p style='color:red;'>" + number + " is NOT a Prime Number</p>");
            }
            out.println("<a href='index.html'>Check Another Number</a>");
            out.println("</div></body></html>");
        } catch (NumberFormatException e) {
            // Handle invalid input
            out.println("<html><head><title>Error</title></head><body>");
            out.println("<h2 style='color:red;'>Invalid input! Please enter a valid integer.</h2>");
            out.println("<a href='index.html'>Try Again</a>");
            out.println("</body></html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("index.html");
    }
}

