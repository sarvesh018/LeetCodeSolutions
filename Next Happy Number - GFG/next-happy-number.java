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
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.nextHappy(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int calc(int n){
         int ans = 0;
        while(n != 0){
            int digit = n % 10;
            ans += digit * digit;
            n = n / 10;
        }
        return ans;
    }
    
    static int nextHappy(int N){
        // code here
          int ans = 0;
        boolean flag = false;
        
        for(int i = N + 1; i < 100003; i++){
            ArrayList<Integer> list = new ArrayList<>();
            
            int num = i;
            while(true){
                
                int res = calc(num);
                num = res;
                if(res == 1){
                    flag = true;
                    break;
                }
                else if(list.contains(res)){
                    break;
                }
                else{
                    list.add(res);
                }
                
            }
            
            if(flag){
                ans = i;
                break;
            }
        }
        return ans;
    }
}