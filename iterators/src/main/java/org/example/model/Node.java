package org.example.model;


public class Node implements Comparable<Node> {
    private int iterNumber = -1;
    private float value = 0;

    public Node(int iterNumber, float value) {
        this.iterNumber = iterNumber;
        this.value = value;
    }

    @Override
    public int compareTo(Node o) {
        if (o != null) {
            return Float.compare(this.value, o.value);
        }

        return -1;
    }

    public int getIterNumber() {
        return iterNumber;
    }

    public float getValue() {
        return value;
    }
}
