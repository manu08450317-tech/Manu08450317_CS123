/*2 a. Develop a java program for performing various string operations with different string handling
functions directed as follows
String Creation and Basic Operations, Length and Character Access, String Comparison, String Searching,
Substring Operations , String Modification, Whitespace Handling, String Concatenation, String
Splitting, StringBuilder Demo, String Formatting , Validate Email with contains( ) and startsWith() and
endsWith()*/





package program2;


import java.util.*;

public class StringOperationsDemo {
    public static void main(String[] args) {
        // 1. String Creation and Basic Operations
        System.out.println("=== String Creation and Basic Operations ===");
        String str1 = "Hello, World!";
        String str2 = new String("Java Programming");
        System.out.println("str1: " + str1);
        System.out.println("str2: " + str2);

        // 2. Length and Character Access
        System.out.println("\n=== Length and Character Access ===");
        System.out.println("Length of str1: " + str1.length());
        System.out.println("Character at index 4 in str1: " + str1.charAt(4));

        // 3. String Comparison
        System.out.println("\n=== String Comparison ===");
        String str3 = "hello, world!";
        System.out.println("str1 equals str3: " + str1.equals(str3));
        System.out.println("str1 equalsIgnoreCase str3: " + str1.equalsIgnoreCase(str3));
        System.out.println("str1 compareTo str3: " + str1.compareTo(str3));

        // 4. String Searching
        System.out.println("\n=== String Searching ===");
        System.out.println("Index of 'World' in str1: " + str1.indexOf("World"));
        System.out.println("Last index of 'o' in str1: " + str1.lastIndexOf('o'));
        System.out.println("str1 contains 'Hello': " + str1.contains("Hello"));

        // 5. Substring Operations
        System.out.println("\n=== Substring Operations ===");
        System.out.println("Substring from index 7: " + str1.substring(7));
        System.out.println("Substring from 0 to 5: " + str1.substring(0, 5));

        // 6. String Modification
        System.out.println("\n=== String Modification ===");
        System.out.println("Uppercase: " + str1.toUpperCase());
        System.out.println("Lowercase: " + str1.toLowerCase());
        System.out.println("Replace 'World' with 'Java': " + str1.replace("World", "Java"));

        // 7. Whitespace Handling
        System.out.println("\n=== Whitespace Handling ===");
        String spaced = "   Trim Example   ";
        System.out.println("Original: '" + spaced + "'");
        System.out.println("After trim: '" + spaced.trim() + "'");

        // 8. String Concatenation
        System.out.println("\n=== String Concatenation ===");
        String s1 = "Hello";
        String s2 = "World";
        System.out.println("Using + operator: " + (s1 + " " + s2));
        System.out.println("Using concat(): " + s1.concat(" ").concat(s2));

        // 9. String Splitting
        System.out.println("\n=== String Splitting ===");
        String csv = "Java,Python,C++,JavaScript";
        String[] langs = csv.split(",");
        System.out.println("Languages:");
        for (String lang : langs) {
            System.out.println(lang);
        }

        // 10. StringBuilder Demo
        System.out.println("\n=== StringBuilder Demo ===");
        StringBuilder sb = new StringBuilder();
        sb.append("Learning ");
        sb.append("Java ");
        sb.append("Programming");
        System.out.println("Result: " + sb.toString());
        sb.insert(9, "Core ");
        System.out.println("After insert: " + sb.toString());
        sb.reverse();
        System.out.println("After reverse: " + sb.toString());

        // 11. String Formatting
        System.out.println("\n=== String Formatting ===");
        String formatted = String.format("Name: %s, Age: %d, Height: %.2f", "John", 25, 1.75);
        System.out.println("Formatted string: " + formatted);

        // 12. Validate Email
        System.out.println("\n=== Email Validation ===");
        String email = "user@example.com";
        boolean valid = validateEmail(email);
        System.out.println("Email: " + email);
        System.out.println("Is valid: " + valid);
    }

    // Helper method for email validation
    private static boolean validateEmail(String email) {
        return email != null &&
               email.contains("@") &&
               email.contains(".") &&
               email.indexOf("@") < email.lastIndexOf(".") &&
               !email.startsWith("@") &&
               !email.endsWith(".") &&
               email.startsWith("user") && // example check with startsWith()
               email.endsWith(".com");     // example check with endsWith()
    }
}
