//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.longestPalin(S));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static String longestPalin(String S){
        // code here
        if(S.length() <= 1) return S;
        int n=S.length();
        String str = "";
        int max = 0;
        
        int [][] dp = new int[n][n];
        
        for(int gap=0; gap<n; gap++){
            for(int i=0, j=gap; j<n&&i<n; i++,j++){
                if(gap==0) dp[i][j] = 1;
                else if(gap==1){
                    if(S.charAt(i)==S.charAt(j)){
                        dp[i][j] = 1;
                    }
                    else{
                        dp[i][j] = 0;
                    }
                }
                else{
                    if(S.charAt(i)==S.charAt(j) && dp[i+1][j-1]==1){
                        dp[i][j] = 1;
                    }
                    else dp[i][j] = 0;
                }
                
                if(dp[i][j] == 1 && j-i+1>max){
                    max = j-i+1;
                    str = S.substring(i, j+1);
                }
            }
            
        }

        return str;
    }
}
