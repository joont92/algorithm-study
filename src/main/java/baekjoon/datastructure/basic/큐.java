package baekjoon.datastructure.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://www.acmicpc.net/problem/10845
 */
public class 큐 {
    private final static int DEFAULT_SIZE = 10;

    private List<Integer> history;
    private int begin;
    private int end;
    private int[] array;

    public 큐() {
        begin = 0;
        end = 0;
        array = new int[DEFAULT_SIZE];

        history = new ArrayList<>();
    }

    public 큐 command(String arg) {
        var split = arg.split(" ");

        switch (split[0]) {
            case "push" :
                push(Integer.parseInt(split[1]));
                break;
            case "pop" :
                history.add(pop());
                break;
            case "size" :
                history.add(size());
                break;
            case "empty" :
                history.add(empty());
                break;
            case "front" :
                history.add(front());
                break;
            case "back" :
                history.add(back());
                break;
            default:
                throw new IllegalArgumentException();
        }

        return this;
    }

    public int[] result() {
        return history.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public void push(int number) {
        if(end == array.length) {
            var newArray = new int[array.length + DEFAULT_SIZE];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }

        array[end++] = number;
    }

    public int pop() {
        if(empty() == 1) {
            return -1;
        }
        return array[begin++];
    }

    public int size() {
        return end - begin;
    }

    public int empty() {
        return size() == 0 ? 1 : 0;
    }

    public int front() {
        if (empty() == 1) {
            return -1;
        }
        return array[begin];
    }

    public int back() {
        if (empty() == 1) {
            return -1;
        }
        return array[end - 1];
    }

    public static void main(String[] args) {
        basic();
        System.out.println(Arrays.equals(
                new 큐().command("push 1")
                        .command("push 2")
                        .command("push 3")
                        .command("pop")
                        .command("pop")
                        .command("pop")
                        .result(),
                new int[]{1,2,3}));

        System.out.println(Arrays.equals(
                new 큐().command("push 1")
                        .command("push 2")
                        .command("push 3")
                        .command("front")
                        .command("back")
                        .command("pop")
                        .command("front")
                        .result(),
                new int[]{1,3,1,2}));

        System.out.println(Arrays.equals(
                new 큐().command("front")
                        .command("back")
                        .result(),
                new int[]{-1, -1}));

        System.out.println(Arrays.equals(
                new 큐().command("pop")
                        .result(),
                new int[]{-1}));

        System.out.println(Arrays.equals(
                new 큐().command("push 1").command("push 2").command("push 3").command("push 4")
                        .command("push 5").command("push 6").command("push 7").command("push 8")
                        .command("push 9").command("push 10").command("push 11")
                        .command("size")
                        .result(),
                new int[]{11}));

        System.out.println(Arrays.equals(
                new 큐().command("push 1")
                        .command("push 2")
                        .command("front")
                        .command("back")
                        .command("size")
                        .command("empty")
                        .command("pop")
                        .command("pop")
                        .command("pop")
                        .command("size")
                        .command("empty")
                        .command("pop")
                        .command("push 3")
                        .command("empty")
                        .command("front")
                        .result(),
                new int[]{1,2,2,0,1,2,-1,0,1,-1,0,3}));
    }

    private static void basic() {
        var fn = new 큐();

        try {
            var br = new BufferedReader(new InputStreamReader(System.in));
            var count = Integer.parseInt(br.readLine());
            for (var i = 0; i < count; i++) {
                fn.command(br.readLine());
            }
            Arrays.stream(fn.result())
                    .forEach(System.out::println);
        } catch (IOException e) {
            //
        }
    }
}
