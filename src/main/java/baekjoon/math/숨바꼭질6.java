package baekjoon.math;

/**
 * https://www.acmicpc.net/problem/17087
 *
 * 모든 동생을 찾으려고 할 때, 전진할 수 있는 칸의 수가 최대 몇칸인지 구하는 문제
 *
 * 형의 위치와 동생들의 위치간 차이를 모두 구한 뒤, 그 숫자들의 최대공약수를 구해주면 된다
 * 여러수들의 최대공약수는, 단순히 2개 수의 최대공약수를 구하고, 최대공약수와 그 다음수의 최대공약수를 구하는 식으로 진행하면 된다
 */
public class 숨바꼭질6 {
    public int maxJump(int standard, int... locations) {
        int gcd = Math.abs(locations[0] - standard);
        for (int i = 1; i < locations.length; i++) {
            gcd = gcd(gcd, Math.abs(locations[i] - standard));
        }

        return gcd;
    }

    private int gcd(int a, int b) {
        if(b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }
}
