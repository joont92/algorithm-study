package codility.countingelements;

/**
 * https://app.codility.com/programmers/lessons/4-counting_elements/frog_river_one/
 *
 * 이동할 위치만큼 boolean 배열을 생성하고, 나뭇잎이 채워질 떄 마다 count-- 한다
 * count가 0이 되면 시간(index) 반환
 */
public class FrogRiverOne {
    public static void main(String[] args) {
        int[] A = {1, 3, 1, 4, 2, 3, 5, 4};
        FrogRiverOne fn = new FrogRiverOne();

        System.out.println(fn.solution(5, A));
    }

    public int solution(int X, int[] A) {
        boolean[] falls = new boolean[X + 1];

        for (int i = 0; i < A.length; i++) {
            int position = A[i];
            if(!falls[position]) {
                falls[position] = true;
                X--;

                if(X == 0) {
                    return i;
                }
            }
        }

        return -1;
    }
}
