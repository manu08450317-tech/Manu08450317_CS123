Q6. Write a Java Program for Capitalizing the first letter of each word. using user defined function
capitalizeWords()
  // 6. Function to capitalize the first letter of each word
public static String capitalizeWords(String str) {
if (str == null || str.isEmpty()) {
return str;
}
StringBuilder result = new StringBuilder();
String[] words = str.split(&quot;\\s+&quot;);
for (String word : words) {
if (!word.isEmpty()) {
result.append(Character.toUpperCase(word.charAt(0)))
.append(word.substring(1).toLowerCase())
.append(&quot; &quot;);

}
}
return result.toString().trim();
}
