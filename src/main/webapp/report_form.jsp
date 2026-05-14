<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Report Criteria - Inventory Management</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            min-height: 100vh;
            padding: 30px 0;
        }
        .container {
            max-width: 650px;
        }
        .card {
            border-radius: 1rem;
            box-shadow: 0 15px 35px rgba(0,0,0,0.2);
            overflow: hidden;
        }
        .card-header {
            background: linear-gradient(45deg, #28a745, #20c997);
            padding: 1.5rem;
            text-align: center;
        }
        .card-header h3 {
            margin: 0;
            font-weight: bold;
            color: white;
        }
        .card-body {
            padding: 2rem;
            background: #ffffff;
        }
        .form-label {
            font-weight: 600;
            color: #2c3e50;
        }
        .btn-submit {
            background: linear-gradient(45deg, #28a745, #20c997);
            border: none;
            padding: 12px;
            font-weight: bold;
            font-size: 1.1rem;
            transition: transform 0.2s;
        }
        .btn-submit:hover {
            transform: scale(1.02);
            background: linear-gradient(45deg, #218838, #1aa179);
        }
        .dynamic-field {
            background: #f8f9fa;
            padding: 15px;
            border-radius: 10px;
            margin-top: 10px;
            transition: all 0.3s ease;
        }
        .back-btn {
            text-decoration: none;
            display: inline-block;
            margin-top: 20px;
        }
        .error-msg {
            color: #dc3545;
            font-size: 0.9rem;
            margin-top: 5px;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="card">
        <div class="card-header">
            <h3>📊 Generate Inventory Report</h3>
        </div>
        <div class="card-body">
            <!-- Display error if any (from server-side validation) -->
            <%
                String error = (String) request.getAttribute("error");
                if (error != null && !error.isEmpty()) {
            %>
                <div class="alert alert-danger alert-dismissible fade show" role="alert">
                    <strong>⚠️ Error:</strong> <%= error %>
                    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                </div>
            <%
                }
            %>

            <form action="report" method="post" id="reportForm">
                <!-- Report Type Selection -->
                <div class="mb-4">
                    <label class="form-label">📌 Select Report Type:</label>
                    <select name="reportType" id="reportType" class="form-select form-select-lg" required>
                        <option value="">-- Please choose an option --</option>
                        <option value="price">💰 Products with price greater than (Amount)</option>
                        <option value="category">📂 Products in a specific category</option>
                        <option value="top">🏆 Top N best-selling products (by quantity)</option>
                    </select>
                </div>

                <!-- Dynamic fields based on selection -->
                <div id="priceField" class="dynamic-field" style="display: none;">
                    <label class="form-label">💵 Minimum Price ($):</label>
                    <input type="number" step="0.01" name="minPrice" id="minPrice" class="form-control" placeholder="Enter amount, e.g., 100.00">
                    <small class="text-muted">Shows products with price greater than this value.</small>
                </div>

                <div id="categoryField" class="dynamic-field" style="display: none;">
                    <label class="form-label">📁 Category Name:</label>
                    <input type="text" name="category" id="category" class="form-control" placeholder="e.g., Electronics, Furniture, Clothing">
                    <small class="text-muted">Partial matches are allowed (case-insensitive).</small>
                </div>

                <div id="topField" class="dynamic-field" style="display: none;">
                    <label class="form-label">🔢 Top N Products:</label>
                    <input type="number" name="topN" id="topN" class="form-control" placeholder="e.g., 5" min="1">
                    <small class="text-muted">Sorts products by quantity (highest first) and shows top N.</small>
                </div>

                <!-- Submit Button -->
                <button type="submit" class="btn btn-success btn-submit w-100 mt-4">🚀 Generate Report</button>
            </form>

            <!-- Back Button -->
            <div class="text-center back-btn">
                <a href="index.jsp" class="btn btn-secondary btn-lg px-4">🔙 Back to Home</a>
            </div>
        </div>
    </div>
</div>

<!-- JavaScript for dynamic field display and client-side validation -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<script>
    const reportTypeSelect = document.getElementById('reportType');
    const priceDiv = document.getElementById('priceField');
    const categoryDiv = document.getElementById('categoryField');
    const topDiv = document.getElementById('topField');
    
    // Also get input references for validation
    const minPriceInput = document.getElementById('minPrice');
    const categoryInput = document.getElementById('category');
    const topNInput = document.getElementById('topN');
    
    function toggleFields() {
        // Hide all dynamic fields
        priceDiv.style.display = 'none';
        categoryDiv.style.display = 'none';
        topDiv.style.display = 'none';
        
        // Remove required attributes to avoid false blocking
        minPriceInput.removeAttribute('required');
        categoryInput.removeAttribute('required');
        topNInput.removeAttribute('required');
        
        const selected = reportTypeSelect.value;
        if (selected === 'price') {
            priceDiv.style.display = 'block';
            minPriceInput.setAttribute('required', 'required');
        } else if (selected === 'category') {
            categoryDiv.style.display = 'block';
            categoryInput.setAttribute('required', 'required');
        } else if (selected === 'top') {
            topDiv.style.display = 'block';
            topNInput.setAttribute('required', 'required');
        }
    }
    
    // Attach event listener
    reportTypeSelect.addEventListener('change', toggleFields);
    
    // Additional client-side validation before submit
    document.getElementById('reportForm').addEventListener('submit', function(e) {
        const selected = reportTypeSelect.value;
        if (!selected) {
            alert('Please select a report type.');
            e.preventDefault();
            return false;
        }
        
        // Validate specific fields
        if (selected === 'price') {
            const val = minPriceInput.value.trim();
            if (!val || isNaN(parseFloat(val)) || parseFloat(val) <= 0) {
                alert('Please enter a valid positive minimum price.');
                e.preventDefault();
                return false;
            }
        } else if (selected === 'category') {
            if (!categoryInput.value.trim()) {
                alert('Please enter a category name.');
                e.preventDefault();
                return false;
            }
        } else if (selected === 'top') {
            const topVal = topNInput.value.trim();
            if (!topVal || isNaN(parseInt(topVal)) || parseInt(topVal) <= 0) {
                alert('Please enter a valid positive integer for top N.');
                e.preventDefault();
                return false;
            }
        }
        return true;
    });
    
    // Trigger initial state (in case of form reload with error)
    toggleFields();
</script>
</body>
</html>