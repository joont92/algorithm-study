package leetcode.easy;

/**
 * https://leetcode.com/problems/palindrome-number/
 *
 * 1. 숫자를 다 뒤집은 뒤 기존의 숫자와 비교하는 방법
 * 2. 반복문을 돌면서 기존의 숫자가 10씩 나눠지므로, "기존 숫자 > 뒤집은 숫자" 탈출할 때까지만 뒤집으면 딱 반만 뒤집게 된다
 *    - 회문일때만 딱 반만 뒤집게 되는 공식이다(예외 예시 : 567665)
 *    - 홀수 길이의 회문일때는 뒤집은 숫자에 중간글자도 추가되므로, 최종 검사시에 / 10 도 같이 검사해준다
 *
 */
public class PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(new PalindromeNumber().isPalindrome(121) == true);
        System.out.println(new PalindromeNumber().isPalindrome(23) == false);
        System.out.println(new PalindromeNumber().isPalindrome(111) == true);
        System.out.println(new PalindromeNumber().isPalindrome(1221) == true);
        System.out.println(new PalindromeNumber().isPalindrome(123123) == false);
        System.out.println(new PalindromeNumber().isPalindrome(-121) == false);
        System.out.println(new PalindromeNumber().isPalindrome(-1221) == false);
        System.out.println(new PalindromeNumber().isPalindrome(0) == true);
        System.out.println(new PalindromeNumber().isPalindrome(10) == false);
    }

    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        var revertedNumber = 0;

        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        return x == revertedNumber || x == revertedNumber / 10;
    }

    public boolean isPalindrome2(int x) {
        if (x < 0) {
            return false;
        }

        var str = String.valueOf(x);
        var mid = str.length() / 2;

        for (int i = 0; i < mid; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }

        return true;
    }
}
