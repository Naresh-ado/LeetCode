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
        //Now at this step i will have an valid subarray with atmmost k distiict elements[1 2 1 2] Eg : k = 2
        //now from this i need to find subsub  arrays that at exactly k distinct elements [1 2] [2 1] [1 2 1] ... 
        //so we can now find the count of invalid subsub array from the valid subarray [1] [2] Invalid for k = 2
        //so subtracting total number of subarrays can be formed from valid subarray  - number of Invalid subarray gives exactly k distict subarrays count
        //for finding the invalid ones we can use the same logic but if we add k-1 in the while loop it will find the invalid less than k subarrays count
        int atmostKInvalid = atMost(nums,k-1);
        return atmostKdis - atmostKInvalid;
    }
}