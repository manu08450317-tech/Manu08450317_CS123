Q4. Write a Java Program for Checking if a string reads the same backward as forward (ignoring case
and punctuation) using user defined function isPalindrome():
// 4. Function to check if a string is a palindrome
public static boolean isPalindrome(String str) {
if (str == null) {
return false;
}
String cleaned = str.replaceAll(&quot;[^a-zA-Z0-9]&quot;, &quot;&quot;).toLowerCase();
return cleaned.equals(new StringBuilder(cleaned).reverse().toString());
}
