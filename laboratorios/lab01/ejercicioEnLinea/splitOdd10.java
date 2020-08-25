//@Author Juan Pablo Henao, Diego Alejandro Vanegas
public class splitOdd10
{
    public boolean splitOdd10(int[] nums) {
    return helper(0, nums, 0, 0);
    }
 
    private boolean helper(int start, int[] nums, int sum1, int sum2) {
    if (start >= nums.length)
    return sum1 % 10 == 0 && sum2 % 2 == 1 || sum1 % 2 == 1
                && sum2 % 10 == 0;
    return helper(start + 1, nums, sum1 + nums[start], sum2)
            || helper(start + 1, nums, sum1, sum2 + nums[start]);
}  
