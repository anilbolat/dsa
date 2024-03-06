package org.example;

import org.example.model.MyIterator;
import org.example.model.Node;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    
    @Test
    public void test() {
        List<Float> expectedList = Arrays.asList(
                0.01F, 0.02F, 0.03F, 0.04F,
                1F, 2F, 3F, 4F, 5F, 6F, 7F, 111F, 123F, 222F, 1234F);
        List<Float> actualList = new ArrayList<>();
        
        List<Float> list1 = Arrays.asList(1F, 3F, 4F, 7F, 111F, 1234F);
        List<Float> list2 = Arrays.asList(2F, 4F, 5F, 6F, 222F);

        List<Float> list3 = Arrays.asList(0.01F, 0.02F, 0.03F, 0.04F, 123F);

        MyIterator myIter = new MyIterator(Arrays.asList(list1.iterator(), list2.iterator(), list3.iterator()));
        while (myIter.hasNext()) {
            Node node = myIter.next();
            actualList.add(node.getValue());
        }
        System.out.println(expectedList);
        System.out.println(actualList);
        assertArrayEquals(expectedList.toArray(), actualList.toArray());
    }

}