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
public class AddMainClass {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.addValue(30);
        tree.addValue(45);
        tree.addValue(25);
        tree.addValue(29);
        tree.addValue(39);
        tree.addValue(46);
        tree.addValue(44);
        tree.addValue(47);

        PrintOrder printOrder = new PrintOrder();
        System.out.println("In Order Transverse");
        printOrder.printInOrder(tree.getRoot());
        System.out.println("Pre Order Transverse");
        printOrder.printPreOrder(tree.getRoot());
        System.out.println("Post Order Transverse");
        printOrder.arrangeInPostOrder(tree.getRoot());
        System.out.println("Print Node at Level 0");
        printOrder.printLevelTransverse(tree.getRoot(), 0);
        System.out.println("Print Node at Level 1");
        printOrder.printLevelTransverse(tree.getRoot(), 1);
        System.out.println("Print Node at Level 2");
        printOrder.printLevelTransverse(tree.getRoot(), 2);
        System.out.println("Print Node at Level 3");
        printOrder.printLevelTransverse(tree.getRoot(), 3);
        System.out.println("Print Node at Level 4");
        printOrder.printLevelTransverse(tree.getRoot(), 4);
        System.out.println("Print the level of Node 30");
        printOrder.findNodeLevel(tree.getRoot(), 30);
        System.out.println("Print the level of Node 25");
        printOrder.findNodeLevel(tree.getRoot(), 25);
        System.out.println("Print the level of Node 45");
        printOrder.findNodeLevel(tree.getRoot(), 45);
        System.out.println("Print the level of Node 29");
        printOrder.findNodeLevel(tree.getRoot(), 29);
        System.out.println("Print the level of Node 44");
        printOrder.findNodeLevel(tree.getRoot(), 44);
    }
}
