package codility.stacksandqueue;

import java.util.Stack;

/**
 * https://app.codility.com/programmers/lessons/7-stacks_and_queues/brackets/
 *
 * 스택을 이용하면 됨
 */
public class Brackets {
    public static void main(String[] args) {
        Brackets fn = new Brackets();
        System.out.println(fn.solution("{[()()]}"));
        System.out.println(fn.solution("([)()]"));
        System.out.println(fn.solution("("));
        System.out.println(fn.solution("}"));
    }

    public int solution(String S) {
        Stack<Character> stack = new Stack<>();
        for (char ch : S.toCharArray()) {
            if("({[".indexOf(ch) != -1) {
                stack.push(ch);
            } else {
                if(stack.isEmpty() || !canClose(stack.pop(), ch)) {
                    return 0;
                }
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }

    private boolean canClose(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '{' && close == '}') ||
                (open == '[' && close == ']');
    }
}
