package binaryTree;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

    @Test
    void testEmptyTree() throws EmptyTreeException{
        BinaryTree<Integer> bt = new BinaryTree<>();
        assertFalse(bt.isEmpty());
    }

    @Test
    void testTreeOfSize3Traverse() throws EmptyTreeException{
        BinaryTree<Integer> bt = new BinaryTree<>(20,new BinaryTree<>(10), new BinaryTree<>(25));
        Integer testArray[] = {20,10,25};
        bt.traverse();
        assertEquals(testArray, bt.traversalList);
    }
}