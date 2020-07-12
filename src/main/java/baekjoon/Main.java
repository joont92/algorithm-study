package baekjoon;

import baekjoon.dp.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        이친수 fn = new 이친수();
        run(br, (n) -> System.out.println(fn.bottomUp(n)));
    }

    private static void run(BufferedReader br, Consumer<Integer> consumer) throws IOException {
        int n = Integer.parseInt(br.readLine());
        consumer.accept(n);
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
