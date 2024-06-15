package br.qziul.dataStructure.queue;

import java.util.Random;

public class FilaAtendimento {
    public static void main(String[] args) {
        int numeroClientes = 5;

//      Novo cliente;
        String cliente = getRandom();
        Queue queue = new Queue(cliente);
        System.out.println("Chegou o cliente: " + cliente);

//      Chegada de clientes
        for(int i = 2; i <= numeroClientes; i++) {
            cliente = getRandom();
            System.out.println("Chegou o cliente: " + cliente);
            queue.enqueue(cliente);
        }

        System.out.println();

//      Atendimento dos clientes.
        var clienteAtendido = queue.dequeue();
        while(clienteAtendido != null){
            System.out.println("Cliente atendido: " + clienteAtendido.getData());
            clienteAtendido = queue.dequeue();
        }
    }

    public static String getRandom() {
        Random random = new Random();
        return String.valueOf(random.nextInt(101));
    }
}
