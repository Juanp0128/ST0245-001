package Proyectoo;
import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;

public class LeerCSV {
    public static final String PuntoYComa = ";";
    public static final String QUOTE = "\"";
    public static String Doc = "0_test_balanced_5000.csv";
    public static String Doc2 = "0_train_balanced_15000.csv";

    private static ArrayList<String[]> cargarCSV(String dir) {
        ArrayList<String[]> cargar = new ArrayList<>();
    /*  try {
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\juanp\\IdeaProjects\\ProyectoDatos1\\"+dir), "utf-8"));
            String linee;
            int IFiles = 0;
            while ((linee = in.readLine()) != null) {
                String PLinee[] = linee.split(";");
                if (IFiles != 0) {
                    String columns[] = new String[31];
                    int IColumns = 0;
                    for (int i = 0; i < PLinee.length; i++) {
                        if (proveV(i)) {
                            if ((i > 64 && i < 73))
                                columns[IColumns] = Nota(PLinee[i]);
                            else if (PLinee[i].isEmpty())
                                columns[IColumns] = "*";
                            else
                                columns[IColumns] = PLinee[i];
                            IColumns++;
                        }
                    }
                    cargar.add(columns);
                } else {
                    cargar.add(PLinee);
                }
                IFiles++;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return cargar;
    }*/


       BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(Doc));
            String line = br.readLine();
            br = new BufferedReader(new FileReader(Doc2));
            String lined = br.readLine();
            while (null != line) {
                String[] campos = line.split(PuntoYComa);
                campos = removeTrailingQuotes(campos);
                line = br.readLine();
                cargar.add(campos);
            }
            br.close();
            while (null != lined) {
                String[] campos = lined.split(PuntoYComa);
                campos = removeTrailingQuotes(campos);
                lined = br.readLine();
                cargar.add(campos);
            }
            br.close();

        } catch (Exception e) {
            System.err.println("Error! " + e.getMessage());
        }
        for (int i = 0; i < cargar.size(); i++) {
            String[] car = cargar.get(i);

        }
        return cargar;

    }


    private static String[] removeTrailingQuotes(String[] campos) {
        String result[] = new String[campos.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = campos[i].replaceAll("^" + QUOTE, "").replaceAll(QUOTE + "$", "");
        }
        return result;
    }


    private static Tree[] AddTreesV(ArrayList<String[]>data){
        String[] lines = data.remove(0);
        Tree[] trees = new Tree[30];
        int x=0;
        for (int i=0;i<lines.length;i++){
            if (i!=lines.length-1&&proveV(i)){
                trees[x]= new Tree(lines[i],x);
                x++;
            }
        }
        return trees;
    }
    //Inicializa todos los metodos 
    public static Roots start(String dir) {
        ArrayList<String[]>data= cargarCSV(dir);
        Tree trees[] = AddTreesV(data);
        HashSet<String> alreadyV = new HashSet<>();
        govalues(data,alreadyV,trees);
        counting(data,alreadyV,trees);
        bestGini(trees);
        Gini gini = bestGini(trees);
        Roots roots = new Roots();
        roots.root=new Node(gini);
        alreadyV.add(gini.getVariable()+gini.getValue());
        newTree(data,alreadyV,roots.root,trees);
        return roots;


    }
    
    private static boolean govalues(ArrayList<String[]>data, HashSet<String>valued,Tree[]trees){
        int temp=0;
        for (String[]h:data){
            int i=0;
            String finished = h[30];
            for (String column: h){
                if (i!=30){
                    if (!(finished.contains(trees[i].getName()+column))){
                        trees[i].addVariable(column);
                        temp++;
                    }
                }
                i++;
            }
        }
        if (temp==0)return false;
        for (Tree tree:trees){
            tree.FillVariables();
        }
        return true;
    }
    //Permite Crear un nuevo arbol
    public static void newTree(ArrayList<String[]>data, HashSet<String> alreadyV,Node node, Tree[] trees) {
        final int TotalValues = 198;
        ArrayList<String[]> Yes = new ArrayList<>();
        ArrayList<String[]> No = new ArrayList<>();

        for (String [] files : data)
            if (files[node.gini.getAux()].equals(node.gini.getValue()))
                Yes.add(files);
            else No.add(files);
        if (No.size() < 10) {
            int aux = Biggest(No);
            if (aux == 1) node.left = new Node(new Gini("1", "Center", -1));
            else node.left = new Node(new Gini("0", "Center", -1));
        }
        if (Yes.size() < 10) {
            int aux = Biggest(Yes);
            if (aux == 1) node.right = new Node(new Gini("1", "Center", -1));
            else node.right = new Node(new Gini("0", "Center", -1));
        }
        Tree treeYes[] = new Tree[30];
        Tree treeNo[] = new Tree[30];
        HashSet<String> alreadyVYES = new HashSet<>();
        HashSet<String> alreadyVNO = new HashSet<>();
        for (int i = 0; i < trees.length; i++) {
            treeNo[i] = new Tree(trees[i].getName(), i);
            treeYes[i] = new Tree(trees[i].getName(), i);
        }
        for (String alreadyBro : alreadyV) {
            alreadyVYES.add(alreadyBro);
            alreadyVNO.add(alreadyBro);
        }
        if (node.left == null || !node.right.gini.getVariable().equals("Center")) {
            if (!govalues(Yes, alreadyVYES, treeYes)) {
                int aux = Biggest(Yes);
                if (aux == 1) node.right = new Node(new Gini("1", "Center", -1));
                else node.right = new Node(new Gini("0", "Center", -1));

            } else {
                counting(Yes, alreadyVYES, treeYes);
                Gini gini = bestGini(treeYes);
                calculateG(treeYes);
                alreadyVYES.add(gini.getVariable() + gini.getValue());
                if (alreadyVYES.size() == TotalValues) {
                    int aux = Biggest(Yes);
                    if (aux == 1) node.right = new Node(new Gini("1", "Center", -1));
                    else node.right = new Node(new Gini("0", "Center", -1));
                } else if (same(Yes)) {
                    if (Yes.get(0)[30].equals("1")) node.right = new Node(new Gini("1", "Center", -1));
                    else node.right = new Node(new Gini("0", "Center", -1));
                } else {
                    node.right = new Node(gini);
                    newTree(Yes, alreadyVYES, node.right, treeYes);
                }
            }
        }

        if (node.left == null || !node.left.gini.getVariable().equals("Center")) {
            if (!govalues(No, alreadyVNO, treeNo)) {
                int aux = Biggest(No);
                if (aux == 1) node.left = new Node(new Gini("1", "Center", -1));
                else node.left = new Node(new Gini("0", "Center", -1));

            } else {
                counting(No, alreadyVNO, treeNo);
                Gini gini = bestGini(treeNo);
                calculateG(treeNo);
                alreadyVNO.add(gini.getVariable() + gini.getValue());
                if (alreadyVNO.size() == TotalValues) {
                    int aux = Biggest(No);
                    if (aux == 1) node.left = new Node(new Gini("1", "Center", -1));
                    else node.left = new Node(new Gini("0", "Center", -1));
                } else if (same(No)) {
                    if (No.get(0)[30].equals("1")) node.left = new Node(new Gini("1", "Center", -1));
                    else node.left = new Node(new Gini("0", "Center", -1));
                } else {
                    node.left = new Node(gini);
                    newTree(No, alreadyVNO, node.left, treeNo);
                }
            }
        }

    }
    //Comprueba su los datos son iguales
    public static boolean same(ArrayList<String[]>data){
        String i=data.get(0)[30];
        for (String[]files:data){
            if (!files[30].equals(i))
                return false;
        }
        return true;
    }

//Halla la mejor impureza
    private static Gini bestGini(Tree[] trees){
        Gini value = new Gini("","",-1);
        for (Tree tri:trees){
            for (Gini gini: tri.getAllvariables()){
                if (value.getIndex()>gini.getIndex()){
                    value = gini;
                }

            }
        }
        return value;
    }
// Ejecuta el test
    public static double[] executable(String dir,Roots roots) {
        ArrayList<String[]>data = cargarCSV(dir);
        int Perfect = 0;
        int NoPerfect= 0;
        double percents[]=new double[2];
        for (String[]file:data){
            String finished = completed(file,roots.root);
            if (finished.equals(file[30]))
                Perfect++;
            else NoPerfect++;
        }
        percents[0]=(Perfect*100)/data.size();
        percents[1]=(NoPerfect*100)/data.size();
        return percents;
        }

// Analiza cual valor se repite mas
    public static int Biggest(ArrayList<String []>data){
        int B1 = 0;
        int B2 = 0;
        for (String[] files : data){
            if (files[30].equals("1"))
                B1++;
            else
                B2++;
        }
        if (B1>B2)
            return 1;
        else
            return 0;
    }
//Hace un conteo de ginis
    private static void counting(ArrayList<String[]>data, HashSet<String>alreadyV,Tree[]trees){
        int x = 0;
        for (String[] file: data){
            int y=0;
            for (String column: file){
                if (y!=30){
                    Gini[] ginis = trees[y].getAllvariables();
                    String finalV = file[30];
                    for (int i=0;i<ginis.length;i++){
                        if (!(alreadyV.contains(trees[y].getName()+column))){
                            if (column.equals(ginis[i].getValue())){
                                if (finalV.equals(("1"))){
                                    ginis[i].getYesNode1();
                                }else {
                                    ginis[i].getYesNode0();
                                }
                            }else {
                                if (finalV.equals("1")){
                                    ginis[i].getNoNode1();
                                }else{
                                    ginis[i].getNoNode0();
                                }
                            }
                        }
                    }
                }y++;
            }x++;
        }
    }
//Recorre el arbol
    public static String completed(String[]file,Node node){
    if (node.gini.getVariable().equals("Center"))return node.gini.getValue();
    if (file[node.gini.getAux()].equals(node.gini.getValue())){
        return completed(file,node.right);
        }else{
        return completed(file,node.left);
        }
    }
    //Calcula la impureza del arbol
    private static void calculateG(Tree[] trees){
        for (Tree tri:trees){
            for (Gini gini: tri.getAllvariables()){
                gini.impurezaGini();
            }
        }
    }
}

