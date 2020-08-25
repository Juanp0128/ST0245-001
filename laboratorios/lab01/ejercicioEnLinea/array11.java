//@Author Juan Pablo Henao, Diego Alejandro Vanegas
public class array11
{
    public int array11(int[] nums, int index) {
    int cont = 0;
    if(index >= nums.length){
    return 0;
    }
    if(nums[index]==11){
     cont++;
      return cont+array11(nums, index+1); 
    }
     else return array11(nums, index+1);
   }
}
