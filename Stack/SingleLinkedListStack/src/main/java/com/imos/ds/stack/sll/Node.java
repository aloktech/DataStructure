/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.ds.stack.sll;

/**
 *
 * @author p
 */
public class Node {

    final int value;
    Node next;

    public Node(int value) {
        this.value = value;
    }
    
    @Override
    public String toString() {
        return "" + value;
    }
}
