package Feb18;

import java.util.*;

public class SymmetricDifference {
    public static Set<Integer> symmetricDifference(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> unionSet = new HashSet<>(set1);
        unionSet.addAll(set2); // Union of both sets

        Set<Integer> intersectionSet = new HashSet<>(set1);
        intersectionSet.retainAll(set2); // Intersection of both sets

        unionSet.removeAll(intersectionSet); // Remove common elements
        return unionSet;
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5));

        System.out.println("Symmetric Difference: " + symmetricDifference(set1, set2));
    }
}
