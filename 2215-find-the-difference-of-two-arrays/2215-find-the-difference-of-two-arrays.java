class Solution {
    
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        int n = nums1.length;
        
        HashSet<Integer> s1 =  new HashSet<>();
        HashSet<Integer> s2 =  new HashSet<>();
        
        for(int i: nums1) s1.add(i);
        for(int i: nums2) s2.add(i);

        for(int i:s1){
            if(!s2.contains(i)) l1.add(i);
        }
        for(int i:s2){
            if(!s1.contains(i)) l2.add(i);
        }

        list.add(l1);
        list.add(l2);
        return list;
    }
}