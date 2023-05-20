//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            boolean ans = obj.isStraightHand(n, k, a);
            System.out.println(ans ? "True" : "False");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static boolean isStraightHand(int N, int groupSize, int hand[]) {
        if(N%groupSize != 0)
            return false;
            
        Arrays.sort(hand);
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i: hand) arr.add(i);
        
        int size = groupSize;
        while(arr.size() !=0)
        {
            HashSet<Integer> set = new HashSet<>();
            for(int i: arr)
            {
                set.add(i);
                if(set.size() >=groupSize)
                    break;
            }
            int temp = arr.get(0);
            if(size == 0)
                size = groupSize;
                while(size!=0)
                {
                    if(!set.contains(temp))
                        return false;
                    size--;
                    arr.remove(Integer.valueOf(temp));
                    temp++;
                    
                }
        }
        return true;
    }
}
