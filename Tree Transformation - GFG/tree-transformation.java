//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int N;
            N = Integer.parseInt(br.readLine());
            
            
            int[] p = IntArray.input(br, N);
            
            Solution obj = new Solution();
            int res = obj.solve(N, p);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int solve(int n, int[] p) {
        // code here
        HashSet<Integer> set = new HashSet<>();
        int count = 0;
        for(int i=1; i<n; i++){
            if(p[i] == 0) count++;
            if(p[i]!=0 && p[i]!=-1){
                set.add(p[i]);
                p[i] = 0;
            }
        }
        if(count == 1){
            return Math.max((int)set.size()-1, 0);
        }
        return set.size();
    }
}
        
