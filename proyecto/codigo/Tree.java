package Proyectoo;
import java.util.*;
//Juan Pablo Henao,Diego Vanegas
public class Tree {
    private String name;
    private TreeSet<String> variableCollector = new TreeSet<String>();
    private Gini [] Allvariables;

    public Tree(String name) {
        this.name = name;
    }

    public void addVariable(String Variable) {
        this.variableCollector.add(Variable);
    }

    public Gini[] getAllvariables() {
        return Allvariables;
    }

    public void FillVariables(){
        Allvariables = new Gini[variableCollector.size()];
        int i=0;
        for (String V:variableCollector) {
            Allvariables[i]=new Gini(V,name);
            i++;
        }
    }
}
