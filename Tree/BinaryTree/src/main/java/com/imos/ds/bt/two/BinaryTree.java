/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.ds.bt.two;

/**
 *
 * @author p
 */
public class BinaryTree {

    Node root;

    void addValue(int value) {
        root = addValue(root, value);
    }

    private Node addValue(Node node, int value) {
        if (node == null) {
            node = new Node(value);
        } else if (value < node.value) {
            if (node.left == null) {
                Node newNode = new Node(value);
                node.left = newNode;
                newNode.parent = node;
            } else {
                addValue(node.left, value);
            }
        } else if (value > node.value) {
            if (node.right == null) {
                Node newNode = new Node(value);
                node.right = newNode;
                newNode.parent = node;
            } else {
                addValue(node.right, value);
            }
        }
        return node;
    }

    public void deleteValue(Node node, int value) {
        if (node == null) {
            return;
        }
        if (node.value == value && node.left == null && node.right == null) {
            Node parent = node.parent;
            if (parent != null && parent.left != null && parent.left.value == value) {
                parent.left = null;
            } else if (parent != null && parent.right != null && parent.right.value == value) {
                parent.right = null;
            } else {
                root = null;
            }
        } else if (node.value == value && node.left != null && node.right == null) {
            Node parent = node.parent;
            if (parent != null && parent.left != null && parent.left.value == value) {
                parent.left = node.left;
                node.left.parent = parent;
            } else if (parent != null && parent.right != null && parent.right.value == value) {
                parent.right = node.left;
                node.left.parent = parent;
            } else {
                root = node.left;
                node.left.parent = null;
            }
        } else if (node.value == value && node.left == null && node.right != null) {
            Node parent = node.parent;
            if (parent != null && parent.left != null && parent.left.value == value) {
                parent.left = node.right;
                node.right.parent = parent;
            } else if (parent != null && parent.right != null && parent.right.value == value) {
                parent.right = node.right;
                node.right.parent = parent;
            } else {
                root = node.right;
                node.right.parent = null;
            }
        } else if (node.value == value) {
            Node left = node.left;
            Node right = node.right;
            Node parent = node.parent;
            if (parent == null) {
                Node temp = right;
                if (temp.left != null) {
                    while (temp.left != null) {
                        temp = temp.left;
                    }
                    if (temp.right != null) {
                        Node tempParent = temp.parent;
                        tempParent.left = temp.right;
                    }
                    temp.right = right;
                } else {
                    temp.right = right;
                }
                temp.left = left;
                root = temp;
            } else if (parent.left == node) {
                Node temp = right;
                if (temp.left != null) {
                    while (temp.left != null) {
                        temp = temp.left;
                    }
                    if (temp.right != null) {
                        Node tempParent = temp.parent;
                        tempParent.left = temp.right;
                    }
                    temp.right = right;
                }
                temp.left = left;
                temp.parent = parent;
                parent.left = temp;
            } else {
                Node temp = left;
                if (temp.left != null) {
                    while (temp.left != null) {
                        temp = temp.left;
                    }
                    if (temp.right != null) {
                        Node tempParent = temp.parent;
                        tempParent.left = temp.right;
                    }
                }
                temp.right = right;
                temp.parent = parent;
                parent.right = temp;
            }
        } else {
            if (node.value > value) {
                deleteValue(node.left, value);
            } else {
                deleteValue(node.right, value);
            }
        }
    }
}
