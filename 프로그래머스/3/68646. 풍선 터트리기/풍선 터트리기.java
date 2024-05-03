class Solution {
    public int solution(int[] a) {
        int len = a.length;

        // 원소가 1개면 답은 1이다.
        if(len == 1) 
            return 1;

        int[] leftMin = new int[len]; //각 인덱스에서 왼쪽 원소의 최소값을 저장
        int[] rightMin = new int[len]; //각 인덱스에서 오른쪽 원소의 최대값을 저장
        int l = a[0]; //왼쪽 값 중 최소값
        int r = a[len - 1]; //오른쪽 값 중 최소값
        
        for(int i = 1; i < len - 1; i++) {
            // 왼쪽부터 원소의 최소값을 저장
            if(l > a[i]) 
                l = a[i];

            leftMin[i] = l;

            // 오른쪽부터 원소의 최소값을 저장
            if(r > a[len - i - 1])
                r = a[len - i - 1];

            rightMin[len - i - 1] = r;
        }


        // 반환할 값. 원소가 2개 이상일때 무조건 2개 이상은 남게된다.
        int answer = 2;
        for(int i = 1; i <= a.length - 2; i++) {
            if(a[i] > leftMin[i] && a[i] > rightMin[i]) continue;
            answer++;
        }

        return answer;
    }
}