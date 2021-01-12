package baekjoon.datastructure.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/10828
 */
public class 스택 {
    public static void main(String[] args) {
//        basic();
        System.out.println(tc1());
        System.out.println(tc2());
        System.out.println(tc3());
    }

    private static final int DEFAULT_SIZE = 10;

    int index;
    int[] array;

    public 스택() {
        index = 0;
        array = new int[DEFAULT_SIZE];
    }

    public Integer command(String arg) {
        var split = arg.split(" ");
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

    private static void basic() {
        var fn = new 스택();

        try {
            var br = new BufferedReader(new InputStreamReader(System.in));
            var count = Integer.parseInt(br.readLine());
            for (var i = 0; i < count; i++) {
                var result = fn.command(br.readLine());
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

        if(fn.command("push 1") != null) return false;
        if(fn.command("push 2") != null) return false;
        if(fn.command("top") != 2) return false;
        if(fn.command("size") != 2) return false;
        if(fn.command("empty") != 0) return false;
        if(fn.command("pop") != 2) return false;
        if(fn.command("pop") != 1) return false;
        if(fn.command("pop") != -1) return false;
        if(fn.command("size") != 0) return false;
        if(fn.command("empty") != 1) return false;
        if(fn.command("pop") != -1) return false;
        if(fn.command("push 3") != null) return false;
        if(fn.command("empty") != 0) return false;
        if(fn.command("top") != 3) return false;

        return true;
    }

    private static boolean tc2() {
        var fn = new 스택();

        if(fn.command("pop") != -1) return false;
        if(fn.command("top") != -1) return false;
        if(fn.command("push 123") != null) return false;
        if(fn.command("top") != 123) return false;
        if(fn.command("pop") != 123) return false;
        if(fn.command("top") != -1) return false;
        if(fn.command("pop") != -1) return false;

        return true;
    }

    private static boolean tc3() {
        var fn = new 스택();

        for (int i = 1; i <= 100; i++) {
            if(fn.command("push " + i) != null) return false;
        }
        for (int i = 100; i >= 1; i--) {
            if(fn.command("pop") != i) return false;
        }
        if(fn.command("top") != -1) return false;
        if(fn.command("size") != 0) return false;

        return true;
    }
}
