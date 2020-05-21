package fastcampus.recursive;

public class 팩토리얼 {
    public static Integer calculate(Integer number) {
        if(number < 0) {
            throw new IllegalArgumentException("number have to less than 0");
        }

        if(number == 1) {
            return 1;
        }

        return number * calculate(number - 1);
    }
}
