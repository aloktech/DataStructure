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
public class TreeSerializationMainClass {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.addValue(20);
        tree.addValue(10);
        tree.addValue(25);

        tree.printInOrder();
        String data = tree.serialize();
        System.out.println(data);
    }

}
