package programmers.dfsbfs;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/43163
 *
 * dfs 사용하면 됨
 * 탐색하다가 원하는 단어를 만났을 경우, 전체 문자열의 길이에서 아직까지 사용하지 않은 문자열의 길이를 뺸 값이 단어를 찾는데 사용한 횟수임
 * 이 값들의 최소값을 구하면 됨
 */
public class 단어_변환 {
    public static void main(String[] args) {
        String[] words = {"hot","dot","dog","lot","log","cog"};

        단어_변환 fn = new 단어_변환();
        System.out.println(fn.solution("hit", "log", words));
    }

    int min;
    boolean[] check;

    public int solution(String begin, String target, String[] words) {
        check = new boolean[words.length];
        min = words.length;
        dfs(begin, target, words);

        return min == words.length ? 0 : min;
    }

    private void dfs(String begin, String target, String[] words) {
        if(begin.equals(target)) {
            int count = 0;
            for (boolean ch : check) {
                if (!ch) {
                    count++;
                }
            }
            min = Math.min(min, words.length - count);
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if(!check[i] && stringDiffCount(begin, words[i]) == 1) {
                check[i] = true;
                dfs(words[i], target, words);
                check[i] = false;
            }
        }
    }

    // 위처럼 boolean 개수를 세지않고 depth 를 전달하는 방법도 있음
//    public void dfs(String str, int depth, String target, String[] words) {
//        if(str.equals(target)) {
//            min = Math.min(min, depth);
//        }
//
//        for (int i = 0; i < words.length; i++) {
//            if(check[i]) {
//                continue;
//            }
//
//            if(notEqualsCount(str, words[i]) == 1) {
//                check[i] = true;
//                dfs(words[i], depth + 1, target, words);
//                check[i] = false;
//            }
//        }
//    }

    private int stringDiffCount(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                count++;
            }
        }

        return count;
    }
}
