package programmers.bruteforce;

import java.util.HashSet;
import java.util.Set;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42839
 *
 * 순열에서 r 을 계속 증가시키면서 구하면, 숫자로 나타낼 수 있는 모든 경우의 수를 구할 수 있다
 * 순열을 뽑을 때 사용하던 재귀함수를 사용하였다
 */
public class 소수_찾기 {
    public static void main(String[] args) {
        소수_찾기 fn = new 소수_찾기();
        System.out.println(fn.solution("011"));
    }

    boolean[] notPrime = new boolean[10_000_000];

    public int solution(String numbers) {
        notPrime[0] = notPrime[1] = true;
        for (int i = 2; i < notPrime.length; i++) {
            if(notPrime[i]) {
                continue;
            }

            for (int j = i * 2; j < notPrime.length; j+=i) {
                notPrime[j] = true;
            }
        }

        boolean[] used = new boolean[numbers.length()];
        cases("", numbers, used);

        return primeNumbers.size();
    }

    Set<Integer> primeNumbers = new HashSet<>();
    private void cases(String current, String numbers, boolean[] used) {
        char[] chars = numbers.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(used[i]) {
                continue;
            }

            used[i] = true;
            int next = Integer.parseInt(current + chars[i]);
            if(!notPrime[next]) {
                primeNumbers.add(next);
            }
            cases(String.valueOf(next), numbers, used);
            used[i] = false;
        }
    }

//    private char[] characters;
//    private boolean[] check;
//
//    public int solution(String numbers) {
//        this.characters = numbers.toCharArray();
//        this.check = new boolean[characters.length];
//
//        Set<Integer> primeNumbers = new HashSet<>();
//        for (int i = 1; i <= characters.length; i++) {
//            characterCases(0, i, new char[i], primeNumbers);
//        }
//
//        primeNumbers.stream().forEach(System.out::println);
//        return primeNumbers.size();
//    }
//
//    private void characterCases(int idx, int target, char[] temp, Set<Integer> primeNumbers) {
//        if(idx == target) {
//            int number = Integer.parseInt(String.valueOf(temp));
//
//            if(isPrimeNumber(number)) {
//                primeNumbers.add(number);
//            }
//            return;
//        }
//
//        for (int i = 0; i < characters.length; i++) {
//            if(check[i]) {
//               continue;
//            }
//
//            check[i] = true;
//            temp[idx] = characters[i];
//            characterCases(idx + 1, target, temp, primeNumbers);
//            check[i] = false;
//        }
//    }
//
//    private boolean isPrimeNumber(int n) {
//        if(n <= 1) {
//            return false;
//        }
//
//        for (int i = 2; i * i <= n; i++) {
//            if(n % i == 0) {
//                return false;
//            }
//        }
//        return true;
//    }
}
