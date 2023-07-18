//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s = br.readLine().trim();
            Solution ob = new Solution();
            List<String> ans = ob.AllPossibleStrings(s);
            for(String i: ans)
                System.out.print(i + " ");
            System.out.println();
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public void powerSet(String s, int i, List<String> list, String curr){
        if(i == s.length()){

            list.add(curr);

            return;
        }
        powerSet(s, i+1, list, curr+s.charAt(i));
        powerSet(s, i+1, list, curr);
    }
    public List<String> AllPossibleStrings(String s)
    {
        // Code here
        List<String> a = new ArrayList<>();
        powerSet(s, 0, a, "");
        Collections.sort(a);
        a.remove(0);
        return a;
    }
}