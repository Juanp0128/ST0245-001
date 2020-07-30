public class Fechas {
    private final int dia;
    private final int mes;
    private final int anio;

    public Fechas(int dia, int mes, int anio) {
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }

    public int dia(){
        return this.dia;
    }
    public int mes(){
        return this.mes;
    }
    public int anio(){
        return this.anio;
    }
    public int comparar(Fechas otra){
        if (this.anio<otra.anio)
            return -1;
        if(this.anio>otra.anio)
            return 1;
        if (this.mes<otra.mes)
            return -1;
        if(this.mes>otra.mes)
            return 1;
        if (this.dia<otra.dia)
            return -1;
        if(this.dia>otra.dia)
            return 1;

        return 0;
    }

    @Override
    public String toString() {
        return "Fechas: \n" +
                "dia: " + dia +
                "\nmes: " + mes +
                "\naño: " + anio;
    }
}

