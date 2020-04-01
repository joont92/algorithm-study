package datastructure;

import java.util.Optional;

public class 이진트리 {
    private Node head;

    public 이진트리(Integer value) {
        this.head = new Node(value);
    }

    public boolean insert(Integer value) {
        Node current = head;

        while (true) {
            if(current.compare(value) == -1) {
                Optional<Node> opt = current.left();
                if(opt.isPresent()) {
                    current = opt.get();
                } else {
                    current.initLeft(value);
                    return true;
                }
            } else if (current.compare(value) == 1) {
                Optional<Node> opt = current.right();
                if(opt.isPresent()) {
                    current = opt.get();
                } else {
                    current.initRight(value);
                    return true;
                }
            } else {
                return false;
            }
        }
    }

    /**
     * @param value
     * @return 몇 번 만에 찾았는지
     */
    public int exist(Integer value) {
        Node current = head;
        int count = 0;

        int result;
        while((result = current.compare(value)) != 0) {
            if(result == -1) {
                Optional<Node> left = current.left();
                if(!left.isPresent()) {
                    return -1;
                }
                current = left.get();
            } else if(result == 1) {
                Optional<Node> right = current.right();
                if(!right.isPresent()) {
                    return -1;
                }
                current = right.get();
            }
            count++;
        }

        return count;
    }

    public boolean delete(Integer value) {
        Node current = head;

        while(true) {
            if(current.compare(value) == 0) {
                break;
            } else if(current.compare(value) == -1) {
                Optional<Node> opt = current.left();
                if(!opt.isPresent()) {
                    return false;
                }
                current = opt.get();
            } else if(current.compare(value) == 1) {
                Optional<Node> opt = current.right();
                if(!opt.isPresent()) {
                    return false;
                }
                current = opt.get();
            }
        }

        if(current.isLeaf()) {
            current.orphan();
        } else {
            Optional<Node> leftOpt = current.left();
            Optional<Node> rightOpt = current.right();

            if(leftOpt.isPresent() && !rightOpt.isPresent()) {
                current.replace(leftOpt.get());
            } else if(!leftOpt.isPresent() && rightOpt.isPresent()) {
                current.replace(rightOpt.get());
            } else {
                // 왼쪽에서 가장 큰 값 or 오른쪽에서 가장 작은 값

            }
        }

        return true;
    }

    private class Node {
        private Integer value;
        private Node left;
        private Node right;

        private Node parent;
        private Direction parentFrom;

        public Node(Integer value) {
            this.value = value;
        }

        public int compare(Integer value) {
            return Integer.compare(value, this.value);
        }

        // 모든 노드의 부모 세팅을 보장하지 못함
        // 이 함수를 호출한 객체만 부모세팅을 보장함
        // 애초에 left, right 넣을 떄 하면 되지 않는가?
        public void initParent(Node node, Direction from) {
            this.parent = node;
            this.parentFrom = from;
        }

        public Optional<Node> left() {
            return Optional.ofNullable(left);
        }

        public void initLeft(Integer value) {
            Node node = new Node(value);
            node.parent = this;
            node.parentFrom = Direction.LEFT;
            this.left = node;
        }

        public Optional<Node> right() {
            return Optional.ofNullable(right);
        }

        public void initRight(Integer value) {
            Node node = new Node(value);
            node.parent = this;
            node.parentFrom = Direction.RIGHT;
            this.right = node;
        }

        public boolean isLeaf() {
            return left == null && right == null;
        }

        public void orphan() {
            if(this.parentFrom == Direction.LEFT) {
                this.parent.left = null;
            } else {
                this.parent.right = null;
            }

            this.parent = null;
            this.parentFrom = null;
        }

        public void replace(Node node) {
            node.parent = null;
            node.parentFrom = null;
            if(this.parentFrom == Direction.LEFT) {
                this.parent.left = node;
            } else {
                this.parent.right = node;
            }
        }
    }

    private enum Direction {
        LEFT, RIGHT
    }
}
