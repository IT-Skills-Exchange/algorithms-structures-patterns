package com.github.akarazhev.tutorial.datastructures.tree;

/**
 * Provides a simple tree implementation.
 */
public class Tree {
    private Node root;

    /**
     * Inserts a new value with a node.
     *
     * @param value a value.
     */
    public void insert(final int value) {
        if (root == null) {
            root = new Node(value);
        } else {
            root.insert(value);
        }
    }

    /**
     * Gets a node by a value.
     *
     * @param value a value.
     * @return a node.
     */
    public Node get(final int value) {
        if (root != null) {
            return root.get(value);
        }

        return null;
    }

    /**
     * Deletes a value.
     *
     * @param value a value.
     */
    public void delete(final int value) {
        root = delete(root, value);
    }

    /**
     * Returns a min value.
     *
     * @return a value.
     */
    public int min() {
        if (root == null) {
            return Integer.MIN_VALUE;
        } else {
            return root.min();
        }
    }

    /**
     * Returns a max value.
     *
     * @return a value.
     */
    public int max() {
        if (root == null) {
            return Integer.MAX_VALUE;
        } else {
            return root.max();
        }
    }

    /**
     * Performs traverse.
     */
    public void traverse() {
        if (root != null) {
            root.traverse();
            System.out.println();
        }
    }

    private Node delete(final Node subTreeRoot, final int value) {
        if (subTreeRoot == null) {
            return subTreeRoot;
        }

        if (value < subTreeRoot.getData()) {
            subTreeRoot.setLeftChild(delete(subTreeRoot.getLeftChild(), value));
        } else if (value > subTreeRoot.getData()) {
            subTreeRoot.setRightChild(delete(subTreeRoot.getRightChild(), value));
        } else {
            // Cases 1 and 2: node to delete has 0 or 1 child(ren)
            if (subTreeRoot.getLeftChild() == null) {
                return subTreeRoot.getRightChild();
            } else if (subTreeRoot.getRightChild() == null) {
                return subTreeRoot.getLeftChild();
            }

            // Case 3: node to delete has 2 children

            // Replace the value in the subtreeRoot node with the smallest value
            // from the right subtree
            subTreeRoot.setData(subTreeRoot.getRightChild().min());

            // Delete the node that has the smallest value in the right subtree
            subTreeRoot.setRightChild(delete(subTreeRoot.getRightChild(), subTreeRoot.getData()));
        }

        return subTreeRoot;
    }

    final static class Node {
        private int data;
        private Node leftChild;
        private Node rightChild;

        public Node(final int data) {
            this.data = data;
        }

        public void insert(final int value) {
            if (value == data) {
                return;
            }

            if (value < data) {
                if (leftChild == null) {
                    leftChild = new Node(value);
                } else {
                    leftChild.insert(value);
                }
            } else {
                if (rightChild == null) {
                    rightChild = new Node(value);
                } else {
                    rightChild.insert(value);
                }
            }
        }

        public Node get(final int value) {
            if (value == data) {
                return this;
            }

            if (value < data) {
                if (leftChild != null) {
                    return leftChild.get(value);
                }
            } else {
                if (rightChild != null) {
                    return rightChild.get(value);
                }
            }

            return null;
        }

        public int min() {
            if (leftChild == null) {
                return data;
            } else {
                return leftChild.min();
            }
        }

        public int max() {
            if (rightChild == null) {
                return data;
            } else {
                return rightChild.max();
            }
        }

        public void traverse() {
            if (leftChild != null) {
                leftChild.traverse();
            }

            System.out.print(data + ", ");
            if (rightChild != null) {
                rightChild.traverse();
            }
        }

        public int getData() {
            return data;
        }

        public void setData(final int data) {
            this.data = data;
        }

        public Node getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(final Node leftChild) {
            this.leftChild = leftChild;
        }

        public Node getRightChild() {
            return rightChild;
        }

        public void setRightChild(final Node rightChild) {
            this.rightChild = rightChild;
        }

        @Override
        public String toString() {
            return "Data = " + data;
        }
    }
}
