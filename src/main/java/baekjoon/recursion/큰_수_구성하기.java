package baekjoon.recursion;

import java.util.Arrays;
import java.util.Scanner;

public class 큰_수_구성하기 {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var n = scanner.nextInt();
        int[] k = new int[scanner.nextInt()];
        for (int i = 0; i < k.length; i++) {
            k[i] = scanner.nextInt();
        }

        Arrays.sort(k);
        System.out.println(new 큰_수_구성하기().solution(n, k, 0, (int)Math.pow(10, String.valueOf(n).length() - 1)));
    }

    public int solution(int n, int[] k, int current, int digit) {
        var result = current;
        if (digit > 0) {
            var called = false;
            for (int i = k.length - 1; i >= 0; i--) {
                var candidate = current + (k[i] * digit);

                if (candidate > n) continue;
                result = solution(n, k, candidate, digit / 10);
                called = true;
                break;
            }

            if (!called) {
                result = solution(n, k, current, digit / 10);
            }
        }

        return result;
    }
}
