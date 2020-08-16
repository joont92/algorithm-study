package codility;

/**
 * https://app.codility.com/programmers/lessons/3-time_complexity/frog_jmp/
 */
public class _03_FrogJmp {
    public static void main(String[] args) {
        _03_FrogJmp fn = new _03_FrogJmp();
        System.out.println(fn.solution(10, 85, 30));
    }

    // O(1)
    public int solution(int X, int Y, int D) {
        int remain = Y - X;
        return remain % D == 0 ? remain / D : remain / D + 1;
    }
}
