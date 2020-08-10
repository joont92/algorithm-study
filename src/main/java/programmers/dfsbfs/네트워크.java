package programmers.dfsbfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/43162
 *
 * dfs 나 bfs 를 이용하면 됨
 * 시작점을 하나씩 증가하면서, 다른 정점에 의해 방문된 적이 없다면 count++ 한다
 */
public class 네트워크 {
    public static void main(String[] args) {
        int[][] network = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};

        네트워크 fn = new 네트워크();
        System.out.println(fn.solution(3, network));
    }

    public int solution(int n, int[][] computers) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] check = new boolean[computers.length];

        int answer = 0;
        for (int i = 0; i < n; i++) {
            if(!check[i]) {
                check[i] = true;
                queue.offer(i);
                answer++;
            }

            while (!queue.isEmpty()) {
                int startIdx = queue.poll();

                for (int j = 0; j < computers[startIdx].length; j++) {
                    if(startIdx == j) {
                        continue;
                    }

                    if(!check[j] && computers[startIdx][j] > 0) {
                        check[j] = true;
                        queue.offer(j);
                    }
                }
            }
        }


        return answer;
    }
}
