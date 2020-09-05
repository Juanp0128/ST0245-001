package Laboratorios;
import java.util.Arrays;
//Juan Pablo Henao, David Vanegas
public class Lab02 {
    public static void InsertionSort(int[] A)
    { for (int i=0;i<A.length;i++){
        for (int z=i;z>0;z--){
            if (A[z]<A[z-1]){
                int temp=A[z];
                A[z]=A[z-1];
                A[z-1]=temp;
            }else break;
        }
    }
        System.out.println(Arrays.toString(A));
    }
    public static void mergeSort(int [ ] a)
    {
        int[] tmp = new int[a.length];
        mergeSort(a,  0,  a.length - 1);
    }

    private static void mergeSort(int [ ] a,int left, int right)
    {if (left<right){
        int n=(left+right)/2;
        mergeSort(a,left,n);
        mergeSort(a,n+1,right);
        merge(a,left,n,right);
    }
    }

    private static void merge(int[] a, int left, int right, int rightEnd ) {
        int n1 = right - left + 1;
        int n2 = rightEnd - right;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = a[left + i];
        for (int z = 0; z < n2; z++)
            R[z] = a[right + 1 + z];
        int i = 0, z = 0;
        int k = left;
        while (i < n1 && z < n2) {
            if (L[i] <= R[z]) {
                a[k] = L[i];
                i++;
            }else{
            a[k] = R[z];
            z++;
        }
        k++;
    }
        while (i<n1){
            a[k]=L[i];
            i++;
            k++;
        }
        while (z<n2){
            a[k]=R[z];
            z++;
            k++;
        }
    }

    public static void main(String[] args)
    {
        int[] A = {1,5,3,2,6};
        int[] B = {1,5,3,2};
        int[] C = {1,5,2,6};
        int[][] Arrays = {A,B,C};
        for (int[] X : Arrays)
        {
            Lab02.mergeSort(X);
            Lab02.InsertionSort(X);
        }
    }
}
