package Taller11;
import java.util.ArrayList;

public class DiagraphAM extends Graph {

    private final int sinConexion = Integer.MIN_VALUE;
    int[][] mat;
    public void DigraphAM(int size) {
        mat = new int[size][size];
        this.Vertices = size;
        for (int i = 1; i <= size; i++) {
            for (int j = 0; j < size; j++) {
                this.mat[i][j]=sinConexion;
            }
        }
    }

    public DiagraphAM(int vertices) {
        super(vertices);
    }


    public void addArc(int source, int destination, int weight) {
        try{
            this.mat[source][destination] = weight;
            this.Arcos++;
        }catch(Exception e){
            System.out.println(e);
        }
    }


    public ArrayList<Integer> getSuccessors(int vertex) {
        ArrayList<Integer> np= new ArrayList<>();
        for(int i=1; i<=size; i++){
            if(mat[vertex][i]!=  sinConexion )np.add(i);
            }
        return np;
    }


    public int getWeight(int source, int destination) {
        return mat[source][destination];
    }

}
