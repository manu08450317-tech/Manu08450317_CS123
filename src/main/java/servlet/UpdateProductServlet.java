package servlet;

import dao.ProductDAO;
import model.Product;
import java.io.IOException;
import java.math.BigDecimal;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/updateProduct")
public class UpdateProductServlet extends HttpServlet {
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
                    request.setAttribute("fetchError", "Product with ID " + id + " not found");
                }
            } catch (Exception e) {
                request.setAttribute("fetchError", "Invalid product ID");
            }
        }
        request.getRequestDispatcher("/productupdate.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter("productId");
        String name = request.getParameter("productName");
        String category = request.getParameter("category");
        String priceStr = request.getParameter("price");
        String qtyStr = request.getParameter("quantity");

        boolean hasError = false;
        int id = 0;
        try {
            id = Integer.parseInt(idStr);
        } catch (NumberFormatException e) {
            request.setAttribute("error", "Invalid product ID");
            hasError = true;
        }
        if (name == null || name.trim().isEmpty()) {
            request.setAttribute("nameError", "Product name required");
            hasError = true;
        }
        if (category == null || category.trim().isEmpty()) {
            request.setAttribute("categoryError", "Category required");
            hasError = true;
        }
        BigDecimal price = null;
        try {
            price = new BigDecimal(priceStr);
            if (price.compareTo(BigDecimal.ZERO) <= 0) throw new NumberFormatException();
        } catch (Exception e) {
            request.setAttribute("priceError", "Valid positive price required");
            hasError = true;
        }
        int quantity = 0;
        try {
            quantity = Integer.parseInt(qtyStr);
            if (quantity < 0) throw new NumberFormatException();
        } catch (Exception e) {
            request.setAttribute("qtyError", "Non-negative quantity required");
            hasError = true;
        }

        if (hasError) {
            Product partial = new Product();
            partial.setProductId(id);
            partial.setProductName(name);
            partial.setCategory(category);
            if (price != null) partial.setPrice(price);
            partial.setQuantity(quantity);
            request.setAttribute("product", partial);
            request.getRequestDispatcher("/productupdate.jsp").forward(request, response);
            return;
        }

        try {
            ProductDAO dao = new ProductDAO();
            Product product = new Product(id, name.trim(), category.trim(), price, quantity);
            boolean success = dao.updateProduct(product);
            if (success) {
                request.setAttribute("message", "Product updated successfully!");
                request.setAttribute("product", product);
            } else {
                request.setAttribute("error", "Update failed. Product may not exist.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Database error: " + e.getMessage());
        }
        request.getRequestDispatcher("/productupdate.jsp").forward(request, response);
    }
}