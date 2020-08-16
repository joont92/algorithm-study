package codility;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://app.codility.com/programmers/lessons/4-counting_elements/perm_check/
 *
 * 원소중에 배열의 크기보다 큰 숫자가 있으면 순열이 아님
 */
public class _04_PermCheck {
    public static void main(String[] args) {
        int[] A = {1, 1, 2};
        _04_PermCheck fn = new _04_PermCheck();
        System.out.println(fn.solution(A));
    }

    public int solution(int[] A) {
        Arrays.sort(A);
        if(A[A.length - 1] > A.length) {
            return 0;
        }

        for (int i = 0; i < A.length; i++) {
            if(A[i] != i + 1) {
                return 0;
            }
        }

        return 1;
    }

//    public int solution(int[] A) {
//        Set<Integer> set = new HashSet<>();
//        for (int value : A) {
//            set.add(value);
//        }
//
//        if(set.size() != A.length) {
//            return 0;
//        }
//
//        for (Integer value : set) {
//            if(value > A.length) {
//                return 0;
//            }
//        }
//
//        return 1;
//    }
}
