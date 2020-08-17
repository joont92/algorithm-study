package codility.sorting;

import java.util.HashSet;
import java.util.Set;

/**
 * https://app.codility.com/programmers/lessons/6-sorting/distinct/
 */
public class Distinct {
    public static void main(String[] args) {
        int[] A = {2, 1, 1, 2, 3, 1};
        Distinct fn = new Distinct();
        System.out.println(fn.solution(A));
    }

    public int solution(int[] A) {
        Set<Integer> set = new HashSet<>();
        for (int value : A) {
            set.add(value);
        }

        return set.size();
    }
}
