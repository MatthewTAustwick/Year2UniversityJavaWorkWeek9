package binaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * A partial implementation of sorted binary trees.
 * <p>
 * The three constructors (construct an empty tree ({@link #BinaryTree()}, or a tree with a root value but no subtrees
 * ({@link #BinaryTree(Comparable)}, or a tree with a root value and left and right subtrees
 * ({@link #BinaryTree(Comparable, BinaryTree, BinaryTree)}), as well as the {@link #isEmpty()} method are already implemented.
 * <p>
 * For the remaining methods specified in the {@link BTree} interface ({@link #insert(Comparable)}, {@link #getValue()},
 * {@link #setValue(Comparable)}, {@link #getLeft()}, {@link #setLeft(BTree)}, {@link #getRight()}, {@link #setRight(BTree)},
 * {@link #contains(Comparable)}, and {@link #traverse()}) only a "stub" is provided.  For the logbook exercise you
 * should implement these methods.
 * <p>
 * Don't forget to test your implementation!
 *
 * @param <T> the type of value stored in the tree.
 *
 * @author Hugh Osborne.
 * @version December 2019.
 */
public class BinaryTree<T extends Comparable<? super T>> implements BTree<T> {
    /**
     * The root node of this tree.
     */
    private TreeNode<T> root;
    ArrayList<T> traversalList = new ArrayList<>(); //A simple ArrayList which is used to store the values of the nodes
                                                    //which the tree traverses on its way through.


    /**
     * Construct an empty tree.
     */
    public BinaryTree() {
        root = null;
    }

    /**
     * Construct a singleton tree.
     * A singleton tree contains a value in the root, but the left and right subtrees are
     * empty.
     * @param value the value to be stored in the tree.
     */
    public BinaryTree(T value) {
        root = new TreeNode<>(value);
    }

    /**
     * Construct a tree with a root value, and left and right subtrees.
     * @param value the value to be stored in the root of the tree.
     * @param left the tree's left subtree.
     * @param right the tree's right subtree.
     */
    public BinaryTree(T value,BinaryTree<T> left,BinaryTree<T> right) {
        root = new TreeNode<>(value,left,right);
    }

    /**
     * Check if the tree is empty.
     * @return true iff the tree is empty.
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Insert a new value in the binary tree at a position determined by the current contents
     * of the tree, and by the ordering on the type T.
     * @param value the value to be inserted into the tree.
     */
    public void insert(T value) throws EmptyTreeException {
        if (isEmpty()){
            root = new TreeNode<T>(value); //If the tree is empty, then the tree sets the value as the root node (with its appropriate value).
        }
        else if (value.compareTo(getValue()) < 0){ //If the value is less than the current value the code is looking at, insert it to the left
            getLeft().insert(value);
        }
        else{
            getRight().insert(value); //Otherwise just insert it to the right instead.
        }
    }

    /**
     * Get the value stored at the root of the tree.
     * @return the value stored at the root of the tree.
     */
    public T getValue() throws EmptyTreeException {
        if (isEmpty()){
            throw new EmptyTreeException("The tree you are trying to access is currently empty"); //If you try to get the value of an empty tree, then the code just says that you cannot do that as it could cause possible issues.
        }
        return root.getValue();
        // Note: it might make sense to define getValue() to throw a (custom) exception if an attempt
        // is made to access a value from an empty tree.
        // However, since a tree is empty iff its root node is null, it is also acceptable to rely
        // on Java's NullPointerException.
        // This comment also applies to the other get and set methods defined in this interface.

        // placeholder return value below - replace with implementation of getValue()
    }

    /**
     * Change the value stored at the root of the tree.
     * @param value the new value to be stored at the root of the tree.
     */
    public void setValue(T value) {
        root.setValue(value);
    }

    /**
     * Get the left subtree of this tree.
     * @return  This tree's left subtree.
     */
    public BTree<T> getLeft() {
        return root.getLeft();
    }

    /**
     * Change the left subtree of this tree.
     * @param tree the new left subtree.
     */
    public void setLeft(BTree<T> tree) {
        root.setLeft(tree);
    }

    /**
     * Get the right subtree of this tree.
     * @return this tree's right subtree.
     */
    public BTree<T> getRight() {
        return root.getRight();
    }

    /**
     * Change the right subtree of this tree.
     * @param tree the new right subtree.
     */
    public void setRight(BTree<T> tree) {
        root.setRight(tree);
    }

    /**
     * Check if the tree contains a given value.
     * @param value the value to be checked.
     * @return true iff the value is in the tree.
     */
    public boolean contains(T value) {
        if (!isEmpty()){ //The below code only happens if the tree is empty.
            if (root.getValue().equals(value)) return true; //If the value is in the node, return true
            else if (getLeft().contains(value)) return true; //If the value is somewhere in the left tree, return true
            else if (getRight().contains(value)) return true; //If the value is somehwere in the right tree, return true
        }
        return false;
    }

    /**
     * Traverse the tree, producing a list of all the values contained in the tree.
     * @return a list of all the values in the tree.
     */
    public List<T> traverse() throws EmptyTreeException {

        if(!isEmpty()){ //If the tree isn't empty
            traversalList.add(root.getValue()); //Add the route to the traversal list
            traversalList.addAll(root.getLeft().traverse()); //Add all of the left subtrees to the traversal list
            traversalList.addAll(root.getRight().traverse()); //Add all the right subtrees to the traversal list
        }
        return traversalList;
    }

    public static void main(String[] args) throws EmptyTreeException { //Basic code to test if it works or not.
        BinaryTree<Integer> btree = new BinaryTree<>(2,new BinaryTree<>(1), new BinaryTree<>(3)); //Creates a new binary tree with a root value of 2, a left binary tree with a root value of 1 and a right binary tree with a root value of 3
        btree.getLeft().setLeft(new BinaryTree<>(0)); //Creates a new left subtree to the root's left subtree with a root value of 0
        btree.getRight().setRight(new BinaryTree<>(4)); //Creates a new right subtree to the root's right subtree with a root value of 4
        System.out.println(btree.traverse());
        System.out.println(btree.contains(0));
        System.out.println(btree.contains(5));
    }
}

