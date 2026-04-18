
/*2.b. Develop a Java program to make a Performance Test on StringBuffer and StringBuilder for appending
the string ‘AIET’ for 10000 times both in the StringBuffer and StringBuilder. Justify your answer which
one is better.*/



package program2;


public class StringPerformanceTest {
    public static void main(String[] args) {
        int iterations = 10000;

        // Test StringBuffer
        long startBuffer = System.currentTimeMillis();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sbf.append("AIET");
        }
        long endBuffer = System.currentTimeMillis();
        long bufferTime = endBuffer - startBuffer;

        // Test StringBuilder
        long startBuilder = System.currentTimeMillis();
        StringBuilder sbd = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sbd.append("AIET");
        }
        long endBuilder = System.currentTimeMillis();
        long builderTime = endBuilder - startBuilder;

        // Results
        System.out.println("Performance Test Results:");
        System.out.println("StringBuffer time: " + bufferTime + " ms");
        System.out.println("StringBuilder time: " + builderTime + " ms");

        // Justification
        if (bufferTime > builderTime) {
            System.out.println("\nConclusion: StringBuilder is faster because it is not synchronized.");
        } else {
            System.out.println("\nConclusion: StringBuffer is faster (rare case), but usually StringBuilder is better for single-threaded operations.");
        }
    }
}
