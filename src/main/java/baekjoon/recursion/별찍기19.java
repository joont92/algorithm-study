package baekjoon.recursion;

import java.util.Arrays;
import java.util.Scanner;

public class 별찍기19 {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var n = scanner.nextInt();
        var array = new char[(n - 1) * 4 + 1][(n - 1) * 4 + 1];
        for (char[] chars : array) {
            Arrays.fill(chars, ' ');
        }

        new 별찍기19().solution(array, n, 0);
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
    }

    public void solution(char[][] array, int n, int startIdx) {
        if (n == 0) return;

        var end = (n - 1) * 4 + 1 + startIdx;

        for (int i = startIdx; i < end; i++) {
            for (int j = startIdx; j < end; j++) {
                if (i == startIdx || i == end - 1) {
                    array[i][j] = '*';
                } else {
                    if (j == startIdx || j == end - 1) {
                        array[i][j] = '*';
                    }
                }
            }
        }

        solution(array, n - 1, startIdx + 2);
    }
}
