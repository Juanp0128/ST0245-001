//@Author Juan Pablo Henao, Diego Alejandro Vanegas
public class split53
{
    public boolean split53(int[] nums) {
    return helper(0, nums, 0, 0);
    }
   
   private boolean helper(int start, int[] nums, int sum1, int sum2) {
    if (start >= nums.length) return sum1 == sum2;
    if (nums[start] % 5 == 0)
        return helper(start + 1, nums, sum1 + nums[start], sum2);
    if (nums[start] % 3 == 0)
        return helper(start + 1, nums, sum1, sum2 + nums[start]);
 
    return helper(start + 1, nums, sum1 + nums[start], sum2)
            || helper(start + 1, nums, sum1, sum2 + nums[start]);
    }
}
