package br.qziul.dataStructure.stack;

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


        //  Inverter pilha.
        /*
            String[] elementos = {"Elemento 1", "Elemento 2", "Elemento 3", "Elemento 4"};
            for (String elemento : elementos) {
                System.out.println(elemento);
            }
            System.out.println("====================");
            inverterPilha(elementos);
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
