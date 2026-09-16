class Solution {
    public int[][] generateMatrix(int n) 
    {
        int top = 0;
        int bottom = n-1;
        int right = n-1;
        int left = 0;
        int[][] matrix = new int[n][n];
        int ptr = 1;
        while(top<=bottom && left <= right)
        {
            //forward
            for(int i=top;i<=right;i++)
            {
                matrix[top][i] = ptr;
                ptr++;
            }
            top++;
            //downward
            for(int i=top;i<=bottom;i++)
            {
                matrix[i][right] = ptr;
                ptr++;
            }
            right--;
            //leftward
            if(top <= bottom)
            {
                for(int i=right;i>=left;i--)
                {
                    matrix[bottom][i] = ptr;
                    ptr++;
                }
            }
            bottom--;
            //upward
            if(left <= right)
            {
                for(int i=bottom;i>=top;i--)
                {
                    matrix[i][left] = ptr;
                    ptr++;
                }
            }
            left++;

        }
        return matrix;
        
    }
}