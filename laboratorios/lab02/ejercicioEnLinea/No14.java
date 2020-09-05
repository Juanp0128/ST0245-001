public class No14
{
    public boolean no14(int[] nums) {
     boolean siono = false;
     boolean siono2 = false;
     for(int i = 0; i < nums.length; i++){
       if(nums[i] == 1){
         siono = true;
       }
       if(nums[i] == 4){
         siono2 = true;
       }
     }
     if(siono && siono2){
        return false;
      } else return true;
} 
}
