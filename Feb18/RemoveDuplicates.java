package Feb18;

import java.util.*;

public class RemoveDuplicates {
    public static List<Integer> removeDuplicates(List<Integer> list) {
        Set<Integer> seen = new LinkedHashSet<>(list); // Maintains order while removing duplicates
        return new ArrayList<>(seen);
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3, 1, 2, 2, 3, 4);
        List<Integer> result = removeDuplicates(list);
        System.out.println("List after removing duplicates: " + result);
    }
}
