package Laboratorio03;
import java.util.*;
import java.io.*;
public class Map {
    public static void main(String [] args){

        File archivo = new File("Medallo.txt");
        LinkedList<Conexion> vertices = new LinkedList<>();
        boolean arks = false;

        try{
            Scanner enter = new Scanner(archivo);
            String line;

            while(enter.hasNextLine()){

                line = enter.nextLine();
                String [] partes = line.split(" ");



                if(partes[0].equals("Vertices.")) continue;

                if(partes[0].equals("Arcos.")){
                    arks = true;
                    continue;
                }


                int start = partes[0].length()+partes[1].length()
                        +partes[2].length()+2;

                if(!arks){
                    if(partes.length >= 4) vertices.add(new Conexion(partes[0],partes[1],partes[2],line.substring(start)));
                    else vertices.add(new Conexion(partes[0],partes[1],partes[2],""));
                }else{

                    Conexion Inicio = null;
                    Conexion Final = null;

                    for(Conexion ver: vertices){
                        if(ver.ID.equals(partes[0]))Inicio = ver;
                        if(ver.ID.equals(partes[1]))Final = ver;
                        if(Inicio!=null && Final!=null) break;
                    }

                    if(partes.length >= 4) Inicio.conexiones.add(new Arco(Final,partes[2],line.substring(start)));
                    else Inicio.conexiones.add(new Arco(Final,partes[2],""));
                }
            }

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
