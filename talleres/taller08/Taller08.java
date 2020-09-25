package Tall8;
import java.util.*;
//Juan Pablo Henao, Diego Vanegas
    public class Taller08{

        public static int polaca  (String string){
            String[] prefixStr = string.split(" ");
            Stack<Integer> stack = new Stack<>();

            for(int i=0;i<prefixStr.length;i++){
                if(prefixStr[i].equals("+")){
                    stack.push(stack.pop()+ stack.pop());
                }
                else if(prefixStr[i].equals("*")){
                    stack.push(stack.pop()*stack.pop());
                }
                else if(prefixStr[i].equals("-")){
                    stack.push(-1*stack.pop()+stack.pop());
                }
                else if(prefixStr[i].equals("/")){
                    stack.push(stack.pop() / stack.pop());
                }
                else{
                    stack.push(Integer.parseInt(prefixStr[i]));
                }
            }
            return stack.pop();
        }

        /**
         *
         *  posición de una pila si no que tambien devuelve su valor.
         * @return una pila que aga el inverso de sta ck
         */
        public static Stack<Integer> inversa (Stack stack){
            int n = stack.size();
            Stack<Integer> temp = new Stack<Integer>();
            for(int i = 0; i < n; i++)
                temp.push(stack.size());
            return temp;
        }
        
        /**
         * @param queue es una cola ya implementada que se crea en el test
         * Este método se encarga de atender a personas.
         * Nota: Se debe imprimir en consola a quién atiende y sacarlo de la cola
         * existe una función "pull" que hace el trabajo más fácil
         * 
         */
        public static void cola(Queue<String> queue){
          while(queue.peek()!= null)    
            System.out.println("Atendiendo a " + queue.poll());
       }
    }
