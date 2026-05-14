<%@ page import="model.Product" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Delete Product</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body { background: #f8f9fa; }
        .container { max-width: 700px; margin-top: 50px; }
        .card { border-radius: 1rem; box-shadow: 0 5px 15px rgba(0,0,0,0.1); }
    </style>
</head>
<body>
<div class="container">
    <div class="card">
        <div class="card-header bg-danger text-white">
            <h3 class="mb-0">🗑️ Delete Product</h3>
        </div>
        <div class="card-body">
            <% if(request.getAttribute("message") != null) { %>
                <div class="alert alert-success"><%= request.getAttribute("message") %></div>
            <% } %>
            <% if(request.getAttribute("error") != null) { %>
                <div class="alert alert-danger"><%= request.getAttribute("error") %></div>
            <% } %>

            <!-- Step 1: Fetch product by ID -->
            <form action="deleteProduct" method="get" class="row g-3 mb-4">
                <div class="col-auto"><label class="form-label">Enter Product ID:</label></div>
                <div class="col-auto"><input type="number" name="id" class="form-control" required></div>
                <div class="col-auto"><button type="submit" class="btn btn-secondary">Find Product</button></div>
            </form>

            <% Product p = (Product) request.getAttribute("product"); 
               if(p != null) { %>
                <div class="alert alert-warning">
                    <strong>Product Details:</strong><br>
                    ID: <%= p.getProductId() %> | Name: <%= p.getProductName() %> | Category: <%= p.getCategory() %> | Price: $<%= p.getPrice() %> | Qty: <%= p.getQuantity() %>
                </div>
                <form action="deleteProduct" method="post" onsubmit="return confirm('Are you sure to delete this product?')">
                    <input type="hidden" name="productId" value="<%= p.getProductId() %>">
                    <button type="submit" class="btn btn-danger w-100">Confirm Delete</button>
                </form>
            <% } else if(request.getAttribute("fetchError") != null) { %>
                <div class="alert alert-danger"><%= request.getAttribute("fetchError") %></div>
            <% } %>

            <!-- Back Button - returns to Home -->
            <div class="mt-4 text-center">
                <a href="index.jsp" class="btn btn-secondary">← Back to Home</a>
            </div>
        </div>
    </div>
</div>
</body>
</html>