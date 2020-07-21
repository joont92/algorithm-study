package baekjoon.math;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.acmicpc.net/problem/17103
 */
public class 골드바흐_파티션 {
    private List<Integer> primeNumbers;
    private boolean[] check;
    public 골드바흐_파티션() {
        primeNumbers = new ArrayList<>();
        check = new boolean[1_000_000 + 1];

        for (int i = 2; i < check.length; i++) {
            if(!check[i]) {
                primeNumbers.add(i);

                for (int j = i + i; j < check.length; j += i) {
                    check[j] = true;
                }
            }
        }
    }

    public int countPrimeNumberPair(int n) {
        int count = 0;
        for (Integer primeNumber : primeNumbers) {
            if(primeNumber > n - 2 || primeNumber > n - primeNumber) {
                break;
            }

            int sub = n - primeNumber;
            if(!check[sub]) {
                count++;
            }
        }

        return count;
    }
}
