package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class 바닥장식 {
    public static void main(String[] args) throws IOException {
        var reader = new BufferedReader(new InputStreamReader(System.in));
        var str = reader.readLine().split(" ");

        var length = Integer.parseInt(str[0]);
        var width = Integer.parseInt(str[1]);

        var array = new String[length][width];
        for (int i = 0; i < length; i++) {
            System.arraycopy(
                reader.readLine().split(""),
                0,
                array[i],
                0,
                width
            );
        }

        System.out.println(new 바닥장식().solution(array));
    }

    public int solution(String[][] array) {
        var checked = new boolean[array.length][array[0].length];
        var queue = new LinkedList<Node>();

        var count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (checked[i][j]) continue;

                queue.offer(new Node(i, j));

                while (!queue.isEmpty()) {
                    var node = queue.poll();
                    checked[node.y][node.x] = true;

                    if (array[node.y][node.x].equals("-")) {
                        if (node.x + 1 < array[0].length && array[node.y][node.x + 1].equals("-")) {
                            queue.offer(new Node(node.y, node.x + 1));
                        } else {
                            count++;
                        }
                    } else {
                        if (node.y + 1 < array.length && array[node.y + 1][node.x].equals("|")) {
                            queue.offer(new Node(node.y + 1, node.x));
                        } else {
                            count++;
                        }
                    }
                }
            }
        }

        return count;
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
