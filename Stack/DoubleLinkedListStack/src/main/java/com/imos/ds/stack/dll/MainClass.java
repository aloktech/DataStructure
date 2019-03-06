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
public class MainClass {

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(20);
        stack.push(30);
        stack.push(10);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
