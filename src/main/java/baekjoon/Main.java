package baekjoon;

import baekjoon.bruteforce.N과_M1;
import baekjoon.bruteforce.사탕_게임;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N과_M1 fn = new N과_M1();
        run(br, n -> fn.cases(0, n[0], n[1]));
    }

    private static void run(BufferedReader br, Consumer<int[]> consumer) throws IOException {
        consumer.accept(Arrays.stream(br.readLine().split(" ", 2))
                .mapToInt(Integer::parseInt)
                .toArray());
    }
}
