package Proyectoo;
//Juan Pablo Henao, Diego Vanegas
public class Gini {
    private String variable;
    private String value;
    private int yesNode1;
    private int yesNode0;
    private int noNode1;
    private int noNode0;
    private float index;

    public Gini(String variable, String value) {
        this.variable = variable;
        this.value = value;
        this.yesNode1 = 0;
        this.yesNode0 = 0;
        this.noNode1 = 0;
        this.noNode0 = 0;
        this.index = 5000;
    }

    public String getVariable() {
        return variable;
    }

    public String getValue() {
        return value;
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

    public void impurezaGini(){
        float allyes = yesNode0+yesNode1;
        float allno= noNode0+noNode1;
        float V0yes, V1yes,V0no,V1no,ginisi,ginino,giniV;

        V0yes = yesNode0/allyes;
        V1yes = yesNode1/allyes;
        V0no = noNode0/allno;
        V1no = noNode1/allno;
        ginisi = 1-((V0yes*V0yes)+(V1yes*V1yes));
        ginino = 1-((V0no*V0no)+(V1no*V1no));
        giniV= ((allno*ginino)+(allyes*ginisi))/(allno+allyes);
        this.index=giniV;

        System.out.println(variable+"="+value+"Impureza Gini: "+giniV);
    }
    public float getIndex() {
        return index;
    }
}
