package leetcode.easy;

import java.util.Stack;

/**
 * https://leetcode.com/problems/palindrome-number/
 *
 * - 회문인지 검사하는 문제
 * - 숫자의 절반 길이까지 뒤에서 부터 읽어서 저장한 뒤, 저장한 숫자와 남은 숫자가 같은지만 비교하면 된다
 *   - 1221 이면, 21을 거꾸로 저장한 뒤(12), 앞(12)와 같은지 비교하면 된다
 * - 숫자의 개수가 짝수가 아닐수도 있으니, 10으로 나눈 숫자도 같은지 같이 검사한다
 */
public class PalindromeNumber {
    public static void main(String[] args) {
        PalindromeNumber fn = new PalindromeNumber();
        System.out.println(fn.isPalindrome2(1));
    }

    public boolean isPalindrome2(int x) {
        if(x < 0) {
            return false;
        }

        int y = 0;
        int length = String.valueOf(x).length();

        int standard = length / 2;
        while (standard > 0) {
            y = y * 10 + x % 10;
            x /= 10;
            standard--;
        }

        return x == y || x / 10 == y;
    }

    public boolean isPalindrome1(int x) {
        if(x < 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        char[] split = String.valueOf(x).toCharArray();
        int mid = split.length / 2;
        for (int i = 0; i < mid; i++) {
            stack.push(split[i]);
        }

        for (int i = split.length % 2 == 0 ? mid : mid + 1; i < split.length; i++) {
            if(stack.pop() != split[i]) {
                return false;
            }
        }

        return stack.isEmpty();
    }
}
