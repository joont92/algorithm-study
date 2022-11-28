package baekjoon.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class 불 {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var rowCount = scanner.nextInt();
        var columnCount = scanner.nextInt();

        var person = new int[2];
        var fires = new ArrayList<int[]>();
        var array = new int[rowCount][columnCount];

        for (int i = 0; i < rowCount; i++) {
            var strs = scanner.next().split("");
            for (int j = 0; j < columnCount; j++) {
                switch (strs[j]) {
                    case "#" : array[i][j] = -1; break;
                    case "." : array[i][j] = 0; break;
                    case "F" : {
                        array[i][j] = 1;
                        fires.add(new int[]{i, j});
                        break;
                    }
                    case "J" : {
                        person[0] = i;
                        person[1] = j;
                    }
                }
            }
        }

        System.out.println(new 불().solution(array, person, fires.toArray(new int[0][0])));
    }

    public String solution(int[][] array, int[] person, int[][] fires) {
        var personQueue = new LinkedList<Node>();
        personQueue.offer(new Node(person[0], person[1]));

        var check = new boolean[array.length][array[0].length];
        check[person[0]][person[1]] = true;

        var firesQueue = new LinkedList<Node>();
        for (int[] fire : fires) {
            firesQueue.offer(new Node(fire[0], fire[1]));
        }

        var directionX = new int[]{1, -1, 0, 0};
        var directionY = new int[]{0, 0, 1, -1};

        var result = 0;
        while (!personQueue.isEmpty()) {
            var nextFiresQueue = new LinkedList<Node>();
            while (!firesQueue.isEmpty()) {
                var f = firesQueue.poll();
                for (int i = 0; i < 4; i++) {
                    var y = f.y + directionY[i];
                    var x = f.x + directionX[i];

                    if (y < 0 || y >= array.length || x < 0 || x >= array[0].length)
                        continue;

                    if (!check[y][x] && array[y][x] == 0) {
                        nextFiresQueue.offer(new Node(y, x));
                        array[y][x] = 1;
                        check[y][x] = true;
                    }
                }
            }
            firesQueue = nextFiresQueue;

            var nextPersonQueue = new LinkedList<Node>();
            while (!personQueue.isEmpty()) {
                var p = personQueue.poll();

                for (int i = 0; i < 4; i++) {
                    var y = p.y + directionY[i];
                    var x = p.x + directionX[i];

                    if (y < 0 || y >= array.length || x < 0 || x >= array[0].length) {
                        return String.valueOf(result + 1);
                    }

                    if (!check[y][x] && array[y][x] == 0) {
                        nextPersonQueue.offer(new Node(y, x));
                        check[y][x] = true;
                    }
                }
            }
            personQueue = nextPersonQueue;
            result++;
        }


        return "IMPOSSIBLE";
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
