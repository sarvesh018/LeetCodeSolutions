class Solution {
    public int countBits(int n){
        int count = 0;
        while(n > 0){
            n = n & (n-1);
            count++;
        }
        return count;
    }
    public int[] sortByBits(int[] arr) {
       Map<Integer, ArrayList<Integer>> map = new LinkedHashMap<>();
       for(int i: arr){
           int cnt = countBits(i);
           System.out.print(cnt+" ");
           if(map.containsKey(cnt)){
               map.get(cnt).add(i);
           }
           else{
               ArrayList<Integer> list = new ArrayList<>();
               list.add(i);
               map.put(cnt, list);
           }
       } 
       ArrayList<Integer> keys = new ArrayList<>();
       for(int i: map.keySet()){
           keys.add(i);
       }
       Collections.sort(keys);

       ArrayList<Integer> list = new ArrayList<>();
       for(int i: keys){
           Collections.sort(map.get(i));
           list.addAll(map.get(i));
       }

       return list.stream().mapToInt(i -> i).toArray();
    }
}
