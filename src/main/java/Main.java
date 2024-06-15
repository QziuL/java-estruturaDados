import br.qziul.estruturaDeDados.LinkedList;
import br.qziul.estruturaDeDados.Stack;

public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack("Elemento 1");
        stack.push("Elemento 2");
        stack.push("Elemento 3");
        stack.push("Elemento 4");
        stack.getTop();
        stack.getHeight();
        stack.print();

        System.out.println("Elemento deletado: "+stack.pop().getData());


        stack.print();

/*
        Métodos para LinkedList
        LinkedList lista = new LinkedList("Elemento 1");
        lista.append("Elemento 2");
        lista.append("Elemento 3");
        lista.prepend("Elemento 0");

        lista.getHead();
        lista.getTail();
        lista.getLenght();

        lista.print();

        lista.insert(3, "Elemento 2,5");
        lista.set(1, "MUDEI O COISO");
        lista.remove(1);
        lista.makeEmpty();
        System.out.println(lista.get(2).data);
        System.out.println("\nItem deletado: "+lista.removeFirst().data);;
*/
    }
}
