package programmers.sort;

import java.util.Arrays;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42747
 */
public class H_Index {
    public static void main(String[] args) {
        int[] array = {3, 0, 6, 1, 5};

        H_Index fn = new H_Index();
        System.out.println(fn.solution(array));
    }

    public int solution(int[] citations) {
        Arrays.sort(citations);
        for (int i = citations.length - 1; i >= 0; i--) {
            int h = citations[i];

            int count = 1;
            int nonCount = 0;
            for (int j = citations.length - 1; j >= 0 && i != j; j--) {
                if(citations[j] >= h) {
                    count++;
                } else {
                    nonCount++;
                }
            }

            if(count >= h && nonCount <= h) {
                return h;
            }
        }

        return 0;
    }
}
