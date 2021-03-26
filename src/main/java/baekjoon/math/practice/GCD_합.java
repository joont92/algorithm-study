package baekjoon.math.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * https://www.acmicpc.net/problem/9613
 */
public class GCD_합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());

        GCD_합 fn = new GCD_합();
        for (int i = 0; i < cnt; i++) {
            String str = br.readLine();
            int[] arr = Arrays.stream(str.split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            System.out.println(fn.sumOfGcds(Arrays.copyOfRange(arr, 1, arr.length)));
        }
    }

    public long sumOfGcds(int... numbers) {
        long sum = 0;
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                sum += gcd(numbers[i], numbers[j]);
            }
        }

        return sum;
    }

    private int gcd(int a, int b) {
        if(b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
