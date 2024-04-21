class Solution {
    static final int pizza = 7;
    
    public int solution(int n) {
        return n/pizza + (n % pizza == 0 ? 0 : 1);
    }
}