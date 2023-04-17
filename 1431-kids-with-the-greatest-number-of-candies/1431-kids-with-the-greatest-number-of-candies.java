class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for(int i=0; i<candies.length; i++){
            max = Math.max(candies[i], max);
        }
        List<Boolean> list = new ArrayList<>();
        for(int i: candies){
            if(i+extraCandies >= max){
                list.add(true);
            }
            else list.add(false);
        }
        return list;
    }
}