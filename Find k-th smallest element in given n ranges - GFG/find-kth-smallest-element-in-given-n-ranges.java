//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());
        
        while(t-- > 0){
            int n=Integer.parseInt(in.readLine().trim());
            int range[][]=new int[n][2];
            for(int i=0;i<n;i++){
                String s[]=in.readLine().trim().split(" ");
                range[i][0]=Integer.parseInt(s[0]);
                range[i][1]=Integer.parseInt(s[1]);
            }
            int q=Integer.parseInt(in.readLine().trim());
            int Q[]=new int[q];
            String s[]=in.readLine().trim().split(" ");
            for(int i=0;i<q;i++){
                Q[i]=Integer.parseInt(s[i]);
            }

            Solution ob=new Solution();
            ArrayList<Integer> ans=ob.kthSmallestNum(n, range, q, Q);

            for(int i:ans){
                out.print(i+" ");
            }out.println();
        }
        out.close();
    } 
}
// } Driver Code Ends


class Solution {
    public static ArrayList<Integer> kthSmallestNum(int n, int[][] range, int Q, int[] queries) {
        
        ArrayList<Integer> res = new  ArrayList<>();
        Arrays.sort(range,(i,j) -> i[0]-j[0]);
        // for(int i=0; i<n; i++){
        //     System.out.println(range[i][0]+" "+range[i][1]);
        // }
        
        int ind = 0;
        int start = 0, end = 0;
        
        
        for(int i=1;i<n;i++){
            if(range[ind][1] >= range[i][0]){
                start = Math.min(range[ind][0], range[i][0]);
                end = Math.max(range[ind][1], range[i][1]);
                range[ind][0] = start;
                range[ind][1] = end;
            }
            else{
                ind++;
            }
        }
        for(int q : queries){
            
            int count = 0, prev = 0;
            boolean flag = false;
            
            for(int i=0;i<=ind;i++){
                count += (range[i][1]-range[i][0]+1);
                if(q<=count){
                    int num = range[i][0] + q - prev - 1;
                    res.add(num);
                    flag = true;
                    break;
                }
                prev = (range[i][1]-range[i][0]+1);
            }
            if(!flag) res.add(-1);
        
            
        }
        return res;
    }
}