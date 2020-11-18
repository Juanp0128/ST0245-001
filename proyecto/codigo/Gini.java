package Proyectoo;

import java.util.TreeSet;

//Juan Pablo Henao, Diego Vanegas
public class Gini {
    private String variable;
    private String value;
    private int yesNode1;
    private int yesNode0;
    private int noNode1;
    private int noNode0;
    private float index;
    private int aux;

    public Gini(String variable, String value,int aux) {
        this.variable = variable;
        this.value = value;
        this.yesNode1 = 0;
        this.yesNode0 = 0;
        this.noNode1 = 0;
        this.noNode0 = 0;
        this.index = 9999999;
        this.aux = aux;
    }

    public String getVariable() {
        return variable;
    }

    public String getValue() {
        return value;
    }
    public int getAux(){
        return this.aux;
    }

    public void getYesNode1() {
        yesNode1++;
    }

    public void getYesNode0() {
        yesNode0++;
    }

    public void getNoNode1() {
        noNode1++;
    }

    public void getNoNode0() {
        noNode0++;
    }

    public void impurezaGini() {
        float allyes = yesNode0 + yesNode1;
        float allno = noNode0 + noNode1;
        if (allyes==0||allno==0){
            this.index=0;
            return;
        }
        float V0yes, V1yes, V0no, V1no, ginisi, ginino, giniV;

        V0yes = yesNode0 / allyes;
        V1yes = yesNode1 / allyes;
        V0no = noNode0 / allno;
        V1no = noNode1 / allno;
        ginisi = 1 - ((V0yes * V0yes) + (V1yes * V1yes));
        ginino = 1 - ((V0no * V0no) + (V1no * V1no));
        giniV = ((allno * ginino) + (allyes * ginisi)) / (allno + allyes);
        this.index = giniV;

       // System.out.println(variable + "=" + value + "Impureza Gini: " + giniV);
    }

   public static TreeSet<String> valueSet(String[][] matrix, int pos) {
        TreeSet<String> values = new TreeSet<String>();
        for (int i = 0; i < matrix.length; i++) {
            values.add(matrix[i][pos]);
        }
        return values;
    }
//Se implementa un algoritmo distinto para analizar cual es mas eficiente
    public static float academicGini(int pos, String[][] matrix, String value) {
        float ganaRight = 0;
        float ganaLeft = 0;
        float pierdeRight = 0;
        float pierdeLeft = 0;
        float left = 0;
        float right = 0;
        if (Numerico(matrix[1][pos])) {
            for (int i = 0; i < matrix.length; i++) {
                if (Double.parseDouble(matrix[i][pos]) >= Double.parseDouble(value)) {
                    left++;
                    if (matrix[i][matrix[0].length - 1].equals("0")) {
                        pierdeLeft++;
                    } else {
                        ganaLeft++;
                    }

                } else {
                    right++;
                    if (matrix[i][matrix[0].length - 1].equals("0")) {
                        pierdeRight++;
                    } else {
                        ganaRight++;
                    }
                }
            }
        } else {
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][pos].equals(value)) {
                    left++;
                    if (matrix[i][matrix[0].length - 1].equals("0")) {
                        pierdeLeft++;
                    } else {
                        ganaLeft++;
                    }
                } else {
                    right++;
                    if (matrix[i][matrix[0].length - 1].equals("0")) {
                        pierdeRight++;
                    } else {
                        ganaRight++;
                    }
                }
            }
        }
        if (right == 0) {
            return (float) ((float) 1 - (Math.pow(pierdeLeft / left, 2) + (Math.pow(ganaLeft / left, 2))));
        } else if (left == 0) {
            return (float) ((float) 1 - (Math.pow(pierdeRight / right, 2) + (Math.pow(ganaRight / right, 2))));
        } else {
            float academicLeft = (float) ((float) 1 - (Math.pow(pierdeLeft / left, 2) + (Math.pow(ganaLeft / left, 2))));
            float academicRight = (float) ((float) 1 - (Math.pow(pierdeRight / right, 2) + (Math.pow(ganaRight / right, 2))));
            float academicPon = (float) (((academicLeft * left) + (academicRight * right)) / (right + left));
            return academicPon;
        }
    }

    public static boolean Numerico(String num){
        if (num==null){
            return false;
        }
        try {
            double n = Double.parseDouble(num);
        }catch (NumberFormatException FFF){
            return false;
        }
        return true;
    }

   public float getIndex() {
        return this.index;
    }
}

