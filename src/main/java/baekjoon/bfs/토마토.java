package baekjoon.bfs;

import java.util.LinkedList;
import java.util.Scanner;

public class 토마토 {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var rowSize = scanner.nextInt();
        var columnSize = scanner.nextInt();

        var array = new int[columnSize][rowSize];
        for (int i = 0; i < columnSize; i++) {
            for (int j = 0; j < rowSize; j++) {
                array[i][j] = scanner.nextInt();
            }
        }

        System.out.println(new 토마토().solution(array));
    }

    public int solution(int[][] array) {
        var totalCount = 0;
        var ripenTomatoes = new LinkedList<Node>();
        var checked = new boolean[array.length][array[0].length];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] != -1) {
                    totalCount++;
                }
                if (array[i][j] == 1) {
                    ripenTomatoes.offer(new Node(i, j, 1));
                    checked[i][j] = true;
                }
            }
        }

        if (totalCount == ripenTomatoes.size()) {
            return 0;
        }

        var directionX = new int[]{1, -1, 0, 0};
        var directionY = new int[]{0, 0, 1, -1};

        var tomatoGraph = new LinkedList<Node>();
        while (!ripenTomatoes.isEmpty()) {
            var ripenTomato = ripenTomatoes.poll();
            tomatoGraph.offer(new Node(ripenTomato.y, ripenTomato.x, 0));

            // TODO 하나씩 잡고 도는게 아니라 한번에 ripenTomato를 같이 이동해야함
            while (!tomatoGraph.isEmpty()) {
                var tomato = tomatoGraph.poll();

                for (int i = 0; i < 4; i++) {
                    var y = tomato.y + directionY[i];
                    var x = tomato.x + directionX[i];

                    if (y < 0 || y >= array.length || x < 0 || x >= array[0].length) continue;

                    if (!checked[y][x] && array[y][x] != -1) {
                        array[y][x] = tomato.day + 1;
                        tomatoGraph.offer(new Node(y, x, tomato.day + 1));
                        checked[y][x] = true;
                    }
                }
            }
        }

        var result = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] == 0) {
                    return -1;
                }
                result = Math.max(result, array[i][j]);
            }
        }

        return result;
    }

    class Node {
        int y;
        int x;
        int day;

        public Node(int y, int x, int day) {
            this.y = y;
            this.x = x;
            this.day = day;
        }
    }
}
