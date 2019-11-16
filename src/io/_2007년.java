package io;

import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/1924
 */
public class _2007년 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] daysOfMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        // 1일을 index 1로 처리한다
        String[] datesOfWeeks = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

        int month = scanner.nextInt();
        int day = scanner.nextInt();

        int sum = 0;
        for (int i = 0; i < month - 1; i++) {
            sum += daysOfMonth[i];
        }
        sum += day;

        System.out.println(datesOfWeeks[sum % 7]);
    }
}
