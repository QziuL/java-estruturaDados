package br.qziul.dataStructure.tree;

import java.util.LinkedList;
import java.util.Queue;

public class Tree {
    private Node root;

    public static class Node {
        private final int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }

//      Leaf (folha) - elemento sem filho.
        public boolean isLeaf() {
            return (this.left == null) && (this.right == null);
        }

        public int getValue() {
            return value;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }
    }

    public void insert(int value) {
        if(root == null) root = new Node(value);
        else {
            Node newNode = new Node(value);
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            while(!queue.isEmpty()) {
                Node currentNode = queue.remove();
                if(currentNode.left == null) {
                    currentNode.left = newNode;
                    break;
                } else { queue.add(currentNode.left); }
                if(currentNode.right == null) {
                    currentNode.right = newNode;
                    break;
                } else { queue.add(currentNode.right); }
            }
        }
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
//      R - E - D
        if(node == null) return;
        System.out.println(node.value);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
//      E - R - D
        if(node == null) return;
        inOrder(node.left);
        System.out.println(node.value);
        inOrder(node.right);
    }

    public void posOrder() {
        posOrder(root);
    }

    private void posOrder(Node node) {
//      E - R - D
        if(node == null) return;
        posOrder(node.left);
        posOrder(node.right);
        System.out.println(node.value);
    }

//  Busca em Largura
    public Node BFS(int value) {
        if(root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            Node newNode = queue.remove();
            if(newNode.left != null) queue.add(newNode.left);
            if(newNode.right != null) queue.add(newNode.right);
            if(newNode.value == value) return newNode;
        }
        return null;
    }

//  Implementar Busca em Profundidade é idêntico ao preOrder().

    public Node getRoot() {
        return root;
    }
}
