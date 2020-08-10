package programmers.bruteforce;

import java.util.HashSet;
import java.util.Set;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42839
 */
public class 소수_찾기 {
    public static void main(String[] args) {
        소수_찾기 fn = new 소수_찾기();
        System.out.println(fn.solution("110"));
    }

    private char[] characters;
    private boolean[] check;

    public int solution(String numbers) {
        this.characters = numbers.toCharArray();
        this.check = new boolean[characters.length];

        Set<Integer> primeNumbers = new HashSet<>();
        for (int i = 1; i <= characters.length; i++) {
            characterCases(0, i, new char[i], primeNumbers);
        }

        primeNumbers.stream().forEach(System.out::println);
        return primeNumbers.size();
    }

    private void characterCases(int idx, int target, char[] temp, Set<Integer> primeNumbers) {
        if(idx == target) {
            int number = Integer.parseInt(String.valueOf(temp));

            if(isPrimeNumber(number)) {
                primeNumbers.add(number);
            }
            return;
        }

        for (int i = 0; i < characters.length; i++) {
            if(check[i]) {
               continue;
            }

            check[i] = true;
            temp[idx] = characters[i];
            characterCases(idx + 1, target, temp, primeNumbers);
            check[i] = false;
        }
    }

    private boolean isPrimeNumber(int n) {
        if(n <= 1) {
            return false;
        }

        for (int i = 2; i * i <= n; i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
