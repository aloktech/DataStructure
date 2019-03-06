/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.ds.bt.six;

/**
 *
 * @author p
 */
public class BinaryTree {

    TNode root;

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
}
