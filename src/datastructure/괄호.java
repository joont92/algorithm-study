package datastructure;

import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/9012
 */
public class 괄호 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < count; i++) {
            String ps = scanner.nextLine();

            int result = 0;
            for (char c : ps.toCharArray()) {
                if(c == '(') {
                    result++;
                } else if(c == ')') {
                    result--;

                    if(result < 0) {
                        break;
                    }
                }
            }

            System.out.println(result == 0 ? "YES" : "NO");
        }
    }
}
