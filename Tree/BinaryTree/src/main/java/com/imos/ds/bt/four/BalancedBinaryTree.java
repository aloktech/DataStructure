/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.ds.bt.four;

/**
 *
 * @author p
 */
public class BalancedBinaryTree {

    Node root;

    void addValue(int value) {
        addValue(root, value);
    }

    private void addValue(Node node, int value) {
        if (node == null) {
            root = new Node(value);
        } else if (value < node.value) {
            if (node.left == null) {
                Node newNode = new Node(value);
                node.left = newNode;
                newNode.parent = node;
            } else {
                addValue(node.left, value);
                Node baseNode = node.left;
                int leftLevel = findMaxLevel(baseNode.left);
                int rightLevel = findMaxLevel(baseNode.right);
                int diff = Math.abs(leftLevel - rightLevel);
                if (diff > 1) {
                    rotationOfTree(baseNode);
                    System.out.println("Rotation at node: " + baseNode.value + " rotation for node: " + value);
                }
            }
        } else if (value > node.value) {
            if (node.right == null) {
                Node newNode = new Node(value);
                node.right = newNode;
                newNode.parent = node;
            } else {
                addValue(node.right, value);
                Node baseNode = node.right;
                int leftLevel = findMaxLevel(baseNode.left);
                int rightLevel = findMaxLevel(baseNode.right);
                int diff = Math.abs(leftLevel - rightLevel);
                if (diff > 1) {
                    rotationOfTree(baseNode);
                    System.out.println("Rotation at node: " + baseNode.value + " rotation for node: " + value);
                }
            }
        }
    }

    private int findMaxLevel(Node node) {
        if (node == null) {
            return 0;
        }
        int leftLevel = 0, rightLevel = 0;
        if (node.left == null && node.right == null) {
            return 1;
        }
        if (node.left != null) {
            leftLevel = findMaxLevel(node.left) + 1;
        }
        if (node.right != null) {
            rightLevel = findMaxLevel(node.right) + 1;
        }
        return leftLevel > rightLevel ? leftLevel : rightLevel;
    }

    private int findNodeLevel(Node root, Node node) {
        int leftLevel = 0, rightLevel = 0;
        if (root == null) {
            return 0;
        }
        if (root.value == node.value) {
            return 0;
        }
        if (root.left != null && root.value > node.value) {
            if (root.left.value == node.value) {
                leftLevel = 1;
            } else {
                leftLevel = findNodeLevel(root.left, node) + 1;
            }
        } else if (root.right != null && root.value < node.value) {
            if (root.right.value == node.value) {
                rightLevel = 1;
            } else {
                rightLevel = findNodeLevel(root.right, node) + 1;
            }
        }
        return leftLevel > rightLevel ? leftLevel : rightLevel;
    }

    void rotationOfTree(Node node) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            Node leftChild = node.left;
            if (leftChild.left != null) {
                if (leftChild.right != null) {
                    rotationOfTree(leftChild);
                } else {
                    Node tempParent = node.parent;
                    leftChild.parent = tempParent;
                    leftChild.right = node;
                    node.parent = leftChild;
                    node.left = null;
                    if (tempParent == null) {
                        root = leftChild;
                    } else if (tempParent.left == node) {
                        tempParent.left = leftChild;
                    } else if (tempParent.right == node) {
                        tempParent.right = leftChild;
                    }
                }
            } else if (leftChild.right != null) {
                Node tempParent = node.parent;
                Node child = leftChild.right;
                child.parent = tempParent;
                child.left = leftChild;
                child.right = node;
                node.parent = child;
                node.left = null;
                leftChild.parent = child;
                leftChild.right = null;
                if (tempParent == null) {
                    root = child;
                } else if (tempParent.left == node) {
                    tempParent.left = child;
                } else if (tempParent.right == node) {
                    tempParent.right = child;
                }
            }
        } else if (node.right != null) {
            Node rightChild = node.right;
            if (rightChild.right != null) {
                if (rightChild.left == null) {
                    Node tempParent = node.parent;
                    rightChild.left = node;
                    node.parent = rightChild;
                    node.right = null;
                    if (tempParent == null) {
                        root = rightChild;
                    } else if (tempParent.right == node) {
                        tempParent.right = rightChild;
                    } else if (tempParent.left == node) {
                        tempParent.left = rightChild;
                    }
                } else {
                    rotationOfTree(rightChild);
                }
            } else if (rightChild.left != null) {
                Node tempParent = node.parent;
                Node child = rightChild.left;
                child.parent = tempParent;
                child.left = node;
                child.right = rightChild;
                node.parent = child;
                node.right = null;
                rightChild.left = null;
                rightChild.parent = child;
                if (tempParent == null) {
                    root = child;
                } else if (tempParent.left == node) {
                    tempParent.left = child;
                } else if (tempParent.right == node) {
                    tempParent.right = child;
                }

            }
        }
    }

//    private Node rotateTree(Node node) {
//        Node parent = node.parent;
//        Node superParent = parent.parent;
//        if (parent.left == node) {
//            if (superParent.left == parent) {
//                Node tempParent = superParent.parent;
//                Node tempRight = parent.right;
//                parent.parent = tempParent;
//                parent.right = superParent;
//                superParent.parent = parent;
//                superParent.left = tempRight;
//            } else {
//                Node tempParent = superParent.parent;
//                Node tempLeft = node.left;
//                Node tempRight = node.right;
//                node.left = superParent;
//                superParent.parent = node;
//                superParent.right = tempLeft;
//                node.right = parent;
//                parent.parent = node;
//                node.parent = tempParent;
//                parent.left = tempRight;
//            }
//        } else {
//            if (superParent.left == parent) {
//                Node tempParent = superParent.parent;
//                Node tempLeft = node.left;
//                Node tempRight = node.right;
//                node.left = parent;
//                parent.parent = node;
//                parent.right = tempLeft;
//                node.right = superParent;
//                superParent.parent = node;
//                superParent.left = tempRight;
//                node.parent = tempParent;
//            } else {
//                Node tempParent = superParent.parent;
//                Node tempLeft = parent.left;
//                parent.left = superParent;
//                parent.parent = tempParent;
//                superParent.parent = parent;
//                superParent.right = tempLeft;
//            }
//        }
//        return node;
//    }
    public void deleteValue(Node node, int value) {
        if (node == null) {
            return;
        }
        if (node.value == value && node.left == null && node.right == null) {
            Node parent = node.parent;
            if (parent != null && parent.left != null && parent.left.value == value) {
                parent.left = null;
            } else if (parent != null && parent.right != null && parent.right.value == value) {
                parent.right = null;
            } else {
                root = null;
            }
        } else if (node.value == value && node.left != null && node.right == null) {
            Node parent = node.parent;
            if (parent != null && parent.left != null && parent.left.value == value) {
                parent.left = node.left;
                node.left.parent = parent;
            } else if (parent != null && parent.right != null && parent.right.value == value) {
                parent.right = node.left;
                node.left.parent = parent;
            } else {
                root = node.left;
                node.left.parent = null;
            }
        } else if (node.value == value && node.left == null && node.right != null) {
            Node parent = node.parent;
            if (parent != null && parent.left != null && parent.left.value == value) {
                parent.left = node.right;
                node.right.parent = parent;
            } else if (parent != null && parent.right != null && parent.right.value == value) {
                parent.right = node.right;
                node.right.parent = parent;
            } else {
                root = node.right;
                node.right.parent = null;
            }
        } else if (node.value == value) {
            Node left = node.left;
            Node right = node.right;
            Node parent = node.parent;
            if (parent == null) {
                Node temp = right;
                if (temp.left != null) {
                    while (temp.left != null) {
                        temp = temp.left;
                    }
                    if (temp.right != null) {
                        Node tempParent = temp.parent;
                        tempParent.left = temp.right;
                    }
                    temp.right = right;
                } else {
                    temp.right = right;
                }
                temp.left = left;
                root = temp;
            } else if (parent.left == node) {
                Node temp = right;
                if (temp.left != null) {
                    while (temp.left != null) {
                        temp = temp.left;
                    }
                    if (temp.right != null) {
                        Node tempParent = temp.parent;
                        tempParent.left = temp.right;
                    }
                    temp.right = right;
                }
                temp.left = left;
                temp.parent = parent;
                parent.left = temp;
            } else {
                Node temp = left;
                if (temp.left != null) {
                    while (temp.left != null) {
                        temp = temp.left;
                    }
                    if (temp.right != null) {
                        Node tempParent = temp.parent;
                        tempParent.left = temp.right;
                    }
                }
                temp.right = right;
                temp.parent = parent;
                parent.right = temp;
            }
        } else {
            if (node.value > value) {
                deleteValue(node.left, value);
            } else {
                deleteValue(node.right, value);
            }
        }
    }

}
