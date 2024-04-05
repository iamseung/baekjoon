import java.util.*;

class Solution {
    static int c, N;
    static boolean[] visit;
    public int solution(int[] cards) {
        N = cards.length;
        visit = new boolean[N+1];
        List<Integer> list = new ArrayList<>();
        
        int one;
        while((one = findOne()) != -1) {
            c = 0;
            rec(cards, one);
            list.add(c);
        }
        
        Collections.sort(list, ((a, b) -> (a - b)));

        if(list.size() <= 1)
            return 0;

        return list.get(list.size() - 1) * list.get(list.size() - 2);
    }
    
    static void rec(int[] cards, int k) {
        visit[k] = true;
        c++;

        if(visit[cards[k-1]])
            return;

        rec(cards, cards[k-1]);
    }
    
    static int findOne() {
        int one = -1;
        for(int i=1; i<=N; i++) {
            if(!visit[i]) {
                one = i;
                break;
            }
        }

        return one;
    }
}