class Solution {
    public List<List<String>> groupAnagrams(String[] strs) 
    {
        //Optimized way Signature based
        
        HashMap<String, List<String>> map = new HashMap<>();

        for(String s : strs)
        {
            int[] freq = new int[26];

            for(char ch : s.toCharArray())
            {
                freq[ch - 'a']++;
            }

            StringBuilder key = new StringBuilder();

            for(int i = 0; i < 26; i++)
            {
                if(freq[i] > 0)
                {
                    key.append((char)('a' + i));
                    key.append(freq[i]);
                }
            }

            map.putIfAbsent(key.toString(), new ArrayList<>());
            map.get(key.toString()).add(s);
        }

        return new ArrayList<>(map.values());
        /* 
        This is O(n^2 * k) Brute force
        List<List<String>> list = new ArrayList<>();
        int[] freq = new int[strs.length];
        
        //Edge case Empty String handling
        int efound = 0;
        List<String> emp = new ArrayList<>();
        for(int i=0;i<strs.length;i++)
        {
            if(strs[i].length() == 0)
            {
                emp.add(strs[i]);
                freq[i] = 1;
                efound = 1;
            }
        }
        if(efound == 1)list.add(emp);
        
        for(int i=0;i<strs.length;i++)
        {
            List<String> l = new ArrayList<>();
            HashMap<Character,Integer> map = new HashMap<>();
            if(freq[i] == 0)
            {
                l.add(strs[i]);
                freq[i] = 1;
                for(char ch : strs[i].toCharArray())
                {
                    map.put(ch,map.getOrDefault(ch,0) + 1);
                }
                for(int j=i+1;j<strs.length;j++)
                {
                    if(freq[j] == 0)
                    {
                        String sd = strs[j];

                        if(strs[i].length() != sd.length())
                            continue;

                        HashMap<Character,Integer> m2 = new HashMap<>();

                        for(char ch : sd.toCharArray())
                        {
                            m2.put(ch, m2.getOrDefault(ch,0) + 1);
                        }

                        int found = 0;

                        for(char ch : strs[i].toCharArray())
                        {
                            if(!map.get(ch).equals(m2.get(ch)))
                            {
                                found = 1;
                                break;
                            }
                        }

                        if(found == 0)
                        {
                            l.add(sd);
                            freq[j] = 1;
                        }
                    }
                }
                list.add(l);
            }
            
        }
        return list;
        */
    }
}