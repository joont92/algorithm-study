package codility.stacksandqueue;

import java.util.Stack;

/**
 * https://app.codility.com/programmers/lessons/7-stacks_and_queues/stone_wall/
 *
 * 백준 쇠막대기와 비슷한 유형의 문제
 * 1. 앞의 블록이 없거나, 자신보다 작을 경우 스택에 자신을 추가한다
 * > 자기보다 작은 블록밖에 없으면 블록을 얹어야 함
 * 2. 스택에서 자기보다 큰 블록이 있을 경우 뺀다
 * > 더 이상 블록이 이어지지 않으므로 스택에서 빼면서 count++
 * 3. 스택에 있는 블록의 크기가 자신과 같을 경우 그냥 넘어간다
 * > 블록이 이어짐
 */
public class StoneWall {
    public static void main(String[] args) {
        int[] H = {8, 9, 5, 7, 9, 8, 7, 4, 8};
        StoneWall fn = new StoneWall();
        System.out.println(fn.solution(H));
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
