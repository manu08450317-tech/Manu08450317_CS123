<%@ page import="java.util.List, model.Product" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Report Result</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body { background: #f4f6f9; }
        .container { margin-top: 30px; }
    </style>
</head>
<body>
<div class="container">
    <div class="card shadow">
        <div class="card-header bg-secondary text-white">
            <h4>📊 Report Output 
            <% 
                String type = (String) request.getAttribute("reportType");
                if("price".equals(type)) out.print(" - Products with price greater than given amount");
                else if("category".equals(type)) out.print(" - Products by Category");
                else if("top".equals(type)) out.print(" - Top Selling Products");
            %>
            </h4>
        </div>
        <div class="card-body">
            <% if(request.getAttribute("error") != null) { %>
                <div class="alert alert-danger"><%= request.getAttribute("error") %></div>
            <% } else { 
                List<Product> results = (List<Product>) request.getAttribute("reportResults");
                if(results == null || results.isEmpty()) { %>
                    <div class="alert alert-warning">⚠️ No products match the selected criteria.</div>
                <% } else { %>
                    <div class="mb-3"><span class="badge bg-info">Total records: <%= results.size() %></span></div>
                    <table class="table table-bordered table-hover">
                        <thead class="table-dark">
                            <tr><th>ID</th><th>Name</th><th>Category</th><th>Price ($)</th><th>Quantity</th></tr>
                        </thead>
                        <tbody>
                        <% for(Product p : results) { %>
                            <tr><td><%= p.getProductId() %></td>
                                <td><%= p.getProductName() %></td>
                                <td><%= p.getCategory() %></td>
                                <td>$<%= p.getPrice() %></td>
                                <td><%= p.getQuantity() %></td>
                            </tr>
                        <% } %>
                        </tbody>
                    </table>
            <% } } %>
            <hr>
            <div class="d-flex justify-content-between">
                <a href="reports.jsp" class="btn btn-secondary">← Back to Report Criteria</a>
                <a href="index.jsp" class="btn btn-primary">🏠 Home</a>
            </div>
        </div>
    </div>
</div>
</body>
</html>