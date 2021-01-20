package baekjoon.datastructure.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://www.acmicpc.net/problem/10828
 */
public class 스택 {
    private static final int DEFAULT_SIZE = 10;

    private List<Integer> history;
    private int index;
    private int[] array;

    public 스택() {
        index = 0;
        array = new int[DEFAULT_SIZE];

        history = new ArrayList<>();
    }

    public 스택 command(String arg) {
        var split = arg.split(" ");
        var command = split[0];

        switch (command) {
            case "push":
                push(Integer.parseInt(split[1]));
                break;
            case "pop":
                history.add(pop());
                break;
            case "top":
                history.add(top());
                break;
            case "size":
                history.add(size());
                break;
            case "empty":
                history.add(empty());
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

    public static void main(String[] args) {
//        basic();

        var tc1 = new 스택();
        System.out.println(Arrays.equals(
                tc1.command("push 1")
                        .command("push 2")
                        .command("top")
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
                        .command("top")
                        .result(),
                new int[]{2,2,0,2,1,-1,0,1,-1,0,3})
        );

        var tc2 = new 스택();
        System.out.println(Arrays.equals(
                tc2.command("pop")
                        .command("top")
                        .command("push 123")
                        .command("top")
                        .command("pop")
                        .command("top")
                        .command("pop")
                        .result(),
                new int[]{-1,-1,123,123,-1,-1})
        );

        var tc3 = new 스택();
        var expected = new ArrayList<Integer>();
        for (int i = 1; i <= 100; i++) {
            tc3.command("push " + i);
        }
        for (int i = 100; i >= 1; i--) {
            tc3.command("pop");
            expected.add(i);
        }
        tc3.command("top");
        expected.add(-1);
        tc3.command("size");
        expected.add(0);
        System.out.println(Arrays.equals(
                tc3.result(), expected.stream()
                        .mapToInt(Integer::intValue)
                        .toArray()));
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
}
