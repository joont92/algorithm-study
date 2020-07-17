package baekjoon.math;

/**
 * https://www.acmicpc.net/problem/11005
 *
 * 10진수를 a진법으로 변환하는 방법은, 단순히 10진수 n 을 a 로 계속 나눈 뒤 나머지를 나열하면 된다
 */
public class 진법_변환2 {
    public String convert(int n, int system) {
        StringBuilder result = new StringBuilder();

        while (n != 0) {
            int mod = n % system;
            result.append((char)(mod >= 10 ? mod + 55 : mod + 48));
            n = n / system;
        }

        return result.reverse().toString();
    }
}
