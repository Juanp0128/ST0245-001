Package Tall6;
//Juan Pablo Henao, Diego Vanegas
import java.util.Arrays;

public class MyArrayList {
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    private int array[];

    public void MiArrayLis() {
        array = new int[DEFAULT_CAPACITY];
        size = 0;
        System.out.println(Arrays.toString(array));
    }

    public int size() {
        return size;
    }

    public void add(int e) {
        if (size==array.length) {
            int[] otroArreglo = new int[array.length * 2];
            for (int i = 0; i < array.length; i++)
                otroArreglo[i] = array[i];
              array = otroArreglo;
        }
        array[size]=e;
        size++;
    }

    public int get(int i) throws Exception {
        if (i >= size || i < 0)
            throw new Exception("index: "+i);
        return array[i];
    }

    public void add(int index, int e)throws Exception {
        if (index > size || index < 0)
            throw new Exception("index:" + index);

            int[] copyArray;
            if (size == array.length)
                copyArray = new int[array.length * 2];
            else
                copyArray = new int[array.length];

            for (int i = 0; i < index; i++) {
                copyArray[i] = array[i];
            }
            copyArray[index] = e;
            for (int i = index; i < copyArray.length; i++) {
                copyArray[i + 1] = array[i];
            }
            size++;
            array = copyArray;
        }


    private void extend() {
        int [] array2 =  new int[array.length + 1];
        for (int i = 0; i < size; i++) {
            array2[i] = array[i];
        }
        array = array2;
    }

    public void del(int index)throws Exception{
        if (index>=size||index<0)
            throw new Exception("index: "+index);
        int[] copyArray=new int[array.length];
        boolean tem=false;

        for (int i=0;i<size;i++){
            if (i==index)
                tem=true;
            if (i==size-1)
                copyArray[i]=0;
            else if (tem)
                copyArray[i]=array[i+1];
            else copyArray[i]=array[i];
        }
        array=copyArray;
        size--;
    }
}
