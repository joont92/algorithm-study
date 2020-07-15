package baekjoon.math;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.acmicpc.net/problem/6588
 *
 * 100만 이하의 소수를 모두 구함
 * 짝수에 대해 brute forcing?
 * b-a 가 가장 큰 값이라는 말은 결국 속임수. 가장 먼저 찾는 값이 b-a 가 가장 큼.
 */
public class 골드바흐의_추측 {
    List<Integer> primeNumbers;
    boolean[] check;
    public 골드바흐의_추측() {
        primeNumbers = new ArrayList<>();
        check = new boolean[1_000_001];

        for (int i = 2; i < check.length; i++) {
            if(!check[i]) {
                primeNumbers.add(i);

                for (int j = i * 2; j < check.length; j+=i) {
                    check[j] = true;
                }
            }
        }
    }

    public void sumOfPrimeNumber(int number) {
        boolean proof = false;
        for (Integer primeNumber : primeNumbers) {
            int sub = number - primeNumber;
            if(sub <= 1) {
                break;
            }

            if(!check[sub]) {
                proof = true;
                System.out.println(number + " = " + primeNumber + " + " + sub);
                break;
            }
        }

        if(!proof) {
            System.out.println("Goldbach's conjecture is wrong.");
        }

    }
}
