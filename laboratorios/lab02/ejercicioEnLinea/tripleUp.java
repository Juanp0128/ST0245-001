public class TripleUp
{
  public boolean tripleUp(int[] nums) {
  boolean siono = false;
  int n = 0;
  for(int i = 0; i < nums.length-2; i++){
     n=nums[i];
     if(nums[i+1]==n+1 && nums[i+2]==n+2){
       siono=true;
     }
  }
  return siono;
}
}
