package Taller4;
//Juan Pablo Henao B, Diego Vanegas
public class Taller4 {
    public static int arrayMax(int[] array, int i) {
    return arrayMax(array,0,-99999);
    }

    private static int arrayMax(int[] array, int i, int max) {
        if(array.length-1 == i) return max;
        if(array[i]>max)return arrayMax(array,i+1,array[i]);
           else
               return arrayMax(array,i+1,max);
    }

    public static boolean groupSum(int[] nums,int target) {
        return groupSum(0, nums, target);
    }

    public static boolean groupSum(int start, int[] nums, int target) {
        if (start>= nums.length)
            return target == 0;
        else
        return groupSum(start+1,nums,target)||
                groupSum(start + 1, nums, target - nums[start]);

    }

    public static long fibonacci(int n) {
        if (n==0) return  0;
        if (n == 1)
            return 1;
        else
            return fibonacci(n-1) + fibonacci(n-2);
    }
}
