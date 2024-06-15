package br.qziul.dataStructure.linkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList lista = new LinkedList("Elemento 1");
        lista.append("Elemento 2");
        lista.append("Elemento 3");
        lista.prepend("Elemento 0");
        lista.insert(3, "Elemento 2,5");
        lista.getHead();
        lista.getTail();
        lista.getLenght();

        lista.print();

//        lista.set(1, "MUDEI O COISO");
//        lista.remove(1);
//        lista.makeEmpty();
        System.out.println(lista.get(2).data);
        System.out.println("\nItem deletado: "+lista.removeFirst().data);
    }
}
