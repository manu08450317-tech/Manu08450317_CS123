package servlet;

import dao.ProductDAO;
import model.Product;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deleteProduct")
public class DeleteProductServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter("id");
        if (idStr != null && !idStr.trim().isEmpty()) {
            try {
                int id = Integer.parseInt(idStr);
                ProductDAO dao = new ProductDAO();
                Product product = dao.getProductById(id);
                if (product != null) {
                    request.setAttribute("product", product);
                } else {
                    request.setAttribute("fetchError", "Product ID " + id + " not found");
                }
            } catch (Exception e) {
                request.setAttribute("fetchError", "Invalid ID");
            }
        }
        request.getRequestDispatcher("/productdelete.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter("productId");
        if (idStr == null || idStr.trim().isEmpty()) {
            request.setAttribute("error", "Product ID required");
            request.getRequestDispatcher("/productdelete.jsp").forward(request, response);
            return;
        }
        try {
            int id = Integer.parseInt(idStr);
            ProductDAO dao = new ProductDAO();
            boolean success = dao.deleteProduct(id);
            if (success) {
                request.setAttribute("message", "Product with ID " + id + " deleted successfully");
            } else {
                request.setAttribute("error", "Product not found or delete failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Database error: " + e.getMessage());
        }
        request.getRequestDispatcher("/productdelete.jsp").forward(request, response);
    }
}