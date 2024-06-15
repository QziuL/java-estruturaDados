package br.qziul.dataStructure.tree;

public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(37);
        tree.insert(11);
        tree.insert(66);
        tree.insert(8);
        tree.insert(17);
        tree.insert(42);
        tree.insert(72);

        Tree.Node node = tree.BFS(42);
        System.out.println("===============");
        System.out.println((node != null) ? node.getValue() : "Não encontrado.");
        System.out.println("===============");
    }
}
