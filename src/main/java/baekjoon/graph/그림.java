package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class 그림 {
    public static void main(String[] args) throws IOException {
        var reader = new BufferedReader(new InputStreamReader(System.in));
        var size = reader.readLine().split(" ");

        var rowSize = Integer.parseInt(size[0]);
        var columnSize = Integer.parseInt(size[1]);

        var picture = new int[rowSize][columnSize];
        for (int i = 0; i < rowSize; i++) {
            var column = reader.readLine().split(" ");
            for (int j = 0; j < columnSize; j++) {
                picture[i][j] = Integer.parseInt(column[j]);
            }
        }

//        var picture = new int[][] {
//            {1, 1, 0, 1, 1},
//            {0, 1, 1, 0, 0},
//            {0, 0, 0, 0, 0},
//            {1, 0, 1, 1, 1},
//            {0, 0, 1, 1, 1},
//            {0, 0, 1, 1, 1}
//        };

        Arrays.stream(new 그림().solution(picture))
            .forEach(System.out::println);
    }

    public int[] solution(int[][] picture) {
        var directionX = new int[]{-1, 1, 0, 0};
        var directionY = new int[]{0, 0, -1, 1};

        var result = new int[2];

        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[0].length; j++) {
                if (picture[i][j] != 1) continue;

                var queue = new LinkedList<Node>();
                queue.offer(new Node(i, j));
                picture[i][j] = -1;

                var size = 1;
                while (!queue.isEmpty()) {
                    var node = queue.poll();

                    for (int k = 0; k < 4; k++) {
                        var x = node.x + directionX[k];
                        var y = node.y + directionY[k];

                        if (!(x >= 0 && y >= 0 && x < picture.length && y < picture[0].length)) continue;

                        if (picture[x][y] == 1) {
                            picture[x][y] = -1;
                            size++;
                            queue.offer(new Node(x, y));
                        }
                    }
                }

                result[0]++;
                result[1] = Math.max(size, result[1]);
            }
        }

        return result;
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
