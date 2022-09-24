package study;

import java.util.Arrays;
import java.util.LinkedList;

public class BFS {
    public static void main(String[] args) {
        var graph = new int[][] {
            {1,1,1,0,1,0,0,0,0,0},
            {1,0,0,0,1,0,0,0,0,0},
            {1,1,1,0,1,0,0,0,0,0},
            {1,1,0,0,1,0,0,0,0,0},
            {0,1,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0},
        };

        var result1 = new BFS().bfs(graph);
        Arrays.stream(result1)
            .forEach(e1 -> {
                Arrays.stream(e1).forEach(System.out::print);
                System.out.println();
            });
    }

    public int[][] bfs(int[][] graph) {
        var directionX = new int[]{-1, 1, 0, 0};
        var directionY = new int[]{0, 0, -1, 1};

        var queue = new LinkedList<Node>();
        queue.offer(new Node(0, 0)); // 0,0 always 1

        while (!queue.isEmpty()) {
            var standard = queue.poll();

            for (int i = 0; i < 4; i++) {
                var x = standard.x + directionX[i];
                var y = standard.y + directionY[i];

                if (x >= 0 && y >= 0 && x < graph.length && y < graph[0].length) {
                    if (graph[x][y] == 1) { // visit 하면 2로 변경하므로 이거로만 체크 가능
                        graph[x][y]++;
                        queue.offer(new Node(x, y));
                    }
                }
            }
        }

        return graph;
    }

    class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
