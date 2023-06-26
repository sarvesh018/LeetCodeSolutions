//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String read[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(read[0]);
            int r = Integer.parseInt(read[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.nCr(n, r));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static int nCr(int n, int r)
    {
        // code here
        if(r>n) return 0;
        if(r==1) return n;
        if(r==n) return 1;
        
        int mod = (int)1e9+7;
        
        int dp[][] = new int[r][n];
        for(int i=0; i<n; i++){
            dp[0][i] = i+1;
        }
        for(int i=1; i<r; i++){
            for(int j=1; j<n; j++){
                if(i>j){
                    dp[i][j] = 0;
                }
                else if(i==j){
                    dp[i][j] = 1;
                }
                else{
                    dp[i][j] = (dp[i][j-1] + dp[i-1][j-1])%mod;
                }
            }
        }
        
        return dp[r-1][n-1] % mod;
    }
}