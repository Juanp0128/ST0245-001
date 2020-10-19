package Tall10;

public class Tree {
    private Node root;
    public int size;
    public String name;


    // Constructor sin parametros iniciar sin nodo
    public Tree() {
        this.root = null;
        size = 0;
        this.name=null;
    }
    //Contructor iniciando con nodo
    public Tree(int n,String name) {
        this.root = new Node(n);
    }

    //Llama al metodo auxiliar insertar
    public void insertar(int n,String name) {
        insertarAux(root, n,name);
    }
    // Agrega un nodo al arbol
    private void insertarAux(Node node, int n,String name) {
        if (node.data == n){
            return;
        }else if (n > node.data) {
            if (node.rigth == null) {
                node.rigth = new Node(n);
            }else {
                insertarAux(node, n,name);
            }
        }else {
            if (node.left == null) {
                node.left = new Node(n);
            }else {
                insertarAux(node, n,name);
            }
        }
    }

    // Llama al metodo auxiliar buscar
    public boolean buscar(int n, String name) {
        return buscarAux(root, n,name);
    }

    //Busca en el arbol si existe un valor, devuelve true o false, dependiendo de si este o no
    private boolean buscarAux(Node node, int n,String name) {
        if (node.data == n) {
            return true;
        }
        if (node == null) {
            return false;
        }
        if (n > node.data) {
            return buscarAux(node, n,name);
        }
        return buscarAux(node, n,name);
    }

    //Llama al metodo auxiliar borrar
    public void borrar(int n) {
        borrarAux(root, n);
    }

    //Borra un nodo el arbol
    private Node borrarAux(Node node, int n) {
        if (node == null) {
            return null;
        }
        if (node.data == n) {
            if (node.rigth == null && node.left == null) {
                return null;
            }
            if (node.rigth == null) {
                return node.left;
            }
            if (node.left == null) {
                return node.rigth;
            }else {
                node.data = encontrarNodoReemplazo(node.left);
            }
        }
        if (n > node.data) {
            node.rigth = borrarAux(node.rigth, n);
            return node;
        }
        node.left = borrarAux(node.left, n);
        return node;
    }

    private int encontrarNodoReemplazo(Node n) {
        if (n.rigth == null) {
            int res = n.data;
            n = null;
            return res;
        }
        return encontrarNodoReemplazo(n.rigth);
    }
}
