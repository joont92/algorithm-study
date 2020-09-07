package codility.stacksandqueue;

import java.util.Stack;

/**
 * https://app.codility.com/programmers/lessons/7-stacks_and_queues/stone_wall/
 *
 * 백준 "쇠막대기"와 비슷한 유형의 문제
 * 1. 현재 블럭이 앞의 블럭보다 낮으면 높이가 맞춰질 때 까지 스택에서 제거
 * > 자신보다 높은 블록은 더 이상 이어질 수 없음(별개의 블록으로 처리됨)
 * 2. 현재 블럭이 앞의 높이보다 높으면 블럭 추가
 * > 자신보다 작은 블럭밖에 없으면 블록을 얹어야 함
 * 3. 앞의 블럭이 현재 높이와 같으면 통과
 * > 같은 블럭으로 통합 가능함
 */
public class StoneWall {
    public static void main(String[] args) {
//        int[] H = {8, 9, 5, 7, 9, 8, 7, 4, 8};
        int[] H = {8,8,5,7,9,8,7,4,8};
        StoneWall fn = new StoneWall();
        System.out.println(fn.solution2(H));
    }

    public int solution2(int[] H) {
        Stack<Integer> stack = new Stack<>();
        stack.push(H[0]);

        int count = 0;
        for (int block : H) {
            if(stack.peek() < block) {
                stack.push(block);
                continue;
            }

            while (!stack.isEmpty() && stack.peek() > block) {
                stack.pop();
                count++;
            }

            if(stack.isEmpty() || stack.peek() < block) {
                stack.push(block);
            }
        }

        return stack.size() + count;
    }

    public int solution(int[] H) {
        int count = 0;
        Stack<Integer> stack = new Stack<>();
        for (int block : H) {
            if (stack.isEmpty() || stack.peek() < block) {
                stack.push(block);
                continue;
            }

            while (!stack.isEmpty() && stack.peek() > block) {
                stack.pop();
                count++;
            }

            if (stack.isEmpty() || stack.peek() < block) {
                stack.push(block);
            }
        }

        return count + stack.size();
    }
}
