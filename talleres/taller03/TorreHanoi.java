public class TorreHannoi

{
    public static void torresDeHannoi(int n) {
		Hanoi(n, 1, 2, 3);
	}
	
    public static void Hanoi(int num, int S, int M, int E){
        if(num == 1){
            System.out.println("Mover " + S + " a la Torre " + E);
        }
        else {
            Hanoi(num-1, S, E, M);
            System.out.println("Mover " + S + " a la Torre " + E);
            Hanoi(num-1, M, S, E);
        }
    }
}
