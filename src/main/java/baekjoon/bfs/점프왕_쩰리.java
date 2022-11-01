package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class 점프왕_쩰리 {
    public static void main(String[] args) throws IOException {
        var reader = new BufferedReader(new InputStreamReader(System.in));
        var size = Integer.parseInt(reader.readLine());
        var array = new int[size][size];
        for (int i = 0; i < size; i++) {
            var row = reader.readLine().split(" ");
            for (int j = 0; j < row.length; j++) {
                array[i][j] = Integer.parseInt(row[j]);
            }
        }

        System.out.println(new 점프왕_쩰리().solution(array));
    }

    public String solution(int[][] array) {
        var visited = new int[array.length][array[0].length];

        var queue = new LinkedList<Node>();
        queue.offer(new Node(0, 0));
        visited[0][0] = 1;

        while (!queue.isEmpty()) {
            var node = queue.poll();
            var jumpAvailable = array[node.y][node.x];

            if (jumpAvailable == -1) {
                return "HaruHaru";
            }

            var nextX = node.x + jumpAvailable;
            var nextY = node.y + jumpAvailable;

            if (nextX < array[0].length && visited[node.y][nextX] != 1) {
                queue.offer(new Node(node.y, nextX));
                visited[node.y][nextX] = 1;
            }

            if (nextY < array.length && visited[nextY][node.x] != 1) {
                queue.offer(new Node(nextY, node.x));
                visited[nextY][node.x] = 1;
            }
        }

        return "Hing";
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
