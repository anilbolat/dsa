package org.example.model;

import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class MyIterator implements Iterator<Node> {

    private final List<Iterator<Float>> listFloatIter;

    private final TreeSet<Node> treeSetNode;

    public MyIterator(List<Iterator<Float>> listFloatIter) {
        this.treeSetNode = new TreeSet<>();
        this.listFloatIter = listFloatIter;
        fillTreeWithFirstElements();
    }

    @Override
    public boolean hasNext() {
        return !this.treeSetNode.isEmpty();
    }

    @Override
    public Node next() {
        Node minNode = this.treeSetNode.pollFirst();
        fillTree(minNode);

        return minNode;
    }

    private void fillTree(Node minNode) {
        if (minNode != null) {
            if (this.treeSetNode.size() < this.listFloatIter.size()) {
                fillTreeWithFirstElements();
            } else {
                fillTreeWithNextElement(minNode);
            }
        }
    }

    private void fillTreeWithFirstElements() {
        for (int i = 0; i < this.listFloatIter.size(); i++) {
            Iterator<Float> iter = this.listFloatIter.get(i);
            if (iter.hasNext()) {
                Node node = new Node(i, iter.next());
                this.treeSetNode.add(node);
            }
        }
    }

    private void fillTreeWithNextElement(Node minNode) {
        int iterNumber = minNode.getIterNumber();
        Iterator<Float> iter = this.listFloatIter.get(iterNumber);
        if (iter.hasNext()) {
            float value = iter.next();
            this.treeSetNode.add(new Node(iterNumber, value));
        }
    }

}