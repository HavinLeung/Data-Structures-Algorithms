import com.sun.nio.sctp.IllegalUnbindException;

/**
 * Created by havinleung on 2018-01-08.
 */
public class MyBST<T extends Comparable<T>> {

    private Node root;
    private int size;

    public MyBST(){
        this.root = null;
        size = 0;
    }

    public MyBST(T root) {
        this.root = new Node(root);
        size = 1;
    }

    /**
     * Checks whether the BST contains the data
     *
     * @return true if the data is in the tree
     */
    public boolean contains(T data) {
        return contains(root, data);
    }

    /**
     * Private recursive function to traverse the tree to find the data
     *
     * @return true if the data is in the tree
     */
    private boolean contains(Node node, T data) {
        if (node == null) {
            return false;
        }
        int compare = data.compareTo(node.data);
        if (compare == 0) {
            return true;
        } else if (compare > 0) {
            return contains(node.right, data);
        } else {
            return contains(node.left, data);
        }
    }

    /**
     * Deletes the data if it is in the tree
     *
     * @return true if the data has been removed
     */
    public void remove(T data) {
        remove(root, data);
    }

    /**
     * Recursively searches the tree for the data. If found, it will be deleted (Hibbard delete).
     *
     * @return true if the data has been removed
     */
    private Node remove(Node node, T data) {
        if (node == null) {
            return null;
        }
        int compare = data.compareTo(node.data);
        if (compare > 0) {
            node.right = remove(node.right, data);
        } else if (compare < 0) {
            node.left = remove(node.left, data);
        } else {
            if (node.left == null && node.right == null) {
                size--;
                return null;
            } else if (node.left != null && node.right != null) {
                //Hibbard delete, replace w/ successor
                size--;
                node.data = min(node.right);
                node.right = deleteMin(node.right);
                return node;
            } else if (node.left != null) {
                size--;
                return node.left;
            } else {
                size--;
                return node.right;
            }
        }
        //preserve link
        return node;
    }

    /**
     * Deletes minimum node in a tree
     *
     * @return next smallest node of the tree
     */
    private Node deleteMin(Node node) {
        if (node.left == null) {
            return node.right;
        } else {
            node.left = deleteMin(node.left);
        }
        return node;
    }

    /**
     * @return minimum value of the tree
     */
    private T min(Node node) {
        if (node.left == null) {
            return node.data;
        }
        return min(node.left);
    }

    /**
     * Inserts the data if it is not in the tree
     */
    public void add(T data) {
        if (size == 0) {
            root = new Node(data);
            size++;
        }
        insert(root, data);
    }

    /**
     * Inserts the data if it is not in the tree
     *
     * @return true if the data if the data has been inserted
     */
    private Node insert(Node node, T data) {
        //create new Node w/ data
        if (node == null) {
            size++;
            return new Node(data);
        }
        int compare = data.compareTo(node.data);
        if (compare > 0) {
            node.right = insert(node.right, data);
        } else if (compare < 0) {
            node.left = insert(node.left, data);
        }
        //preserve link
        return node;
    }

    private class Node {
        private T data;
        private Node left;
        private Node right;

        private Node(T data) {
            this.data = data;
        }
    }
}
