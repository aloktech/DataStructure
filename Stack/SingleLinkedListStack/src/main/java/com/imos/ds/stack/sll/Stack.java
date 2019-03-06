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
public class Stack {

    private Node stack;

    void push(int value) {
        if (stack == null) {
            stack = new Node(value);
        } else {
            Node tempNode = stack;
            Node node = new Node(value);
            while (tempNode.next != null) {
                tempNode = tempNode.next;
            }
            tempNode.next = node;
        }
    }

    int pop() {
        int value = 0;
        if (stack == null) {
            throw new IllegalStateException();
        } else {
            Node tempNode = stack;
            while (tempNode.next != null && tempNode.next.next != null) {
                tempNode = tempNode.next;
            }
            if (tempNode.next != null) {
                value = tempNode.next.value;
                tempNode.next = null;
            } else {
                value = tempNode.value;
                stack = null;
            }
        }
        return value;
    }
}
