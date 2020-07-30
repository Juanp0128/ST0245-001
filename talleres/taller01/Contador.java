public class Contador {
    private int cuenta;
    private final String id;

    public Contador(String id){
        this.id = id;
        cuenta = 0;
    }
    public void incrementar(){
        cuenta++;
    }
    public int incrementos(){
        return cuenta;
    }
    @Override
    public String toString() {
        return "Contador: \n" +
                "cuenta: " + cuenta +
                "\nid: " + id;
    }
}
