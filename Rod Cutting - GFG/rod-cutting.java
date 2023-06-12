//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[])throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);

            Solution ob = new Solution();
            out.println(ob.cutRod(arr, n));
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution{
    public int cutRod(int price[], int n) {
        //code here
        //1  2  3  4  5   6   7   8
        //1, 5, 8, 9, 10, 17, 17, 20
        int dp [] = new int[n+1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;
        for(int i=1; i<=n; i++){
            dp[i] = price[i-1];
            for(int j=0; j<i; j++){
                dp[i] = Math.max(dp[i], dp[j]+dp[i-j]);
            }
        }
        return dp[n];
    }
}