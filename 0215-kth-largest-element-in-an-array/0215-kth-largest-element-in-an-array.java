class Solution {

   
    public int findKthLargest(int[] nums, int k) 
    {
        PriorityQueue<Integer> min = new PriorityQueue<>();
        for(int x : nums)
        {
            min.add(x);
            if(min.size() > k)
            {
                min.poll();
            }

        }
        return min.peek();
        /* 31ms we cna use a max heap for this 
        Arrays.sort(nums);
        return nums[nums.length - k];
         */
    }
}