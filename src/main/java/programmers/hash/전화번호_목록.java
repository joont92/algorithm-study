package programmers.hash;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42577
 *
 * 참고 : https://codevang.tistory.com/290
 * startsWith 연산 대신 substring + hashCode 비교 연산을 수행한다
 */
public class 전화번호_목록 {
    public boolean solution(String[] phoneBook) {
        for (int i = 0; i < phoneBook.length; i++) {
            int iLength = phoneBook[i].length();

            for (int j = i + 1; j < phoneBook.length; j++) {
                int jLength = phoneBook[j].length();

                if(iLength < jLength) {
                    if(phoneBook[i].hashCode() == phoneBook[j].substring(0, iLength).hashCode()) {
                        return false;
                    }
                } else {
                    if(phoneBook[i].substring(0, jLength).hashCode() == phoneBook[j].hashCode()) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
