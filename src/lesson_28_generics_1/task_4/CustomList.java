package lesson_28_generics_1.task_4;

public class CustomList<T> {
    private Node<T> rootNode;

    void add(T value) {
        if (rootNode == null) {
            rootNode = new Node<>(value);
        } else {
            getLast(rootNode).setNextNode(new Node<>(value));
        }
    }

    public void delete(T value) {
        Node<T> delNode = findNodeByValue(value, rootNode);
        Node<T> prevNode = getPreviousNode(rootNode, delNode);
        Node<T> nextNode = delNode.getNextNode();

        prevNode.setNextNode(nextNode);
    }

    public int size() {
        if (rootNode == null) {
            return 0;
        }
        return getDepth(rootNode, 1);
    }

    public T find(T value) {
        if (rootNode == null) {
            throw new RuntimeException("List is empty");
        }
        return findNodeByValue(value, rootNode).getValue();
    }

    @Override
    public String toString() {
        if (rootNode == null) {
            return "[...]";
        }
        return String.format("[%s]", makeString(rootNode));
    }

    private Node<T> getLast(Node<T> root) {
        if (root.getNextNode() == null) {
            return root;
        }
        return getLast(root.getNextNode());
    }

    private int getDepth(Node<T> root, int depth) {
        if (root.isLast()) {
            return depth;
        }
        return getDepth(root.getNextNode(), depth + 1);
    }

    private Node<T> findNodeByValue(T value, Node<T> root) {
        if (root.getValue() == value) {
            return root;
        }
        if (root.isLast()) {
            throw new RuntimeException("Value not exist");
        }
        return findNodeByValue(value, root.getNextNode());
    }

    private Node<T> getPreviousNode(Node<T> node, Node<T> targetNode) {
        if (node.getNextNode().equals(targetNode)) {
            return node;
        }
        return getPreviousNode(node.getNextNode(), targetNode);
    }

    private String makeString(Node<T> root) {
        if (root.isLast()) {
            return root.value.toString();
        }
        return String.format("%s, %s", root.value.toString(), makeString(root.nextNode));
    }

    private static class Node<T> {
        private final T value;
        private Node<T> nextNode;

        private Node(T value) {
            this.value = value;
        }

        private T getValue() {
            return value;
        }

        private Node<T> getNextNode() {
            return nextNode;
        }

        private void setNextNode(Node<T> nextNode) {
            this.nextNode = nextNode;
        }

        private boolean isLast() {
            return nextNode == null;
        }
    }
}
