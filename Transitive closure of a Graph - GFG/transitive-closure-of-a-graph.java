//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            int graph[][] = new int[N][N];
            
            for(int i = 0;i < N;i++)
                {String a[] = in.readLine().trim().split("\\s+");
                for(int j=0;j<N;j++)
                graph[i][j] = Integer.parseInt(a[j]);}
            
            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.transitiveClosure(N, graph);
            for(int i = 0;i < N;i++)
               { for(int j = 0;j < ans.get(i).size();j++)
                    System.out.print(ans.get(i).get(j) + " ");
            System.out.println();}
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static void dfs(int graph[][], int n, int ind, boolean vis[]){
        vis[ind] = true;
        for(int i=0; i<graph[ind].length; i++){
            if(ind == i || graph[ind][i]==0){
                continue;
            }
            if(vis[i]) continue;
            dfs(graph, n, i, vis);
        }
    }
    
    static ArrayList<ArrayList<Integer>> transitiveClosure(int N, int graph[][])
    {
        // code here
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        
        boolean vis[] = new boolean[N];
        for(int i=0; i<N; i++){
            vis = new boolean[N];
            dfs(graph, N, i, vis);
            ArrayList<Integer> temp = new ArrayList<>();
            for(boolean b: vis){
                temp.add( (b) ? 1 : 0);
            }
            list.add(temp);
        }
        return list;
    }
}