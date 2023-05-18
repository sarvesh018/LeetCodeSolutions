class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int [] arr = new int[n];
        Arrays.fill(arr,0);
        for(List<Integer> i: edges){
            arr[i.get(1)]++;
        }
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(arr[i]==0){
                list.add(i);
            }
        }
        return list;
    }
}