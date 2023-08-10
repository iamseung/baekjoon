import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int[] arr = new int[10000001];
        List<Integer> cnt = new ArrayList<>();
        // 타입별 귤의 개수를 체크
        for(int t : tangerine) arr[t]++;
        // 귤의 개수가 있는 것들을 수집
        for(int i=1; i<=10000000; i++) {
            if(arr[i] == 0) continue;
            cnt.add(arr[i]);
        }
        // 귤의 개수가 많은 순으로 정렬
        Collections.sort(cnt, Collections.reverseOrder());
        
        int answer = 0;
        
        for(int c : cnt) {
            // 리미트가 더 크거나 같은 경우
            if(k<=0) break;
                
            k -= c;
            answer++;
        }
        
        return answer;
    }
}