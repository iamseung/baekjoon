import java.util.*;

class Solution {
    public String solution(String s) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        StringTokenizer st = new StringTokenizer(s, " ");
        ArrayList<Integer> nums = new ArrayList<>();
        while(st.hasMoreTokens()) nums.add(Integer.parseInt(st.nextToken()));
        
        for(int k : nums) {
            max = Math.max(max, k);
            min = Math.min(min, k);
        }
        return min+" "+max;
    }
}