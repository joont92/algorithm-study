package io;

import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/11721
 */
public class 열개씩_끊어_출력하기 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i]);
            if((i + 1) % 10 == 0) {
                System.out.println();
            }
        }
    }
}
