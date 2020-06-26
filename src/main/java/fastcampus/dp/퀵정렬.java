package fastcampus.dp;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class 퀵정렬 {
    public static List<Integer> sort(List<Integer> numbers) {
        if(numbers.size() <= 1) {
            return numbers;
        }

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        Integer pivot = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            Integer number = numbers.get(i);
            if(number < pivot) {
                left.add(number);
            } else {
                right.add(number);
            }
        }

        left.add(pivot);
        return Stream.concat(sort(left).stream(), sort(right).stream()).collect(Collectors.toList());
    }
}
