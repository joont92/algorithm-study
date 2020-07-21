package baekjoon;

import baekjoon.math._2진수_8진수;
import baekjoon.math.골드바흐_파티션;
import baekjoon.math.골드바흐의_추측;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        골드바흐_파티션 fn = new 골드바흐_파티션();
        runWithCnt(br, s -> System.out.println(fn.countPrimeNumberPair(s)));
    }

    private static void runWithCnt(BufferedReader br, Consumer<Integer> consumer) throws IOException {
//        String[] str2 = br.readLine().split(" ", size);
//        consumer.accept(standard, Arrays.stream(str2)
//                .mapToInt(Integer::parseInt)
//                .toArray());
        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++) {
            consumer.accept(Integer.parseInt(br.readLine()));
        }
    }
}
