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
            
            
            int K;
            K = Integer.parseInt(br.readLine());
            
            
            int[] A = IntArray.input(br, N);
            
            Solution obj = new Solution();
            int res = obj.totalCuts(N, K, A);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int totalCuts(int N, int K, int[] A) {
        // code here
        int [] max = new int[N];
        int [] min = new int[N];
        int Max = Integer.MIN_VALUE;
        int Min = Integer.MAX_VALUE;
        for(int i=0; i<N; i++){
            Max = Math.max(Max, A[i]);
            max[i] = Max;
        }
        for(int i=N-1; i>=0; i--){
            Min = Math.min(Min, A[i]);
            min[i] = Min;
        }
        // for(int i=0; i<N; i++){
        //     System.out.println(max[i]+" "+min[i]);
        // }
        int count = 0;
        for(int i=0; i<N-1; i++){
            if((max[i]+min[i+1])>=K) count++;
        }
        return count;
    }
}
        
