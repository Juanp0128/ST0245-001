package Laboratorios;
//@autor Juan Pablo Henao, Diego Vanegas
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestLab01 {
    public static void ejercicio11(){
        String adn1,adn2;
        adn1=adn2="";
        String NFichero="AcipensertransmontanusmitochondrialDNA.txt";
        File fichero = new File(NFichero);
        Scanner scan = null;
        try{
            scan = new Scanner(fichero);
            adn1 = scan.next();
            adn2 = scan.next();
           // adn3 = scan.next();
        }catch (FileNotFoundException f){
            System.out.println(f);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            scan.close();
        }
        for (int i=10;i<40;i++){
            long c1 = System.currentTimeMillis();
            System.out.println("Adn1,Adn2: "+Lab01.lcsDNA(adn1.substring(0,i),adn2.substring(0,i)));
            Lab01.lcsDNA(adn1.substring(0,i),adn2.substring(0,i));
            long c2 = System.currentTimeMillis();
            System.out.println(c2-c1);
        }
    }
    public static void ejercicio12(){
        System.out.println("Para 1: "+Lab01.ways(1));
        System.out.println("Para 2: "+Lab01.ways(2));
        System.out.println("Para 5: "+Lab01.ways(5));
        System.out.println("Para 9: "+Lab01.ways(9));
        System.out.println("Para 15: "+Lab01.ways(15));
    }

    public static void main(String[] args) {
        ejercicio11();
        ejercicio12();
    }
}
