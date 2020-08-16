package codility;

/**
 * https://app.codility.com/programmers/lessons/1-iterations/binary_gap/
 */
public class _01_BinaryGap {
    public static void main(String[] args) {
        _01_BinaryGap fn = new _01_BinaryGap();
        System.out.println(fn.solution(32));
    }
    
    public int solution(int n) {
        char[] binary = decimalToBinary(n);

        if(binary.length <= 1) {
            return 0;
        }

        int max = 0;
        int count = 0;
        for (int i = 1; i < binary.length; i++) {
            if(binary[i] == '0') {
                count++;
            } else {
                if(max < count) {
                    max = count;
                }
                count = 0;
            }
        }

        return max;
    }

    private char[] decimalToBinary(int n) {
        StringBuilder sb = new StringBuilder();
        while(n > 0) {
            sb.append(n % 2);
            n /= 2;
        }

        return sb.reverse().toString().toCharArray();
    }
}
