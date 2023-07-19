//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Solution obj = new Solution();
                    System.out.println(obj.longestPalinSubseq(s));
                }
                
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int longestPalinSubseq(String S)
    {
        //code here
        StringBuilder s = new StringBuilder(S);
        s.reverse();
        String str = s.toString();
        
        int n = S.length();
        
        int [][] dp = new int[n+1][n+1];
        for(int i=0; i<n; i++){
            dp[i][0] = 0;
            dp[0][i] = 0;
        }
        
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(S.charAt(i-1) == str.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        
        return dp[n][n];
    }
}