package baekjoon.datastructure.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * https://www.acmicpc.net/problem/1406
 *
 * 커서를 기준으로 왼쪽, 오른쪽 2개 스택을 관리한다
 *  스택을 2개 이어붙이는데, 왼쪽은 정방향, 오른쪽은 반대방향으로 이어 붙인
 *
 *  커서가 왼쪽으로 움직이면 왼쪽 스택에서 오른쪽 스택으로 값을 옮긴다 push(pop)
 *  커서가 오른쪽으로 움직이면 오른쪽 스택에서 왼쪽 스택으로 값을 옮긴다 push(pop)
 */
public class 에디터 {
    public static void main(String[] args) {
//        basic();
        System.out.println(tc1());
        System.out.println(tc2());
        System.out.println(tc3());
    }

    private Stack<Character> leftStack;
    private Stack<Character> rightStack;

    public 에디터(String init) {
        this.leftStack = new Stack<>();
        this.rightStack = new Stack<>();

        init.chars()
                .mapToObj(i -> (char) i)
                .forEach(leftStack::add);
    }

    public 에디터 command(String arg) {
        var split = arg.split(" ");
        switch (split[0]) {
            case "P" :
                insert(split[1].charAt(0));
                break;
            case "B" :
                delete();
                break;
            case "L" :
                left();
                break;
            case "D" :
                right();
                break;
            default:
                throw new IllegalArgumentException();
        }

        return this;
    }

    public void insert(char value) {
        leftStack.push(value);
    }

    public void delete() {
        if(leftStack.isEmpty()) {
            return;
        }
        leftStack.pop();
    }

    public void left() {
        if(leftStack.isEmpty()) {
            return;
        }
        rightStack.push(leftStack.pop());
    }

    public void right() {
        if(rightStack.isEmpty()) {
            return;
        }
        leftStack.push(rightStack.pop());
    }

    public String result() {
        var leftStream = leftStack.stream();
        var rightStream = IntStream.range(0, rightStack.size())
                .mapToObj(i -> rightStack.get(rightStack.size() - i - 1));

        return Stream.concat(leftStream, rightStream)
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    private static void basic() {

        try {
            var br = new BufferedReader(new InputStreamReader(System.in));

            var fn = new 에디터(br.readLine());
            var count = Integer.parseInt(br.readLine());
            for (var i = 0; i < count; i++) {
                fn.command(br.readLine());
            }
            System.out.println(fn.result());
        } catch (IOException e) {
            //
        }
    }

    private static boolean tc1() {
        if(!new 에디터("abcd").command("P e").command("P f")
                .result().equals("abcdef")) return false;
        if(!new 에디터("abcd").command("B").command("B")
                .result().equals("ab")) return false;
        if(!new 에디터("abcd").command("L").command("L").command("B")
                .result().equals("acd")) return false;
        if(!new 에디터("abcd").command("L").command("L").command("D").command("B")
                .result().equals("abd")) return false;

        return true;
    }

    private static boolean tc2() {
        if(!new 에디터("").command("P a")
                .result().equals("a")) return false;
        if(!new 에디터("a").command("B").command("B")
                .result().equals("")) return false;

        return true;
    }

    private static boolean tc3() {
        if(!new 에디터("abcd").command("P x").command("L").command("P y")
                .result().equals("abcdyx")) return false;
        if(!new 에디터("abc").command("L").command("L").command("L").command("L")
                .command("L").command("P x").command("L").command("B").command("P y")
                .result().equals("yxabc")) return false;
        if(!new 에디터("dmih").command("B").command("B").command("P x").command("L")
                .command("B").command("B").command("B").command("P y").command("D")
                .command("D").command("P z")
                .result().equals("yxz")) return false;

        return true;
    }
}
