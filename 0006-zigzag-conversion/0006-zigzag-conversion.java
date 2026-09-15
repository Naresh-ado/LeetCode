class Solution {
    public String convert(String s, int k) 
    {
        if(s.length() <= k || k==1)return s;
        StringBuilder sb = new StringBuilder();
        int toprow = 2 * (k - 1);
        int row = 0;
        while(row < s.length())
        {
            sb.append(s.charAt(row));
            row += toprow;

        }
        for(int r=1;r<k-1;r++)
        {
            int first = 2 * (k - 1 - r);
            int second  = 2 * r;
            int ptr = r;
            sb.append(s.charAt(ptr));
            while(ptr < s.length())
            {
                ptr+=first;
                if(ptr < s.length()){
                    sb.append(s.charAt(ptr));
                }
                ptr+=second;
                if(ptr < s.length()){
                    sb.append(s.charAt(ptr));
                }
                
            }

        }
        row = k-1;
        while(row < s.length())
        {
            sb.append(s.charAt(row));
            row += toprow;
        }
        return sb.toString();
        
    }
}