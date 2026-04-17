Q3. Write a Java Program for Reversing the characters in a string using user defined function
reverseString().

  // 3. Function to reverse a string
public static String reverseString(String str) {
if (str == null) {
return null;
}
return new StringBuilder(str).reverse().toString();
}
