//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        // code here
        
        HashMap<Character, Integer> map = new HashMap<>();
        Queue<Character> q = new LinkedList<>();
        
        int max = -1;
        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
            q.offer(c);
            if(map.size() > k){
                while(map.size() > k){
                    char ch = q.poll();
                    map.put(ch, map.get(ch)-1);
                    if(map.get(ch) == 0){
                        map.remove(ch);
                    }
                }
            }
            max = Math.max(max, q.size());
        }
        if(map.size() < k) return -1;
        else return max;
    }
}