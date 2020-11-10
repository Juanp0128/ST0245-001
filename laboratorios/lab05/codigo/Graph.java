package Laboratorio5;

import Taller11.Taller12;
import java.util.ArrayList;
import java.util.LinkedList;

public abstract class Graph {
    LinkedList<LinkedList<Taller12.Vertices>> list = new LinkedList<>();
    protected int sizeV;
    protected int sizeA;

    public Graph(int sizeV) {
        this.sizeV = sizeV;
        this.sizeA = 0;
        for (int i = 0; i < sizeV; i++) {

        }
    }

    private boolean addArcaux(int source, int destination, int weight) {
        int i = 0;
        for (LinkedList<Taller12.Vertices> l : list) {
            if (i == source) {
                for (Taller12.Vertices ver:l){
                    if (ver.source==destination){
                        ver.weight= weight;
                        return true;
                    }
                }
                l.add(new Taller12.Vertices(destination,weight));
                sizeA++;
                return true;

            }
            i++;
        }
        return false;
    }

    boolean addArc(int source, int destination, int weight){
        return addArcaux(source,destination,weight)&&addArcaux(destination,source,weight);
    }

    public abstract ArrayList<Integer> getSuccessors(int sizeV);
    /**
     * Metodo que retorna el valor o peso de un arco entre dos vertices
     */
    public abstract int getWeight(int source, int destination);
    /**
     * Metodo que retorna el tamaño del grafo
     */
    public  int size() {return size();}

}
