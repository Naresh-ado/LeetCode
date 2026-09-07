class Solution {
    public int lengthOfLongestSubstring(String s) 
    {
        int maxsize = 0;
        int left = 0;
        HashMap<Character,Integer> window = new HashMap<>();
        for(int right = 0;right < s.length();right++)
        {
            char ch = s.charAt(right);
            window.put(ch,window.getOrDefault(ch,0) + 1);
            while(window.get(ch) > 1)
            {
                char lch = s.charAt(left);
                window.put(lch,window.get(lch) - 1);
                if(window.get(lch) == 0)
                {
                    window.remove(lch);
                }
                left++;
            }
            if(window.size() > maxsize)
            {
                maxsize = window.size();
            }

        }
        return maxsize;
        
    }
}