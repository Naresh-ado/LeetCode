class Solution {
    public List<Integer> spiralOrder(int[][] matrix) 
    {
        List<Integer> list =  new ArrayList<>();
        int r = matrix.length;
        int c = matrix[0].length;
  
        int top  = 0;
        int bottom = r-1;
        int  left = 0;
        int  right = c-1;

        while(top <= bottom && left<=right)
        {
            //top forward traversal
            for(int i=top;i<=right;i++)
            {
                list.add(matrix[top][i]);
            }
            top++;
            //right down travesal
            for(int i=top;i<=bottom;i++)
            {
                list.add(matrix[i][right]);
            }
            right--;

            //bottom left traversal
            if(top <= bottom)
            {
                for(int i=right;i>=left;i--)
                {
                    list.add(matrix[bottom][i]);
                }

            }
            bottom--;
            //upward up traversal
            if(left <= right)
            {
                for(int i=bottom;i>=top;i--)
                {
                    list.add(matrix[i][left]);
                }

            }
            left++;
            
        }
        return list;
        
    }
}