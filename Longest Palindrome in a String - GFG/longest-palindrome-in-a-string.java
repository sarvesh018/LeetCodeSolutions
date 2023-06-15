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
    static String solve(String str,int i,int j){
        while(i>=0 && j<str.length() && str.charAt(i)==str.charAt(j)){
            i--;
            j++;
        }
        return str.substring(i+1,j);
    }
    static String longestPalin(String S){
        // code here
        String ans="";
        if(S.length()<2){
            return S;
        }
        
        for(int i=0;i<S.length()-1;i++){
            String even = solve(S,i,i);
            if(even.length() > ans.length()){
                ans = even;
            }
            
            String odd = solve(S,i,i+1);
            if(odd.length() > ans.length()){
                ans = odd;
            }
        }
        
        return ans;
    }
}