//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.find_permutation(S);
            for( int i = 0; i < ans.size(); i++)
            {
                out.print(ans.get(i)+" ");
            }
            out.println();
                        
        }
        out.close();
	}
}


// } Driver Code Ends


class Solution {
    public void permute(String str, String res, List<String> list){
        if(str.length() == 0 && !list.contains(res)){
            list.add(res);
            return;
        }
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            String nxt = str.substring(0,i) + str.substring(i+1);
            permute(nxt, res+c, list);
        }
    }
    public List<String> find_permutation(String S) {
        // Code here
        List<String> list = new ArrayList<>();
        
        permute(S,"",list);
        Collections.sort(list);
        return list;
    }
}