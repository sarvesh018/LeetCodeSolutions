class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        if(sx == fx && sy == fy){
            if(t == 1){
                return false;
            }
        }

        int x = Math.abs(sx - fx);
        int y = Math.abs(sy - fy);

        if(Math.max(x,y) <= t){
            return true;
        }
        return false;
    }
}