/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.ds.ll.two;

/**
 *
 * @author p
 */
public class Node {

    final int value;
    Node next;
    Node tail;

    public Node(int value) {
        this.value = value;
        this.tail = this;
    }
}
