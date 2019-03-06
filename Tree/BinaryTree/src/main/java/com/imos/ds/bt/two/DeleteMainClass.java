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
public class DeleteMainClass {

    public static void main(String[] args) {
        PrintOrder printOrder = new PrintOrder();
        BinaryTree tree = new BinaryTree();
        tree.addValue(30);
        tree.addValue(45);
        tree.addValue(25);
        tree.addValue(29);
        tree.addValue(39);
        tree.addValue(46);
        tree.addValue(44);
        tree.addValue(47);
        tree.addValue(20);
        tree.addValue(14);

        tree.deleteValue(tree.root, 30);
        tree.deleteValue(tree.root, 14);
        tree.deleteValue(tree.root, 44);
        tree.deleteValue(tree.root, 47);
        tree.deleteValue(tree.root, 25);
        tree.deleteValue(tree.root, 29);
        tree.deleteValue(tree.root, 45);
        tree.deleteValue(tree.root, 39);
        tree.deleteValue(tree.root, 20);
        tree.deleteValue(tree.root, 30);
        tree.deleteValue(tree.root, 46);
        tree.deleteValue(tree.root, 4);

        printOrder.printInOrder(tree.root);
        System.out.println("");
        for (int i = 0; i < 5; i++) {
            printOrder.printLevelTransverse(tree.root, i);
            System.out.println("");
        }
    }
}
