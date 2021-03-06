package baekjoon.datastructure.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * https://www.acmicpc.net/problem/1874
 *
 * 올라가는건 건너뛰어도 상관없지만 내려올때는 순서대로 내려와야함(혹은 앞에서 이미 출력했거나)
 */
public class 스택_수열 {
    public String solution(int[] numbers) {
        var result = new StringBuilder();

        var stack = new Stack<Integer>();
        var seq = 1;

        for (int number : numbers) {
            while (seq <= number) {
                stack.push(seq++);
                result.append("+");
            }

            if (stack.pop() == number) {
                result.append("-");
            } else {
                return "NO";
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
//        basic();
        var fn = new 스택_수열();
        System.out.println(fn.solution(new int[]{1,2,3,4,5}).equals("+-+-+-+-+-"));
        System.out.println(fn.solution(new int[]{3,2,1}).equals("+++---"));
        System.out.println(fn.solution(new int[]{3,5,4}).equals("+++-++--"));
        System.out.println(fn.solution(new int[]{4,3,6,8,7,5,2,1}).equals("++++--++-++-----"));
        System.out.println(fn.solution(new int[]{1,2,5,3,4}).equals("NO"));
        System.out.println(fn.solution(new int[]{5,1}).equals("NO"));
        System.out.println(fn.solution(new int[]{5}).equals("+++++-"));
        System.out.println(fn.solution(new int[]{3,3}).equals("NO"));
    }

    private static void basic() {
        var fn = new 스택_수열();

        try {
            var br = new BufferedReader(new InputStreamReader(System.in));
            var count = Integer.parseInt(br.readLine());
            var arr = new int[count];
            for (var i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }
            var result = fn.solution(arr);
            System.out.println(result.equals("NO") ? result : String.join("\n", fn.solution(arr).split("")));
        } catch (IOException e) {
            //
        }
    }
}
