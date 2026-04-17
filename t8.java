Q8. Write a Java Program for Verifying if a string contains only numeric characters using user defined
function isNumeric()
  // 8. Function to check if a string contains only digits
public static boolean isNumeric(String str) {
if (str == null || str.isEmpty()) {
return false;
}
return str.matches(&quot;\\d+&quot;);
}
