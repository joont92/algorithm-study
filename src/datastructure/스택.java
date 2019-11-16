package datastructure;

import java.util.Scanner;

public class 스택 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());

        Stack stack = new Stack(count);
        for (int i = 0; i < count; i++) {
            String[] strs = scanner.nextLine().split(" ");
            switch (strs[0]) {
                case "push" : {
                    stack.push(Integer.valueOf(strs[1]));
                    break;
                }
                case "pop" : {
                    System.out.println(stack.pop());
                    break;
                }
                case "size" : {
                    System.out.println(stack.size());
                    break;
                }
                case "empty" : {
                    System.out.println(stack.empty());
                    break;
                }
                case "top" : {
                    System.out.println(stack.top());
                }
            }
        }
    }

    static class Stack {
        int[] arr;
        int index;

        public Stack(int size) {
            this.arr = new int[size];
            this.index = 0;
        }

        public void push(int n) {
            arr[index++] = n;
        }

        public int pop() {
            if (index == 0) {
                return -1;
            }

            return arr[--index];
        }

        public int size() {
            return index;
        }

        public int empty() {
            return index == 0 ? 1 : 0;
        }

        public int top() {
            if (index == 0) {
                return -1;
            }

            return arr[index - 1];
        }
    }
}
