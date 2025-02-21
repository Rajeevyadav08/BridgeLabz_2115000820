package Feb18;

import java.util.*;

public class NthFromEnd {
    public static String findNthFromEnd(LinkedList<String> list, int n) {
        Iterator<String> fast = list.iterator();
        Iterator<String> slow = list.iterator();
        
        // Move fast pointer n steps ahead
        for (int i = 0; i < n; i++) {
            if (fast.hasNext()) {
                fast.next();
            } else {
                return "N is greater than the size of the list";
            }
        }
        
        // Move both pointers until fast reaches the end
        while (fast.hasNext()) {
            fast.next();
            slow.next();
        }
        
        return slow.next(); // Nth element from the end
    }

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>(Arrays.asList("A", "B", "C", "D", "E"));
        int n = 2;
        System.out.println("Nth element from the end: " + findNthFromEnd(list, n));
    }
}
