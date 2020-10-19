package Tall10;

public class Taller10 {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insertar(123,"Rigoberto");
        tree.insertar(557,"Aurelio");
        tree.insertar(867,"Gustavo");
        tree.insertar(938,"Richard");
        System.out.println(tree.buscar(557,"Aurelio"));

    }
}
