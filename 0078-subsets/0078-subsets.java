class Solution {
    public List<List<Integer>> subsets(int[] nums)
    {
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        int ptr = 0;
        for(int i=0;i<nums.length;i++)
        {
            int len = list.size();
            for(int j=0;j<len;j++)
            {
                List<Integer> sol = new ArrayList<>(list.get(j));
                sol.add(nums[i]);
                list.add(sol);
            }

        }

        return list;
        
    }
}