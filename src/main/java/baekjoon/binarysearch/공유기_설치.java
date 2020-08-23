package baekjoon.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * https://www.acmicpc.net/problem/2110
 *
 * - 이진탐색 문제
 * - 이진탐색을 해야하니 일단 정렬을 해야한다
 * - `1 ~ 첫번쨰 집과 마지막 집 사이의 거리` 에서 이진탐색으로 숫자를 고른 뒤, 공유기를 몇개 놓을 수 있는지 구한다
 *   - 놓을 수 있는 공유기의 숫자가 작을 경우 간격을 줄인다(high = mid - 1)
 *   - 놓을 수 있는 공유기의 숫자가 크거나 같을 경우 원하는 개수만큼 공유기를 놓을 수 있기 때문에 정답에 해당한다(뒤에 공유기들을 안놓으면 됨)
 *     - 하지만 최대 간격을 찾아야 하기 때문에, 간격을 늘려서(low = mid + 1) 더 시도해보고 최대값을 반환한다
 *
 * 공유기를 놓을 시점은 이전 공유기를 놓은 집과 현재 집까지의 거리가 간격보다 클 경우에만 놓는다
 */
public class 공유기_설치 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        공유기_설치 fn = new 공유기_설치();
        String[] strs = br.readLine().split(" ");
        int homeCount = Integer.parseInt(strs[0]);
        int apCount = Integer.parseInt(strs[1]);
        int[] home = new int[homeCount];
        for (int i = 0; i < homeCount; i++) {
            home[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(fn.solution(apCount, home));
    }

    public int solution(int apCount, int[] home) {
        Arrays.sort(home);

        int low = 1;
        int high = home[home.length - 1] - home[0];
        int mid;

        int max = 0;
        while (low <= high) {
            mid = (low + high) / 2;

            int count = 1;
            int lastIdx = 0;
            for (int i = 1; i < home.length; i++) {
                if(home[i] - home[lastIdx] >= mid) {
                    count++;
                    lastIdx = i;
                }
            }

            // 숫자가 많으면 뒤쪽에 공유기를 설치하지 않으면 되니 같거나 크다로 통과시켜야 한다
            if(count >= apCount) {
                max = Math.max(max, mid);
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return max;
    }
}
