/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.ds.bt.five;

import java.io.Serializable;

/**
 *
 * @author p
 */
public class Node implements Serializable {

    Node parent;
    Node left;
    Node right;
    final int value;

    public Node(int value) {
        this.value = value;
    }
    
    @Override
    public String toString() {
        return "" + value;
    }
}
