package codility.countingelements;

import java.util.Arrays;

/**
 * https://app.codility.com/programmers/lessons/4-counting_elements/max_counters/
 *
 * max로 fill하는 부분을 줄여야함
 * 1. max 연산이 나올 당시의 max 값을 구한다
 * 2. 그 뒤에 연산에서 값이 max 보다 작을 경우 max로 세팅한다
 * 3. 연산이 끝난 후 max 보다 작은 값을 전부 max로 세팅한다
 *
 * 복잡..
 */
public class MaxCounters {
    public static void main(String[] args) {
        int[] A = {3, 4, 4, 6, 1, 4, 4};
        MaxCounters fn = new MaxCounters();
        Arrays.stream(fn.solution(5, A)).forEach(System.out::println);
    }

    public int[] solution(int N, int[] A) {
        int[] answer = new int[N];

        int max = 0;
        int latestMax = 0;
        for (int position : A) {
            position = position - 1;

            if(position == N) {
                latestMax = max;
            }else {
                if(answer[position] < latestMax) {
                    answer[position] = latestMax;
                }
                answer[position]++;
                max = Math.max(max, answer[position]);
            }
        }

        for (int i = 0; i < answer.length; i++) {
            if(answer[i] < latestMax) {
                answer[i] = latestMax;
            }
        }

        return answer;
    }

    // 시간 복잡도를 만족하지 못하는 풀이
//    public int[] solution(int N, int[] A) {
//        int[] answer = new int[N];
//
//        int max = 0;
//        for (int position : A) {
//            position = position - 1;
//            if (position == N) {
//                Arrays.fill(answer, max);
//            } else {
//                answer[position]++;
//                max = Math.max(max, answer[position]);
//            }
//        }
//
//        return answer;
//    }
}
