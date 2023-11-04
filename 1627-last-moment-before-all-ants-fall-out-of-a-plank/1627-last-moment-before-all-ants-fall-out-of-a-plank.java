class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        int lft, rt;
        if (left.length == 0)
            lft = 0;
        else 
            lft = Arrays.stream(left).max().getAsInt();
        if (right.length == 0)
            rt = n;
        else 
            rt = Arrays.stream(right).min().getAsInt();
        return Math.max(lft, n-rt);
    }
}