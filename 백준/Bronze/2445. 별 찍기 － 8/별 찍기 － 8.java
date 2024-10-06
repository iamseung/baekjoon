import java.util.Scanner;
 
public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        // 윗부분 출력
        for (int i = N - 1; i >= 0; i--) {
            // 왼쪽 별 출력
            for (int j = 1; j <= N - i; j++) {
                System.out.print("*");
            }
            
            // 짝수 공백 출력
            for (int j = 1; j <= 2 * i; j++) {
                System.out.print(" ");
            }
            
            // 오른쪽 별 출력
            for (int j = 1; j <= N - i; j++) {
                System.out.print("*");
            }
            
            // 줄바꿈
            System.out.println();
        }
        
        // 아랫부분 출력
        for (int i = 1; i < N; i++) {
            // 왼쪽 별 출력
            for (int j = 1; j <= N - i; j++) {
                System.out.print("*");
            }
            
            // 짝수 공백 출력
            for (int j = 1; j <= 2 * i; j++) {
                System.out.print(" ");
            }
            
            // 오른쪽 별 출력
            for (int j = 1; j <= N - i; j++) {
                System.out.print("*");
            }
            
            // 줄바꿈
            System.out.println();
        }
    }
    
}
