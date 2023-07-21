class Solution {
    static int[] alpha = new int[26];
    public int[] solution(String[] keymap, String[] targets) {
        // 초기화
        for(int i=0; i<26; i++) alpha[i] = Integer.MAX_VALUE;
        // 최소 index 저장
        for(String str : keymap) {
            for(int i=0; i<str.length(); i++) {
                // 저장되어 있는 값과 현재 인덱스 중 최솟값 저장
                alpha[str.charAt(i)-'A'] = Math.min(alpha[str.charAt(i)-'A'], i);
            }
        }
        // 정답배열
        int[] answer = new int[targets.length];
        // 비교
        for(int i=0; i<targets.length; i++) {
            for(int j=0; j<targets[i].length(); j++) {
                if(alpha[targets[i].charAt(j)-'A'] == Integer.MAX_VALUE) {
                    answer[i] = -1;
                    break;
                }
                
                // 0부터 인덱스를 잡기 때문에 +1
                answer[i] += alpha[targets[i].charAt(j)-'A']+1;
            }
        }
        
        return answer;
    }
}