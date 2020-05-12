package fastcampus.sort;

import java.util.Arrays;
import java.util.List;

public class 선택정렬 {
    public static List<Integer> sort(Integer... numbers) {
        for (int i = 0; i < numbers.length; i++) {
            int minIdx = i;
            for (int j = i + 1; j < numbers.length; j++) {
                if(numbers[minIdx] > numbers[j]) {
                    minIdx = j;
                }
            }

            int temp = numbers[i];
            numbers[i] = numbers[minIdx];
            numbers[minIdx] = temp;
        }

        return Arrays.asList(numbers);
    }
}
