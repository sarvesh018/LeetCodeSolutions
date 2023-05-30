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
            String[] S = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            char [][] board = new char[n][m];
            for(int i = 0; i < n; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    board[i][j] = s[j].charAt(0);
                }
            }
            String word = br.readLine().trim();
            Solution obj = new Solution();
            boolean ans = obj.isWordExist(board, word);
            if(ans)
                System.out.println("1");
            else
                System.out.println("0");
       }
    }
}
// } Driver Code Ends


class Solution
{
    public boolean backtracking(int i, int j, int n, int m, char[][] board, int k, int len, String word){
        if(k==len){
            return true;
        }
        char ch = word.charAt(k);
        char cur = board[i][j];
        if(ch!=cur) return false;
        for(int di=-1; di<=1; di++){
            for(int dj=-1; dj<=1; dj++){
                int i1=i+di;
                int j1=j+dj;
                if(Math.abs(di)!=Math.abs(dj) && i1>=0 && i1<n && j1>=0 && j1<m){
                    board[i][j]='$';
                    if(backtracking(i1, j1, n, m, board, k+1, len, word)) return true;
                    board[i][j] = cur;
                }
            }
        }
        return false;
    }
    
    public boolean isWordExist(char[][] board, String word)
    {
        int n=board.length;
        int m=board[0].length;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(backtracking(i, j, n, m, board, 0, word.length(), word)){
                    return true;
                }
            }
        }
        
        return false;
    }
}