package baekjoon;

import baekjoon.tree.트리_순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());
        트리_순회 fn = new 트리_순회(count);
        for (int i = 0; i < count; i++) {
            String[] strs = br.readLine().split(" ");
            fn.add(strs[0].charAt(0), strs[1].charAt(0), strs[2].charAt(0));
        }

        fn.preOrder('A');
        System.out.println();
        fn.inOrder('A');
        System.out.println();
        fn.postOrder('A');

//        String[] condition = br.readLine().split(" ");
//        DFS와_BFS fn = new DFS와_BFS(Integer.parseInt(condition[0]));
//
//        for (int i = 0; i < Integer.parseInt(condition[1]); i++) {
//            String[] relation = br.readLine().split(" ");
//            fn.add(Integer.parseInt(relation[0]), Integer.parseInt(relation[1]));
//        }
//        fn.dfsSearch(Integer.parseInt(condition[2]));
//        System.out.println();
//        fn.bfsSearch(Integer.parseInt(condition[2]));
    }

//    private static void run(BufferedReader br, int count, Consumer<Map<Integer, Integer>> consumer) throws IOException {
//        Map<Integer, Integer> relation = new HashMap<>();
//        for (int i = 0; i < count; i++) {
//            String[] args = br.readLine().split(" ");
//            relation.put(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
//        }
//        consumer.accept(relation);
//    }
}
