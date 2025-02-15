package Feb14;

public class StringConcatenationComparison {
    public static void main(String[] args) {
        int iterations = 1_000_000;
        String text = "hello";

        // Measure time for StringBuffer
        long startTimeBuffer = System.nanoTime();
        StringBuffer sbBuffer = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sbBuffer.append(text);
        }
        long endTimeBuffer = System.nanoTime();
        long durationBuffer = endTimeBuffer - startTimeBuffer;

        // Measure time for StringBuilder
        long startTimeBuilder = System.nanoTime();
        StringBuilder sbBuilder = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sbBuilder.append(text);
        }
        long endTimeBuilder = System.nanoTime();
        long durationBuilder = endTimeBuilder - startTimeBuilder;

        // Print results
        System.out.println("Time taken by StringBuffer: " + durationBuffer / 1_000_000 + " ms");
        System.out.println("Time taken by StringBuilder: " + durationBuilder / 1_000_000 + " ms");
    }
}
