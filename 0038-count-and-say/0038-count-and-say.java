class Solution {
    public String countAndSay(int n) 
    {
        String str = "1";
        if(n == 1)return str;
        for(int i=1;i<n;i++) // < n because already one term str = "1"
        {
            StringBuilder sb = new StringBuilder();
            int ptr = 0;
            while(ptr < str.length())
            {
                int count = 0;
                char ch = str.charAt(ptr);
                while(ptr < str.length() && ch == str.charAt(ptr))
                {
                    count++;
                    ptr++;
                }
                sb.append(count);
                sb.append(ch);
            }  
            str = sb.toString();

        }
        return str;
        

        
    }
}