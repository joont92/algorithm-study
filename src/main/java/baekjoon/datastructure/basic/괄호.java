package baekjoon.datastructure.basic;

/**
 * https://www.acmicpc.net/problem/9012
 *
 */
public class 괄호 {
    public static void main(String[] args) {
        System.out.println(tc1());
        System.out.println(tc2());
        System.out.println(tc3());
    }

    public String solution(String parenthesis) {
        var result = 0;
        var chars = parenthesis.toCharArray();
        for (char ch : chars) {
            if(ch == '(') {
                result++;
            } else if (ch == ')') {
                result--;

                if(result < 0) {
                    break;
                }
            } else {
                throw new IllegalArgumentException();
            }
        }

        return result == 0 ? "YES" : "NO";
    }

    private static boolean tc1() {
        var fn = new 괄호();
        if(!fn.solution("(())())").equals("NO")) return false;
        if(!fn.solution("(((()())()").equals("NO")) return false;
        if(!fn.solution("(()())((()))").equals("YES")) return false;
        if(!fn.solution("((()()(()))(((())))()").equals("NO")) return false;
        if(!fn.solution("()()()()(()()())()").equals("YES")) return false;
        if(!fn.solution("(()((())()(").equals("NO")) return false;

        return true;
    }

    private static boolean tc2() {
        var fn = new 괄호();
        if(!fn.solution("((").equals("NO")) return false;
        if(!fn.solution("))").equals("NO")) return false;
        if(!fn.solution("())(()").equals("NO")) return false;

        return true;
    }

    private static boolean tc3() {
        var fn = new 괄호();
        if(!fn.solution("(").equals("NO")) return false;
        if(!fn.solution(")").equals("NO")) return false;

        return true;
    }
}
