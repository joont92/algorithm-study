package programmers.dfsbfs;

import kotlin.Pair;

import java.util.Arrays;
import java.util.Stack;

public class DFS {
    public static void main(String[] args) {
        var rowCount = 7;
        var columnCount = 10;
        var board = new int[][]{ // 10 x 7
            {1,1,1,1,1,0,0,0,0,0},
            {1,0,0,0,1,0,0,0,0,0},
            {1,1,1,0,1,0,0,0,0,0},
            {1,1,0,0,1,0,0,0,0,0},
            {0,1,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0}
        };


        // 상하좌우
        var directionX = new int[]{-1, 1, 0, 0};
        var directionY = new int[]{0, 0, -1, 1};

        var visited = new int[7][10];
        visited[0][0] = 1;

        var stack = new Stack<Pair<Integer, Integer>>();
        stack.push(new Pair<>(0, 0));

        while (!stack.isEmpty()) {
            var front = stack.pop();
            for (int i = 0; i < 4; i++) {
                var X = front.getFirst() + directionX[i];
                var Y = front.getSecond() + directionY[i];

                if (X < 0 || X > rowCount || Y < 0 || Y > columnCount) continue;
                if (board[X][Y] == 1 && visited[X][Y] != 1) {
                    visited[X][Y] = 1;
                    stack.push(new Pair<>(X, Y));
                }
            }
        }

        for (int[] arr : visited) {
            Arrays.stream(arr).forEach(System.out::print);
            System.out.println();
        }
    }
}
