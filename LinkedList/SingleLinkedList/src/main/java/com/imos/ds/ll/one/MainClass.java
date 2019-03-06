/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.ds.ll.one;

import java.util.ArrayList;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Random;
import java.util.stream.Collectors;

/**
 *
 * @author p
 */
public class MainClass {

    static List<Long> timesTaken = new ArrayList<>();

    public static void main(String[] args) {
        Node head = new Node(20);
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            addValue(head, random.nextInt(1000));
        }
        statistic();
    }

    private static void statistic() {
        LongSummaryStatistics stat = timesTaken.stream().collect(Collectors.summarizingLong(Long::longValue));
        System.out.println("Avg.: " + stat.getAverage());
        System.out.println("Max.: " + stat.getMax());
        System.out.println("Min.: " + stat.getMin());
    }

    private static void addValue(Node head, int value) {
        long startTime;
        System.out.println("");
        startTime = System.nanoTime();
        add(head, value);
        long diff = System.nanoTime() - startTime;
        timesTaken.add(diff);
        System.out.println("Add: " + diff);
        startTime = System.nanoTime();
        print(head);
        diff = System.nanoTime() - startTime;
        System.out.println("\nPrint: " + diff);
    }

    static void add(Node node, int value) {
        if (node.next == null) {
            Node next = new Node(value);
            node.next = next;
        } else {
            add(node.next, value);
        }
    }

    static void print(Node node) {
        if (node != null) {
            System.out.print(node.value + " ");
            print(node.next);
        }
    }
}
