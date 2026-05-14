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

@WebServlet("/addProduct")
public class AddProductServlet extends HttpServlet {

    // Show the add product form with the next available ID
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            ProductDAO dao = new ProductDAO();
            int nextId = dao.getNextProductId();
            request.setAttribute("nextId", nextId);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Unable to generate next product ID");
        }
        request.getRequestDispatcher("/productadd.jsp").forward(request, response);
    }

    // Handle form submission
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("productName");
        String category = request.getParameter("category");
        String priceStr = request.getParameter("price");
        String qtyStr = request.getParameter("quantity");

        boolean hasError = false;

        // Product Name Validation: only letters and spaces (no digits or special characters)
        if (name == null || name.trim().isEmpty()) {
            request.setAttribute("nameError", "Product name is required");
            hasError = true;
        } else if (!name.matches("[a-zA-Z\\s]+")) {
            request.setAttribute("nameError", "Product name must contain only letters and spaces (no numbers or symbols)");
            hasError = true;
        } else {
            request.setAttribute("productName", name); // store valid name for re-display
        }

        // Category validation
        if (category == null || category.trim().isEmpty()) {
            request.setAttribute("categoryError", "Category is required");
            hasError = true;
        } else {
            request.setAttribute("category", category);
        }

        // Price validation
        BigDecimal price = null;
        try {
            price = new BigDecimal(priceStr);
            if (price.compareTo(BigDecimal.ZERO) <= 0) throw new NumberFormatException();
            request.setAttribute("price", priceStr);
        } catch (Exception e) {
            request.setAttribute("priceError", "Valid positive price required");
            hasError = true;
        }

        // Quantity validation
        int quantity = 0;
        try {
            quantity = Integer.parseInt(qtyStr);
            if (quantity < 0) throw new NumberFormatException();
            request.setAttribute("quantity", qtyStr);
        } catch (Exception e) {
            request.setAttribute("qtyError", "Valid non-negative quantity required");
            hasError = true;
        }

        // If validation fails, repopulate form with entered values and show errors
        if (hasError) {
            try {
                ProductDAO dao = new ProductDAO();
                request.setAttribute("nextId", dao.getNextProductId());
            } catch (Exception e) {
                e.printStackTrace();
            }
            request.getRequestDispatcher("/productadd.jsp").forward(request, response);
            return;
        }

        // Save product
        try {
            ProductDAO dao = new ProductDAO();
            int newId = dao.getNextProductId();
            Product product = new Product(newId, name.trim(), category.trim(), price, quantity);
            boolean success = dao.addProduct(product);
            if (success) {
                request.setAttribute("message", "Product added successfully! Auto-generated ID: " + newId);
                request.setAttribute("product", product);
                // Generate next ID for a fresh form
                request.setAttribute("nextId", dao.getNextProductId());
                // Clear form fields after success (except nextId)
                request.setAttribute("productName", "");
                request.setAttribute("category", "");
                request.setAttribute("price", "");
                request.setAttribute("quantity", "");
            } else {
                request.setAttribute("error", "Failed to add product");
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Database error: " + e.getMessage());
        }
        request.getRequestDispatcher("/productadd.jsp").forward(request, response);
    }
}