//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] str = br.readLine().trim().split(" ");
            int N = Integer.parseInt(str[0]);
            int M = Integer.parseInt(str[1]);
            int[][] matrix = new int[N][M];
            for(int i=0; i<N; i++)
            {
                String[] s = br.readLine().trim().split(" ");
                for(int j=0; j<M; j++)
                    matrix[i][j] = Integer.parseInt(s[j]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.closedIslands(matrix, N, M));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public void dfs(int [][] matrix, int i, int j){
        if(i<0 || j<0 || i>matrix.length-1 || j>matrix[0].length-1){
            return;
        }
        if(matrix[i][j]==0) return;
        
        matrix[i][j] = 0;
        dfs(matrix, i+1, j);
        dfs(matrix, i, j+1);
        dfs(matrix, i-1, j);
        dfs(matrix, i, j-1);
        
    }
    public int closedIslands(int[][] matrix, int N, int M)
    {
        // Code here
        int count = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(i==0 || j==0 || i==N-1 || j==M-1){
                    dfs(matrix, i, j);
                }
            }
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(matrix[i][j]==1){
                    dfs(matrix, i, j);
                    count++;
                }
            }
        }
        return count;
    }
}