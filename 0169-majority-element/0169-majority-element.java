class Solution {
    public int majorityElement(int[] nums) 
    {
        //Using Boyre-Moore voting algorithm
        int count = 0;
        int candidate = 0;
        for(int x : nums)
        {
            if(count == 0)
            {
                candidate = x;
            }

            if(candidate == x)
            {
                count++;
            }
            else
            {
                count--;
            }
        }
        return candidate;
        /*
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int x : nums)
        {
            map.put(x,map.getOrDefault(x,0)+1);
        }
        int n = 0;
        for(int x : map.keySet())
        {
            if(map.get(x) > nums.length/2)
            {
                n = x;
            }
        }
        return n;
        */
    }
}