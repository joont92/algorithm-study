package baekjoon.datastructure.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * https://www.acmicpc.net/problem/17298
 *
 * 자신의 다음 index가 자신보다 크지 않을경우 stack에 계속 index를 넣음
 * 다음 index가 자신보다 클 경우 stack에 저장된 index를 하나씩 빼면서 다음 index의 값을 해당 index의 오큰수로 넣음
 */
public class 오큰수 {
    public int[] solution(int[] numbers) {
        var result = new int[numbers.length];
        Arrays.fill(result, -1);

        var stack = new Stack<Integer>();

        for (int i = 0; i < numbers.length; i++) {
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                result[stack.pop()] = numbers[i];
            }
            stack.push(i);
        }

        return result;
    }

    public static void main(String[] args) {
        var fn = new 오큰수();
//        basic();
        System.out.println(Arrays.equals(fn.solution(new int[]{1,2,3,4,5}), new int[]{2,3,4,5,-1}));
        System.out.println(Arrays.equals(fn.solution(new int[]{5,4,3,2,1}), new int[]{-1,-1,-1,-1,-1}));
        System.out.println(Arrays.equals(fn.solution(new int[]{3,5,2,7}), new int[]{5,7,7,-1}));
        System.out.println(Arrays.equals(fn.solution(new int[]{9,5,4,8}), new int[]{-1,8,8,-1}));
        System.out.println(Arrays.equals(fn.solution(new int[]{4,5}), new int[]{5,-1}));
        System.out.println(Arrays.equals(fn.solution(new int[]{4}), new int[]{-1}));
    }

    private static void basic() {
        var fn = new 오큰수();
        try {
            var br = new BufferedReader(new InputStreamReader(System.in));
            var count = Integer.parseInt(br.readLine());
            var result = fn.solution(Arrays.stream(br.readLine().split(" ", count))
                    .mapToInt(Integer::parseInt)
                    .toArray());
            System.out.println(Arrays.stream(result)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(" ")));
        } catch (Exception e) {
            //
        }
    }

    // 값 하나에 대해 뒤에 모든 값들을 비교하면서 오큰수를 찾아나가는 방식 == O(N^2)
    /*
    public int[] solution2(int[] numbers) {
        var result = new ArrayList<Integer>();

        var stack = new Stack<Integer>();
        IntStream.rangeClosed(1, numbers.length)
                .map(i -> numbers[numbers.length - i])
                .forEach(stack::push);

        var index = 1;
        while (!stack.isEmpty()) {
            var top = stack.peek();

            int i;
            for (i = index; i < numbers.length; i++) {
                var number = numbers[i];
                if (top < number) {
                    result.add(number);
                    stack.pop();
                    index++;
                    break;
                }
            }

            if (i == numbers.length) {
                result.add(-1);
                stack.pop();
                index++;
            }
        }

        return result.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
     */
}