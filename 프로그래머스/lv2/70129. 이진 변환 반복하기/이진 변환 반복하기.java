class Solution {
    public int[] solution(String s) {
        int total = 0, zeroCnt = 0;
        while(s.length() !=1)
        {
            for(int i=0; i<s.length(); i++) if(s.charAt(i) == '0') zeroCnt++;
            s = s.replace("0", "");
            s = String.valueOf(Integer.toBinaryString(s.length()));
            total++;
        }
     
        return new int[]{total, zeroCnt};
    }
}