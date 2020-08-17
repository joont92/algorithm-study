package codility.arrays;

import java.util.Arrays;

/**
 * https://app.codility.com/programmers/lessons/2-arrays/odd_occurrences_in_array/
 *
 * 1. hash에 value:count 형태로 데이터를 넣고, 홀수인 데이터를 출력하면 된다
 * > 시간복잡도가 NlogN이 나오는데.. 0.008초 차이로 시간제한에 걸렸다
 * > 마지막 stream 으로 한번 더 돌아서 그런가 ㅜㅜ
 *
 * 2. 배열을 정렬하고, 다음 수와 자신이 같지 않으면 반환한다
 * - 인덱스는 2개씩 증가시킨다
 * - 마지막 1개까지 반환되는 값을 찾지 못헀다면, 마지막 값을 반환한다
 */
public class OddOccurrencesInArray {
    public static void main(String[] args) {
        int[] A = {9, 3, 9, 3, 9, 7, 9};
        OddOccurrencesInArray fn = new OddOccurrencesInArray();
        System.out.println(fn.solution(A));
    }

//    public int solution(int[] A) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int value : A) {
//            map.put(value, map.getOrDefault(value, 0) + 1);
//        }
//
//        return map.keySet().stream()
//                .filter(v -> map.get(v) % 2 != 0)
//                .findFirst()
//                .orElseThrow(IllegalArgumentException::new);
//    }

    public int solution(int[] A) {
        Arrays.sort(A);

        for (int i = 0; i < A.length; i+=2) {
            if(i == A.length - 1) {
                return A[i];
            }

            if(A[i] != A[i + 1]) {
                return A[i];
            }
        }

        return -1;
    }
}
