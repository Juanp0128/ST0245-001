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
                    stack.push( stack.pop()-stack.pop());
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
