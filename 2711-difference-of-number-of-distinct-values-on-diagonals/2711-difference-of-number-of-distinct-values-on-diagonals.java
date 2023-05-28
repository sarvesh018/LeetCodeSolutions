class Solution {
    public int[][] differenceOfDistinctValues(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int [][] res = new int[n][m];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                int r1 = i-1, c1 = j-1;
                HashSet<Integer> set = new HashSet<>();
                while(r1>=0 && c1>=0){
                    set.add(grid[r1][c1]);
                    r1--;c1--;
                }
                int r2 = i+1, c2 = j+1;
                HashSet<Integer> set1 = new HashSet<>();
                while(r2<n && c2<m){
                    set1.add(grid[r2][c2]);
                    r2++;c2++;
                }
                res[i][j] = Math.abs(set.size() - set1.size());
            }
        }
        return res;
    }
}