package baekjoon.dp.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * https://www.acmicpc.net/problem/1912
 *
 * 처음 구현했던 방법
 * - 배열의 인덱스를 하나씩 증가시키면서, 자신부터 자신 앞의 숫자들 하나하나씩 더해가며 배열에 저장하고, 최대값을 뽑는다
 * [2][1] = array[2]
 * [2][2] = array[2] + [1][1]
 * [3][1] = array[3]
 * [3][2] = array[3] + [2][1]
 * [3][3] = array[3] + [2][2]
 * ...
 * > dp[i][j] = dp[i][1] + dp[i-1][j-1]
 * 이런식으로 `자신`의 index 를 증가시키며 `자신, 자신 + 자신-1, 자신 + 자신-2, 자신 + 자신-3...` 을 구하고, 그 중에 max 값을 구한다
 *
 * 이랬는데..! 아래와 같은 문제점이 있다
 * - 들어오는 숫자의 수가 많으면 배열의 크기가 커진다 e.g. int[100_000][100_000] (메모리 초과)
 * - 자기 자신 앞에 숫자들의 연속합을 매번 구할 필요 없다 (시간 초과)
 *
 * - `자기 자신, 자기 자신 + 앞의 연속합` 중 큰 값을 선택한다
 *   - **자기 자신이 선택될 수도 있기 때문에 이어져 온 연속합은 항상 최대값이다**
 *   - 자기 자신이 더 크면 지금까지의 연속합을 끊고 진행하기 때문이다
 * - 0부터 시작해서 배열에 연속합 최대값을 담으면서 bottomUp 한다
 */
public class 연속_합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        연속_합 fn = new 연속_합();
        int count = Integer.parseInt(br.readLine());
        System.out.println(fn.maxStreamSum(Arrays.stream(br.readLine().split(" ", count))
                .mapToInt(Integer::parseInt)
                .toArray()));
    }

    public int maxStreamSum(int... stream) {
        int[] dp = new int[stream.length];

        dp[0] = stream[0];
        for (int i = 1; i < stream.length; i++) {
            dp[i] = Math.max(stream[i], dp[i - 1] + stream[i]);
        }

        return Arrays.stream(dp).max().getAsInt();
    }
}
