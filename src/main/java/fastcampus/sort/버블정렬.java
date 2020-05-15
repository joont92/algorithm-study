package fastcampus.sort;

import java.util.Arrays;
import java.util.List;

public class 버블정렬 {
    public static List<Integer> sort(Integer... numbers) {
        for (int i = 1; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length - i; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }

        return Arrays.asList(numbers);
    }
}