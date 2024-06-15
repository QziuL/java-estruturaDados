package br.qziul.estruturaDeDados.linkedList;

public class LinkedList {

    private Node head;  // 'Cabeça', primeiro elemento da lista.
    private Node tail;  // 'Cauda', último elemento da lista.
    private int lenght;

    public LinkedList(String data) {
        Node newNode = new Node(data);
        lenght = 1;
        head = newNode;
        tail = newNode;
    }

//  Classe que representa os 'Nós' (Elementos) da lista.
    static class Node {
        String data;
        Node next;  // Sempre aponta para o próximo Nó. É de tipo Null se for o último Nó da lista.

        Node(String data){
            this.data = data;
            next = null;
        }
    }

    public void print() {
/*
        Variável temporária do tipo Node que vai percorrer cada item contido na lista e imprimir seu respectivo dado.
*/
        Node temp = this.head;
        System.out.println("\n=================");
        while(temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
        System.out.println("=================");
    }

//  Insere novo elemento ao final da lista.
    public void append(String data) {
        Node newNode = new Node(data);
        if(this.lenght == 0) {
            primeiroElemento(newNode);
        } else {
/*
            O próximo elemento depois do último vai receber o newNode,
            o tail recebe o mesmo valor, apontando então para o último elemento criado
*/
            this.tail = this.tail.next = newNode;
        }
        lenght++;
    }

//  Remove último elemento da lista.
    public Node removeLast() {
        if(this.lenght == 0) return null;
        Node penultimo = head;
        Node varTemp = null;

//      Percorre os itens da lista até encontrar o penúltimo elemento.
        while (penultimo.next != this.tail) {
            penultimo = penultimo.next;
        }

/*
        - varTemp armazena o ultimo elemento antes de deletar;
        - apontamos o penúltimo elemento como ultimo;
        - por fim declaramos que o próximo elemento é Null, apagando o antigo elemento.
*/
        varTemp = this.tail;
        this.tail = penultimo;
        this.tail.next = null;

        this.lenght--;
        if(lenght == 0) {
            this.head = null;
            this.tail = null;
        }

        return varTemp;
    }

//  Insere novo elemento no começo da lista.
    public void prepend(String data) {
        Node newNode = new Node(data);

        if(this.lenght == 0) {
            primeiroElemento(newNode);
        } else {
            newNode.next = this.head;
            this.head = newNode;
        }
        this.lenght++;
    }

//  Remove o primeiro elemento da lista.
    public Node removeFirst() {
        if(this.lenght == 0) return  null;

        Node varTemp = this.head;
        this.head = this.head.next;
        varTemp.next = null;

        this.lenght--;
        if(this.lenght == 0){
            this.head = null;
            this.tail = null;
        }
        return varTemp;
    }

//  Ler o dado de um determinado elemento da lista.
    public Node get(int index) {
        if(index < 0 || index >= this.lenght) return null;
        Node varTemp = this.head;
        for(int i = 0; i < index; i++) {
            varTemp = varTemp.next;
        }
        return varTemp;
    }

//  Método para alterar o dado de um elemento num determinado index.
    public boolean set(int index, String data) {
        if(index < 0 || index >= this.lenght) return false;
        Node varTemp = get(index);
        varTemp.data = data;
        return true;
    }

//  Método para inserir um elemento num determinado index.
    public boolean insert(int index, String data) {
        if(index < 0)   return false;

        if(index == 0) {
            prepend(data);
            return true;
        }
        if(index > this.lenght) {
            append(data);
            return true;
        }

/*
        O elemento novo vai se infiltrar no espaço entre dois elementos da lista.
        Ex: lista com os elementos 1, 2 e 3 nas posições [0, 1, 2]:
        quero colocar o elemento 2,5 entre o 2 e 3,
        o elemento 2,5 vai dizer que o elemento posterior a ele é o 3
        e o elemento 2 vai dizer que o elemento posterior a ele é o 2,5,
        dessa forma o elemento 2,5 infiltra-se no lugar entre os dois elementos.
*/
        Node newNode = new Node(data);
        Node varTemp = get(index - 1);
        newNode.next = varTemp.next;
        varTemp.next = newNode;
        this.lenght++;
        return true;
    }

//  Método para remover elemento de um index específico.
    public Node remove(int index) {
        if(index < 0 || index >= this.lenght)   return null;
        if(index == 0)                          return removeFirst();
        if(index == this.lenght-1)              return removeLast();

/*
        Armazena o elemento anterior e o elemento desejado.
        O elemento anterior vai dizer que seu próximo elemento é o posterior
        ao elemento desejado.
        O elemento desejado vai apontar que o próximo elemento a ele é Null.
        Removendo-o da lista.

        Ex: lista com elementos 1, 2 e 3 nas posições 0, 1 e 2:
        Para excluir o elemento 1, o elemento 0 vai dizer que o elemento posterior a ele é o 2, enquanto que o elemento 1 vai dizer que o elemento posterior a ele é Null.
*/
        Node anterior = get(index - 1);
        Node varTemp = anterior.next;
        anterior.next = varTemp.next;
        varTemp.next = null;
        this.lenght--;
        return varTemp;
    }

//  Método que cria um novo elemento caso a lista esteja vazia.
    private void primeiroElemento(Node newNode) {
        this.head = newNode;
        this.tail = newNode;
    }

    public void makeEmpty() {
        this.head = null;
        this.tail = null;
        this.lenght = 0;
    }

    public void getHead() {
        if(this.head == null)
            System.out.println("Lista vazia.");
        else
            System.out.println("Head: "+this.head.data);
    }

    public void getTail() {
        if(this.tail == null)
            System.out.println("Lista vazia.");
        else
            System.out.println("Tail: "+this.tail.data);
    }

    public void getLenght() { System.out.println("Lenght: "+this.lenght); }
}