package br.qziul.estruturaDeDados;

/*
    Operações da Pilha:
    - Adicionar (push)
    - Remover (pop)
    - Ler topo (getTop)
    - Imprimir (print)
 */

import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;

public class Stack {
    private Node top;
    private int height;


//  Classe que representa um Nó na pilha.
    class Node {
        private String data;
        private Node next;

        public Node(String data) {
            this.data = data;
        }
    }

//  Construtor.
    public Stack(String data) {
        Node newNode = new Node(data);
        this.top = newNode;
        this.height = 1;
    }

//  Adiciona item na pilha.
    public void push(String data) {
        Node newNode = new Node(data);
        if(this.height == 0) {
            this.top = newNode;
        } else {
            newNode.next = this.top;
            this.top = newNode;
        }
        this.height++;
    }

    public void getTop() {
        System.out.println((this.top == null)
                ? "Pilha vazia."
                : "Topo: " + this.top.data
        );
    }

    public void getHeight() {
        System.out.println((this.height == 0)
                ? "Pilha vazia."
                : "Altura: "+this.height
        );
    }

    public void print() {
        Node varTemp = top;

        System.out.println("====================");
        while(varTemp != null) {
            System.out.println(varTemp.data);
            varTemp = varTemp.next;
        }
        System.out.println("====================");
    }
}
