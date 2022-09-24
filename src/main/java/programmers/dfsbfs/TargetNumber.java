package programmers.dfsbfs;

public class TargetNumber {
    public static void main(String[] args) {
        System.out.println(new TargetNumber().solution(new int[]{1, 1, 1, 1, 1}, 3) == 5);
        System.out.println(new TargetNumber().solution(new int[]{4, 1, 2, 1}, 4) == 2);
    }

    private int[] numbers;
    private int target;
    private int resultCount = 0;

    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;

        explore(0, numbers[0]);

        return resultCount;
    }

    private void explore(int index, int middleResult) {
        if (index == numbers.length - 1) {
            if (target == middleResult) resultCount++;
            return;
        }

        explore(index + 1, middleResult + numbers[index + 1]);
        explore(index + 1, middleResult - numbers[index + 1]);
    }
}
