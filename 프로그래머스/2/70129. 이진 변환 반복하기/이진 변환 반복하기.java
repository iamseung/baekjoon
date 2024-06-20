class Solution {
    static int cnt = 0;
    
    public int[] solution(String s) {
        int index = 0, zeroCnt = 0;

        while(s.length() != 1)
        {
            for(int i=0; i<s.length(); i++) {
                if(s.charAt(i) == '0') 
                    zeroCnt++;
            }

            s = s.replace("0", "");
            s = String.valueOf(Integer.toBinaryString(s.length()));
            index++;
        }
     
        return new int[]{index, zeroCnt};
    }
}