class Solution {
    public int[][] generateMatrix(int n) {
        int [][] arr = new int[n][n];
        int size = 1;
        int rs=0, re=n-1, cs=0, ce=n-1;
        while(size <= n*n){
            for(int i=cs; i<=ce; i++){
                arr[rs][i] = size++;
            }
            rs++;
            for(int i=rs; i<=re; i++){
                arr[i][ce] = size++;
            }
            ce--;
            if(rs<=re){
                for(int i=ce; i>=cs; i--){
                    arr[re][i] = size++;
                }
                re--;
            }
            if(cs<=ce){
                for(int i=re; i>=rs; i--){
                    arr[i][cs] = size++;
                }
                cs++;
            }
        }
        return arr;
    }
}