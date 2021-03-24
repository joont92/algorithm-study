package baekjoon.datastructure.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * https://www.acmicpc.net/problem/17413
 */
public class 단어_뒤집기2 {
    public String solution(String arg) {
        var result = new StringBuilder();

        var ignore = false;
        var stack = new Stack<Character>();

        for (char ch : arg.toCharArray()) {
            if (ch == '<') {
                // 지금까지 저장해왔던 값
                while (!stack.isEmpty()) {
                    result.append(stack.pop());
                }

                ignore = true;
                result.append('<');
                continue;
            } else if (ch == '>') {
                ignore = false;
                result.append('>');
                continue;
            }

            if (ignore) {
                result.append(ch);
                continue;
            }

            if (ch != ' ') {
                stack.push(ch);
            } else {
                while (!stack.isEmpty()) {
                    result.append(stack.pop());
                }
                result.append(' ');
            }
        }
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }

    public static void main(String[] args) {
        basic();
        var fn = new 단어_뒤집기2();
        System.out.println(fn.solution("baekjoon online judge")
                .equals("noojkeab enilno egduj"));
        System.out.println(fn.solution("<open>tag<close>")
                .equals("<open>gat<close>"));
        System.out.println(fn.solution("<ab cd>ef gh<ij kl>")
                .equals("<ab cd>fe hg<ij kl>"));
        System.out.println(fn.solution("<int><max>2147483647<long long><max>9223372036854775807")
                .equals("<int><max>7463847412<long long><max>7085774586302733229"));
        System.out.println(fn.solution("<problem>17413<is hardest>problem ever<end>")
                .equals("<problem>31471<is hardest>melborp reve<end>"));
        System.out.println(fn.solution("<   space   >space space space<    spa   c e>")
                .equals("<   space   >ecaps ecaps ecaps<    spa   c e>"));
    }

    private static void basic() {
        var fn = new 단어_뒤집기2();
        try {
            var br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println(fn.solution(br.readLine()));
        } catch (IOException e) {
            //
        }
    }
}
