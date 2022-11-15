package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class 그림 {
    public static void main(String[] args) throws IOException {
        var reader = new BufferedReader(new InputStreamReader(System.in));
        var str = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        var length = str[0];
        var width = str[1];

        var array = new int[length][width];
        for (int i = 0; i < length; i++) {
            System.arraycopy(
                Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray(),
                0,
                array[i],
                0,
                width
            );
        }

        Arrays.stream(new 그림().solution(array)).forEach(System.out::println);
    }

    public int[] solution(int[][] array) {
        var queue = new LinkedList<Node>();
        var check = new boolean[array.length][array[0].length];

        var count = 0;
        var size = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (!check[i][j] && array[i][j] == 1) {
                    queue.offer(new Node(i, j));
                    check[i][j] = true;
                    count++;
                }

                var tempSize = 0;
                while (!queue.isEmpty()) {
                    var node = queue.poll();
                    tempSize++;

                    if (node.x + 1 < array[i].length) {
                        if (!check[node.y][node.x + 1] && array[node.y][node.x + 1] == 1) {
                            queue.offer(new Node(node.y, node.x + 1));
                            check[node.y][node.x + 1] = true;
                        }
                    }
                    if (node.x - 1 >= 0) {
                        if (!check[node.y][node.x - 1] && array[node.y][node.x - 1] == 1) {
                            queue.offer(new Node(node.y, node.x - 1));
                            check[node.y][node.x - 1] = true;
                        }
                    }
                    if (node.y + 1 < array.length) {
                        if (!check[node.y + 1][node.x] && array[node.y + 1][node.x] == 1) {
                            queue.offer(new Node(node.y + 1, node.x));
                            check[node.y + 1][node.x] = true;
                        }
                    }
                    if (node.y - 1 >= 0) {
                        if (!check[node.y - 1][node.x] && array[node.y - 1][node.x] == 1) {
                            queue.offer(new Node(node.y - 1, node.x));
                            check[node.y - 1][node.x] = true;
                        }
                    }
                }
                size = Integer.max(size, tempSize);
            }
        }

        return new int[]{count, size};
    }

    class Node {
        int y;
        int x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
