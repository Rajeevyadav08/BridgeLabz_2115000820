package Feb18;
import java.util.*;

public class SubsetCheck {
    public static boolean isSubset(Set<Integer> subset, Set<Integer> mainSet) {
        return mainSet.containsAll(subset); // Checks if all elements of subset exist in mainSet
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(1, 2, 3, 4));

        System.out.println("Is Set1 a subset of Set2? " + isSubset(set1, set2));
    }
}

