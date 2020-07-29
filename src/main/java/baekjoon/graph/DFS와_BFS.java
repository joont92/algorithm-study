package baekjoon.graph;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * https://www.acmicpc.net/problem/1260
 */
public class DFS와_BFS {
    private Set<Integer> hasEdge = new HashSet<>();
    private Stack<Integer> tracking = new Stack<>();
    private boolean result;

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

        hasEdge.add(me);
        hasEdge.add(you);
    }

    public String dfsSearch(int start) {
        dfs(start, 0);

        if(result) {
            return tracking.stream().map(String::valueOf).collect(Collectors.joining(" "));
        }

        return "";
    }

    public void dfs(int vertex, int depth) {
        if(depth == hasEdge.size() - 1) {
            result = true;
        }

        List<Integer> element = graph.get(vertex - 1);

        tracking.push(vertex);
        check[vertex] = true;
        for (Integer e : element) {
            if(!check[e]) {
                dfs(e, depth + 1);
            }

            if(result) {
                break;
            }
        }
        if(!result) {
            tracking.pop();
        }
        check[vertex] = false;
    }
}
