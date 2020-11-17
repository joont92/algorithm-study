package baekjoon.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * https://www.acmicpc.net/problem/9093
 *
 * 스택에 넣다가 공백을 만나면 스택에서 뺴면서 출력
 * 맨 마지막 글자는 공백이 없으므로 반복이 끝난 후 한번 더 스택에 있는 내용을 비워줘야 함
 */
public class 단어_뒤집기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        단어_뒤집기 fn = new 단어_뒤집기();
        System.out.println(fn.solution(br.readLine()));
    }

    public String solution(String str) {
        Stack<Character> stack = new Stack<>();

        StringBuilder result = new StringBuilder();
        char[] chars = str.toCharArray();
        for (char ch : chars) {
            if(ch == ' ') {
                while(!stack.empty()) {
                    result.append(stack.pop());
                }
                result.append(' ');
                continue;
            }
            stack.add(ch);
        }
        while(!stack.empty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }
}
