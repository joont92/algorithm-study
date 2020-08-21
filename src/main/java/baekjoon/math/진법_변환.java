package baekjoon.math;

/**
 * https://www.acmicpc.net/problem/2745
 *
 * A진법 수를 10진수로 바꾸려면 A^k 를 곱해가며 더하면 된다
 * 2진수 1011 = 8 * 1 + 4 * 0 + 2 * 1 + 1 * 1 = 11
 */
public class 진법_변환 {
    public int convert(String n, int system) {
        int pow = n.length() - 1;

        int sum = 0;
        for (char ch : n.toCharArray()) {
            sum += Math.pow(system, pow--) * (ch >= 'A' ? ch - 'A' + 10 : ch - '0');
        }

        return sum;
    }
}
