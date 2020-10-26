package Taller11;
import java.util.ArrayList;


public abstract class Graph {
    protected int size;
    public int Vertices;
    public int Arcos;

    public Graph(int vertices) {
        size = vertices;
    }

    public abstract void addArc(int source, int destination, int weight);

    public abstract ArrayList<Integer> getSuccessors(int vertex);

   
    public abstract int getWeight(int source, int destination);


    public int size() {
        return size;
    }
}
