public class Has77
{
    public boolean has77(int[] nums) {
  boolean siono = false;
  for(int i = 0; i < nums.length-1; i++){
    if(nums[i] == 7 && nums[i+1] == 7){
    siono = true;
  }
  }
  for(int i = 0; i < nums.length-2; i++){
    if(nums[i] == 7 && nums[i+2] == 7){
    siono = true;
  }
  }
  return siono;
}

}
