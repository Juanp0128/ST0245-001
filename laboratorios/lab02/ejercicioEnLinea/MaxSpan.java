public class MaxSpan
{
    public int maxSpan(int[] nums) {
  int n = 0;
  for(int i = 0; i<nums.length;i++){
    int j = nums.length-1;
     while(nums[i]!= nums[j]){
       j--;}
   if(n<j-i+1){
   n = j-i+1;
   }
  }
  return n;
}

}
