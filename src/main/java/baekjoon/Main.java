package baekjoon;

import baekjoon.datastructure.요세푸스_문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        요세푸스_문제 fn = new 요세푸스_문제();
        run(br, n ->
                System.out.println("<" + fn.removedOrder(n[0], n[1]).stream().map(String::valueOf).collect(Collectors.joining(", ")) + ">"));
    }

    private static void run(BufferedReader br, Consumer<int[]> consumer) throws IOException {
        consumer.accept(Arrays.stream(br.readLine().split(" ", 2))
                .mapToInt(Integer::parseInt)
                .toArray());
    }
}
