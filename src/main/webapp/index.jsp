<!-- File: WebContent/index.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Product Management System</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body { background: linear-gradient(135deg, #667eea 0%, #764ba2 100%); min-height: 100vh; }
        .card { border-radius: 1rem; box-shadow: 0 10px 25px rgba(0,0,0,0.1); margin-top: 50px; }
        .btn-custom { width: 180px; margin: 10px; padding: 12px; font-weight: bold; border-radius: 50px; }
        h1 { color: #4a5568; font-weight: bold; }
    </style>
</head>
<body>
<div class="container">
    <div class="card">
        <div class="card-body text-center p-5">
            <h1 class="mb-4">📦 Product Management System</h1>
            <p class="lead mb-5">Product Management System</p>
            <div class="row justify-content-center">
                <div class="col-md-4"><a href="addProduct" class="btn btn-primary btn-custom">➕ Add Product</a></div>
                <div class="col-md-4"><a href="updateProduct" class="btn btn-warning btn-custom">✏️ Update Product</a></div>
                <div class="col-md-4"><a href="deleteProduct" class="btn btn-danger btn-custom">🗑️ Delete Product</a></div>
                <div class="col-md-4 mt-3"><a href="displayProducts" class="btn btn-info btn-custom">📋 View All Products</a></div>
                <div class="col-md-4 mt-3"><a href="reports.jsp" class="btn btn-success btn-custom">📊 Reports</a></div>
            </div>
        </div>
    </div>
</div>
</body>
</html>