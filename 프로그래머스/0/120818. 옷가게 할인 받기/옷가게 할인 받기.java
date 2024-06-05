class Solution {
    public int solution(int price) {
         if (price >= 500000) {
            return (int)(price * 0.8); // 20% discount
        } else if (price >= 300000) {
            return (int)(price * 0.9); // 10% discount
        } else if (price >= 100000) {
        return (int)(price * 0.95); // 5% discount
        } else {
            return price; // no discount
        }
    }
}