//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t=Integer.parseInt(in.readLine());
        while(t-->0){
            int n=Integer.parseInt(in.readLine().trim());
            int a[][]=new int[n][2];
            for(int i=0;i<n;i++){
                String s[]=in.readLine().trim().split(" ");
                a[i][0]=Integer.parseInt(s[0]);
                a[i][1]=Integer.parseInt(s[1]);
            }
            int k=Integer.parseInt(in.readLine().trim());
            Solution ob=new Solution();
            out.println(ob.powerfullInteger(n,a,k));
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    public static int powerfullInteger(int n,int interval[][],int k)
    {
        int end = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            end = Math.max(end, interval[i][1]);
        }
        
        int [] arr = new int[end+2];
        for(int i=0; i<n; i++){
            arr[interval[i][0]]++;
            arr[interval[i][1]+1]--;
        }
        int res = -1;
        for(int i=1; i<arr.length; i++){
            arr[i] = arr[i-1]+arr[i];
            if(arr[i]>=k) res = i;
        }
        return res;
    }
}