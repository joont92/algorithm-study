package programmers.dfsbfs;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/43163
 */
public class 단어_변환 {
    public static void main(String[] args) {
        String[] words = {"hot","dot","dog","lot","log","cog"};

        단어_변환 fn = new 단어_변환();
        System.out.println(fn.solution("hit", "cog", words));
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
