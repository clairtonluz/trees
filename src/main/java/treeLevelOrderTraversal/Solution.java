package treeLevelOrderTraversal;

import commons.InputTree;
import commons.Node;

import java.util.*;

public class Solution {
    private static final InputTree INPUT_TREE = new InputTree();

    public static void main(String[] args) {
//        Node root = new InputTree().loadTreeFromStdin();
        Node root = new InputTree().loadTreeFromArray(Arrays.asList(1, 2, 5, 3, 6, 4));
        levelOrder(root);
    }

    public static void levelOrder(Node root) {
        if (root == null) return;

        Queue<Node> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        queue.add(root);

        while (queue.size() > 0) {
            var node = queue.poll();

            list.add(node.getData());

            if (node.getLeft() != null) {
                queue.add(node.getLeft());
            }

            if (node.getRight() != null) {
                queue.add(node.getRight());
            }

        }

        var output = list.stream().map(Object::toString).reduce((v1, v2) -> v1 + " " + v2).orElse("");
        System.out.println(output);
    }

}
