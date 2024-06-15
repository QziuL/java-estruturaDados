package br.qziul.dataStructure.queue;

public class Main {
    public static void main(String[] args) {
        Queue queue = new Queue("Elemento 1");
        queue.enqueue("Elemento 2");
        queue.enqueue("Elemento 3");
        System.out.println("Removido da fila: " + queue.dequeue().getData());
        queue.print();
        queue.getFirst();
        queue.getLast();
        queue.getLength();
    }
}
