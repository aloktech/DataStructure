/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.ds.queue.one;

/**
 *
 * @author p
 */
public class Queue {
    Node queue;
    
    void push(int value) {
        if (queue == null) {
            queue = new Node(value);
            queue.tail = queue;
        } else {
            Node node = new Node(value);
            queue.tail.next = node;
            queue.tail = node;
        }
    }
    
    int pop() {
        int value = 0;
        if (queue == null) {
            throw new IllegalStateException();
        }
        value = queue.value;
        queue = queue.next;
        return value;
    }
}
