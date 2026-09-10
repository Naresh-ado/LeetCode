class Solution {
    public int longestConsecutive(int[] nums) 
    {
        HashSet<Integer> set = new HashSet<>();
        for(int x : nums)
        {
            set.add(x);
        }
        int longest = 0;
        for(int x : set)
        {
            if(!set.contains(x-1)) // verifies x is the begining 
            {
                int count = 1;
                int num = x;
                while(set.contains(num+1))
                {
                    count++;
                    num++;

                }
                longest = Math.max(longest,count);

            }
        }
        return longest;
       /*
       This is  a waste methos this only counts does every numsber contains x+1 but we need to find the longets consecutive one
        HashSet<Integer> map = new HashSet<>();
        for(int x : nums)
        {
            map.add(x);
        }
        int count = 0;
        for(int x : nums)
        {
            if(map.contains(x+1))
            {
                count++;
            }
        }
        return count;
        */
        
    }
}