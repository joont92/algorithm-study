package baekjoon;

import baekjoon.math.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        조합_0의_개수 fn = new 조합_0의_개수();
        run2(br, n -> System.out.println(fn.count(Integer.parseInt(n[0]), Integer.parseInt(n[1]))));
    }

    private static void run(BufferedReader br, Consumer<Integer> consumer) throws IOException {
        int n = Integer.parseInt(br.readLine());
        consumer.accept(n);
    }

    private static void run2(BufferedReader br, Consumer<String[]> consumer) throws IOException {
        String str = br.readLine();
        consumer.accept(str.split(" "));
    }

    private static void runInfinitely(BufferedReader br, Consumer<Integer> consumer) throws IOException {
        int n;
        while((n = Integer.parseInt(br.readLine())) != 0) {
            consumer.accept(n);
        }
    }

    private static void runWithCnt(BufferedReader br, Consumer<Integer> consumer) throws IOException {
        int cnt = Integer.parseInt(br.readLine());

        for (int i = 0; i < cnt; i++) {
            int n = Integer.parseInt(br.readLine());
            consumer.accept(n);
        }
    }

    private static void runWithCnt2(BufferedReader br, Consumer<int[]> consumer) throws IOException {
        int cnt = Integer.parseInt(br.readLine());

        String str = br.readLine();
        consumer.accept(Arrays.stream(str.split(" ", cnt))
                .mapToInt(Integer::parseInt)
                .toArray());
    }
}
