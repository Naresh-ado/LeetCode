class Solution {
    public String longestCommonPrefix(String[] str) 
    {
        int minlength = Integer.MAX_VALUE;
        
        String res ="";

        for(int i=0;i<str.length;i++)
        {
            minlength = Math.min(minlength,str[i].length());
        }

        for(int i=0;i<minlength;i++)
        {
            char current = str[0].charAt(i);
            for(int j=1;j<str.length;j++)
            {
                if(str[j].charAt(i) != current)
                {
                    return res;
                }
            }

           res+=current;
        }

        return res;

        
    }
}