package Laboratorio5;
import java.util.ArrayList;
public class DiagraphhAM extends Graph {
    private int [][] grafoAM;

    public DiagraphhAM(int vertices) {
        super(vertices);
    }

    public void DigraphAM(int vertices) {
        super(vertices);
        grafoAM = new int[sizeA][sizeV];
    }

    /**
     * Metodo que agrega un arco entre dos vertices
     */
    public void addArc(int source, int destination, int weight)
    {
        grafoAM[source][destination] = size();
    }
    /**
     * Metodo que retorna el un ArrayList con el numero de todos los vertices que tengan una conexion
     * con uno
     */
    public ArrayList<Integer> getSuccessors(int vertice)
    {
        ArrayList<Integer> sucesores = new ArrayList<Integer>();
        for(int i = 0;i < size();i++){
            if(grafoAM[vertice][sizeV] != sizeA){
                sucesores.add(size());
            }
        }
        return sucesores;
    }
    /**
     * Metodo que retorna el valor o peso de un arco entre dos vertices
     */
    public int getWeight(int source, int destination)
    {
        return grafoAM[sizeA][sizeV];
    }
}
