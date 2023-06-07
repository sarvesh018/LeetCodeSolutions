class Solution {
    public int minFlips(int a, int b, int c) {
        String res = String.format("%32s",Integer.toBinaryString(c)).replaceAll(" ","0");
        String x = String.format("%32s",Integer.toBinaryString(a)).replaceAll(" ","0");
        String y = String.format("%32s",Integer.toBinaryString(b)).replaceAll(" ","0");

        char [] resA = res.toCharArray();
        char [] xA = x.toCharArray();
        char [] yA = y.toCharArray();
        
        int count = 0;

        for(int i=0; i<32; i++){
            int p = resA[i] - '0';
            int q = xA[i] - '0';
            int r = yA[i] - '0';
            
            if(p==1 && (q|r)!=1) count++;
            else if(p==0 && (q|r)!=0){
                if(q==1 && r==1) count+=2;
                else count+=1;
            }
        }

        return count;
    }
}