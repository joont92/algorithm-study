package baekjoon;

import baekjoon.dp._2xN_타일링;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        _2xN_타일링 a = new _2xN_타일링();
        System.out.println(a.bottomUp(n));
    }
}
