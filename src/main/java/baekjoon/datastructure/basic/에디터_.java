package baekjoon.datastructure.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * https://www.acmicpc.net/problem/1406
 *
 * 커서를 기준으로 왼쪽, 오른쪽 2개 스택을 관리한다
 * 스택을 2개 이어붙이는데, 왼쪽은 정방향, 오른쪽은 반대방향으로 이어 붙인
 *
 * 커서가 왼쪽으로 움직이면 왼쪽 스택에서 오른쪽 스택으로 값을 옮긴다 push(pop)
 * 커서가 오른쪽으로 움직이면 오른쪽 스택에서 왼쪽 스택으로 값을 옮긴다 push(pop)
 */
public class 에디터_ {
    private Stack<String> left = new Stack<>();
    private Stack<String> right = new Stack<>();

    public 에디터_(String init) {
        Arrays.stream(init.split(""))
                .forEach(left::push);
    }

    public void command(String arg) {
        String[] args = arg.split(" ");
        switch (args[0]) {
            case "L" :
                if(!left.isEmpty()) {
                    right.push(left.pop());
                }
                break;
            case "D" :
                if(!right.isEmpty()) {
                    left.push(right.pop());
                }
                break;
            case "B" :
                if(!left.isEmpty()) {
                    left.pop();
                }
                break;
            case "P" :
                left.push(args[1]);
        }
    }

    public String print() {
        Stream<String> rightReversedStream = IntStream.range(0, right.size())
                .boxed()
                .sorted(Collections.reverseOrder())
                .map(right::get);

        return Stream.concat(left.stream(), rightReversedStream).collect(Collectors.joining());
    }
}
