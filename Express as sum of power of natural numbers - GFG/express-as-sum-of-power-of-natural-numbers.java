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
            String[] input = new String[2]; 
            input = br.readLine().split(" "); 
            int n = Integer.parseInt(input[0]); 
            int x = Integer.parseInt(input[1]); 
            Solution ob = new Solution();
            System.out.println(ob.numOfWays(n, x));
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution
{
    public static int mod = (int)Math.pow(10,9)+7;
    public static int memo(int ind, int n, int x, int [][]dp){
        if(ind > n){
            if(n==0) return 1;
            return 0;
        }    
        if(dp[ind][n] != -1) return dp[ind][n];
        int take = 0;
        if(n>0){
            take = memo(ind+1, n-(int)Math.pow(ind,x), x, dp);
        }
        int nottake = memo(ind+1, n, x, dp);
        dp[ind][n] = (take+nottake)%mod;
        return dp[ind][n];
    }
    static int numOfWays(int n, int x)
    {
        // code here
        int [][] dp = new int[n+1][n+1];
        for(int i=0; i<n+1; i++){
            for(int j=0; j<n+1; j++){
                dp[i][j] = -1;
            }
        }
        
        return memo(1, n, x, dp);
    }
}