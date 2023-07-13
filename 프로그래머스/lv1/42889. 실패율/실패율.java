import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        List<Per> p = new ArrayList<>();
        // 총 인원수
        int total = stages.length;
        
        // 스테이지별 인원 수
        int[] s = new int[N+2];
        for(int k : stages) s[k]++;
        
        for(int i=1; i<=N; i++) {
            if(total != 0) {
                p.add(new Per(i,(double)s[i]/total));
                total -= s[i];       // 인원수 차감
            } else {
                p.add(new Per(i, 0));
            }
            
        }
        
        Collections.sort(p);
        
        int[] answer = new int[N];
        for(int i=0; i<N; i++) {
            answer[i] = p.get(i).index;
        }
        
        return answer;
    }
    
    static class Per implements Comparable<Per> {
        int index;
        double failP;
        
        public Per(int index, double failP) {
            this.index = index;
            this.failP = failP;
        }
        
        @Override
        public int compareTo(Per other) {
            if(failP == other.failP) return index - other.index;
            return (-1) * Double.compare(failP, other.failP);
        }
    }
}