class Solution {
    public boolean canConstruct(String ransomNote, String magazine) 
    {
        char[] freq1 = new char[26];
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
        
    }
}