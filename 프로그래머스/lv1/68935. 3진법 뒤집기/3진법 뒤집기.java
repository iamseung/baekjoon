class Solution {
    static StringBuilder sb;
    public int solution(int n) {
        // 10->3
        String three = Integer.toString(n, 3);
        // 앞뒤 반전
        String rev = new StringBuilder(three).reverse().toString();
        // 3->10
        return Integer.parseInt(rev, 3);
    }
}