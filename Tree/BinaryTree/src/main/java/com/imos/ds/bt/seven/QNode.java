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
public class QNode {

    final TNode value;
    QNode header;
    QNode previous;
    QNode next;
    QNode tail;

    public QNode(TNode value) {
        this.value = value;
        this.header = this;
        this.tail = this;
    }

    @Override
    public String toString() {
        return "" + value.value;
    }

}
