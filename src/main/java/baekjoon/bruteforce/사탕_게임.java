package baekjoon.bruteforce;

/**
 * https://www.acmicpc.net/problem/3085
 *
 * 2차원 배열을 전체적으로 돌면서
 * 현재 값과 오른쪽 값이 다를 경우 swap & calculate, 현재 값과 아래 쪽 값이 다를 경우 swap & calculate
 * calculate 한 값들 중 max 값을 구한다
 *
 * calculate 는
 *
 * ----->
 * ↓↓↓↓↓
 *
 * -----
 * ----->
 * ↓↓↓↓↓
 *
 * -----
 * -----
 * ----->
 * ↓↓↓↓↓
 *
 * 처럼 행을 증가하면서
 * 행에 있는 값들 중 연속되는 최대값
 * 열에 있는 값들 중 연속되는 최대값
 * 을 구하면 된다
 */
public class 사탕_게임 {
    public int maxCandies(String[] candyArgs) {
        int max = 0;
        char[][] candyBox = init(candyArgs);

        for (int i = 0; i < candyBox.length; i++) {
            char[] candyArray = candyBox[i];
            for (int j = 0; j < candyArray.length; j++) {
                if(j + 1 < candyArray.length && candyArray[j] != candyArray[j + 1]) {
                    char temp = candyBox[i][j];
                    candyBox[i][j] = candyBox[i][j + 1];
                    candyBox[i][j + 1] = temp;

                    int count = getMaxAmountOfEnableCandies(candyBox);
                    if (max < count) {
                        max = count;
                    }

                    temp = candyBox[i][j];
                    candyBox[i][j] = candyBox[i][j + 1];
                    candyBox[i][j + 1] = temp;
                }

                if(i + 1 < candyBox.length && candyBox[i][j] != candyBox[i + 1][j]) {
                    char temp = candyBox[i][j];
                    candyBox[i][j] = candyBox[i + 1][j];
                    candyBox[i + 1][j] = temp;

                    int count = getMaxAmountOfEnableCandies(candyBox);
                    if (max < count) {
                        max = count;
                    }

                    temp = candyBox[i][j];
                    candyBox[i][j] = candyBox[i + 1][j];
                    candyBox[i + 1][j] = temp;
                }
            }
        }

        return max;
    }

    private int getMaxAmountOfEnableCandies(char[][] candyBox) {
        int max = 0;

        for (int i = 0; i < candyBox.length; i++) {
            char[] candyArray = candyBox[i];

            int count = 0;
            char prev = ' ';

            // 가로
            for (char candy : candyArray) {
                count = countCalculate(count, prev, candy);
                max = getMax(max, count);

                prev = candy;
            }

            count = 0;
            prev = ' ';

            // 세로
            for (int j = 0; j < candyArray.length; j++) {
                for (int k = i; k < candyBox.length; k++) {
                    count = countCalculate(count, prev, candyBox[k][j]);
                    max = getMax(max, count);

                    prev = candyBox[k][j];
                }
                prev = ' ';
            }
        }

        return max;
    }

    private char[][] init(String[] candyArgs) {
        char[][] candyBox = new char[candyArgs.length][candyArgs[0].length()];

        for (int i = 0; i < candyArgs.length; i++) {
            char[] candyArg = candyArgs[i].toCharArray();
            System.arraycopy(candyArg, 0, candyBox[i], 0, candyArg.length);
        }

        return candyBox;
    }

    private int getMax(int max, int count) {
        if (max < count) {
            max = count;
        }
        return max;
    }

    private int countCalculate(int count, char prev, char current) {
        if (prev == current) {
            count++;
        } else {
            count = 1;
        }
        return count;
    }
}