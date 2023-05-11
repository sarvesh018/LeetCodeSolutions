//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String s;
            s = br.readLine();

            Solution obj = new Solution();
            int res = obj.minimumSum(s);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int minimumSum(String str) {
        // code here
        int n = str.length();
        int left = 0;
        int right = n-1;
        char [] s = str.toCharArray();
        while(left<=right){
            if(s[left]=='?' && s[right]=='?'){
                if(left!=0)
                    s[left] = s[left-1];
                if(right!=n-1)
                    s[right] = s[right+1];
            }
            else if(s[left]=='?'){
                s[left] = s[right];
            }
            else if(s[right]=='?'){
                s[right] = s[left];
            }
            else if(s[left] != s[right]){
                return -1;
            }
            left++;
            right--;
        }
        
        int count =0;
        for(int i=1;i<n;i++){
            if(s[i]!='?' && s[i-1]!='?')
            count+=Math.abs(s[i]-s[i-1]);
        }
        
        return count;
    }
}
