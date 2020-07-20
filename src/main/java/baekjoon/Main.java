package baekjoon;

import baekjoon.math._2진수_8진수;
import baekjoon.math.숨바꼭질6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        _2진수_8진수 fn = new _2진수_8진수();
        runWithCnt(br, s -> System.out.println(fn.toOctal(s)));
    }

    private static void runWithCnt(BufferedReader br, Consumer<String> consumer) throws IOException {
//        String[] str1 = br.readLine().split(" ");
//        int size = Integer.parseInt(str1[0]);
//        int standard = Integer.parseInt(str1[1]);
//
//        String[] str2 = br.readLine().split(" ", size);
//        consumer.accept(standard, Arrays.stream(str2)
//                .mapToInt(Integer::parseInt)
//                .toArray());
        consumer.accept(br.readLine());
    }
}
