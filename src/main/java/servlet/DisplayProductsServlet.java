package servlet;

import dao.ProductDAO;
import model.Product;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/displayProducts")
public class DisplayProductsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            ProductDAO dao = new ProductDAO();
            List<Product> products = dao.getAllProducts();
            request.setAttribute("productList", products);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Failed to load products: " + e.getMessage());
        }
        request.getRequestDispatcher("/productdisplay.jsp").forward(request, response);
    }
}