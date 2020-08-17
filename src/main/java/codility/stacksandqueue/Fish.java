package codility.stacksandqueue;

import java.util.Stack;

/**
 * https://app.codility.com/programmers/lessons/7-stacks_and_queues/fish/
 *
 * 물고기가 위에서 아래로, 아래에서 위로 올라가면서 서로 잡아먹고, 최종적으로 남은 물고기의 개수를 세는 문제
 * 밑으로 내려가는 물고기를 스택에 담고, 위로 올라가는 물고기를 만났을 떄 크기 비교후 pop or ignore 하면 된다
 */
public class Fish {
    public static void main(String[] args) {
        int[] A = {4, 3, 2, 1, 5};
        int[] B = {0, 1, 1, 1, 0};
        Fish fn = new Fish();
        System.out.println(fn.solution(A, B));
    }

    public int solution(int[] A, int[] B) {
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            count++;
            if(B[i] == 1) {
                stack.push(i);
            } else {
                while (!stack.isEmpty()) {
                    count--;
                    if(A[stack.peek()] < A[i]) {
                        stack.pop();
                    } else {
                        break;
                    }
                }
            }
        }

        return count;
    }
}
