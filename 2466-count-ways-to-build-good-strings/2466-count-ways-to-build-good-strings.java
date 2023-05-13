class Solution {
    int mod = (int)(1e9)+7;
    public int memo(int ind, int [] dp, int zero, int one){
        if(ind == 0) return 1;
        if(ind < 0) return 0;
        if(dp[ind]!=-1) return dp[ind];
        //take zero or not take zero
        int take = memo(ind-zero, dp, zero, one);
        int nottake = memo(ind-one, dp, zero, one);
        dp[ind] = (take+nottake)% mod;
        return dp[ind];
    }
    public int countGoodStrings(int low, int high, int zero, int one) {
        int dp [] = new int[high+1];
        Arrays.fill(dp,-1);
        int res = 0;
        for(int i=low; i<=high; i++){
            res =((res%mod) + memo(i,dp,zero,one)%mod)%mod;
        }
        return res;
    }
}