//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int sum = sc.nextInt();
            int N = sc.nextInt();
            int coins[] = new int[N];
            for (int i = 0; i < N; i++) coins[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.count(coins, N, sum));
        }
    }
}


// } Driver Code Ends


// User function Template for Java

class Solution {
    public long memo(int [] coins, int ind, int sum, Long[][]dp){
        if(sum == 0){
            return 1;
        }
        if(ind >= coins.length || sum < 0){
            return 0;
        }
        if(dp[ind][sum] != null){
            return dp[ind][sum];
        }
        
        long nottake = memo(coins, ind+1, sum, dp);
        long take = 0;
        if(coins[ind] <= sum){
            take = memo(coins, ind, sum-coins[ind], dp);
        }
        
        return dp[ind][sum] = take+nottake;
    }
    public long count(int coins[], int N, int sum) {
        // code here.
        Long [][] dp = new Long[N][sum+1];
        
        return memo(coins, 0, sum, dp);
    }
}