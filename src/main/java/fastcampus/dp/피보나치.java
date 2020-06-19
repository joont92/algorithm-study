package fastcampus.dp;

public class 피보나치 {
    public static long result(int num) {
        return num <= 1 ? num : result(num - 1) + result(num - 2);
    }

    public static long resultWithoutRecursive(int num) {
        if(num <= 1) {
            return num;
        }

        long[] arr = new long[num + 1];
        arr[0] = 0;
        arr[1] = 1;

        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        return arr[num];
    }
}
