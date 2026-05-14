<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Add Product</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body { background: #f0f2f5; }
        .container { max-width: 600px; margin-top: 40px; }
        .card { border-radius: 20px; box-shadow: 0 8px 20px rgba(0,0,0,0.1); }
        .back-btn { margin-top: 20px; }
    </style>
</head>
<body>
<div class="container">
    <div class="card">
        <div class="card-header bg-primary text-white text-center">
            <h3>➕ Add New Product</h3>
        </div>
        <div class="card-body">
            <% if(request.getAttribute("message") != null) { %>
                <div class="alert alert-success alert-dismissible fade show" role="alert">
                    <%= request.getAttribute("message") %>
                    <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
                </div>
            <% } %>
            <% if(request.getAttribute("error") != null) { %>
                <div class="alert alert-danger"><%= request.getAttribute("error") %></div>
            <% } %>
            <form action="addProduct" method="post" id="addForm">
                <div class="mb-3">
                    <label class="form-label">Auto-generated ID</label>
                    <input type="text" class="form-control" value="<%= request.getAttribute("nextId") != null ? request.getAttribute("nextId") : "" %>" disabled>
                </div>
                <div class="mb-3">
                    <label class="form-label">Product Name * (only letters and spaces)</label>
                    <input type="text" name="productName" class="form-control" value="<%= request.getAttribute("productName") != null ? request.getAttribute("productName") : "" %>" required>
                    <div class="text-danger"><%= request.getAttribute("nameError") != null ? request.getAttribute("nameError") : "" %></div>
                </div>
                <div class="mb-3">
                    <label class="form-label">Category *</label>
                    <select name="category" class="form-select" required>
                        <option value="">-- Select a category --</option>
                        <%
                            String selectedCategory = (String) request.getAttribute("category");
                            String[] categories = {
                                "electronics",
                                "textiles",
                                "groceries",
                                "home and furniture",
                                "beauty and personal care",
                                "health pharmacy",
                                "sports and outdoors",
                                "automotive",
                                "books and stationary",
                                "toys and baby products",
                                "digital products",
                                "jewellery and accessories",
                                "agriculture"
                            };
                            for (String cat : categories) {
                                String selectedAttr = (cat.equals(selectedCategory)) ? "selected" : "";
                        %>
                        <option value="<%= cat %>" <%= selectedAttr %>><%= cat %></option>
                        <% } %>
                    </select>
                    <div class="text-danger"><%= request.getAttribute("categoryError") != null ? request.getAttribute("categoryError") : "" %></div>
                </div>
                <div class="mb-3">
                    <label class="form-label">Price * (positive number)</label>
                    <input type="number" step="0.01" name="price" class="form-control" value="<%= request.getAttribute("price") != null ? request.getAttribute("price") : "" %>" required>
                    <div class="text-danger"><%= request.getAttribute("priceError") != null ? request.getAttribute("priceError") : "" %></div>
                </div>
                <div class="mb-3">
                    <label class="form-label">Quantity * (≥0)</label>
                    <input type="number" name="quantity" class="form-control" value="<%= request.getAttribute("quantity") != null ? request.getAttribute("quantity") : "" %>" required>
                    <div class="text-danger"><%= request.getAttribute("qtyError") != null ? request.getAttribute("qtyError") : "" %></div>
                </div>
                <button type="submit" class="btn btn-primary w-100">Save Product</button>
            </form>
            <div class="back-btn text-center">
                <a href="index.jsp" class="btn btn-secondary">🔙 Back to Home</a>
            </div>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>