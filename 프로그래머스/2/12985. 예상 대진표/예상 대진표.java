class Solution {
    public int solution(int n, int a, int b) {
        int index = 1;

        while(!isRival(a, b)) {
            a = win(a);
            b = win(b);
            index++;
        }

        return index;
    }

    public static int win(int N) {
        return (N%2 == 0) ? N/2 : N/2+1;
    }
    
    public static int getRival(int N) {
        return (N%2 == 0) ? N-1 : N+1;
    }

    public static boolean isRival(int A, int B) {
        return B == getRival(A);
    }
}