/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.ds.ll.one;

/**
 *
 * @author p
 */
public class Node {
    Node previous;
    Node next;
    final int value;

    public Node(int value) {
        this.value = value;
    }
}
