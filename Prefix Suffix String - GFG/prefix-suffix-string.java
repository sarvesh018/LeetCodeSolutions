//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;

public class code1 
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t=Integer.parseInt(in.readLine());
        while(t-->0){
            String s1[]=in.readLine().trim().split(" ");
            String s2[]=in.readLine().trim().split(" ");

            Solution ob=new Solution();
            int ans=ob.prefixSuffixString(s1,s2);
            out.println(ans);

        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
    public int prefixSuffixString(String s1[],String s2[])
    {
        int count = 0;
        HashSet<String> set = new HashSet<>();
        for(int i=0; i<s2.length; i++){
            // int x = s2[i].length();
            String str2 = s2[i];
            for(int j=0; j<s1.length; j++){
                // int n = s1[j].length();
                String str1 = s1[j];
                // if(n>x){
                    if(str1.startsWith(str2) || str1.endsWith(str2)){
                        count++;
                        break;
                    }
                // }
            }
        }
        return count;
    }
}