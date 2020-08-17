package codility.countingelements;

import java.util.HashSet;
import java.util.Set;

/**
 * https://app.codility.com/programmers/lessons/4-counting_elements/missing_integer/
 *
 * 1. 음수 제거하고, 중복 제거한 뒤 1부터 올라가면서 없는 수 반환하기
 * 2. set 사용하기
 *
 * 둘 다 통과 가능한데, 1번 구현에서 java stream api를 써서 시간이 조금 초과되었다
 * 2번도 stream을 쓰니까 시간이 조금 초과되었다
 * stream이 조금 느리구나..
 */
public class MissingInteger {
    public static void main(String[] args) {
        int[] A = {-1, -3};

        MissingInteger fn = new MissingInteger();
        System.out.println(fn.solution(A));
    }

    public int solution(int[] A) {
        Set<Integer> set = new HashSet<>();
        for (int value : A) {
            set.add(value);
        }

        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            if(!set.contains(i)) {
                return i;
            }
        }

        return -1;
    }

//    public int solution(int[] A) {
//        int[] target = Arrays.stream(A).filter(i -> i > 0).sorted().distinct().toArray();
//
//        if(target.length == 0) {
//            return 1;
//        }
//
//        for (int i = 0; i < target.length; i++) {
//            if(target[i] != i + 1) {
//                return i + 1;
//            }
//        }
//
//        return target[target.length - 1] + 1;
//    }
}
