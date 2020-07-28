package baekjoon;

import baekjoon.bruteforce.모든_순열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        모든_순열 fn = new 모든_순열();
        run(br, n -> fn.allPermutation(0, n));
    }

    private static void run(BufferedReader br, Consumer<Integer> consumer) throws IOException {
        consumer.accept(Integer.parseInt(br.readLine()));
    }
}
