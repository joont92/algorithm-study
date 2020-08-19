package baekjoon.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * https://acmicpc.net/problem/2776
 *
 * 이분 탐색을 사용하면 된다
 */
public class 암기왕 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        암기왕 fn = new 암기왕();
        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            int note1Count = Integer.parseInt(br.readLine());
            int[] note1 = Arrays.stream(br.readLine().split(" ", note1Count))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            Arrays.sort(note1);

            int note2Count = Integer.parseInt(br.readLine());
            int[] note2 = Arrays.stream(br.readLine().split(" ", note2Count))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            Arrays.stream(fn.solution(note1, note2)).forEach(System.out::println);
        }
    }

    public int[] solution(int[] note1, int[] note2) {
        int[] answer = new int[note2.length];

        int low = 0;
        int high = note1.length - 1;
        int mid;

        for (int i = 0; i < note2.length; i++) {
            while(low <= high) {
                mid = (low + high) / 2;

                if(note2[i] == note1[mid]) {
                    answer[i] = 1;
                    break;
                }

                if(note2[i] < note1[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            low = 0;
            high = note1.length - 1;
        }

        return answer;
    }
}
