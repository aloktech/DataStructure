/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.ds.bt.seven;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author p
 */
public class TreeDeserializationMainClass {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.addValue(1);
        tree.addValue(2);
        tree.addValue(3);

        tree.printInOrder();
        String data = tree.serialize();
        System.out.println(data);
        TNode node = tree.deserialize(data);
        tree.setRoot(node);
        tree.printInOrder();

        tree.clear();

        tree.addValue(6);
        tree.addValue(5);
        tree.addValue(4);

        tree.printInOrder();
        data = tree.serialize();
        System.out.println(data);
        node = tree.deserialize(data);
        tree.setRoot(node);
        tree.printInOrder();
    }
}
