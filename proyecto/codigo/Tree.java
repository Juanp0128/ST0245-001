package Proyectoo;
import java.util.*;
//Juan Pablo Henao,Diego Vanegas
public class Tree {
    private String name;
    private TreeSet<String> variableCollector = new TreeSet<String>();
    private Gini [] Allvariables;
    int i;

    public Tree(String name,int i){
        this.name = name;
        this.i = i;
    }


    public void addVariable(String Variable) {
        variableCollector.add(Variable);
    }

    public String getName(){
        return name;
    }

    public void FillVariables(){
        Allvariables = new Gini[variableCollector.size()];
        int i=0;
        for (String V:variableCollector) {
            Allvariables[i]=new Gini(V,name,i);
            i++;
        }
    }
    public Gini[] getAllvariables() {
        return Allvariables;
    }
}
