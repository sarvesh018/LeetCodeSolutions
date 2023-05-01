class Solution {
    public int kthFactor(int n, int k) {
    //    ArrayList<Integer> list = new ArrayList<>();
    //     for(int i=1; i<=n; i++){
    //         if(n%i == 0){
    //             list.add(i);
    //         }
    //     }
    //     return (list.size()>=k) ? list.get(k-1) : -1;
        int count = 0;
        for(int i=1; i<=n; i++){
            if(n%i == 0) count++;
            if(count==k) return i;
        }
        return -1;
    }
}