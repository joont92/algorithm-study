package baekjoon.tree;

/**
 * https://www.acmicpc.net/problem/1991
 *
 * 전달받은 문자열에서 'A'를 뺴서 배열의 index 에 저장되도록 처리
 * left, right 에 있는 문자를 전달하고, 문자를 index 바꿔서 다시 배열에서 찾음
 * 출력하는 순서 조정하여 preOrder, inOrder, postOrder 처리
 */
public class 트리_순회 {
    private Node tree[];

    public 트리_순회(int size) {
        this.tree = new Node[size];
    }

    public void add(char current, char left, char right) {
        tree[index(current)] = new Node(current, left, right);
    }

    public void preOrder(char value) {
        if(value == '.') {
            return;
        }

        Node node = tree[index(value)];
        System.out.print(node.value);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder(char value) {
        if(value == '.') {
            return;
        }

        Node node = tree[index(value)];
        inOrder(node.left);
        System.out.print(node.value);
        inOrder(node.right);
    }

    public void postOrder(char value) {
        if(value == '.') {
            return;
        }

        Node node = tree[index(value)];
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value);
    }

    private int index(char value) {
        return value - 'A';
    }

    class Node {
        private char value;

        private char left;
        private char right;

        public Node(char value, char left, char right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}
