package baekjoon;

import baekjoon.dp._1_2_3_더하기5;
import baekjoon.dp.쉬운_계단_수;
import baekjoon.dp.카드_구매하기;
import baekjoon.dp.카드_구매하기2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        쉬운_계단_수 fn = new 쉬운_계단_수();
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
