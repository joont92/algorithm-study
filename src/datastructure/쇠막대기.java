package datastructure;

import java.util.Scanner;
import java.util.Stack;

/**
 * https://www.acmicpc.net/problem/10799
 */
public class 쇠막대기 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String stickStr = scanner.nextLine();

        int stickCount = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < stickStr.toCharArray().length; i++) {
            char c = stickStr.charAt(i);

            if(c == '(') {
                if(stickStr.charAt(i + 1) == ')') {
                    stickCount += stack.size();
                    i++;
                } else {
                    stack.push(c);
                }
            } else if(c == ')') {
                stack.pop();
                stickCount++;
            }
        }

        System.out.println(stickCount);
    }
}
