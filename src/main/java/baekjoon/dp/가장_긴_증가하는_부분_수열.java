package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * https://www.acmicpc.net/problem/11053
 *
 * 앞에서부터 하나씩 돌면서 얼마나 수열이 이어져왔는지 체크한다
 * 자신 앞에 있는 LIS 들의 최대값을 구한 뒤 +1을 하면 그게 곧 자신의 LIS 가 된다
 *
 * arr = 10 20 10 30 20 50
 * lis =  1  2  1  3  2  4
 *
 * > 30은 20 LIS 에 + 1
 * > 50은 30 LIS 에 + 1
 */
public class 가장_긴_증가하는_부분_수열 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());
        가장_긴_증가하는_부분_수열 fn = new 가장_긴_증가하는_부분_수열();
        System.out.println(fn.lis(Arrays.stream(br.readLine().split(" ", count))
                .mapToInt(Integer::parseInt)
                .toArray()));
    }

    public int lis(int... sequence) {
        int[] lis = new int[sequence.length];
        Arrays.fill(lis, 1);

        for (int i = 1; i < sequence.length; i++) {
            for (int j = i; j >= 0; j--) {
                if(sequence[i] > sequence[j] && lis[j] + 1 > lis[i]) {
                    lis[i] = lis[j] + 1;
                }
            }
        }

        return Arrays.stream(lis).max().getAsInt();
    }
}
