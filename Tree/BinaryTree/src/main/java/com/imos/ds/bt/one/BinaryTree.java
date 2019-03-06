/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.ds.bt.one;

/**
 *
 * @author p
 */
public class BinaryTree {

    private Node root;

    void addValue(int value) {
        root = addValue(root, value);
    }

    private Node addValue(Node node, int value) {
        if (node == null) {
            node = new Node(value);
        } else if (value < node.value) {
            if (node.left == null) {
                Node temp = new Node(value);
                node.left = temp;
            } else {
                addValue(node.left, value);
            }
        } else if (value > node.value) {
            if (node.right == null) {
                Node temp = new Node(value);
                node.right = temp;
            } else {
                addValue(node.right, value);
            }
        }
        return node;
    }
    
    public Node getRoot() {
        return root;
    }
}
