package binaryTree;

import java.util.List;

/**
 * A minimum interface for sorted binary trees.
 *
 * @param <T> the type of value stored in the tree.
 *
 * @author Hugh Osborne.
 * @version December 2019.
 */
public interface BTree<T extends Comparable<? super T>> {

    /**
     * Check if the tree is empty.
     * @return true iff the tree is empty.
     */
    boolean isEmpty();

    /**
     * Insert a new value in the binary tree at a position determined by the current contents
     * of the tree, and by the ordering on the type T.
     * @param value the value to be inserted into the tree.
     */
    void insert(T value) throws EmptyTreeException;

    /**
     * Get the value stored at the root of the tree.
     * @return the value stored at the root of the tree.
     */
    T getValue() throws EmptyTreeException;
    // Note: it might make sense to define getValue() to throw a (custom) exception if an attempt
    // is made to access a value from an empty tree.
    // However, since a tree is empty iff its root node is null, it is also acceptable to rely
    // on Java's NullPointerException.
    // This comment also applies to the other get and set methods defined in this interface.

    /**
     * Change the value stored at the root of the tree.
     * @param value the new value to be stored at the root of the tree.
     */
    void setValue(T value);

    /**
     * Get the left subtree of this tree.
     * @return  This tree's left subtree.
     */
    BTree<T> getLeft();

    /**
     * Change the left subtree of this tree.
     * @param tree the new left subtree.
     */
    void setLeft(BTree<T> tree);

    /**
     * Get the right subtree of this tree.
     * @return this tree's right subtree.
     */
    BTree<T> getRight();

    /**
     * Change the right subtree of this tree.
     * @param tree the new right subtree.
     */
    void setRight(BTree<T> tree);

    /**
     * Check if the tree contains a given value.
     * @param value the value to be checked.
     * @return true iff the value is in the tree.
     */
    boolean contains(T value);

    /**
     * Traverse the tree, producing a list of all the values contained in the tree.
     * @return a list of all the values in the tree.
     */
    List<T> traverse() throws EmptyTreeException;
}

