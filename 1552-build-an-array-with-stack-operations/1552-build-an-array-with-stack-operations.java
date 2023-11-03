class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> list = new ArrayList<>();
        int size = 0, curr = 0;
        for(int i=1; i<=n; i++){
            if(target[curr] == i){
                list.add("Push");
                curr++;
                if(curr == target.length){
                    break;
                }
            }
            else{
                list.add("Push");
                list.add("Pop");
            }
        }

        return list;
    }
}