package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/reportCriteria")
public class ReportCriteriaServlet extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String reportType = request.getParameter("reportType");
        String minPrice = request.getParameter("minPrice");
        String category = request.getParameter("category");
        String topN = request.getParameter("topN");
        
        // Server-side validation
        boolean hasError = false;
        if (reportType == null || reportType.isEmpty()) {
            request.setAttribute("error", "Please select a report type");
            hasError = true;
        } else {
            switch (reportType) {
                case "price":
                    if (minPrice == null || minPrice.trim().isEmpty()) {
                        request.setAttribute("error", "Minimum price required");
                        hasError = true;
                    } else {
                        try {
                            Double.parseDouble(minPrice);
                        } catch (NumberFormatException e) {
                            request.setAttribute("error", "Invalid price value");
                            hasError = true;
                        }
                    }
                    break;
                case "category":
                    if (category == null || category.trim().isEmpty()) {
                        request.setAttribute("error", "Category required");
                        hasError = true;
                    }
                    break;
                case "top":
                    if (topN == null || topN.trim().isEmpty()) {
                        request.setAttribute("error", "Top N value required");
                        hasError = true;
                    } else {
                        try {
                            int n = Integer.parseInt(topN);
                            if (n <= 0) throw new NumberFormatException();
                        } catch (NumberFormatException e) {
                            request.setAttribute("error", "Top N must be a positive integer");
                            hasError = true;
                        }
                    }
                    break;
                default:
                    request.setAttribute("error", "Invalid report type");
                    hasError = true;
            }
        }
        
        if (hasError) {
            // Forward back to form with error
            request.getRequestDispatcher("/reports.jsp").forward(request, response);
        } else {
            // Forward to ReportServlet for actual processing
            request.getRequestDispatcher("/report").forward(request, response);
        }
    }
}