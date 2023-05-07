//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            String str;
            str = br.readLine();
            
            Solution obj = new Solution();
            String res = obj.stringMirror(str);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static String stringMirror(String str) {
        // code here
        String prefix = "";
        prefix += str.charAt(0);
        for(int i=1; i<str.length(); i++){
            char c = str.charAt(i);
            if(c > str.charAt(i-1)) break;
            if(c == str.charAt(0)) break;
            prefix += c;
        }
        StringBuilder s = new StringBuilder(prefix);
        String res = s.toString();
        s.reverse();
        return res+s.toString();
    }
}
        
