//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String A = br.readLine().trim();
            Solution ob = new Solution();
            String ans = ob.FirstNonRepeating(A);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution
{
    public String FirstNonRepeating(String A)
    {
        // code here
        StringBuilder str = new StringBuilder();
        int [] arr = new int[26];
        Queue<Character> q = new LinkedList<>();
        
        for(char c: A.toCharArray()){
            arr[c-'a']++;
            if(arr[c-'a']<=1){
                q.add(c);
            }
            else{
                q.remove(c);
            }
            if(!q.isEmpty()) str.append(q.peek());
            else str.append('#');
            
        }
        
        return str.toString();
    }
}