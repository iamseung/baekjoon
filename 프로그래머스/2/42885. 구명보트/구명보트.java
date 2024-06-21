import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);

        int count = 0, L = 0;
        for(int R=people.length-1; R>=0; R--) {
            if(L > R)
                break;
            
            if(people[L] + people[R] <= limit) {
                L++;
            }

            count++;
        }
        
        return count;
    }
}