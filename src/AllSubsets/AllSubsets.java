package AllSubsets;

import java.util.ArrayList;
import java.util.List;

//program that outputs all subsets of a given set by Süleyman Can Şimşek
public class AllSubsets {

    public static List<List<Integer>> generateSubsets(int[] set) {
        List<List<Integer>> subsets = new ArrayList<>();
        generateSubsets(set, 0, new ArrayList<>(), subsets);
        return subsets;
    }

    private static void generateSubsets(int[] set, int index, List<Integer> current, List<List<Integer>> subsets) {
        if (index == set.length) {
            subsets.add(current);
            return;
        }

        // Generate subsets without including the current element
        generateSubsets(set, index + 1, current, subsets);

        // Generate subsets by including the current element
        List<Integer> newSubset = new ArrayList<>(current);
        newSubset.add(set[index]);
        generateSubsets(set, index + 1, newSubset, subsets);
    }

    public static void main(String[] args) {
        int[] set = {1, 2, 3};
        List<List<Integer>> subsets = generateSubsets(set);
        System.out.println(subsets);
    }
}
