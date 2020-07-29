package baekjoon.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.acmicpc.net/problem/13023
 */
public class ABCDE {
    private List<List<Integer>> graph;
    private boolean[] check;
    private boolean result;

    public ABCDE(int v) {
        graph = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }

        check = new boolean[v];
    }

    public void add(int me, int friend) {
        graph.get(me).add(friend);
        graph.get(friend).add(me);
    }

    public boolean search() {
        for (int i = 0; i < graph.size(); i++) {
            search(i, 1);
        }
        return result;
    }

    private void search(int v, int depth) {
        if(depth == 5) {
            result = true;
            return;
        }
        List<Integer> friends = graph.get(v);

        check[v] = true;
        for (Integer friend : friends) {
            if(result) {
                break;
            }

            if (!check[friend]) {
                search(friend, depth + 1);
            }
        }
        check[v] = false;
    }
}
