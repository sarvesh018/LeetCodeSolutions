//{ Driver Code Starts
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
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.orangesRotting(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

class Pair{
    int a ,b ,time;
    Pair(int i, int j, int t){
        this.a = i;
        this.b = j;
        this.time = t;
    }
}

class Solution
{
    //Function to find minimum time required to rot all oranges. 
    public int orangesRotting(int[][] grid)
    {
        // Code here
        int n = grid.length, m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        
        int maxTime = 0;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 2){
                    q.offer(new Pair(i, j, 0));
                }
            }
        }
        
        while(!q.isEmpty()){
            Pair p = q.poll();
            int i=p.a, j=p.b, t=p.time;
            
            if(i-1>=0 && grid[i-1][j]==1){
                grid[i-1][j] = 2;
                q.offer((new Pair(i-1, j, t+1)));
                maxTime = Math.max(maxTime, t+1);
            }
            if(i+1<n && grid[i+1][j]==1){
                grid[i+1][j] = 2;
                q.offer(new Pair(i+1, j, t+1));
                maxTime = Math.max(maxTime, t+1);
            }
            if(j-1>=0 && grid[i][j-1]==1){
                grid[i][j-1] = 2;
                q.offer(new Pair(i, j-1, t+1));
                maxTime = Math.max(maxTime, t+1);
            }
            if(j+1<m && grid[i][j+1]==1){
                grid[i][j+1] = 2;
                q.offer(new Pair(i, j+1, t+1));
                maxTime = Math.max(maxTime, t+1);
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 1) return -1;
            }
        }
        
        return maxTime;
    }
}