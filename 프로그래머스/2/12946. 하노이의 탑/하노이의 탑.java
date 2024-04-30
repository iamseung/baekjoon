import java.util.*;
import java.util.stream.*;

class Solution {
    static List<int[]> seq = new ArrayList<>();
    
    public int[][] solution(int n) {
        Hanoi(n, 1, 2, 3);
        
        return seq.stream()
                    .toArray(int[][]::new); 
    }
    
    public void Hanoi(int N, int start, int mid, int to) {
		if (N == 1) {
            seq.add(new int[]{start,to});
			return;
		}

		Hanoi(N - 1, start, to, mid);
    
		seq.add(new int[]{start,to});
    
		Hanoi(N - 1, mid, start, to);
	}
}