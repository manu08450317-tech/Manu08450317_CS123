/*1.a Develop a Java program for adding elements [Apple, Banana, Orange] into an ArrayList and a
LinkedList to perform the following operations with different functions directed as follows
1. Adding elements, 2. Adding element at specific index, 3. Adding multiple elements, 4. Accessing
elements,5. Updating elements, 6. Removing elements, 7. Searching elements, 8. List size, 9. Iterating
over list, 10. Using Iterator, 11. Sorting, 12. Sublist, 13. Clearing the list  give code*/









package program1;
import java.util.*;

public class ListOperationsDemo {
    public static void main(String[] args) {
        // 1. Adding elements
        ArrayList<String> arrayList = new ArrayList<>();
        LinkedList<String> linkedList = new LinkedList<>();

        arrayList.add("Apple");
        arrayList.add("Banana");
        arrayList.add("Orange");

        linkedList.add("Apple");
        linkedList.add("Banana");
        linkedList.add("Orange");

        System.out.println("ArrayList: " + arrayList);
        System.out.println("LinkedList: " + linkedList);

        // 2. Adding element at specific index
        arrayList.add(1, "Grapes");
        linkedList.add(2, "Mango");
        System.out.println("\nAfter adding at specific index:");
        System.out.println("ArrayList: " + arrayList);
        System.out.println("LinkedList: " + linkedList);

        // 3. Adding multiple elements
        arrayList.addAll(Arrays.asList("Pineapple", "Papaya"));
        linkedList.addAll(Arrays.asList("Kiwi", "Guava"));
        System.out.println("\nAfter adding multiple elements:");
        System.out.println("ArrayList: " + arrayList);
        System.out.println("LinkedList: " + linkedList);

        // 4. Accessing elements
        System.out.println("\nAccessing elements:");
        System.out.println("ArrayList element at index 2: " + arrayList.get(2));
        System.out.println("LinkedList element at index 3: " + linkedList.get(3));

        // 5. Updating elements
        arrayList.set(0, "Strawberry");
        linkedList.set(1, "Blueberry");
        System.out.println("\nAfter updating elements:");
        System.out.println("ArrayList: " + arrayList);
        System.out.println("LinkedList: " + linkedList);

        // 6. Removing elements
        arrayList.remove("Papaya");
        linkedList.remove(2);
        System.out.println("\nAfter removing elements:");
        System.out.println("ArrayList: " + arrayList);
        System.out.println("LinkedList: " + linkedList);

        // 7. Searching elements
        System.out.println("\nSearching elements:");
        System.out.println("ArrayList contains 'Orange': " + arrayList.contains("Orange"));
        System.out.println("LinkedList contains 'Mango': " + linkedList.contains("Mango"));

        // 8. List size
        System.out.println("\nList size:");
        System.out.println("ArrayList size: " + arrayList.size());
        System.out.println("LinkedList size: " + linkedList.size());

        // 9. Iterating over list (for-each loop)
        System.out.println("\nIterating over ArrayList:");
        for (String fruit : arrayList) {
            System.out.println(fruit);
        }

        System.out.println("\nIterating over LinkedList:");
        for (String fruit : linkedList) {
            System.out.println(fruit);
        }

        // 10. Using Iterator
        System.out.println("\nUsing Iterator on ArrayList:");
        Iterator<String> arrayIterator = arrayList.iterator();
        while (arrayIterator.hasNext()) {
            System.out.println(arrayIterator.next());
        }

        System.out.println("\nUsing Iterator on LinkedList:");
        Iterator<String> linkedIterator = linkedList.iterator();
        while (linkedIterator.hasNext()) {
            System.out.println(linkedIterator.next());
        }

        // 11. Sorting
        Collections.sort(arrayList);
        Collections.sort(linkedList);
        System.out.println("\nAfter sorting:");
        System.out.println("ArrayList: " + arrayList);
        System.out.println("LinkedList: " + linkedList);

        // 12. Sublist
        List<String> arraySubList = arrayList.subList(1, 3);
        List<String> linkedSubList = linkedList.subList(0, 2);
        System.out.println("\nSublist:");
        System.out.println("ArrayList sublist (1 to 3): " + arraySubList);
        System.out.println("LinkedList sublist (0 to 2): " + linkedSubList);

        // 13. Clearing the list
        arrayList.clear();
        linkedList.clear();
        System.out.println("\nAfter clearing:");
        System.out.println("ArrayList: " + arrayList);
        System.out.println("LinkedList: " + linkedList);
    }
}
