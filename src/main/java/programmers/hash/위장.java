package programmers.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42578
 *
 * 옷 타입별로 grouping 한다
 * headgear : 3
 * eyewear : 2
 * pants : 3
 *
 * 옷 종류마다 안입는 경우의 수를 더한 뒤(+1) 모든 경우의 수를 구해야한다
 * (+1 하지 않으면 모든 옷을 다 입는 경우의 수만 구하게 됨)
 * 그리고 최종적으로 모든 옷을 입지 않는 경우의 수 1을 빼주면 된다
 */
public class 위장 {
    public static void main(String[] args) {
        String[][] arr = new String[3][2];
        arr[0][0] = "yellow_hat"; arr[0][1] = "headgear";
        arr[1][0] = "blue_sunglasses"; arr[1][1] = "eyewear";
        arr[2][0] = "green_turban"; arr[2][1] = "headgear";

        위장 fn = new 위장();
        System.out.println(fn.solution(arr));
    }

    public int solution(String[][] clothes) {
        Map<String, Integer> clothesMap = new HashMap<>();

        for (String[] e : clothes) {
            String type = e[1];
            clothesMap.put(type, clothesMap.getOrDefault(type, 0) + 1);
        }

        return clothesMap.values().stream()
                .map(i -> i + 1)
                .reduce(1, (a,b) -> a * b) - 1;
    }
}
