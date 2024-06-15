package br.qziul.dataStructure.exercicios;

import br.qziul.dataStructure.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/*
    Encontra o maior valor de cada nível em uma árvore binária genérica.
 */
public class MaiorValorPorNivelDaArvore {
    public static List<Integer> maioresValores(Tree tree) {
        var list = new ArrayList<Integer>();

        resolucaoArvore(tree.getRoot(), 0, list);

        return list;
    }

    private static void resolucaoArvore(Tree.Node node, int level, ArrayList<Integer> list) {
        if(node == null) return;
        if(level == list.size()) list.add(node.getValue());
        else
            list.set(level, Math.max(list.get(level), node.getValue()));
        resolucaoArvore(node.getLeft(), level+1, list);
        resolucaoArvore(node.getRight(), level+1, list);
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(100);

        tree.insert(10);
        tree.insert(5);

        tree.insert(6);
        tree.insert(1);
        tree.insert(7);
        tree.insert(5);

        System.out.println(maioresValores(tree));
    }
}
