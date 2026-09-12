class Solution {
    public List<Integer> findSubstring(String s, String[] words) 
    {
        List<Integer> list = new ArrayList<>();
        int wl = words[0].length();
        int len = words.length;

        HashMap<String,Integer> required = new HashMap<>();
        for(String x : words)
        {
            required.put(x,required.getOrDefault(x,0) + 1);
        }

        for(int offset = 0;offset < wl;offset++)
        {
            int left = offset;
            int right = offset;
            int count = 0;
            HashMap<String,Integer> map = new HashMap<>();
            while(right + wl <= s.length())
            {
                String word = s.substring(right,right+wl);
                right += wl;
                
                if(!required.containsKey(word))
                {
                    map.clear();
                    count = 0;
                    left = right;
                }
                else
                {
                    map.put(word,map.getOrDefault(word,0) + 1);
                    count++;
                    while(map.get(word) > required.get(word))
                    {
                        String leftWord = s.substring(left, left + wl);
                        map.put(leftWord, map.get(leftWord) - 1);
                        left += wl;
                        count--;
                    }
                }
                if(count  == len)
                {
                    list.add(left);
                }
                
            }

        }
        return list;

        
    }
}