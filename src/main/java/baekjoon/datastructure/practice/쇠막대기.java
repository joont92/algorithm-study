package baekjoon.datastructure.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/10799
 *
 * ( 를 만나면 스택에 push, 짝이 맞는 )를 만나면 스택에서 pop
 * ()를 만나면 스택에 있는 개수만큼 ++
 */
public class 쇠막대기 {
    public int solution(String arg) {
        var count = 0;
        var basket = 0;

        var chars = arg.toCharArray();
        for (int i = 0; i < chars.length; i++) { // 마지막 글자는 무조건 ')' 라고 가정
            if (chars[i] == '(') {
                if (chars[i + 1] == ')') {
                    count += basket;
                    i++;
                } else {
                    basket++;
                }
            } else if (chars[i] == ')') {
                count++;
                basket--;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        basic();
        var fn = new 쇠막대기();
        System.out.println(fn.solution("()(((()())(())()))(())") == 17);
        System.out.println(fn.solution("(((()(()()))(())()))(()())") == 24);
    }

    private static void basic() {
        var fn = new 쇠막대기();

        try {
            var br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println(fn.solution(br.readLine()));
        } catch (IOException e) {
            //
        }
    }
}
