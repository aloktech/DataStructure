/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.ds.ll.one;

import java.util.ArrayList;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.stream.Collectors;

/**
 *
 * @author p
 */
public class MainClass {

    static List<Long> timesTaken = new ArrayList<>();

    public static void main(String[] args) {
        statistic();
    }

    private static void statistic() {
        LongSummaryStatistics stat = timesTaken.stream().collect(Collectors.summarizingLong(Long::longValue));
        System.out.println("Avg.: " + stat.getAverage());
        System.out.println("Max.: " + stat.getMax());
        System.out.println("Min.: " + stat.getMin());
    }

    static void addNode(Node node, int value) {
        if (node.next == null) {
            Node next = new Node(value);
            next.previous = node;
            node.next = next;
        } else {
            addNode(node.next, value);
        }
    }

    static void print(Node node) {
        if (node != null) {
            System.out.print(node.value + " ");
            print(node.next);
        }
    }
}
