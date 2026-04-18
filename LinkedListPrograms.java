/*1c. Linked List Programs

1. Write a Java program to iterate through all elements in a linked list starting at the
specified position ( 2 nd ) using iterator ( hint : Iterator iteratorobj = listobj.listIterator(1))
2. Write a Java program to iterate a linked list in reverse order (using
objlist.descendingIterator())
3. Write a Java program to insert the specified element at the end of a linked list.( using
l_listobj.offerLast(&quot;Pink&quot;))
4. Write a Java program to display elements and their positions in a linked list ( using
l_listobj.get(p) )
5. Write a Java program that swaps two elements ( first and third elements ) in a linked list ( using
Collections.swap(l_list, 0, 2))*/






package program1;
import java.util.*;

public class LinkedListPrograms {
    public static void main(String[] args) {
        // Create LinkedList with colors
        LinkedList<String> colors = new LinkedList<>();
        colors.add("Red");
        colors.add("Blue");
        colors.add("Green");
        colors.add("Yellow");
        colors.add("Orange");

        System.out.println("Initial LinkedList: " + colors);

        // 1. Iterate through all elements starting at 2nd position using iterator
        System.out.println("\n1. Iterating from 2nd position:");
        Iterator<String> itr = colors.listIterator(1); // start at index 1 (2nd element)
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        // 2. Iterate in reverse order
        System.out.println("\n2. Iterating in reverse order:");
        Iterator<String> descItr = colors.descendingIterator();
        while (descItr.hasNext()) {
            System.out.println(descItr.next());
        }

        // 3. Insert specified element at the end
        System.out.println("\n3. Inserting 'Pink' at the end:");
        colors.offerLast("Pink");
        System.out.println("After insertion: " + colors);

        // 4. Display elements and their positions
        System.out.println("\n4. Displaying elements with positions:");
        for (int i = 0; i < colors.size(); i++) {
            System.out.println("Position " + i + ": " + colors.get(i));
        }

        // 5. Swap two elements (first and third)
        System.out.println("\n5. Swapping first and third elements:");
        Collections.swap(colors, 0, 2);
        System.out.println("After swap: " + colors);
    }
}
