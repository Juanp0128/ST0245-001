public class Test3 {
    public static void ejercicio1() {
        TorresHanoi.torresDeHanoi(2);
        TorresHanoi.torresDeHanoi(3);
        TorresHanoi.torresDeHanoi(4);
    }


    public static void ejercicio2() {
        Permutation.permutation("abc");
        Permutation.permutation("Eafit");
        Permutation.permutation("Hola");
        Permutation.permutation("H, Hi, i");
    }

    public static void main(String[] args) {
        System.out.println("");
        System.out.println("Ejercicio 1");
        ejercicio1();

        System.out.println("");
        System.out.println("Ejercicio 2");
        ejercicio2();
    }
}
