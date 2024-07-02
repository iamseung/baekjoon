import java.util.*;

class Solution {
    static final int len = 10000000;
    static boolean[] prime = new boolean[len];
    static Set<Integer> resultList = new HashSet<>();
    
    public int solution(String numbers) {
        makePrimeArr();

        int len = numbers.length();
        char[] arr = numbers.toCharArray();

        for(int i=1; i<=len; i++)
            permutation(arr, 0, len, i);
        
        return resultList.size();
    }
    
    // n 개 중에 r 개
    static void permutation(char[] arr, int depth, int n, int r) {
        if(depth == r) {
            String number = "";
            for(int i=0; i<r; i++) {
                number += arr[i];
            }

            if(!prime[Integer.valueOf(number)]) 
                resultList.add(Integer.valueOf(number));

            return;
        }

        for(int i=depth; i<n; i++) {
            swap(arr, depth, i);
            permutation(arr, depth + 1, n, r);
            swap(arr, depth, i);
        }
    }

    static void swap(char[] arr, int depth, int i) {
        char temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }

    static void makePrimeArr() {
        prime[0] = prime[1] = true;

        for(int i=2; i<=(int) Math.sqrt(len); i++) {
            for(int j=2; i*j<len; j++)
                prime[i*j] = true;
        }
    }
}