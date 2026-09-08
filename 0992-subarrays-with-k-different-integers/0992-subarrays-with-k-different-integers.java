class Solution {
    int atMost(int[] nums, int k)
    {
        int left = 0;
        int count = 0;
        HashMap<Integer,Integer> window = new HashMap<>();
        for(int right= 0;right<nums.length;right++)
        {
            int num = nums[right];
            window.put(num,window.getOrDefault(num,0) + 1);
            while(window.size() > k)
            {
                int leftn = nums[left];
                window.put(leftn , window.get(leftn) - 1);
                if(window.get(leftn) == 0)
                {
                    window.remove(leftn);
                }
                left++;

            }
            //after the while loop i now have a vlaid subarray from this i need to find how many subarray can i form
            //now i have a subarray that as a whole has k distict elem but now i need to find subarrays of subarrays from that that have exactly  distinct elements
            count+= right - left + 1;
        }
        return count;
        
    }
    public int subarraysWithKDistinct(int[] nums, int k) 
    {
        int atmostKdis = atMost(nums,k);
        int atmostKInvalid = atMost(nums,k-1);
        return atmostKdis - atmostKInvalid;
    }
}