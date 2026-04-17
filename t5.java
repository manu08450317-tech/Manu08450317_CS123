Q5. Write a Java Program for Eliminating all whitespace characters from a string using user defined
function removeWhitespace()
// 5. Function to remove all whitespace from a string
public static String removeWhitespace(String str) {
return str == null ? null : str.replaceAll(&quot;\\s&quot;, &quot;&quot;);
}
