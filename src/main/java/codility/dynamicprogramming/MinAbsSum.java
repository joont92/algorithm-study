package codility.dynamicprogramming;

public class MinAbsSum {
    public int soultion(int[] array) {
        if(array.length == 0) {
            return 0;
        }

        int sum = array[0];
        for (int i = 1; i < array.length; i++) {
            int value = array[i];
            if(Math.abs(sum - value) < Math.abs(sum + value)) {
                sum -= value;
            } else {
                sum += value;
            }
        }

        return sum;
    }
}
