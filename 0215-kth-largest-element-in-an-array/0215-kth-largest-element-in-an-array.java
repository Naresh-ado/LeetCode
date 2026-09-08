class Solution {

   
    public int findKthLargest(int[] nums, int k) 
    {
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        for(int x : nums)
        {
            max.offer(x);
        }

        for(int i=1;i<k;i++)//starts from 1 because there are only k-1 removal not k removal
        {
            max.poll();
        }

        return max.peek();
        /*PriorityQueue<Integer> min = new PriorityQueue<>();
        for(int x : nums)
        {
            min.offer(x);
            if(min.size() > k)
            {
                min.poll();
            }

        }
        return min.peek();
         31ms we cna use a max heap for this 
        Arrays.sort(nums);
        return nums[nums.length - k];
         */
    }
}