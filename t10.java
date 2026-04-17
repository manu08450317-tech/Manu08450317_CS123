Q10. Write a Java Program for Counting the number of words in a string using user defined function
countWords()

  public class StringFunctionsDemo {

    // 1. Check if string is null or empty
    public static boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }

    // 2. Count occurrences of a substring
    public static int countOccurrences(String str, String word) {
        if (str == null || word == null || word.isEmpty()) return 0;
        String[] parts = str.split("\\s+");
        int count = 0;
        for (String part : parts) {
            if (part.equals(word)) {
                count++;
            }
        }
        return count;
    }

    // 3. Reverse a string
    public static String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    // 4. Check palindrome (ignoring case and non-alphanumeric)
    public static boolean isPalindrome(String str) {
        if (str == null) return false;
        String cleaned = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        return cleaned.equals(new StringBuilder(cleaned).reverse().toString());
    }

    // 5. Remove whitespace
    public static String removeWhitespace(String str) {
        return str.replaceAll("\\s+", "");
    }

    // 6. Capitalize words
    public static String capitalizeWords(String str) {
        String[] words = str.split("\\s+");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            if (!word.isEmpty()) {
                result.append(Character.toUpperCase(word.charAt(0)))
                      .append(word.substring(1))
                      .append(" ");
            }
        }
        return result.toString().trim();
    }

    // 7. Truncate string
    public static String truncate(String str, int length) {
        if (str == null || str.length() <= length) return str;
        return str.substring(0, length) + "...";
    }

    // 8. Check if numeric
    public static boolean isNumeric(String str) {
        return str != null && str.matches("\\d+");
    }

    // 9. Generate random string
    public static String generateRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder random = new StringBuilder(length);
        java.util.Random rand = new java.util.Random();
        for (int i = 0; i < length; i++) {
            int index = rand.nextInt(characters.length());
            random.append(characters.charAt(index));
        }
        return random.toString();
    }

    // 10. Count words
    public static int countWords(String str) {
        if (str == null || str.trim().isEmpty()) {
            return 0;
        }
        return str.trim().split("\\s+").length;
    }

    // Main method to demonstrate usage
    public static void main(String[] args) {
        System.out.println("1. Is Empty: " + isNullOrEmpty("")); // true
        System.out.println("2. Occurrences: " + countOccurrences("hello hello world", "hello")); // 2
        System.out.println("3. Reverse: " + reverseString("hello")); // olleh
        System.out.println("4. Palindrome: " + isPalindrome("A man, a plan, a canal: Panama")); // true
        System.out.println("5. Remove Whitespace: " + removeWhitespace("Hello World")); // HelloWorld
        System.out.println("6. Capitalize Words: " + capitalizeWords("hello world")); // Hello World
        System.out.println("7. Truncate: " + truncate("Hello World", 5)); // Hello...
        System.out.println("8. Is Numeric: " + isNumeric("12345")); // true
        System.out.println("9. Random String: " + generateRandomString(10)); // Random 10-char string
        System.out.println("10. Word Count: " + countWords("Hello world java")); // 3
    }
}
