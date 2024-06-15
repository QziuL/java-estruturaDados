import br.qziul.estruturaDeDados.LinkedList;
import br.qziul.estruturaDeDados.Stack;

public class Main {
    public static void main(String[] args) {
/*
        == Métodos para Stack (Pilha) ==
        Stack stack = new Stack("Elemento 1");
        stack.push("Elemento 2");
        stack.push("Elemento 3");
        stack.push("Elemento 4");
        stack.getTop();
        stack.getHeight();
        stack.print();
        System.out.println("Elemento deletado: "+stack.pop().getData());
        stack.print();
*/

        // inverter pilha
        String[] elementos = {"Elemento 1", "Elemento 2", "Elemento 3", "Elemento 4"};
        for (String elemento : elementos) {
            System.out.println(elemento);
        }
        System.out.println("====================");
        inverterPilha(elementos);


/*
        == Métodos para Linked List (Lista Encadeada) ==
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

    private static void inverterPilha(String[] elementos) {
        Stack stack = new Stack(elementos[0]);
        for(int i = 1; i < elementos.length; i++){
            stack.push(elementos[i]);
        }

        Stack.Node elementoDeletado = stack.pop();
        while(elementoDeletado != null) {
            System.out.println(elementoDeletado.getData());
            elementoDeletado = stack.pop();
        }
    }
}
