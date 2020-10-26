package Taller11;
//Juan Pablo Henao, Diego Vanegas
public class Taller11 {
    public static void main(String[] args) {
        DiagraphAL diaL = new DiagraphAL(6);
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


        DiagraphAM diaM = new DiagraphAM(6);
        diaM.addArc(10,0,1);
        diaM.addArc(20,6,3);
        diaM.addArc(30,5,2);
        diaM.addArc(40,5,1);
        diaM.addArc(50,3,4);
        diaM.addArc(60,2,0);
        diaM.addArc(70,2,1);
        diaM.addArc(80,4,1);
        diaM.addArc(90,3,0);

        System.out.println(diaM.getWeight(4,1));
        System.out.println(diaM.getSuccessors(6));
    }
}
