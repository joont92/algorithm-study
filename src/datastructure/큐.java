package datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/10845
 */
public class 큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());

        Queue queue = new Queue();
        for (int i = 0; i < count; i++) {
            String[] str = br.readLine().split(" ");

            switch (str[0]) {
                case "push" : {
                    queue.push(Integer.parseInt(str[1]));
                    break;
                }
                case "pop" : {
                    System.out.println(queue.pop());
                    break;
                }
                case "size" : {
                    System.out.println(queue.size());
                    break;
                }
                case "empty" : {
                    System.out.println(queue.empty());
                    break;
                }
                case "front" : {
                    System.out.println(queue.front());
                    break;
                }
                case "back" : {
                    System.out.println(queue.back());
                }
            }
        }
    }

    static class Queue {
        private static final int DEFAULT_ARRAY_SIZE = 10;

        private int[] arr;
        private int index = 0;

        public Queue() {
            this.arr = new int[DEFAULT_ARRAY_SIZE];
        }

        public void push(int n) {
            if (index == arr.length) {
                increaseQueue();
            }
            arr[index++] = n;
        }

        public int pop() {
            return index > 0 ? removeElement() : -1;
        }

        public int size() {
            return index;
        }

        public int empty() {
            return index == 0 ? 1 : 0;
        }

        public int front() {
            return index > 0 ? arr[0] : -1;
        }

        public int back() {
            return index > 0 ? arr[index - 1] : -1;
        }

        private void increaseQueue() {
            int[] newArr = new int[arr.length + DEFAULT_ARRAY_SIZE];
            System.arraycopy(arr, 0, newArr, 0, arr.length);

            arr = newArr;
        }

        private int removeElement() {
            int n = arr[0];

            System.arraycopy(arr, 1, arr, 0, arr.length - 1);
            arr[arr.length - 1] = 0;
            index--;

            return n;
        }
    }
}
