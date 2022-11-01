package programmers.dfsbfs;

import java.util.LinkedList;

public class PickItem {
    public static void main(String[] args) {
        var rectangle = new int[][]{
            {1,1,7,4},
            {3,2,5,5},
            {4,3,6,9},
            {2,6,8,8}
        };

        new PickItem().solution(rectangle, 0,0,0,0);
    }

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;

        var graph = new int[50][50];

        for (int i = 0; i < rectangle.length; i++) {
            var numberOfRectangle = i + 1;

            var startX = rectangle[i][0] - 1;
            var startY = rectangle[i][1] - 1;
            var endX = rectangle[i][2] - 1;
            var endY = rectangle[i][3] - 1;

            for (int j = startX; j <= endX; j++) {
                graph[startY][j] = numberOfRectangle;
                graph[endY][j] = numberOfRectangle;
            }

            for (int j = startY; j <= endY; j++) {
                graph[j][startX] = numberOfRectangle;
                graph[j][endX] = numberOfRectangle;
            }
        }

        // 여기 돌기전에 미리 겹치는 부분들을 다 지워버리는게 좋을듯. 그래봐야 2n임

        var directionX = new int[]{0,0,-1,1};
        var directionY = new int[]{1,-1,0,0};

        var queue = new LinkedList<Node>();
        queue.offer(new Node(characterX - 1, characterY - 1));

        while (!queue.isEmpty()) {
            var node = queue.poll();

            Node maxNode;
            for (int i = 0; i < 4; i++) {
                var x = node.x + directionX[i];
                var y = node.y + directionY[i];

                if (x < 0 || x > graph.length || y < 0 || y > graph[0].length) continue;

                if (graph[x][y] != 0) {
                    queue.offer(new Node(x, y));
                }
            }
//            queue.offer(maxNode);
        }

        return answer;
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
