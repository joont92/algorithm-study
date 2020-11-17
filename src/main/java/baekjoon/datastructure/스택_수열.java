package baekjoon.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.stream.IntStream;

/**
 * https://www.acmicpc.net/problem/1874
 *
 * 1. 전달받은 숫자까지 seq 값을 증가시키면서 stack에 저장함
 * 2. 스택의 마지막 값과 전달받은 숫자가 같다면 stack 에서 하나 제거함
 * 3. 2를 만족하지 않는다는 것은, 전달받은 숫자가 seq 보다 작다는 것을 의미하고, 이는 성립할 수 없으므로 NO 반환
 */
public class 스택_수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        스택_수열 fn = new 스택_수열();
        StringBuilder sb = new StringBuilder();

        int count = Integer.parseInt(br.readLine());
        for (int i = 0; i < count; i++) {
            sb.append(fn.solution(Integer.parseInt(br.readLine())));
        }

        System.out.println(sb.toString().contains("NO") ? "NO" : sb.toString());
    }

    private Stack<Integer> stack = new Stack<>();
    private int seq = 1;

    public String solution(int number) {
        StringBuilder sb = new StringBuilder();
        while (seq <= number) {
            stack.push(seq++);
            sb.append("+\n");
        }

        if (number == stack.lastElement()) {
            stack.pop();
            sb.append("-\n");
            return sb.toString();
        }

        return "NO";
    }

//    public String solution(int number) {
//        while (true) {
//            if(!stack.isEmpty() && stack.lastElement() == n) {
//                stack.pop();
//                sb.append("-\n");
//                break;
//            }
//
//            if(seq > n) {
//                return "NO";
//            }
//
//            stack.push(seq++);
//            sb.append("+\n");
//        }
//
//        return sb.toString();
//    }

}
