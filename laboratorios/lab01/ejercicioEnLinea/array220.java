/**@Author Juan Pablo Henao
public class array220
{
     public boolean array220(int[] nums, int index) {
      if(index >= nums.length-1){
      return false;
    } 
     if(nums[index+1]==nums[index]*10){
     return true;
    }
     return array220(nums, index+1);
    }
}
