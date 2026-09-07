class Solution {
    public int lengthOfLongestSubstring(String s) 
    {

        int[] lastseen = new int[128];
        int left = 0;
        int maxsize = 0;
        for(int right = 0;right<s.length();right++)
        {
            char ch = s.charAt(right);
            left = Math.max(left,lastseen[ch]);
            maxsize = Math.max(maxsize,right - left + 1);

            lastseen[ch] = right + 1;
        }
        return maxsize;









        /* 

        Intead of when seen a duplicate removing the character one by one why can't if i known the index of that we can directly move to the next character after this can be done using HashMap or freq[] array since String consists if only char Array

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
        return maxsize; */
        
    }
}