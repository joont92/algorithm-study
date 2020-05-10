package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

/**
 * https://www.acmicpc.net/problem/1406
 */
public class 에디터 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Editor editor = new Editor(br.readLine());

        int count = Integer.parseInt(br.readLine());
        for (int i = 0; i < count; i++) {
            String[] operation = br.readLine().split(" ");

            switch (operation[0]) {
                case "L" : {
                    editor.left();
                    break;
                }
                case "D" : {
                    editor.right();
                    break;
                }
                case "B" : {
                    editor.delete();
                    break;
                }
                case "P" : {
                    editor.insert(operation[1].charAt(0));
                }
            }
        }

        System.out.println(editor.print());
    }

    static class Editor {
        private Stack<Character> left;
        private Stack<Character> right;

        public Editor(String initString) {
            left = new Stack<>();
            right = new Stack<>();

            Arrays.stream(initString.split(""))
                .map(s -> s.charAt(0))
                .forEach(left::push);
        }

        public void left() {
            if(left.isEmpty()) {
                return;
            }

            right.push(left.pop());
        }

        public void right() {
            if(right.isEmpty()) {
                return;
            }

            left.push(right.pop());
        }

        public void insert(char ch) {
            left.push(ch);
        }

        public void delete() {
            if(left.isEmpty()) {
                return;
            }

            left.pop();
        }

        public String print() {
            StringBuilder sb = new StringBuilder();
            while(!left.isEmpty()) {
                sb.append(left.pop());
            }
            sb.reverse();
            while(!right.isEmpty()) {
                sb.append(right.pop());
            }

            return sb.toString();
        }
    }
}
