Q7. Write a Java Program for Shortening a string to a specified length and adds an ellipsis using user
defined function truncate()
  // 7. Function to truncate a string to a specified length
public static String truncate(String str, int maxLength) {
if (str == null) {
return null;
}
return str.length() &gt; maxLength ? str.substring(0, maxLength) + &quot;...&quot; : str;
}
