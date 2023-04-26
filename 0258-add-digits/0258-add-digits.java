class Solution {
    static int sumDigits(int x){
        if(x==0) return 0;
        else return(x%10 + sumDigits(x/10));
    }
    public int addDigits(int num) {
        int ans = sumDigits(num);
        while(ans/10 >0){
            ans = sumDigits(ans);            
        }
        return ans;
    }
}