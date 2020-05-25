package fastcampus.recursive;

import java.util.Arrays;

public class 회문 {
    public static boolean validate(String str) {
        char[] origin = str.toCharArray();
        char[] target = new char[origin.length];

        for (int i = origin.length - 1; i >= 0; i--) {
            target[origin.length - 1 - i] = origin[i];
        }

        return Arrays.equals(origin, target);
    }

    public static boolean validateWithRecursive(String str) {
        if(str.length() <= 1) {
            return true;
        }

        if(str.charAt(0) == str.charAt(str.length() - 1)) {
            return validateWithRecursive(str.substring(1, str.length() - 1));
        }

        return false;
    }
}
