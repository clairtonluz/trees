package tree.swapNodesAlgo;

import commons.Node;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class Result {


    public static List<List<Integer>> swapNodes(List<List<Integer>> indexes, List<Integer> queries) {
        Queue<Node> queue = new LinkedList<>();
        var root = new Node(1, 1);
        queue.add(root);
        indexes.forEach(i -> {
            var node = queue.poll();
            var a = i.get(0);
            var b = i.get(1);

            var left = a == -1 ? null : new Node(a, node.getDepth() + 1);
            var right = b == -1 ? null : new Node(b, node.getDepth() + 1);
            node.setLeft(left);
            node.setRight(right);

            if (left != null) {
                queue.add(left);
            }

            if (right != null) {
                queue.add(right);
            }

        });

        int levels = root.getHeight() + 1;
        return queries.stream().map(q -> {
            int i = q;
            while (levels > i) {
                root.swapDepth(i);
                i = i + q;
            }
            return root.getInOrderTraversal();
        }).collect(Collectors.toList());

    }
}
