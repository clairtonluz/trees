package commons;

public class NodeLevel {
    private final Node node;
    private final int level;

    public NodeLevel(Node node, int level) {
        this.node = node;
        this.level = level;
    }

    public Node getNode() {
        return node;
    }

    public int getLevel() {
        return level;
    }
}

