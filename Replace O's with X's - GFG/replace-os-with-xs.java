//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            char mat[][] = new char[n][m];
            for(int i=0; i<n; i++)
            {
                String S[] = in.readLine().trim().split(" ");
                for(int j=0; j<m; j++)
                {
                    mat[i][j] = S[j].charAt(0);
                }
            }
            
            Solution ob = new Solution();
            char[][] ans = ob.fill(n, m, mat);
            for(int i = 0;i < n;i++) {
                for(int j = 0;j < m;j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    
    static void dfs(int row, int col, char a[][]){
        if(row<0 || row>=a.length || col<0 || col>=a[0].length || a[row][col]!='O'){
            return;
        }    
        
        a[row][col] = 'K';
        
        dfs(row, col+1, a);
        dfs(row, col-1, a);
        dfs(row+1, col, a);
        dfs(row-1, col, a);
    }
    
    static char[][] fill(int n, int m, char a[][])
    {
        // code here
        if(m==1 || m==2){
            return a;
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if((i==0 || j==0 || i==n-1 || j==m-1) && a[i][j]=='O'){
                    dfs(i, j, a);
                }
            }
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(a[i][j] == 'K'){
                    a[i][j] = 'O';
                }
                else if(a[i][j] == 'O'){
                    a[i][j] = 'X';
                }
            }
        }
        
        return a;
    }
}