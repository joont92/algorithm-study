package baekjoon.math.reference;

/**
 * https://www.acmicpc.net/problem/11005
 *
 * 10진수를 a진법으로 변환하는 방법은, 단순히 10진수 n 을 a 로 계속 나눈 뒤 나머지를 나열하면 된다
 */
public class 진법_변환2 {
    public String convert(int n, int system) {
        StringBuilder sb = new StringBuilder();

        while(n > 0) {
            int mod = n % system;
            sb.append((char)(mod >= 10 ? mod - 10 + 'A' : mod + '0'));
            n /= system;
        }

        return sb.reverse().toString();
    }
}
