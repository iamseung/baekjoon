import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int n, int[] numlist) {
        
        return Arrays.stream(numlist)
            .filter(i->i%n ==0)
            .map(i->i)
            .toArray();
    
    }
}