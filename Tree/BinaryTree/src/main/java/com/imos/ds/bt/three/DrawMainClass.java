/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.ds.bt.three;

/**
 *
 * @author p
 */
public class DrawMainClass {

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
        tree.addValue(20);
        tree.addValue(14);
        tree.addValue(11);
        tree.addValue(10);
        tree.addValue(28);
        tree.addValue(27);
        tree.addValue(22);
        tree.addValue(21);
        tree.addValue(12);
        tree.addValue(13);
        tree.addValue(14);
        tree.addValue(15);
        tree.addValue(16);
        tree.addValue(17);
        tree.addValue(18);
        tree.addValue(19);
        tree.addValue(22);
        tree.addValue(23);
        tree.addValue(24);

        DrawTree draw = new DrawTree();
        draw.constructTree(tree.getRoot());
        draw.validateTree(tree.getRoot());
        draw.drawTree(tree.getRoot());
    }
}
