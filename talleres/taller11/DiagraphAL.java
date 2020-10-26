package Taller11;

import javafx.util.Pair;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;


public class DiagraphAL extends Graph {
    private ArrayList<LinkedList<Pair<Integer,Integer>>> nodo;


    public DigraphAL(int Vertices) {
        super(Vertices);
        nodo = new LinkedList<>();
        for (int i = 0; i < Vertices; i++) {
            nodo.add(new LinkedList<>());
        }

    }

    public DiagraphAL(int vertices) {
        super(vertices);
    }


    public boolean addArc(Pair<Integer,Integer> node, int source) {
        int result = 0;
        for (LinkedList list : nodo){
            if(result == source){
                nodo.add(node);
                Vertices++;
            }
            result++;
        }
        return false;
    }

    boolean addArc(int node,int source, int destination){
        return addArc(new Pair(node,source),destination);
    }


    public ArrayList<Integer> getSuccessors(int vertex) {
        ArrayList<Integer> n = new ArrayList<>();
        int result = 0;
        for (LinkedList list:nodo){
            if (result==vertex){
                Iterator iterador = nodo.iterator();
                while (iterador.hasNext()){
                    n.add((Integer)((Pair)iterador.next()).getKey());
                }
            }
            result++;
        }
        return n;
    }


    public int getWeight(int source, int destination) {
        int result = 0;
        for (LinkedList list: nodo) {
            if (result==source){
                Iterator iter = list.iterator();
                while (iter.hasNext()){
                    Pair<Integer,Integer> node =(Pair<Integer,Integer>) iter.next();
                    if (node.getKey()==destination){
                        return (node.getValue());
                    }
                }
            }
            result++;
        }
        return -1;
    }

}
