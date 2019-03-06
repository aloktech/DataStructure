/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.ds.bt.eight;

import com.imos.ds.bt.seven.*;

/**
 *
 * @author p
 */
public class BinaryTree {

    TNode root;

    void clear() {
        root = null;
    }

    void addValue(int value) {
        root = addValue(root, value);
    }

    private TNode addValue(TNode node, int value) {
        if (node == null) {
            node = new TNode(value);
        } else if (value < node.value) {
            if (node.left == null) {
                TNode temp = new TNode(value);
                node.left = temp;
            } else {
                addValue(node.left, value);
            }
        } else if (value > node.value) {
            if (node.right == null) {
                TNode temp = new TNode(value);
                node.right = temp;
            } else {
                addValue(node.right, value);
            }
        }
        return node;
    }

    void printInOrder() {
        printInOrder(root);
        System.out.println("");
    }

    private void printInOrder(TNode node) {
        if (node == null) {
        } else if (node.left == null && node.right == null) {
            System.out.print(node.value + " ");
        } else if (node.left != null && node.right == null) {
            printInOrder(node.left);
            System.out.print(node.value + " ");
        } else if (node.left == null && node.right != null) {
            System.out.print(node.value + " ");
            printInOrder(node.right);
        } else if (node.left != null && node.right != null) {
            printInOrder(node.left);
            System.out.print(node.value + " ");
            printInOrder(node.right);
        }
    }

    String serialize() {
        return serialize(root);
    }

    private String serialize(TNode node) {
        if (node == null) {
            return "";
        } else if (node.left != null && node.right != null) {
            return node.value + ":" + node.left.value + ":" + node.right.value + " " + serialize(node.left) + " " + serialize(node.right);
        } else if (node.left == null && node.right != null) {
            return node.value + ":" + node.left + ":" + node.right.value + " " + serialize(node.right);
        } else if (node.left != null && node.right == null) {
            return node.value + ":" + node.left.value + ":" + node.right + " " + serialize(node.left);
        } else if (node.left == null && node.right == null) {
            return node.value + ":" + node.left + ":" + node.right;
        } else {
            return "";
        }
    }

    TNode deserialize(String data) {
        TNode rootNode = null;
        Queue queue = new Queue();
        if (data.contains(" ")) {
            for (String nData : data.split(" ")) {
                addToQueue(nData, queue);
            }
        } else {
            addToQueue(data, queue);
        }
        while (!queue.isEmpty()) {
            QNode qnode = queue.pop();
            if (rootNode == null) {
                rootNode = qnode.value;
            } else {
                mergeNode(rootNode, qnode.value);
            }
        }
        return rootNode;
    }

    private void addToQueue(String nData, Queue queue) {
        if (nData.contains(":")) {
            String[] val = nData.split(":");
            TNode node = createNode(val[0]);
            TNode left = createNode(val[1]);
            if (left != null) {
                node.left = left;
            }
            TNode right = createNode(val[2]);
            if (right != null) {
                node.right = right;
            }
            queue.push(node);
        }
    }

    void mergeNode(TNode parent, TNode child) {
        if (parent == null || child == null) {
        } else if (parent.value == child.value) {
            parent = child;
        } else if (parent.left != null && parent.left.value == child.value) {
            parent.left = child;
        } else if (parent.right != null && parent.right.value == child.value) {
            parent.right = child;
        } else if (child.left != null && child.left.value == parent.value) {
            child.left = parent;
        } else if (child.right != null && child.right.value == parent.value) {
            child.right = parent;
        } else {
            mergeNode(parent.left, child);
            mergeNode(parent.right, child);
        }
    }

    private TNode createNode(String string) {
        TNode node = null;
        try {
            int value = Integer.parseInt(string);
            node = new TNode(value);
        } catch (Exception e) {

        }
        return node;
    }

    public void setRoot(TNode root) {
        this.root = root;
    }
}
