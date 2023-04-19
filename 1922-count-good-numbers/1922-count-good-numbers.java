class Solution {
    int mod = 1000000007;
    public long pow(int x, long y){
        if(y==0) return 1;
        long ans = pow(x,(y)/2);
        ans *= ans;
        ans %= mod;
        if(y%2 == 1){
            ans *= x;
        }
        ans %= mod;

        return ans;
    }
    public int countGoodNumbers(long n) {
        long odd = n/2, even = (n+1)/2;
        return (int)((pow(4, odd) * pow(5, even)) % mod);
    }
}