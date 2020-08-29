public class InsertionSort
{
    public int[] insertionSort(int[] list){
        int j, temp, ult;  
        for(int i = 1; i <list.length; i++){ // c1+c2n
            temp = list[i]; //c3n
            j = i-1; //c4n
            while(j>=0 && list[j]>temp){ // (c5+c6n)n
                list[j+1] = list[j]; // c7n^2
                j--;  //c8n^2
            }
            list[j+1] = temp; //c9n
        }
        return list; //c10  
    }   // T(n) = c1+c2n+c3n+c4n+c5n+c6n^2+c7n^2+c8n^2+c9n^2+c10 es 0(n^2)                
    
}
