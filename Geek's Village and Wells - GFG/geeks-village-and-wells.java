//{ Driver Code Starts
import java.util.*;
import java.io.*;

class Gfg {
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t=Integer.parseInt(in.readLine());
        while(t-->0){
            
            String s[]=in.readLine().trim().split(" ");
            int n=Integer.parseInt(s[0]);
            int m=Integer.parseInt(s[1]);
            char c[][]=new char[n][m];
            for(int i=0;i<n;i++){
                s=in.readLine().trim().split(" ");
                for(int j=0;j<m;j++){
                    c[i][j]=s[j].charAt(0);
                }
            }
            Solution ob=new Solution();
            int ans[][]=ob.chefAndWells(n, m, c);

            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    out.print(ans[i][j]+" ");
                }
                out.println();
            }
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
    public static final int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    public boolean isValid(int r, int c, int n, int m) {
        return r>= 0 && r < n && c >= 0 && c < m;
    }
    
    public int[][] chefAndWells(int n,int m,char c[][])
    {
        
        int[][] res = new int[n][m];
        Queue<int[]> q = new LinkedList<>();
        
        for (int i=0; i < n; i++) {
            for (int j=0; j < m; j++) {
                if (c[i][j] == 'W') {
                    q.offer(new int[]{0, i, j});
                }
            }
        }
        
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] curr = q.poll();
                int row = curr[1];
                int col = curr[2];
                int dist = curr[0];
                
                for (int[] dir : directions) {
                    int nRow = row + dir[0];
                    int nCol = col + dir[1];
                    
                    if (isValid(nRow, nCol, n, m) 
                     && res[nRow][nCol] == 0 && c[nRow][nCol] != 'N' && c[nRow][nCol] != 'W') {
                        
                        q.offer(new int[]{dist + 1, nRow, nCol});
                        res[nRow][nCol] = dist + 1;
                        
                    }    
                }
            }
        }
        
        for (int i=0; i < n; i++) {
            for (int j=0; j < m; j++) {
                if (c[i][j] == '.') {
                    res[i][j] = 0;
                }
                else if (c[i][j] == 'H') {
                    if (res[i][j] == 0) {
                        res[i][j] = -1;
                    } 
                    else {
                        res[i][j] = 2 * res[i][j];
                    }
                } 
            }
        }
        
        return res;
        
    }
}