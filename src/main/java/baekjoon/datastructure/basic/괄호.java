package baekjoon.datastructure.basic;

/**
 * https://www.acmicpc.net/problem/9012
 *
 */
public class 괄호 {
    public String solution(String parenthesis) {
        var result = 0;
        var chars = parenthesis.toCharArray();
        for (char ch : chars) {
            if (ch == '(') {
                result++;
            } else if (ch == ')') {
                result--;

                if (result < 0) {
                    break;
                }
            } else {
                throw new IllegalArgumentException();
            }
        }

        return result == 0 ? "YES" : "NO";
    }

    public static void main(String[] args) {
        var fn = new 괄호();
        System.out.println(fn.solution("(())())").equals("NO"));
        System.out.println(fn.solution("(((()())()").equals("NO"));
        System.out.println(fn.solution("(()())((()))").equals("YES"));
        System.out.println(fn.solution("((()()(()))(((())))()").equals("NO"));
        System.out.println(fn.solution("()()()()(()()())()").equals("YES"));
        System.out.println(fn.solution("(()((())()(").equals("NO"));
        System.out.println(fn.solution("((").equals("NO"));
        System.out.println(fn.solution("))").equals("NO"));
        System.out.println(fn.solution("())(()").equals("NO"));
        System.out.println(fn.solution("(").equals("NO"));
        System.out.println(fn.solution(")").equals("NO"));
    }
}