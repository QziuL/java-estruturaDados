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
    public class Node {
        String data;
        Node next;

        public Node(String data) {
            this.data = data;
        }

        public String getData() {
            return data;
        }
    }

//  Construtor.
    public Stack(String data) {
        Node newNode = new Node(data);
        this.top = newNode;
        this.height = 1;
    }

//  Remover item da pilha.
    public Node pop() {
        if(this.height == 0) {
            return null;
        }

        Node varTemp;
        if(this.height == 1) {
            varTemp = this.top;
            this.top = null;
        } else {
            varTemp = this.top;
            this.top = this.top.next;
        }

        this.height--;
        return varTemp;
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

    public void print() {
        if(this.height == 0){
            System.err.println("Pilha vazia.");
        } else {
            Node varTemp = top;

            System.out.println("====================");
            while(varTemp != null) {
                System.out.println(varTemp.data);
                varTemp = varTemp.next;
            }
            System.out.println("====================");
        }
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
}
