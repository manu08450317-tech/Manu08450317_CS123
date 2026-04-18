/*1b. Array List programs

1. Write a java program for getting different colors through ArrayList interface and search whether
the color &quot;Red&quot; is available or not

2. Write a java program for getting different colors through ArrayList interface and remove the
2nd element and color &quot;Blue&quot; from the ArrayList

3. Write a java program for getting different colors through ArrayList interface and sort them
using Collections.sort( ArrayListObj)

4. Write a java program for getting different colors through ArrayList interface and extract the
elements 1st and 2nd from the ArrayList object by using SubList()

5. Write a java program for getting different colors through ArrayList interface and delete nth
element from the ArrayList object by using remove by index*/



package program1;
import java.util.*;

public class ArrayListColorsDemo {
    public static void main(String[] args) {
        // Create ArrayList with colors
        ArrayList<String> colors = new ArrayList<>();
        colors.add("Red");
        colors.add("Blue");
        colors.add("Green");
        colors.add("Yellow");
        colors.add("Orange");

        System.out.println("Initial Colors: " + colors);

        // 1. Search whether "Red" is available
        System.out.println("\n1. Searching for 'Red':");
        if (colors.contains("Red")) {
            System.out.println("'Red' is available in the list.");
        } else {
            System.out.println("'Red' is not available in the list.");
        }

        // 2. Remove 2nd element and color "Blue"
        System.out.println("\n2. Removing 2nd element and 'Blue':");
        if (colors.size() > 1) {
            colors.remove(1); // remove 2nd element (index 1)
        }
        colors.remove("Blue"); // remove "Blue" if present
        System.out.println("After removal: " + colors);

        // 3. Sort using Collections.sort()
        System.out.println("\n3. Sorting colors:");
        Collections.sort(colors);
        System.out.println("Sorted Colors: " + colors);

        // 4. Extract 1st and 2nd elements using subList()
        System.out.println("\n4. Extracting 1st and 2nd elements:");
        if (colors.size() >= 2) {
            List<String> subList = colors.subList(0, 2);
            System.out.println("SubList (1st and 2nd): " + subList);
        } else {
            System.out.println("Not enough elements to extract.");
        }

        // 5. Delete nth element using remove(index)
        System.out.println("\n5. Deleting nth element:");
        int n = 3; // Example: delete 3rd element
        if (n > 0 && n <= colors.size()) {
            colors.remove(n - 1);
            System.out.println("After deleting " + n + "rd element: " + colors);
        } else {
            System.out.println("Invalid index!");
        }
    }
}
