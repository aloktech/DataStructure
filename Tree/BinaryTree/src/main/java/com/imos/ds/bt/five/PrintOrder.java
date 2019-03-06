/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.ds.bt.five;

import com.imos.ds.bt.four.*;
import static com.imos.ds.utils.CollectionUtils.createNewArray;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author p
 */
public class PrintOrder {

    public void findNodeLevel(Node node, int value) {
        if (node == null) {
            return;
        }
        if (node.value == value) {
            System.out.println(0);
        }
        if (node.left != null) {
            findNodeLevel(node.left, value, 1);
        }
        if (node.right != null) {
            findNodeLevel(node.right, value, 1);
        }
    }

    private void findNodeLevel(Node node, int value, int level) {
        if (node == null) {
            return;
        }
        if (node.value == value) {
            System.out.println(level);
        }
        if (node.left != null) {
            findNodeLevel(node.left, value, level + 1);
        }
        if (node.right != null) {
            findNodeLevel(node.right, value, level + 1);
        }
    }

    public void printLevelTransverse(Node node, int level) {
        if (node == null) {
            return;
        }
        if (level == 0) {
            System.out.println(node.value + " : " + node.left + " : " + node.right);
        }
        if (node.left != null) {
            printLevelTransverse(node.left, level - 1);
        }
        if (node.right != null) {
            printLevelTransverse(node.right, level - 1);
        }
    }

    public List<Integer> arrangeInPostOrder(Node node) {
        if (node == null) {
            return createNewArray();
        }
        if (node.left != null && node.right != null) {
            List<Integer> list = new ArrayList<>();
            list.addAll(arrangeInPostOrder(node.left));
            list.addAll(arrangeInPostOrder(node.right));
            System.out.println(node.value);
            list.add(node.value);
            return list;
        } else if (node.left == null && node.right == null) {
            System.out.println(node.value);
            List<Integer> list = new ArrayList<>();
            list.add(node.value);
            return list;
        } else if (node.left != null && node.right == null) {
            List<Integer> list = arrangeInPostOrder(node.left);
            System.out.println(node.value);
            list.add(node.value);
            return list;
        } else if (node.left == null && node.right != null) {
            List<Integer> list = arrangeInPostOrder(node.right);
            System.out.println(node.value);
            list.add(node.value);
            return list;
        } else {
            return new ArrayList<>();
        }
    }

    public void printPreOrder(Node node) {
        if (node == null) {
            return;
        }
        if (node.left != null && node.right != null) {
            System.out.println(node.value);
            printPreOrder(node.left);
            printPreOrder(node.right);
        } else if (node.left == null && node.right == null) {
            System.out.println(node.value);
        } else if (node.left != null && node.right == null) {
            System.out.println(node.value);
            printPreOrder(node.left);
        } else if (node.left == null && node.right != null) {
            System.out.println(node.value);
            printPreOrder(node.right);
        }
    }

    public List<Integer> printInOrder(Node node) {
        if (node == null) {
            return createNewArray();
        }
        if (node.left != null && node.right != null) {
            List<Integer> list = printInOrder(node.left);
            System.out.println(node.value);
            list.add(node.value);
            list.addAll(printInOrder(node.right));
            return list;
        } else if (node.left == null && node.right == null) {
            System.out.println(node.value);
            List<Integer> list = createNewArray();
            list.add(node.value);
            return list;
        } else if (node.left == null && node.right != null) {
            List<Integer> list = createNewArray();
            System.out.println(node.value);
            list.add(node.value);
            list.addAll(printInOrder(node.right));
            return list;
        } else if (node.left != null && node.right == null) {
            List<Integer> list = printInOrder(node.left);
            System.out.println(node.value);
            list.add(node.value);
            return list;
        } else {
            return createNewArray();
        }
    }
}
