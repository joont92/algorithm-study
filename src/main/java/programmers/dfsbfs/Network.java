package programmers.dfsbfs;

import java.util.ArrayList;
import java.util.List;

public class Network {
    public static void main(String[] args) {
        System.out.println(new Network().solution(3, new int[][]{
            {1, 1, 0},
            {1, 1, 0},
            {0, 0, 1}
        }));

        System.out.println(new Network().solution(3, new int[][]{
            {1, 1, 0}, {1, 1, 1}, {0, 1, 1}
        }));

        System.out.println(new Network().solution(3, new int[][]{
            {1, 0, 0}, {0, 1, 0}, {0, 0, 1}
        }));
    }

    int count = 0;
    public int solution(int n, int[][] computers) {
        var visited = new int[n];

        var dfs = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; i++) {
            dfs.add(new ArrayList<>());
        }

        for (int i = 0; i < computers.length; i++) {
            for (int j = 0; j < computers[0].length; j++) {
                if (i == j) continue;
                if (computers[i][j] == 1) {
                    dfs.get(i).add(j);
                }
            }
        }


        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                dfs(i, dfs, visited);
                count++;
            }
        }

        return count;
    }

    private void dfs(int index, List<List<Integer>> dfs, int[] visited) {
        visited[index] = 1;

        var elementList = dfs.get(index);

        for (Integer element : elementList) {
            if (visited[element] == 0) {
                dfs(element, dfs, visited);
            }
        }
    }
}
