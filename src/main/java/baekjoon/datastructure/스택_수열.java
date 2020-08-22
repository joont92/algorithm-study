package baekjoon.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * https://www.acmicpc.net/problem/1874
 *
 * 1. 스택의 값이 비어있거나(처음) 전달받은 숫자가 스택의 마지막 값보다 클 경우 전달받은 숫자까지 스택에 값을 넣는다
 *   - 스택에 저장된 값은 전체 클래스에서 관장하는 seq 값이므로, n > stack.lastElement() 는
 *     현재까지 증가한 seq 가 전달받은 값을 넘어가는지 검사하는것과 같음
 * 2. 스택의 마지막 값과 전달받은 숫자가 같다면 stack 에서 하나 제거함
 * 동일하지 않다면 sequence 를 ++ 하면서 push
 */
public class 스택_수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        스택_수열 fn = new 스택_수열();
        for (int i = 0; i < count; i++) {
            sb.append(fn.stackSequence(Integer.parseInt(br.readLine())));
        }
        System.out.println(sb.toString().contains("NO") ? "NO" : sb.toString());
    }

    private Stack<Integer> stack = new Stack<>();
    private int seq = 1;

    public String stackSequence(int n) {
        StringBuilder sb = new StringBuilder();
        if(stack.isEmpty() || n > stack.lastElement()) {
            while(seq <= n) {
                stack.push(seq++);
                sb.append("+\n");
            }
        }

        if(n == stack.lastElement()) {
            stack.pop();
            sb.append("-\n");
            return sb.toString();
        }

        return "NO";

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
    }
}
