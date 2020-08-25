//@Author Juan Pablo Henao, Diego Alejandro Vanegas
public class groupNoAdj
{
   public boolean groupNoAdj(int start, int[] nums, int target) {
  if (start >= nums.length)
  {
  return target == 0;
  }
  else
  {
  return groupNoAdj(start + 2, nums, target - nums[start]) ||
   groupNoAdj(start + 1, nums, target);
  }
}
}
