//@Author Juan Pablo Henao, Diego Alejandro Vanegas
public class splitArray
{
    public boolean splitArray(int[] nums) {
     return helper(0, nums, 0, 0);
    }

    public boolean helper(int start, int[] nums, int sum1, int sum2){
      if(start>= nums.length){
        return sum1==sum2;
      }
    int value = nums[start];
      return (helper(start+1, nums, sum1+value, sum2) 
     || helper(start+1, nums, sum1, sum2+value));
    }
}
