package Feb18;

import java.util.*;

public class SetToSortedList {
    public static List<Integer> convertAndSort(Set<Integer> set) {
        List<Integer> sortedList = new ArrayList<>(set); // Convert Set to List
        Collections.sort(sortedList); // Sort the List in ascending order
        return sortedList;
    }

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>(Arrays.asList(5, 3, 9, 1));
        System.out.println("Sorted List: " + convertAndSort(set));
    }
}
