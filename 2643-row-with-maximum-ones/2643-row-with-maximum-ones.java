class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int [] res = new int[2];
        int max = 0;
        for(int i=0; i<mat.length; i++){
            int count = 0;
            for(int j=0; j<mat[0].length; j++){
                if(mat[i][j] == 1) count++;
            }
            if(max < count){
                max = count;
                res[0] = i;
                res[1] = count;
            }
        }
        return res;
    }
}