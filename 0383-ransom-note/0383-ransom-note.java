class Solution {
    public boolean canConstruct(String ransomNote, String magazine) 
    {

        //USING ONLY 1 ARRAY
        int[] freq = new int[26];
        for(char ch : magazine.toCharArray())
        {
            freq[ch - 'a']++;
        }

        for(char ch : ransomNote.toCharArray())
        {
            freq[ch - 'a']--;
            if(freq[ch-'a'] < 0)
            {
                return false;
            }
        }

        return true;
        /*
        char[] freq1 = new char[26]; here actually you need to use int 
        char[] freq2 = new char[26];
        for(char ch : ransomNote.toCharArray())
        {
            freq1[ch-'a']++;
        }
        for(char ch : magazine.toCharArray())
        {
            freq2[ch-'a']++;
        }

        for(char ch : ransomNote.toCharArray())
        {
            if(freq1[ch-'a'] > freq2[ch-'a'])
            {
                return false;
            }
        }
        return true;
        */
    }
}