package br.qziul.dataStructure.exercicios;

import java.util.LinkedList;
import java.util.Queue;

/*
    Inverte os primeiros K elementos de uma fila numérica.
 */

public class FilaReversa {
    public static Queue<Integer> inverter_K_Elementos(Queue<Integer> queue, int k){
        resolucaoInverte(queue, k);
        int restante = queue.size() - k;
        while(restante > 0) {
            int elemento = queue.remove();
            queue.add(elemento);
            restante--;
        }
        return queue;
    }

    private static void resolucaoInverte(Queue<Integer> queue, int k) {
        if(k==0) return;
        int elemento = queue.remove();
        resolucaoInverte(queue, k-1);
        queue.add(elemento);
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= 10; i++){
            queue.add(i);
        }
        System.out.println(inverter_K_Elementos(queue, 2));
    }
}
