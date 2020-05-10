package fastcampus.datastructure;

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
                Node left = leftOpt.get();
                Node right = rightOpt.get();

                // 왼쪽에서 가장 큰 값 or 오른쪽에서 가장 작은 값 : 무엇을 선택하든 관계없다
                Node node = current.rightNearestNode();
                current.replace(node);

                if(node.right().isPresent()) {
                    right.left = node.right().get();
                }

                node.left = left;
                if(node != right) {
                    node.right = right;
                }
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
            if(node.parentFrom == Direction.LEFT) {
                node.parent.left = null;
            } else if(node.parentFrom == Direction.RIGHT) {
                node.parent.right = null;
            }

            node.parent = this.parent;
            node.parentFrom = this.parentFrom;
            if(this.parentFrom == Direction.LEFT) {
                this.parent.left = node;
            } else {
                this.parent.right = node;
            }
        }

        public Node rightNearestNode() {
            if(!this.right().isPresent()) {
                throw new IllegalStateException("this node doesn't have right node anymore");
            }

            Node current = this.right().get();
            while (current.left().isPresent()) {
                current = current.left().get();
            }

            return current;
        }
    }

    private enum Direction {
        LEFT, RIGHT
    }
}
