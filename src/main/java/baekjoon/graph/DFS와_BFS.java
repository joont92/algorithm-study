package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

/**
 * https://www.acmicpc.net/problem/1260
 */
public class DFS와_BFS {
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

    private List<List<Integer>> graph = new ArrayList<>();
    private boolean[] check;

    public DFS와_BFS(int vertexCount) {
        IntStream.range(0, vertexCount).forEach(i -> graph.add(new ArrayList<>()));
        check = new boolean[graph.size() + 1];
    }

    public void add(int me, int you) {
        graph.get(me - 1).add(you);
        graph.get(you - 1).add(me);
        Collections.sort(graph.get(me - 1));
        Collections.sort(graph.get(you - 1));
    }

    public void dfsSearch(int start) {
        Arrays.fill(check, false);
        dfs(start);
    }

    private void dfs(int vertex) {
        check[vertex] = true;
        System.out.print(vertex + " ");

        List<Integer> element = graph.get(vertex - 1);
        for (Integer e : element) {
            if(!check[e]) {
                dfs(e);
            }
        }
    }

    public void bfsSearch(int start) {
        Arrays.fill(check, false);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        check[start] = true;

        bfs(queue);
    }

    private void bfs(Queue<Integer> queue) {
        while(!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");

            List<Integer> element = graph.get(vertex - 1);
            for (Integer e : element) {
                if(!check[e]) {
                    check[e] = true;
                    queue.add(e);
                }
            }
        }
    }
}
