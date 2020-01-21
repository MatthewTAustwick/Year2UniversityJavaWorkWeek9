package binaryTree;

/**
 * Implements a node for constructing sorted binary trees.
 *
 * @param <T> the type of value stored in the binary tree.
 *
 * @author Hugh Osborne.
 * @version December 2019.
 */
public class TreeNode<T extends Comparable<? super T>> {
    /**
     * The value stored in this node.
     */
    private T value;
    /**
     * The left subtree of this node.
     */
    private BTree<T> left;
    /**
     * The right subtree of this node.
     */
    private BTree<T> right;

    /**
     * Construct a new singleton tree node.
     * @param value the value to be stored in the node.
     */
    public TreeNode(T value) {
        this.value = value;
        left = new BinaryTree<>();
        right = new BinaryTree<>();
    }

    /**
     * Construct a new tree node with left and right subtrees.
     * @param value the value to be stored in the node.
     * @param left the left subtree.
     * @param right the right subtree.
     */
    public TreeNode(T value,BTree<T> left,BTree<T> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    /**
     * Get this node's value.
     * @return the value held in this node.
     */
    public T getValue() {
        return value;
    }

    /**
     * Change the value held in this node.
     * @param value the new value to be sotred in the node
     */
    public void setValue(T value) {
        this.value = value;
    }

    /**
     * Get the left subtree of this node.
     * @return this node's left subtree.
     */
    public BTree<T> getLeft() {
        return left;
    }

    /**
     * Change the left subtree of this node.
     * @param tree the new left subtree.
     */
    public void setLeft(BTree<T> tree) {
        left = tree;
    }

    /**
     * Get the right subtree of this node.
     * @return this node's right subtree.
     */
    public BTree<T> getRight() {
        return right;
    }

    /**
     * Change the right subtree of this node.
     * @param tree the new right subtree.
     */
    public void setRight(BTree<T> tree) {
        right = tree;
    }

}

