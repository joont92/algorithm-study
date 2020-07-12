package baekjoon.math;

/**
 * https://www.acmicpc.net/problem/1978
 *
 * 1 ~ n-1 까지 나눠떨어지는 수가 있으면 소수가 아님
 * > 2 ~ n/2 까지 나눠떨어지는 수가 있으면 소수가 아님
 */
public class 소수_찾기 {
    public int count(int... n) {
        int count = 0;
        for (int value : n) {
            if(value <= 3) {
                continue;
            }

            for (int i = 2; i <= value / 2; i++) {
                if (value % i > 0) {
                    count++;
                }
            }
        }
        return count;
    }
}
