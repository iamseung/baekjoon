class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0; // 설치할 기지국 개수
        int now = 1; // 현재 위치
        int idx = 0; // 기지국 인덱스
        int len = stations.length;

        while (now <= n) {
            // 1. 설치된 기지국 이외의 위치 또는 이미 다 조회, 설치해주어야 함
            if (idx >= len || now < stations[idx] - w) {
                answer++; // now + w 에 기지국 설치
                now += w * 2 + 1; // 설치 후, now 의 위치 이동
            } else {
                // 2. 이전에 설치된 기지국 범위 안이라 간주, 현재 위치를 설치된 기지국 밖으로 이동
                now = stations[idx] + w + 1;
                idx++;
            }
        }

        return answer;
    }
}