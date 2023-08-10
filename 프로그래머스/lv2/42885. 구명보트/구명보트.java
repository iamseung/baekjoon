import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int count = 0, index = 0;
        Arrays.sort(people);
        for(int i=people.length-1; i>=0; i--) {
            // 가장 무거운 사람과 가벼운 사람이 switching 되는 경우
            if(index > i) {
                break;
            }
            // 가장 무거운 사람과 가벼운 사람의 합이 limit 보다 작은지 확인
            if(people[i] + people[index] <= limit) {
                index++;
            }
            count++;
        }
        return count;
    }
}