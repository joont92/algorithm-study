package baekjoon;

import baekjoon.graph.DFS와_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] condition = br.readLine().split(" ");
        DFS와_BFS fn = new DFS와_BFS(Integer.parseInt(condition[0]));

        for (int i = 0; i < Integer.parseInt(condition[1]); i++) {
            String[] relation = br.readLine().split(" ");
            fn.add(Integer.parseInt(relation[0]), Integer.parseInt(relation[1]));
        }
        fn.dfsSearch(Integer.parseInt(condition[2]));
        System.out.println();
        fn.bfsSearch(Integer.parseInt(condition[2]));
    }

    private static void run(BufferedReader br, int count, Consumer<Map<Integer, Integer>> consumer) throws IOException {
        Map<Integer, Integer> relation = new HashMap<>();
        for (int i = 0; i < count; i++) {
            String[] args = br.readLine().split(" ");
            relation.put(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        }
        consumer.accept(relation);
    }
}
