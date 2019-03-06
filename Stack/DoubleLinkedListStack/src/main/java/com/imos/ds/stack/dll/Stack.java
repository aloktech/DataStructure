/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.ds.stack.dll;

/**
 *
 * @author p
 */
public class Stack {

    Node stack;

    void push(int value) {
        if (stack == null) {
            stack = new Node(value);
        } else {
            Node node = new Node(value);
            stack.next = node;
            node.previous = stack;
            stack = node;
        }
    }

    int pop() {
        int value = 0;
        if (stack == null) {
            throw new IllegalStateException();
        } else {
            value = stack.value;
            stack = stack.previous;
        }
        return value;
    }
}
