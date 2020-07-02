package fastcampus.dp;

import java.util.ArrayList;
import java.util.List;

public class 병합정렬 {
    public static List<Integer> sort(List<Integer> numbers) {
        return splitAndMerge(numbers);
    }

    private static List<Integer> splitAndMerge(List<Integer> numbers) {
        if(numbers.size() <= 1) {
            return numbers;
        }

        int pivot = numbers.size() / 2;
        List<Integer> left = numbers.subList(0, pivot);
        List<Integer> right = numbers.subList(pivot, numbers.size());

        return merge(splitAndMerge(left), splitAndMerge(right));
    }

    private static List<Integer> merge(List<Integer> left, List<Integer> right) {
        int leftIdx = 0;
        int rightIdx = 0;

        List<Integer> result = new ArrayList<>();
        while(leftIdx < left.size() && rightIdx < right.size()) {
            Integer leftValue = left.get(leftIdx);
            Integer rightValue = right.get(rightIdx);

            if(leftValue < rightValue) {
                result.add(leftValue);
                leftIdx++;
            } else {
                result.add(rightValue);
                rightIdx++;
            }
        }

        if(leftIdx < left.size()) {
            result.addAll(left.subList(leftIdx, left.size()));
        } else if(rightIdx < right.size()) {
            result.addAll(right.subList(rightIdx, right.size()));
        }

        return result;
    }
}
