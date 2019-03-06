/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.ds.bt.eight;

import com.imos.ds.bt.seven.*;

/**
 *
 * @author p
 */
public class Queue {

    QNode header;

    void push(TNode value) {
        if (header == null) {
            header = new QNode(value);
        } else {
            QNode node = new QNode(value);
            QNode tnode = header.tail;
            header.tail = node;
            tnode.next = node;
            node.previous = tnode;
        }
    }

    boolean isEmpty() {
        return header == null;
    }

    QNode pop() {
        QNode node = null;
        if (header == null) {
            throw new IllegalStateException("Queue is empty");
        } else {
            node = header;
            QNode tnode = header.next;
            QNode tail = header.tail;
            header = tnode;
            if (tnode != null) {
                tnode.previous = null;
                header.tail = tail;
            }
        }
        return node;
    }
}
