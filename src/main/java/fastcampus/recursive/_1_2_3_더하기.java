package fastcampus.recursive;

// https://ssu-gongdoli.tistory.com/36
public class _1_2_3_더하기 {
    public static int count(int number) {
        if(number <= 1) {
            return 1;
        }

        if(number == 2) {
            return 2;
        }

        if(number == 3) {
            return 4;
        }

        return count(number - 1) + count(number - 2) + count(number - 3);
    }
}
