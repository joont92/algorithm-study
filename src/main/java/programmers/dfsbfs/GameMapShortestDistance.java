package programmers.dfsbfs;

import java.util.LinkedList;

public class GameMapShortestDistance {
    public static void main(String[] args) {
        var result = new GameMapShortestDistance();
        System.out.println(result.solution(new int[][]{
            {1,0,1,1,1},
            {1,0,1,0,1},
            {1,0,1,1,1},
            {1,1,1,0,1},
            {0,0,0,0,1}
        }));
        System.out.println(result.solution(new int[][]{
            {1,0,1,1,1},
            {1,0,1,0,1},
            {1,0,1,1,1},
            {1,1,1,0,0},
            {0,0,0,0,1}
        }));
    }

    public int solution(int[][] maps) {
        var n = maps.length;
        var m = maps[0].length;

        var visited = new int[n][m];
        visited[0][0] = 1;

        var directionX = new int[]{1,-1,0,0};
        var directionY = new int[]{0,0,-1,1};

        var queue = new LinkedList<Node>();
        queue.offer(new Node(0, 0, 1));

        while (!queue.isEmpty()) {
            var node = queue.poll();

            if (node.x == n - 1 && node.y == m - 1) return node.cost;

            for (int i = 0; i < 4; i++) {
                var x = node.x + directionX[i];
                var y = node.y + directionY[i];

                if (!(x >= 0 && y >= 0 && x < n && y < m)) continue;
                if (maps[x][y] == 0 || visited[x][y] == 1) continue;

                visited[x][y] = 1;
                queue.offer(new Node(x, y, node.cost + 1));
            }
        }

        return -1;
    }

    class Node {
        int x;
        int y;
        int cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
}
