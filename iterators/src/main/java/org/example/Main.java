package org.example;

import org.example.model.MyIterator;
import org.example.model.Node;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Float> list1 = Arrays.asList(1F, 3F, 4F, 7F, 111F, 1234F);
        List<Float> list2 = Arrays.asList(2F, 4F, 5F, 6F, 222F);

        List<Float> list3 = Arrays.asList(0.01F, 0.02F, 0.03F, 0.04F, 123F);

        MyIterator myIter = new MyIterator(Arrays.asList(list1.iterator(), list2.iterator(), list3.iterator()));
        while (myIter.hasNext()) {
            Node node = myIter.next();
            System.out.println(node.getValue());
        }

    }
}