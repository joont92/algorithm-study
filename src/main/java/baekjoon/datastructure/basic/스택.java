package baekjoon.datastructure.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/10828
 */
public class 스택 {
    public static void main(String[] args) {
        System.out.println(tc1());
        System.out.println(tc2());
        System.out.println(tc3());
    }

    private static void basic() {
        var fn = new 스택();

        try {
            var br = new BufferedReader(new InputStreamReader(System.in));
            var count = Integer.parseInt(br.readLine());
            for (var i = 0; i < count; i++) {
                var result = fn.solution(br.readLine());
                if(result != null) {
                    System.out.println(result);
                }
            }
        } catch (IOException e) {
            //
        }
    }

    private static boolean tc1() {
        var fn = new 스택();

        if(fn.solution("push 1") != null) return false;
        if(fn.solution("push 2") != null) return false;
        if(fn.solution("top") != 2) return false;
        if(fn.solution("size") != 2) return false;
        if(fn.solution("empty") != 0) return false;
        if(fn.solution("pop") != 2) return false;
        if(fn.solution("pop") != 1) return false;
        if(fn.solution("pop") != -1) return false;
        if(fn.solution("size") != 0) return false;
        if(fn.solution("empty") != 1) return false;
        if(fn.solution("pop") != -1) return false;
        if(fn.solution("push 3") != null) return false;
        if(fn.solution("empty") != 0) return false;
        if(fn.solution("top") != 3) return false;

        return true;
    }

    private static boolean tc2() {
        var fn = new 스택();

        if(fn.solution("pop") != -1) return false;
        if(fn.solution("top") != -1) return false;
        if(fn.solution("push 123") != null) return false;
        if(fn.solution("top") != 123) return false;
        if(fn.solution("pop") != 123) return false;
        if(fn.solution("top") != -1) return false;
        if(fn.solution("pop") != -1) return false;

        return true;
    }

    private static boolean tc3() {
        var fn = new 스택();

        for (int i = 1; i <= 100; i++) {
            if(fn.solution("push " + i) != null) return false;
        }
        for (int i = 100; i >= 1; i--) {
            if(fn.solution("pop") != i) return false;
        }
        if(fn.solution("top") != -1) return false;
        if(fn.solution("size") != 0) return false;

        return true;
    }

    private static final int DEFAULT_SIZE = 10;

    int index;
    int[] array;

    public 스택() {
        index = 0;
        array = new int[DEFAULT_SIZE];
    }

    public Integer solution(String operation) {
        var split = operation.split(" ");
        var command = split[0];

        switch (command) {
            case "push":
                push(Integer.parseInt(split[1]));
                return null;
            case "pop":
                return pop();
            case "top":
                return top();
            case "size":
                return size();
            case "empty":
                return empty();
        }

        throw new IllegalArgumentException();
    }

    public void push(int number) {
        if(index == array.length) {
            var newArr = new int[array.length + DEFAULT_SIZE];
            System.arraycopy(array, 0, newArr, 0, array.length);
            array = newArr;
        }

        array[index++] = number;
    }

    public int pop() {
        if(index == 0) {
            return -1;
        }

        return array[--index];
    }

    public int top() {
        if(index == 0) {
            return -1;
        }

        return array[index - 1];
    }

    public int size() {
        return index;
    }

    public int empty() {
        return index == 0 ? 1 : 0;
    }
}
