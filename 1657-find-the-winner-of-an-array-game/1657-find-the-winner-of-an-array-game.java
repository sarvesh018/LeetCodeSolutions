class Solution {
    public int getWinner(int[] arr, int k) {
        int n = arr.length;
        int max = arr[0];
        for(int i: arr){
            max = Math.max(i, max);
        }
        
        if(k >= n){
            return max;
        }

        int win = arr[0], count = 0;
        for(int i=1; i<arr.length; i++){
            if(win > arr[i]){
                count++;
            }
            else{
                count = 1;
                win = arr[i];
            }
            if(count == k || win == max){
                return win;
            }
        }

        return win;
    }
}