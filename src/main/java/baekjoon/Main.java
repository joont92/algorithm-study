package baekjoon;

import baekjoon.dp.*;
import baekjoon.math.나머지;
import baekjoon.math.소수_찾기;
import baekjoon.math.최대공약수와_최소공배수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        소수_찾기 fn = new 소수_찾기();
        runWithCnt2(br, (n) -> {
            System.out.println(fn.count(n));
        });
    }

    private static void run(BufferedReader br, Consumer<Integer> consumer) throws IOException {
        int n = Integer.parseInt(br.readLine());
        consumer.accept(n);
    }

    private static void run2(BufferedReader br, Consumer<int[]> consumer) throws IOException {
        String str = br.readLine();
        consumer.accept(Arrays.stream(str.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray());
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
