public class Punto {
    private double x;
    private double y;

    public Punto(double x, double y){
        this.x = x;
        this.y = y;
    }
    public double x(){
        return this.x;
    }

    public double y(){
        return this.y;
    }

    public double radioPolar(){
        return Math.sqrt(x*x+y*y);

    }
    public double anguloPolar(){
        return Math.atan2(y,x);

    }
    public double distanciaEuclidiana(Punto otro){
        return Math.sqrt(Math.pow(this.x-otro.x,2)+Math.pow(this.y-otro.y,2));
    }
}
