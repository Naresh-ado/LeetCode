class Solution {
    public String reorganizeString(String s) 
    {
        HashMap<Character,Integer> map = new HashMap<>();
        for(char ch : s.toCharArray())
        {
            map.put(ch,map.getOrDefault(ch,0) + 1);
        }
        PriorityQueue<Character> pq = new PriorityQueue<>(
            (a,b) -> map.get(b) - map.get(a)
        );

        pq.addAll(map.keySet());

        StringBuilder sb = new StringBuilder();

        while(pq.size() >= 2)
        {
            char first = pq.poll();
            char second = pq.poll();

            map.put(first,map.get(first) - 1);
            map.put(second,map.get(second) - 1);

            sb.append(first);
            sb.append(second);

            if(map.get(first) > 0)
            {
                pq.offer(first);
            }

            if(map.get(second) > 0)
            {
                pq.offer(second);
            }
        }

            //One Character remains     
            if(!pq.isEmpty())
            {
                char last = pq.poll();
                if(map.get(last) > 1)
                {
                    return  "";
                }
                if(sb.length() > 0 && sb.charAt(sb.length() - 1) == last)
                {
                    return "";
                }

                sb.append(last);
            }   

        return sb.toString();

        


       
        
    }
}