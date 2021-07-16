package treeTopView;

import commons.InputTree;
import commons.Node;
import commons.NodeLevel;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
//        Node root = new InputTree().loadTreeFromStdin();
        Node root = new InputTree().loadTreeFromArray(Arrays.asList(1, 2, 5, 3, 6, 4));
//        Node root = new InputTree().loadTreeFromArray(Arrays.asList(37,23,108,59,86,64,94,14,105,17,111,65,55,31,79,97,78,25,50,22,66,46,104,98,81,90,68,40,103,77,74,18,69,82,41,4,48,83,67,6,2,95,54,100,99,84,34,88,27,72,32,62,9,56,109,115,33,15,91,29,85,114,112,20,26,30,93,96,87,42,38,60,7,73,35,12,10,57,80,13,52,44,16,70,8,39,107,106,63,24,92,45,75,116,5,61,49,101,71,11,53,43,102,110,1,58,36,28,76,47,113,21,89,51,19,3));
//        Node root = new InputTree().loadTreeFromArray(Arrays.asList(1, 14, 3, 7, 4, 5, 15, 6, 13, 10, 11, 2, 12, 8, 9));
//       System.out.println(root == null ? -1 : root.getHeight());
        topView(root);
    }


    public static void topView(Node root) {
        if (root == null) return;

        Queue<NodeLevel> queue = new LinkedList<>();
        Map<Integer, Integer> map = new TreeMap<>();

        queue.add(new NodeLevel(root, 0));

        while (queue.size() > 0) {
            var nodeLevel = queue.poll();
            if (!map.containsKey(nodeLevel.getLevel())) {
                map.put(nodeLevel.getLevel(), nodeLevel.getNode().getData());
            }

            if (nodeLevel.getNode().getLeft() != null) {
                queue.add(new NodeLevel(nodeLevel.getNode().getLeft(), nodeLevel.getLevel() - 1));
            }

            if (nodeLevel.getNode().getRight() != null) {
                queue.add(new NodeLevel(nodeLevel.getNode().getRight(), nodeLevel.getLevel() + 1));
            }
        }

        var output = map.values().stream().map(Object::toString).reduce((v1, v2) -> v1 + " " + v2).orElse("");
        System.out.println(output);
    }

}
