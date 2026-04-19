<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Student Marks Entry</title>
<script>
function validateForm() {
    var rollno = document.forms["studentForm"]["rollno"].value;
    var name = document.forms["studentForm"]["studentname"].value;
    var subjects = ["sub1","sub2","sub3","sub4","sub5"];
    if (rollno == "" || name == "") {
        alert("Roll number and name are required");
        return false;
    }
    for (var i=0; i<subjects.length; i++) {
        var val = document.forms["studentForm"][subjects[i]].value;
        if (val == "" || isNaN(val) || val < 0 || val > 100) {
            alert("Please enter valid marks (0-100) for " + subjects[i]);
            return false;
        }
    }
    return true;
}
</script>
</head>
<body>
<h2>Enter Student Details</h2>
<form name="studentForm" action="ResultServlet" method="post" onsubmit="return validateForm()">
    Roll No: <input type="text" name="rollno"><br><br>
    Student Name: <input type="text" name="studentname"><br><br>
    Subject 1: <input type="text" name="sub1"><br><br>
    Subject 2: <input type="text" name="sub2"><br><br>
    Subject 3: <input type="text" name="sub3"><br><br>
    Subject 4: <input type="text" name="sub4"><br><br>
    Subject 5: <input type="text" name="sub5"><br><br>
    <input type="submit" value="Submit">
</form>
</body>
</html>
