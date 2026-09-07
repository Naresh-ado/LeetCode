class Solution {
    public String minWindow(String s, String t) 
    {
        if(t.length() == 0)return "";
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        HashMap<Character,Integer> need = new HashMap<>();
        HashMap<Character,Integer> window = new HashMap<>();
        for(char ch : t.toCharArray())
        {
            need.put(ch,need.getOrDefault(ch,0) + 1);
        }
        int formed = 0;
        int required = need.size();
        for(int right = 0;right<s.length();right++)
        {
            char ch = s.charAt(right);
            window.put(ch,window.getOrDefault(ch,0) + 1);
            if (need.containsKey(ch) && window.get(ch).equals(need.get(ch))) 
            {
                formed++;
            }
            while(formed == required)
            {
                if (right - left + 1 < minLen)
                {
                    minLen = right - left + 1;
                    start = left;
                }

                char leftchar = s.charAt(left);
                window.put(leftchar,window.get(leftchar) - 1);
                if(need.containsKey(leftchar) && window.get(leftchar) < need.get(leftchar))
                {
                    formed--;
                }
                left++;
            }

        }
        if(minLen == Integer.MAX_VALUE)return  "";
        return s.substring(start,start+minLen);
        
    }
}