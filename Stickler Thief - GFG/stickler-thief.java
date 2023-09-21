//{ Driver Code Starts
import java.util.*;
import java.io.*;

class GFG
 {
	public static void main (String[] args)
	 {
	  
	  //taking input using Scanner class
	  Scanner sc = new Scanner(System.in);
	  
	  //taking count of testcases
	  int t = sc.nextInt();
	  while(t-- > 0){
	      
	      //taking count of houses
	      int n = sc.nextInt();
	      int arr[] = new int[n];
	      
	      //inserting money present in 
	      //each house in the array
	      for(int i = 0; i<n; ++i)
	           arr[i] = sc.nextInt();
  	      
  	      //calling method FindMaxSum() of class solve
  	      System.out.println(new Solution().FindMaxSum(arr, n));
	 }
   }
}
// } Driver Code Ends


class Solution
{
    //Function to find the maximum money the thief can get.
    // public int memo(int[] arr, int n, int ind, int [] dp){
    //     if(ind >= n){
    //         return 0;
    //     }
    //     if(dp[ind] != -1){
    //         return dp[ind];
    //     }
    //     int take = 0, notTake = 0; 
    //     take = arr[ind] + memo(arr, n, ind+2, dp);
    //     notTake = memo(arr, n, ind+1, dp);
        
    //     dp[ind] = Math.max(take, notTake);
    //     return dp[ind];
    // }
    
    public int FindMaxSum(int arr[], int n)
    {
        // Your code here
        if(n==1){
            return arr[0];
        }
        else if(n==2){
            return Math.max(arr[0], arr[1]);
        }
        int dp [] = new int[n];
        dp[n-1] = arr[n-1];
        dp[n-2] = Math.max(arr[n-1], arr[n-2]);
        
        for(int i=n-3; i>=0; i--){
            dp[i] = Math.max(arr[i]+dp[i+2], dp[i+1]);
        }
        
        return dp[0];
    }
}