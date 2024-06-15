package br.qziul.dataStructure.tree.BST;

public class BinarySearchTree {
    private Node root;

    public static class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public void insert(int value) {
        if(this.root == null) this.root = new Node(value);
        else {
            insert(this.root, value);
        }
    }

    private void insert(Node root, int value) {
        if(root == null) return;
        if(value == root.value) return;
        if(value > root.getValue())
            if(root.right == null) root.right = new Node(value);
            else insert(root.right, value);
        else
            if(root.left == null) root.left = new Node(value);
            else insert(root.left, value);
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
//      E - R - D
        if(node == null) return;
        inOrder(node.left);
        System.out.println(node.value);
        inOrder(node.right);
    }

    public boolean contains(int value){
        return contains(root, value);
    }

    private boolean contains(Node root, int value) {
        if(root == null) return false;
        if(root.value == value) return true;
        if(value > root.value) return contains(root.right, value);
        else return contains(root.left, value);
    }

    public void deleteNode(int value) {
        this.root = deleteNode(this.root, value);
    }

    private Node deleteNode(Node root, int value) {
        if(root == null) return null;
        if(value < root.value) {
            root.left = deleteNode(root.left, value);
        } else if(value > root.value) {
            root.right = deleteNode(root.right, value);
        } else {
            if((root.left == null) && (root.right == null)) {
                return null;
            } else if(root.left == null) {
                return root.right;
            } else if(root.right == null) {
                return root.left;
            } else {
//              Obs. O menor valor de um Nó completo é sempre o filho à esquerda do seu filho à direita.
                int minValue = minValue(root.right);
                root.value = minValue;
                root.right = deleteNode(root.right, minValue);
            }
        }
        return root;
    }

    public int minValue(Node currentNode) {
        while(currentNode.left != null) {
            currentNode = currentNode.left;
        }
        return currentNode.value;
    }

    public Node getRoot() {
        return root;
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(37);
        tree.insert(11);
        tree.insert(66);
        tree.insert(8);
        tree.insert(17);
        tree.insert(42);
        tree.insert(72);

        tree.deleteNode(8);
        tree.inOrder();
    }
}
