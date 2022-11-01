package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class 바이러스 {
    public static void main(String[] args) throws IOException {
        var reader = new BufferedReader(new InputStreamReader(System.in));
        var numberOfComputer = Integer.parseInt(reader.readLine());
        var numberOfNetwork = Integer.parseInt(reader.readLine());
        Set<Integer>[] graph = new Set[numberOfComputer];

        for (int i = 0; i < numberOfNetwork; i++) {
            var str = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

            var start = str[0] - 1;
            var end = str[1] - 1;

            if (graph[start] == null) graph[start] = new HashSet<>();
            if (graph[end] == null) graph[end] = new HashSet<>();

            graph[start].add(end);
            graph[end].add(start);
        }

        System.out.println(new 바이러스().solution(graph, new boolean[graph.length]));
    }

    public int solution(Set<Integer>[] graph, boolean[] checked) {
        var queue = new LinkedList<Integer>();
        queue.offer(0);

        var count = 0;
        while (!queue.isEmpty()) {
            var computer = queue.poll();
            if (!checked[computer]) {
                checked[computer] = true;
                count++;
            }

            var network = graph[computer];
            if (network == null) continue;

            for (Integer connected : network) {
                if (!checked[connected]) {
                    queue.offer(connected);
                }
            }
        }

        return count - 1;
    }
}
