import java.util.*;

class Solution {
    static Set<Integer> resultList = new HashSet<>();
    
    public int solution(String numbers) { 
        int len = numbers.length();
        int[] arr = new int[len];

        for(int i=0; i<len; i++) 
            arr[i] = numbers.charAt(i) - '0';
            
        // 1개부터 모두 고르는 조합을 구한다.
        for(int i=1; i<=len; i++) 
            permutation(arr, 0, len, i);

        return resultList.size();
    }
    
    // n개 중에서 r개를 순서있게 뽑기
    static void permutation(int[] arr, int depth, int n, int r) {
        if(depth == r) {
            String number = "";
            for(int i=0; i<r; i++) {
                number += arr[i];
            }

            if(isPrime(Integer.valueOf(number))) 
                resultList.add(Integer.valueOf(number));

            return;
        }

        for(int i=depth; i<n; i++) {
            swap(arr, depth, i);
            permutation(arr, depth + 1, n, r);
            swap(arr, depth, i);
        }
    }
    
    static void swap(int[] arr, int depth, int i) {
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }

    static boolean isPrime(int N) {
        if(N < 2) return false;

        for(int i=2; i<=(int) Math.sqrt(N); i++) {
            if(N % i == 0) {
                return false;
            }
        }

        return true;
    }
    
}