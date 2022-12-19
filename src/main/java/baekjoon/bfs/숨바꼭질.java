package baekjoon.bfs;

import java.util.LinkedList;
import java.util.Scanner;

public class 숨바꼭질 {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var start = scanner.nextInt();
        var end = scanner.nextInt();

        System.out.println(new 숨바꼭질().solution(start, end));
    }

    final int minLocation = 0;
    final int maxLocation = 100_000;

    public int solution(int start, int end) {
        var check = new boolean[maxLocation + 1];
        check[start] = true;

        var queue = new LinkedList<Node>();
        queue.offer(new Node(start, 0));

        while (!queue.isEmpty()) {
            var current = queue.poll();

            if (current.location == end) {
                return current.time;
            }

            for (int i = 0; i < 3; i++) {
                int next;

                switch (i) {
                    case 0 : {
                        next = current.location - 1;
                        break;
                    }
                    case 1 : {
                        next = current.location + 1;
                        break;
                    }
                    case 2 : {
                        next = current.location * 2;
                        break;
                    }
                    default : next = current.location;
                }

                if (next >= minLocation && next <= maxLocation && !check[next]) {
                    queue.offer(new Node(next, current.time + 1));
                    check[next] = true;
                }
            }
        }

        return 0;
    }

    class Node {
        int location;
        int time;

        public Node(int location, int time) {
            this.location = location;
            this.time = time;
        }
    }
}
