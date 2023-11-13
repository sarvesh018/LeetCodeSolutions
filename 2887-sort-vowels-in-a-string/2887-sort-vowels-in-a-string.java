class Solution {
    public boolean vowel(char c){
        if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u' || c=='A' || c=='E' || c=='I' || c=='O' || c=='U'){
            return true;
        }
        return false;
    }
    public String sortVowels(String s) {
        ArrayList<Character> list = new ArrayList<>();
        for(char c: s.toCharArray()){
            if(vowel(c)){
                list.add(c);
            }
        }
        Collections.sort(list);
        StringBuilder str = new StringBuilder();
        int size = 0;
        for(char c: s.toCharArray()){
            if(vowel(c)){
                str.append(list.get(size++));
            }
            else{
                str.append(c);
            }
        }
        return str.toString();
    }
}