package codility.stacksandqueue;

/**
 * https://app.codility.com/programmers/lessons/7-stacks_and_queues/nesting/
 *
 * 괄호 종류를 하나만 사용했으므로 스택 대신 숫자 +-로 해도 된다
 */
public class Nesting {
    public static void main(String[] args) {
        Nesting fn = new Nesting();
        System.out.println(fn.solution("(()(())())"));
        System.out.println(fn.solution("(()"));
        System.out.println(fn.solution(")("));
        System.out.println(fn.solution("(()()()(()))"));
    }

    public int solution(String S) {
        int stack = 0;
        for (char ch : S.toCharArray()) {
            if(ch == '(') {
                stack++;
            } else {
                if(stack == 0) {
                    return 0;
                }
                stack--;
            }
        }

        return stack == 0 ? 1 : 0;
    }
}
