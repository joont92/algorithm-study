package baekjoon.datastructure.basic;

/**
 * https://www.acmicpc.net/problem/9093
 *
 * 스택에 넣다가 공백을 만나면 스택에서 뺴면서 출력
 * 맨 마지막 글자는 공백이 없으므로 반복이 끝난 후 한번 더 스택에 있는 내용을 비워줘야 함
 */
public class 단어_뒤집기 {
    public static void main(String[] args) {
        System.out.println(tc1());
    }

    public String solution(String sentence) {
        var result = new StringBuilder();

        var chars = sentence.toCharArray();

        var index = 0;
        var stack = new char[chars.length];
        for (char ch : chars) {
            if(ch == ' ') {
                while(index > 0) {
                    result.append(stack[--index]);
                }
                result.append(ch);
                continue;
            }
            stack[index++] = ch;
        }
        while(index > 0) {
            result.append(stack[--index]);
        }

        return result.toString();
    }

    private static boolean tc1() {
        var fn = new 단어_뒤집기();

        if(!fn.solution("I am happy today").equals("I ma yppah yadot")) return false;
        if(!fn.solution("We want to win the first prize").equals("eW tnaw ot niw eht tsrif ezirp")) return false;
        if(!fn.solution("aaaabbbb").equals("bbbbaaaa")) return false;
        if(!fn.solution("a").equals("a")) return false;

        return true;
    }
}
