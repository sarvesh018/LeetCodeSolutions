//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String s = sc.next ();
            int k = sc.nextInt();
    		System.out.println (new Solution().substrCount (s, k));
        }
        
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    long count(String s, int k){
        int i=0, j=0, n = s.length(), cnt=0;
        int [] arr = new int[26];
        
        long result = 0;
        
        while(j<n){
            char c = s.charAt(j);
            arr[c-'a']++;
            if(arr[c-'a'] == 1){
                cnt++;
            }
            while(cnt > k){
                char prev = s.charAt(i);
                arr[prev-'a']--;
                if(arr[prev-'a'] == 0) cnt--;
                i++;
            }
            result += (j-i+1);
            j++;
        }
        return result;
    }
    long substrCount (String s, int k) {

        return count(s, k) - count(s, k-1);
    }
}