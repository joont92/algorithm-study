package baekjoon.dp;

import java.util.Arrays;

/**
 * https://www.acmicpc.net/problem/11053
 *
 * 앞에서부터 하나씩 돌면서 얼마나 수열이 이어져왔는지 체크한다
 *
 * 자신 앞에 있는 LIS 들의 최대값을 구한 뒤 +1을 하면 그게 곧 자신의 LIS 가 된다
 */
public class 가장_긴_증가하는_부분_수열 {
    public int getLIS(int... progression) {
        int[] lis = new int[progression.length];

        for (int i = 0; i < progression.length; i++) {
            lis[i] = 1;
            for (int j = 0; j < i; j++) {
                if(progression[j] < progression[i] && lis[j] + 1 > lis[i]) {
                    lis[i] = lis[j] + 1;
                }
            }
        }

        return Arrays.stream(lis).max().getAsInt();
    }
}
