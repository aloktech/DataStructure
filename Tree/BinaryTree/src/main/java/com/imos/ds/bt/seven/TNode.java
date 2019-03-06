/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.ds.bt.seven;

/**
 *
 * @author p
 */
public class TNode {

    final int value;

    TNode parent;
    TNode left;
    TNode right;

    public TNode(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "" + value;
    }
}
