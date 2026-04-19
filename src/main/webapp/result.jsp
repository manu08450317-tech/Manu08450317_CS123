<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Student Result</title>
</head>
<body>
<h2>Student Result</h2>
<%
    String error = (String) request.getAttribute("error");
    if (error != null) {
%>
    <p style="color:red;"><%= error %></p>
<%
    } else {
        String rollno = (String) request.getAttribute("rollno");
        String studentname = (String) request.getAttribute("studentname");
        int[] marks = (int[]) request.getAttribute("marks");
        double average = (double) request.getAttribute("average");
        String message = (String) request.getAttribute("message");
%>
    <p>Roll No: <%= rollno %></p>
    <p>Student Name: <%= studentname %></p>
    <p>Marks:</p>
    <ul>
        <li>Subject 1: <%= marks[0] %></li>
        <li>Subject 2: <%= marks[1] %></li>
        <li>Subject 3: <%= marks[2] %></li>
        <li>Subject 4: <%= marks[3] %></li>
        <li>Subject 5: <%= marks[4] %></li>
    </ul>
    <p>Average Marks: <%= average %></p>
    <p><b><%= message %></b></p>
<%
    }
%>
<a href="index.jsp">Back to Form</a>
</body>
</html>
