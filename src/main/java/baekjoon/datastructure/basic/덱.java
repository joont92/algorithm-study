package baekjoon.datastructure.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://www.acmicpc.net/problem/10866
 */
public class 덱 {
    private static final int DEFAULT_SIZE = 10;

    private List<Integer> history;
    private int begin;
    private int end;
    private int[] array;

    public 덱() {
        array = new int[DEFAULT_SIZE];
        begin = end = 0;

        history = new ArrayList<>();
    }

    public 덱 command(String arg) {
        var split = arg.split(" ");

        switch (split[0]) {
            case "push_front" :
                pushFront(Integer.parseInt(split[1]));
                break;
            case "push_back" :
                pushBack(Integer.parseInt(split[1]));
                break;
            case "pop_front" :
                history.add(popFront());
                break;
            case "pop_back" :
                history.add(popBack());
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
            default:
        }

        return this;
    }

    public int[] result() {
        return history.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public void pushFront(int number) {
        if (size() > 0) {
           var newArray = new int[array.length + 1 - begin];
           System.arraycopy(array, begin, newArray, 1, array.length - begin);
           array = newArray;
           end -= begin;
           begin = 0;
        }

        array[begin] = number;
        end++;
    }

    public void pushBack(int number) {
        if (end == array.length) {
            var newArray = new int[array.length + DEFAULT_SIZE];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
        array[end++] = number;
    }

    public int popFront() {
        if (empty() == 1) {
            return -1;
        }
        return array[begin++];
    }

    public int popBack() {
        if (empty() == 1) {
            return -1;
        }
        return array[--end];
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
                new 덱().command("push_front 1")
                        .command("push_front 2")
                        .command("pop_front")
                        .command("pop_front")
                        .command("pop_front")
                        .command("size")
                        .result(),
                new int[]{2,1,-1,0}));

        System.out.println(Arrays.equals(
                new 덱().command("push_front 1")
                        .command("push_front 2")
                        .command("push_back 3")
                        .command("pop_front")
                        .command("pop_back")
                        .result(),
                new int[]{2,3}));

        System.out.println(Arrays.equals(
                new 덱().command("push_front 1")
                        .command("pop_back")
                        .result(),
                new int[]{1}));

        System.out.println(Arrays.equals(
                new 덱().command("push_back 1")
                        .command("push_back 2")
                        .command("push_back 3")
                        .command("pop_back")
                        .command("pop_back")
                        .command("pop_back")
                        .result(),
                new int[]{3,2,1}));

        System.out.println(Arrays.equals(
                new 덱().command("push_back 1")
                        .command("push_front 0")
                        .command("pop_back")
                        .command("pop_front")
                        .result(),
                new int[]{1,0}));

        System.out.println(Arrays.equals(
                new 덱().command("push_back 1")
                        .command("push_front 2")
                        .command("front")
                        .command("back")
                        .command("size")
                        .command("empty")
                        .command("pop_front")
                        .command("pop_back")
                        .command("pop_front")
                        .command("size")
                        .command("empty")
                        .command("pop_back")
                        .command("push_front 3")
                        .command("empty")
                        .command("front")
                        .result(),
                new int[]{2,1,2,0,2,1,-1,0,1,-1,0,3}));

        System.out.println(Arrays.equals(
                new 덱().command("front")
                        .command("back")
                        .command("pop_front")
                        .command("pop_back")
                        .command("push_front 1")
                        .command("front")
                        .command("pop_back")
                        .command("push_back 2")
                        .command("back")
                        .command("pop_front")
                        .command("push_front 10")
                        .command("push_front 333")
                        .command("front")
                        .command("back")
                        .command("pop_back")
                        .command("pop_back")
                        .command("push_back 20")
                        .command("push_back 1234")
                        .command("front")
                        .command("back")
                        .command("pop_back")
                        .command("pop_back")
                        .result(),
                new int[]{-1,-1,-1,-1,1,1,2,2,333,10,10,333,20,1234,1234,20}));
    }

    private static void basic() {
        var fn = new 덱();

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
