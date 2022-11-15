package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class 미로_탐색 {
    public static void main(String[] args) throws IOException {
        var reader = new BufferedReader(new InputStreamReader(System.in));
        var str = reader.readLine().split(" ");
        var rowSize = Integer.parseInt(str[0]);
        var columnSize = Integer.parseInt(str[1]);

        var array = new int[rowSize][columnSize];
        for (int i = 0; i < rowSize; i++) {
            var line = reader.readLine().split("");
            for (int j = 0; j < columnSize; j++) {
                array[i][j] = Integer.parseInt(line[j]);
            }
        }

        System.out.println(new 미로_탐색().solution(array));
    }

    public int solution(int[][] array) {
        var queue = new LinkedList<Node>();
        var checked = new boolean[array.length][array[0].length];
        queue.offer(new Node(0, 0, 1));
        checked[0][0] = true;

        var directionX = new int[]{1, -1, 0, 0};
        var directionY = new int[]{0, 0, 1, -1};

        var result = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            var node = queue.poll();

            if (node.y == array.length - 1 && node.x == array[0].length - 1) {
                result = Math.min(result, node.cost);
            }

            for (int i = 0; i < 4; i++) {
                var y = node.y + directionY[i];
                var x = node.x + directionX[i];

                if (y < 0 || y >= array.length || x < 0 || x >= array[0].length)
                    continue;

                if (!checked[y][x] && array[y][x] == 1) {
                    queue.offer(new Node(y, x, node.cost + 1));
                    checked[y][x] = true;
                }
            }
        }

        return result;
    }

    class Node {
        int y;
        int x;
        int cost;

        public Node(int y, int x, int cost) {
            this.y = y;
            this.x = x;
            this.cost = cost;
        }
    }
}
