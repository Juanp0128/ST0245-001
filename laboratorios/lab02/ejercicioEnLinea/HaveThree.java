public class HaveThree
{
public boolean haveThree(int[] nums) {
  int cont = 0;
  boolean siono = false;
  for(int i = 0; i<nums.length;i++){
    if(nums[i]==3 ){
      cont++;
      i++;
    }
    if(cont==3 && cont<=3) siono=true;
    else siono=false;
  }
  return siono;
}

}
