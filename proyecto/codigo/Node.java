package Proyectoo;
//Juan Pablo Henao & Diego Vanegas
public class Node {
    Gini gini;
    Node right;
    Node left;

    public Node(Gini gini) {
        this.gini = gini;
        this.right = null;
        this.left = null;
    }
}
