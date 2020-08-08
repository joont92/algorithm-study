package programmers.stackqueue;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42584
 *
 * 기준점 이후로 숫자가 얼마동안 연속적으로 떨어지지 않았는지를 기록하면 된다
 */
public class 주식_가격 {
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};

        주식_가격 fn = new 주식_가격();

        int[] result = fn.solution(prices);
        for (int value : result) {
            System.out.println(value);
        }
    }

    public int[] solution(int[] prices) {
        int[] result = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                result[i]++;
                if(prices[j] < prices[i]) {
                    break;
                }
            }
        }

        return result;
    }
}
