//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int[] prices = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.stockBuyAndSell(n, prices);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    // public static int memo(int [] prices, int ind, int flag){
    //     if(ind >= prices.length){
    //         return 0;
    //     }
    //     int take = 0, nottake = 0;
    //     if(flag == 0){
    //         take = -prices[ind] + memo(prices, ind+1, 1);
    //         nottake = memo(prices, ind+1, 0);
    //     }
    //     else{
    //         take = prices[ind] + memo(prices, ind+1, 0);
    //         nottake = memo(prices, ind+1, 1);
    //     }
    //     return Math.max(take, nottake);
    // }
    public static int stockBuyAndSell(int n, int[] prices) {
        // code here
        int res = 0, prev = prices[0];
        for(int i=0; i<n; i++){
            if(prices[i]>=prev){
                res += prices[i] - prev;
            }
            prev = prices[i];
        }
        return res;
    }
}

        