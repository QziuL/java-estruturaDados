package br.qziul.dataStructure.queue;

public class Queue {
    private Node first;
    private Node last;
    private int length;

//  Classe que representa os 'Nós'.
    public static class Node {
        private final String data;
        private Node next;

        public Node(String data) {
            this.data = data;
        }

        public String getData() {
            return data;
        }
    }

//  Construtor.
    public Queue(String data) {
        Node newNode = new Node(data);
        this.first = newNode;
        this.last = newNode;
        this.length = 1;
    }

    public void enqueue(String data) {
        Node newNode = new Node(data);
        if(this.first == null)
            this.first = newNode;
        else
            this.last.next = newNode;
        this.last = newNode;
        this.length++;
    }

    public Node dequeue() {
        if(this.first == null)
            return null;
        Node varTemp = this.first;
        if(this.length == 1)
            makeEmpty();
        else
            this.first = this.first.next;
        varTemp.next = null;
        this.length--;
        return varTemp;
    }

    public void getFirst() {
        System.out.println((this.first != null)
                ? "Primeiro: " + this.first.data
                : "A fila está vazia."
        );
    }

    public void getLast() {
        System.out.println((this.last != null)
                ? "Último: " + this.last.data
                : "A fila está vazia."
        );
    }

    public void getLength() {
        System.out.println("Tamanho: " + this.length);
    }

    public void print() {
        System.out.println("===================");
        Node varTemp = this.first;
        while(varTemp != null) {
            System.out.println(varTemp.data);
            varTemp = varTemp.next;
        }
        System.out.println("===================");
    }

    private void makeEmpty() {
        this.first = null;
        this.last = null;
    }
}
