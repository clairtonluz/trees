package commons;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private final int data;
    private Node left;
    private Node right;
    private int depth;

    public Node(int data) {
        this.data = data;
    }

    public Node(int data, int depth) {
        this.data = data;
        this.depth = depth;
    }

    public void add(Node node) {
        if (node.data < data) {
            if (left == null) {
                left = node;
            } else {
                left.add(node);
            }
        } else {
            if (right == null) {
                right = node;
            } else {
                right.add(node);
            }
        }
    }

    public int getHeight() {
        int leftHeight = 0;
        int rightHeight = 0;
        if (left != null) {
            leftHeight = 1 + left.getHeight();
        }

        if (right != null) {
            rightHeight = 1 + right.getHeight();
        }

        return Math.max(leftHeight, rightHeight);
    }

    public void swapDepth(int depth) {
        if (this.depth == depth) {
            var temp = left;
            left = right;
            right = temp;
        } else {
            if (left != null) left.swapDepth(depth);
            if (right != null) right.swapDepth(depth);
        }
    }

    public int getData() {
        return data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public int getDepth() {
        return depth;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public List<Integer> getInOrderTraversal() {
        var values = new ArrayList<Integer>();

        if (left != null) {
            values.addAll(left.getInOrderTraversal());
        }
        values.add(data);
        if (right != null) {
            values.addAll(right.getInOrderTraversal());
        }

        return values;
    }
}
