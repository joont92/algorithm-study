package baekjoon.math;

/**
 * https://www.acmicpc.net/problem/2745
 *
 *
 */
public class 진법_변환 {
    public int convert(String n, int system) {
        int pow = n.length();

        int sum = 0;
        for (char ch : n.toCharArray()) {
            sum += Math.pow(system, --pow) * (ch >= 'A' ? ch - 55 : ch - 48);
        }

        return sum;
    }
}
