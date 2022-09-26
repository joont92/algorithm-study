package programmers.dfsbfs;

import java.util.LinkedList;

public class WordConversion {
    public static void main(String[] args) {
        System.out.println(new WordConversion().solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
        System.out.println(new WordConversion().solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log"}));
    }

    public int solution(String begin, String target, String[] words) {
        var check = new boolean[words.length];
        
        var queue = new LinkedList<Node>();
        queue.offer(new Node(begin, 0));

        while (!queue.isEmpty()) {
            var node = queue.poll();

            if (node.word.equals(target)) {
                return node.cost;
            }

            for (int i = 0; i < words.length; i++) {
                if (check[i]) continue;

                if (wordDiffCount(node.word, words[i]) == 1) {
                    queue.offer(new Node(words[i], node.cost + 1));
                    check[i] = true;
                }
            }
        }

        return 0;
    }
    
    private int wordDiffCount(String str1, String str2) {
        var count = 0;
        
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                count++;
            }
        }

        return count;
    }

    class Node {
        String word;
        int cost;

        public Node(String word, int cost) {
            this.word = word;
            this.cost = cost;
        }
    }
}
