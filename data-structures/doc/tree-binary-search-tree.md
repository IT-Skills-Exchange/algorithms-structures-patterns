# The Tree, Binary Search Tree Data Structure

## Tree 

In computer science, a tree is a widely used abstract data type (ADT) that simulates a hierarchical tree structure, 
with a root value and subtrees of children with a parent node, represented as a set of linked nodes.

A tree data structure can be defined recursively as a collection of nodes (starting at a root node), where each node is 
a data structure consisting of a value, together with a list of references to nodes (the "children"), with 
the constraints that no reference is duplicated, and none points to the root.

- Every item in the tree is a node
- The node at the top of the tree is the root
- Every non-root node has one and only one parent
- A leaf node has no children
- A singleton tree has only one node - the root

## Links

* [Tree Data Structure](https://en.wikipedia.org/wiki/Tree_(data_structure))

## Binary Search Tree

In computer science, binary search trees (BST), sometimes called ordered or sorted binary trees, are a particular type 
of container: a data structure that stores "items" (such as numbers, names etc.) in memory. They allow fast lookup, 
addition and removal of items, and can be used to implement either dynamic sets of items, or lookup tables that 
allow finding an item by its key (e.g., finding the phone number of a person by name).

### Characteristics

- Every node has 0, 1, or 2 children
- Children are referred to as left child and right child
- In practice, we use binary search trees
- The left child always has a smaller value than its parent
- The right child always has a larger value than its parent
- This means everything to the left of the root is less than the value of the root, and everything to the right of the root is 
greater than tha value of the root
- Because of that, we can do a binary search    

### Time complexity

Average: Space O(n), Search O(log n), Insert O(log n), Delete O(log n) <br>
Worst case: Space O(n), Search O(n), Insert O(n), Delete O(n)

### Operations

Can perform insertions, deletions, and retrievals in O(log n) time

Traversal

* Level - visit nodes on each level
* Pre-order - visit the root of every subtree first
* Post-order - visit the root of every subtree last
* In-order - visit left child, then root, then right child

Delete 

* Node is a leaf 
* Node has one child
* Node has two children

Delete node with two children

* Need to figure out what the replacement node will be
* Want minimal disruption to the existing tree structure
* Can take the replacement node from the deleted node's left subtree or right subtree
* If taking it from the left subtree, we have to take the largest value in the left subtree 
* If taking it from the right subtree, we have to take the smallest value in the right subtree 
* Choose one and stick to it

Let's create a tree implementation:

```java
final class Tree {
    private Node root;

    void insert(final int value) {
        if (root == null) {
            root = new Node(value);
        } else {
            root.insert(value);
        }
    }

    Node get(final int value) {
        if (root != null) {
            return root.get(value);
        }

        return null;
    }

    void delete(final int value) {
        root = delete(root, value);
    }

    int min() {
        if (root == null) {
            return Integer.MIN_VALUE;
        } else {
            return root.min();
        }
    }

    int max() {
        if (root == null) {
            return Integer.MAX_VALUE;
        } else {
            return root.max();
        }
    }

    void traverse() {
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

        Node(final int data) {
            this.data = data;
        }

        void insert(final int value) {
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

        Node get(final int value) {
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

        int min() {
            if (leftChild == null) {
                return data;
            } else {
                return leftChild.min();
            }
        }

        int max() {
            if (rightChild == null) {
                return data;
            } else {
                return rightChild.max();
            }
        }

        void traverse() {
            if (leftChild != null) {
                leftChild.traverse();
            }

            System.out.print(data + ", ");
            if (rightChild != null) {
                rightChild.traverse();
            }
        }

        int getData() {
            return data;
        }

        void setData(final int data) {
            this.data = data;
        }

        Node getLeftChild() {
            return leftChild;
        }

        void setLeftChild(final Node leftChild) {
            this.leftChild = leftChild;
        }

        Node getRightChild() {
            return rightChild;
        }

        void setRightChild(final Node rightChild) {
            this.rightChild = rightChild;
        }

        @Override
        public String toString() {
            return "Data = " + data;
        }
    }
}
```

It can be used as follow:

```java
final var tree = new Tree();
tree.insert(25);
tree.insert(20);
tree.insert(15);
tree.insert(27);
tree.insert(30);
tree.insert(29);
tree.insert(26);
tree.insert(22);
tree.insert(32);
tree.insert(17);
tree.traverse();

var value = tree.get(27).getData();
value = tree.get(17).getData();
value = tree.get(8888);

var min = tree.min();
var max = tree.max();

tree.delete(8888);
tree.traverse();
```

## Links

* [Binary Search Tree Data Structure](https://en.wikipedia.org/wiki/Binary_search_tree)