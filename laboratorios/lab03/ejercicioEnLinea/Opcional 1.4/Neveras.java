package Laboratorio3OPC;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;
public class Neveras {
    public static void main(String[] args) {
    Almacenadas();
}

    public static void Almacenadas() {
        Scanner in = new Scanner(System.in);
        Stack almacen = new Stack();
        LinkedList<Solicitud> queue = new LinkedList<>();

        System.out.print("Cantidad de neveras en almacén: ");
        int neveras_totales = Integer.parseInt(in.nextLine());

        for(int i = 1; i <= neveras_totales; i++) {
            String desc;
            switch((int)(Math.random()*5 + 1)) {
                case 1:
                    desc = "Estado Excelente";
                    break;
                case 2:
                    desc = "Puerta Grande";
                    break;
                case 3:
                    desc = "Blanca";
                    break;
                case 4:
                    desc = "Con Anti-Frost";
                    break;
                default:
                    desc = "Sencilla";
                    break;
            }
            almacen.add(new Nevera(i, desc));
        }

        System.out.print("Cantidad de solicitudes: ");
        int n = Integer.parseInt(in.nextLine());

        for(int i = 1; i <= n; i++) {
            System.out.print("Tienda " + i + ": ");
            String store = in.nextLine();
            System.out.print("Cantidad de neveras: ");
            int id = Integer.parseInt(in.nextLine());
            queue.add(new Solicitud(id, store));
        }

        System.out.println();
        for(Solicitud s: queue) {
            for(int i = 0; i < s.cantidad_neveras; i++) {
                if(!almacen.isEmpty()) s.neveras.add((Nevera) (almacen.pop()));
                else s.neveras.add(new Nevera(0, "NO DISPONIBLE"));
            }
            System.out.println(s.toString());
        }
    }
}

class Nevera {
    int id;
    String description;

    public Nevera(int id, String description) {
        this.id = id;
        this.description = description;
    }
}

class Solicitud {
    int cantidad_neveras;
    String nombre_tienda;
    LinkedList<Nevera> neveras;

    public Solicitud(int n, String name) {
        cantidad_neveras = n;
        nombre_tienda = name;
        neveras = new LinkedList<>();
    }

    @Override
    public String toString() {
        String s = nombre_tienda + "\n";
        for(Nevera n : neveras) {
            s += n.id + " - " + n.description + "\n";
        }
        return s;
    }
}
