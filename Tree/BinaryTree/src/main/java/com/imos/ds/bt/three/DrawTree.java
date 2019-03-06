/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.ds.bt.three;

import java.util.List;

/**
 *
 * @author p
 */
public class DrawTree {

    void constructTree(Node node) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            node.indent = node.left.indent + 1;
        }
        if (node.right != null) {
            node.right.indent = node.indent + 1;
        }
        constructTree(node.left);
        constructTree(node.right);
    }

    void validateTree(Node node) {
        PrintOrder print = new PrintOrder();
        for (int i = 0; i < 10; i++) {
            List<Node> list = print.printLevelTransverse(node, i);
            int preNodeIndent = -1;
            for (Node n : list) {
                if (preNodeIndent == n.indent) {
                    incrementOfIndent(n, n);
                }
                preNodeIndent = n.indent;
            }
        }
    }

    void incrementOfIndent(Node node, Node ref) {
        if (node == null) {
            return;
        }
        if (node.value < ref.value) {
            return;
        }
        node.indent++;
        if (node.parent != null) {
            incrementOfIndent(node.parent, ref);
        }
        if (node.left != null) {
            incrementOfIndent(node.left, ref);
        }
        if (node.right != null) {
            incrementOfIndent(node.right, ref);
        }
    }
    void incrementOfIndent(Node node) {
        if (node == null) {
            return;
        }
        node.indent++;
        if (node.parent != null) {
            incrementOfIndent(node.parent);
        }
        if (node.left != null) {
            incrementOfIndent(node.left);
        }
        if (node.right != null) {
            incrementOfIndent(node.right);
        }
    }

    void drawTree(Node node) {
        PrintOrder print = new PrintOrder();
        for (int i = 0; i < 10; i++) {
            List<Node> list = print.printLevelTransverse(node, i);
            for (Node n : list) {
                for (int j = 0; j < n.indent; j++) {
                    System.out.print("  ");
                }
                System.out.print(n.value);
            }
            System.out.println("");
        }
    }
}
