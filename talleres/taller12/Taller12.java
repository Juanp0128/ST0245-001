package Taller11;

import java.util.LinkedList;
import java.util.ArrayList;
public class Taller12 {
    public static void main(String[] args) {
        DigraphAL diaL = new DigraphAL(6);
        diaL.addArc(10,0,1);
        diaL.addArc(20,6,3);
        diaL.addArc(30,5,2);
        diaL.addArc(40,5,1);
        diaL.addArc(50,3,4);
        diaL.addArc(60,2,0);
        diaL.addArc(70,2,1);
        diaL.addArc(80,4,1);
        diaL.addArc(90,3,0);

        System.out.println(diaL.getWeight(4,1));
        System.out.println(diaL.getSuccessors(6));
    }
    public static boolean DFS(int start,int finish,DigraphAL grafo){
       boolean visited[] = new boolean[grafo.size()];
       return DFSaux(start,finish,grafo,visited);
    }
    public static boolean DFSaux(int start,int finish,DigraphAL grafo,boolean[]visited){
      visited[start]=true;
      if (start==finish)return true;
      ArrayList<Integer> hijos=grafo.getSuccessors(start);
      for (Integer hijo : hijos){
          if (!visited[hijo]){
              return DFSaux(hijo,finish,grafo,visited);
          }
      }
      return false;
    }
    public class Vertices{
        int value;
        int source;
        boolean visited;

        public Vertices(int value, int source) {
            this.value = value;
            this.source = source;
            this.visited = false;
        }
    }

    public static boolean BFS(Vertices start, Vertices finish,DigraphAL grafo,LinkedList<Vertices> values,boolean[]visited){
        if (start.value==finish.value)return true;
        if (values.isEmpty())return false;
        values.remove();
        visited[start.value]=true;
        LinkedList<Vertices> agregar = grafo.getNodo().get(start.value);
        for (Vertices vertice: agregar){
            if (!visited[vertice.value])values.add(vertice);
        }
        if (!values.isEmpty()){
            Vertices vertice = values.peek();
            return BFS(vertice,finish,grafo,values,visited);
        }
        return false;
    }
}
