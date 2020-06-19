package fastcampus.recursive;

public class _1로만들기 {
    public static void printTo1(int n) {
        System.out.println(n);

        if(n == 1) {
            return;
        }

        if(n % 2 == 0) {
            printTo1(n / 2);
        } else {
            printTo1(n * 3 + 1);
        }
    }
}
