import java.util.*;

class Solution {
    static boolean[] prime = new boolean[500001];
    
    public int solution(int[] nums) {
        int cnt = 0;
        getPrime();
        for(int i=0; i<nums.length-2; i++) {
            for(int j=i+1; j<nums.length-1; j++) {
                for(int k=j+1; k<nums.length; k++) {
                   if(!prime[nums[i] + nums[k] + nums[j]]) cnt++;
                }
            }
        }

        return cnt;
    }
    
    static void getPrime()
    {
        // 0과 1은 소수가 아님, true
        prime[0] = prime[1] = true;
        
        for(int i=2; i<=500000; i++) {
            for(int j=2; i*j<500000; j++) {
                prime[i*j] = true;
            }
        }
    }
}