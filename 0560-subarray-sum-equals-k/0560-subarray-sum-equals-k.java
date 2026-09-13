class Solution {
    public int subarraySum(int[] nums, int k) 
    {
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0,1);
        int count= 0;
        for(int x : nums)
        {
            sum += x;
            int target = sum - k;
            if(map.containsKey(target))
            {
                count += map.get(target);
            }
            map.put(sum,map.getOrDefault(sum,0) + 1);
        }
        return count;
        
    }
}