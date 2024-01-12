import java.util.Arrays;

/*
전체 논문의 인용횟수를 값으로 가진 배열에서 "전체 n편 논문 중 h편의 논문이 h회 이상 인용되었다." 조건에 부합하는 h를 찾아야한다. 이 때, 과학자가 발표한 전체 논문 수 n과 H-Index가 될 수 있는 h의 관계는 [h <= n]
*/
public class Solution {
    public int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);
        for (int i = 0; i < citations.length; i++) {
            int h = citations.length - i;
            if (citations[i] >= h) {
                answer = h;
                break;
            }
        }

        return answer;
    }
}