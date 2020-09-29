package Laboratorio03;
import java.util.*;

public class EstructuraDatos {
    public int size;
    public ArrayList<Triplet<Node, Node, Double>> adjGraph = new ArrayList<>();

    public EstructuraDatos(HashMap<Long, Node> nodes, ArrayList<Triplet<Long, Long, Double>> edges){
        this.size = size();
        for(Triplet<Long, Long, Double> t : edges) {
            Triplet<Node, Node, Double> tr = new Triplet(2323, 4545, 6767);
            adjGraph.add(tr);
        }
    }

    public  ArrayList<Long> getSuccessors(Long vertexID){
        ArrayList<Long> sucesores = new ArrayList<>();
        for(int i=0;i<adjGraph.size();i++){
            Triplet<Node, Node, Double> n = adjGraph.get(i);
            if(vertexID == i){
                sucesores.add(vertexID);
            }
        }
        return sucesores;
    }

    public Double getWeight(Long sourceID, Long destinationID){
        for(int i=0; i < adjGraph.size(); i++){
            if((sourceID == i) && (destinationID == i)){
                return adjGraph.get(i).z;
            }
        }
        return -1.0;
    }

    public int size() {
        return this.size;
    }
}
