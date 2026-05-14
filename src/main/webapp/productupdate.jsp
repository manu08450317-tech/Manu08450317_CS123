<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.Product" %>

<!DOCTYPE html>
<html>
<head>
    <title>Update Product</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body { background: #f8f9fa; }
        .container { max-width: 700px; margin-top: 40px; }
    </style>
</head>
<body>
<div class="container">
    <div class="card">
        <div class="card-header bg-warning text-dark text-center"><h3>✏️ Update Product</h3></div>
        <div class="card-body">
            <% if(request.getAttribute("message") != null) { %>
                <div class="alert alert-success"><%= request.getAttribute("message") %></div>
            <% } %>
            <% if(request.getAttribute("error") != null) { %>
                <div class="alert alert-danger"><%= request.getAttribute("error") %></div>
            <% } %>
            <% if(request.getAttribute("fetchError") != null) { %>
                <div class="alert alert-danger"><%= request.getAttribute("fetchError") %></div>
            <% } %>
            
            <!-- Step 1: Fetch product by ID -->
            <form action="updateProduct" method="get" class="row g-3 mb-4">
                <div class="col-auto"><label class="form-label">Enter Product ID:</label></div>
                <div class="col-auto"><input type="number" name="id" class="form-control" required></div>
                <div class="col-auto"><button type="submit" class="btn btn-info">Fetch Product</button></div>
            </form>
            
            <!-- Step 2: Update form -->
            <% Product p = (Product) request.getAttribute("product"); %>
            <form action="updateProduct" method="post">
                <div class="mb-2"><label>Product ID</label>
                    <input type="text" name="productId" class="form-control" value="<%= p != null ? p.getProductId() : "" %>" readonly>
                </div>
                <div class="mb-2"><label>Name *</label>
                    <input type="text" name="productName" class="form-control" value="<%= p != null ? p.getProductName() : "" %>" required>
                    <div class="text-danger"><%= request.getAttribute("nameError") != null ? request.getAttribute("nameError") : "" %></div>
                </div>
                
                <!-- Category Dropdown (replaced text input) -->
                <div class="mb-2"><label>Category *</label>
                    <select name="category" class="form-control" required>
                        <option value="">-- Select Category --</option>
                        <option value="textiles" <%= (p != null && "textiles".equals(p.getCategory())) ? "selected" : "" %>>Textiles</option>
                        <option value="groceries" <%= (p != null && "groceries".equals(p.getCategory())) ? "selected" : "" %>>Groceries</option>
                        <option value="home and furniture" <%= (p != null && "home and furniture".equals(p.getCategory())) ? "selected" : "" %>>Home and Furniture</option>
                        <option value="beauty and personal care" <%= (p != null && "beauty and personal care".equals(p.getCategory())) ? "selected" : "" %>>Beauty and Personal Care</option>
                        <option value="health pharmacy" <%= (p != null && "health pharmacy".equals(p.getCategory())) ? "selected" : "" %>>Health Pharmacy</option>
                        <option value="sports and outdoors" <%= (p != null && "sports and outdoors".equals(p.getCategory())) ? "selected" : "" %>>Sports and Outdoors</option>
                        <option value="automotive" <%= (p != null && "automotive".equals(p.getCategory())) ? "selected" : "" %>>Automotive</option>
                        <option value="books and stationary" <%= (p != null && "books and stationary".equals(p.getCategory())) ? "selected" : "" %>>Books and Stationary</option>
                        <option value="toys and baby products" <%= (p != null && "toys and baby products".equals(p.getCategory())) ? "selected" : "" %>>Toys and Baby Products</option>
                        <option value="digital products" <%= (p != null && "digital products".equals(p.getCategory())) ? "selected" : "" %>>Digital Products</option>
                        <option value="jewellery and accessories" <%= (p != null && "jewellery and accessories".equals(p.getCategory())) ? "selected" : "" %>>Jewellery and Accessories</option>
                        <option value="agriculture" <%= (p != null && "agriculture".equals(p.getCategory())) ? "selected" : "" %>>Agriculture</option>
                    </select>
                    <div class="text-danger"><%= request.getAttribute("categoryError") != null ? request.getAttribute("categoryError") : "" %></div>
                </div>
                
                <div class="mb-2"><label>Price *</label>
                    <input type="number" step="0.01" name="price" class="form-control" value="<%= p != null ? p.getPrice() : "" %>" required>
                    <div class="text-danger"><%= request.getAttribute("priceError") != null ? request.getAttribute("priceError") : "" %></div>
                </div>
                <div class="mb-2"><label>Quantity *</label>
                    <input type="number" name="quantity" class="form-control" value="<%= p != null ? p.getQuantity() : "" %>" required>
                    <div class="text-danger"><%= request.getAttribute("qtyError") != null ? request.getAttribute("qtyError") : "" %></div>
                </div>
                <button type="submit" class="btn btn-warning w-100 mt-2">Update Product</button>
            </form>
            <div class="mt-3 text-center"><a href="index.jsp" class="btn btn-secondary">🔙 Back to Home</a></div>
        </div>
    </div>
</div>
</body>
</html>