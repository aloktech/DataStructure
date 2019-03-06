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
public class MainClass {
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.push(20);
        queue.push(10);
        queue.push(30);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        queue.pop();
    }
}
