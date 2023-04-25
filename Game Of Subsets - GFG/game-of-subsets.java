//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            Solution ob = new Solution();
            int ans = ob.goodSubsets(a, n);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution{
    private static final int MOD = (int) 1e9 + 7;
    private static final int[] PRIMES = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
    private static final int[] PRIME_MASKS = new int[31];

    static {
        for (int i = 2; i <= 30; ++i) {
            if (i % 4 == 0 || i % 9 == 0 || i == 25) continue;
            int mask = 0;
            for (int j = 0; j < 10; ++j) {
                if (i % PRIMES[j] == 0) {
                    mask |= 1 << j;
                }
            }
            PRIME_MASKS[i] = mask;
        }
    }
    
    private static long pow2(int n) {
        long ans = 1, m = 2;
        while (n != 0) {
            if ((n & 1) == 1) ans = (ans * m) % MOD;
            m = (m * m) % MOD;
            n >>= 1;
        }
        return ans;
    }

    public int goodSubsets(int[] arr, int n) {
        int oneCount = 0;
        int[] dp = new int[1 << 10];
        int[] primeCounts = new int[31]; 
        dp[0] = 1; 
        for (int i : arr) {
            if (i == 1) {
                oneCount++; 
            } 
            else if (PRIME_MASKS[i] != 0) {
                primeCounts[i]++; 
            }
        }
        
        for (int i = 0; i < 31; ++i) {
            if (primeCounts[i] == 0) continue;
            int primeMask = PRIME_MASKS[i];
            for (int j = 0; j < 1 << 10; ++j) {

                if ((j & primeMask) != 0) continue;
                dp[j | primeMask] = (int) ((dp[j | primeMask] + dp[j] * (long) primeCounts[i]) % MOD);
            }
        }
        
        long ans = 0;
        for (int count : dp) {
            ans = (ans + count) % MOD;
        }
        ans--;
        if (oneCount != 0) {
            ans = (ans * pow2(oneCount)) % MOD;
        }
    
        return (int) ans;
    }
}