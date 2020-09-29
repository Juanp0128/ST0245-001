package Laboratorio03;

import java.util.LinkedList;

public class Conexion {
    String ID;
    String x;
    String y;
    String name;
    LinkedList<Arco> conexiones = new LinkedList<>();

    public Conexion(String ID, String x, String y, String name) {
        this.ID = ID;
        this.x = x;
        this.y = y;
        this.name = name;
    }
}
