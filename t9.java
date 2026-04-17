
Q9. Write a Java Program for Creating a random string of a specified length using user defined
function generateRandomString()

  // 9. Function to generate a random string of specified length
  // Function to generate a random string of specified length
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
