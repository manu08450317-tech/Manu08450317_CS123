package servlet;

import dao.ProductDAO;
import model.Product;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/report")
public class ReportServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String reportType = request.getParameter("reportType");
        String error = null;
        List<Product> results = null;

        try {
            ProductDAO dao = new ProductDAO();
            if ("price".equals(reportType)) {
                String minPriceStr = request.getParameter("minPrice");
                if (minPriceStr == null || minPriceStr.trim().isEmpty()) {
                    error = "Please enter minimum price";
                } else {
                    BigDecimal minPrice = new BigDecimal(minPriceStr);
                    results = dao.getProductsByPriceGreaterThan(minPrice);
                }
            } else if ("category".equals(reportType)) {
                String category = request.getParameter("category");
                if (category == null || category.trim().isEmpty()) {
                    error = "Please enter a category";
                } else {
                    results = dao.getProductsByCategory(category);
                }
            } else if ("top".equals(reportType)) {
                String topNStr = request.getParameter("topN");
                if (topNStr == null || topNStr.trim().isEmpty()) {
                    error = "Please enter N value";
                } else {
                    int topN = Integer.parseInt(topNStr);
                    if (topN <= 0) throw new NumberFormatException();
                    results = dao.getTopNProductsByQuantity(topN);
                }
            } else {
                error = "Invalid report type";
            }
        } catch (NumberFormatException e) {
            error = "Invalid numeric input (positive number required)";
        } catch (Exception e) {
            e.printStackTrace();
            error = "Database error: " + e.getMessage();
        }

        request.setAttribute("reportResults", results);
        request.setAttribute("error", error);
        request.setAttribute("reportType", reportType);
        request.getRequestDispatcher("/report_result.jsp").forward(request, response);
    }
}