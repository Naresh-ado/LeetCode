class Solution {
    public int minSubArrayLen(int target, int[] nums) 
    {
        int minsum = Integer.MAX_VALUE;
        int left = 0;
        int currsum = 0;
        for(int right = 0;right<nums.length;right++)
        {
            currsum += nums[right];
            while(currsum >= target)
            {
                int len = right - left + 1;
                if(len < minsum)
                {
                    minsum = len;
                }
                currsum -= nums[left];
                left++;
            }
        }
        if(minsum == Integer.MAX_VALUE)return 0;
        return minsum;
    }
}