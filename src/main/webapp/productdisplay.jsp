<%@ page import="java.util.List, model.Product" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>All Products</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body { background: #f0f2f5; }
        .container { margin-top: 30px; }
        .table-hover tbody tr:hover { background-color: #f1f1f1; }
    </style>
</head>
<body>
<div class="container">
    <div class="card shadow">
        <div class="card-header bg-info text-white">
            <h3 class="mb-0">📋 Product Inventory List</h3>
        </div>
        <div class="card-body">
            <% if(request.getAttribute("error") != null) { %>
                <div class="alert alert-danger"><%= request.getAttribute("error") %></div>
            <% } else { 
                List<Product> list = (List<Product>) request.getAttribute("productList");
                if(list == null || list.isEmpty()) { %>
                    <div class="alert alert-secondary">No products found.</div>
                <% } else { %>
                    <table class="table table-bordered table-hover">
                        <thead class="table-dark">
                            <tr><th>ID</th><th>Name</th><th>Category</th><th>Price ($)</th><th>Quantity</th></tr>
                        </thead>
                        <tbody>
                        <% for(Product p : list) { %>
                            <tr><td><%= p.getProductId() %></td>
                                <td><%= p.getProductName() %></td>
                                <td><%= p.getCategory() %></td>
                                <td><%= p.getPrice() %></td>
                                <td><%= p.getQuantity() %></td>
                            </tr>
                        <% } %>
                        </tbody>
                    </table>
            <% } } %>
            <div class="text-center mt-3">
                <a href="index.jsp" class="btn btn-secondary">← Back to Home</a>
            </div>
        </div>
    </div>
</div>
</body>
</html>