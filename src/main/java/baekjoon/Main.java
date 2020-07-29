package baekjoon;

import baekjoon.bruteforce.모든_순열;
import baekjoon.graph.ABCDE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        ABCDE fn = new ABCDE(Integer.parseInt(str[0]));
        for (int i = 0; i < Integer.parseInt(str[1]); i++) {
            String[] relation = br.readLine().split(" ");
            fn.add(Integer.parseInt(relation[0]), Integer.parseInt(relation[1]));
        }
        System.out.println(fn.search() ? 1 : 0);
    }

    private static void run(BufferedReader br, Consumer<Integer> consumer) throws IOException {
        consumer.accept(Integer.parseInt(br.readLine()));
    }
}
