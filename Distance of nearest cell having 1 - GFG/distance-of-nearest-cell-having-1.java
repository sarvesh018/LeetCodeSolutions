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
            int[][] ans = obj.nearest(grid);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid)
    {
        // Code here
        int n = grid.length, m = grid[0].length;
        
        int [][] vis = new int[n][m];
        Queue<int []> q = new LinkedList<>();
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 1){
                    vis[i][j] = 1;
                    grid[i][j] = 0;
                    q.add(new int[]{i, j});
                }
            }
        }
        
        int dir [][] = {{1,0}, {0,1}, {0,-1}, {-1,0}};
        int step = 1;
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int [] arr = q.poll();
                for(int k=0; k<4; k++){
                    int x = arr[0] + dir[k][0];
                    int y = arr[1] + dir[k][1];
                    if(x>=0 && x<n && y>=0 && y<m && vis[x][y]==0){
                        vis[x][y] = 1;
                        grid[x][y] = step;
                        q.add(new int[]{x,y});
                    }
                }
            }
            step++;
        }
        return grid;
    }
}