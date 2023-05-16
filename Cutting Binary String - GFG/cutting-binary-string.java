//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String s = read.readLine();
            Solution ob = new Solution();
            
            System.out.println(ob.cuts(s));
        }
    } 
} 

// } Driver Code Ends


//User function Template for Java

class Solution{
    
    static int max = (int)1e9;
    
    static Set<String> set;
    static{
        set = new HashSet<>();
        long temp = 1; 
        for(int i = 1;i <= 22;i++){
            set.add(Long.toString(temp,2));
            temp = temp*5;
        }
    }
    
    static int find(String s,int idx){
        if(idx >= s.length()) return 0;
        StringBuilder sb = new StringBuilder();
        int ans = max;
        for(int i = idx; i < s.length(); i++){
            sb.append(s.charAt(i));
            if(set.contains(sb.toString())){
                ans = Math.min(ans,1 + find(s,i + 1));
            }
        }
        return ans;
    }
    static int cuts(String s){
        int ans = find(s,0);
        if (ans >= max) return -1;
        else return ans;
    }
}