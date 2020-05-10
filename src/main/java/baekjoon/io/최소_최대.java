package baekjoon.io;

import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/10818
 */
public class 최소_최대 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = scanner.nextInt();

        int min, max;
        min = max = scanner.nextInt(); // 초기값으로 세팅

        for (int i = 0; i < count - 1; i++) {
            int n = scanner.nextInt();

            if(n < min) {
                min = n;
            }

            if(n > max) {
                max = n;
            }
        }

        System.out.println(min + " " + max);
    }
}
