public class Only14
{
    public boolean only14(int[] nums) {
    boolean siono = true;
    for(int i = 0; i < nums.length; i++){
      if(nums[i] != 1 && nums[i] != 4 ){
        siono = false;
      }
    }
    return siono;
    }

}
