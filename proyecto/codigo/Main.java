package Proyectoo;

public class Main {
    public static void Exes(String EXE, String exeT) {
        long time = System.currentTimeMillis();
        Roots roots = LeerCSV.start(EXE);
        System.out.println("Lectura Finalizada");
        System.out.println("Memory MB: "+(double)((Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory())/1024)/1024);
        long total = System.currentTimeMillis()-time;
        long timeG = System.currentTimeMillis();
        System.out.println(total);
       double percents[] = LeerCSV.executable(exeT,roots);
        long totalG = System.currentTimeMillis()-timeG;
        System.out.println("Ejecutable 1: "+total+"\nEjecutable 2: "+totalG);
        System.out.println("Percent 1: "+percents[0]+" of Perfection");
        System.out.println("Percent 2: "+percents[1]+" of Fail");
       System.out.println("General Percent: "+Math.abs(100-(percents[1]+percents[0]))+" of FAIL range");

    }

    public static void main(String[] args){
        Exes("0_test_balanced_5000.csv","0_train_balanced_15000.csv");

    }
}
