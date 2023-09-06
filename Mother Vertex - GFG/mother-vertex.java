//{ Driver Code Starts
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
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
            }
            Solution obj = new Solution();
            int ans = obj.findMotherVertex(V, adj);
            System.out.println(ans);
       }
    }
}
// } Driver Code Ends



class Solution
{
    //Function to find a Mother Vertex in the Graph.
    
    public void dfs(ArrayList<ArrayList<Integer>>adj, int vis [], int ind){
        vis[ind] = 1;
        for(int i: adj.get(ind)){
            if(vis[i] == 0){
                dfs(adj, vis, i);
            }
        }
        return ;
    }
       
    public int findMotherVertex(int V, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        int result = 0;
        int [] vis = new int[V];
        
        Arrays.fill(vis, 0);
        for(int i=0; i<V; i++){
            if(vis[i] == 0){
                result = i;
                dfs(adj, vis, i);
            }
        }
        
        vis = new int[V];
        dfs(adj, vis, result);
        
        for(int i: vis){
            if(i == 0) return -1;
        }
        return result;
    }
}