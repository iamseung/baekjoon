import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int num = sc.nextInt();
    int length = 0; // 입력해준 num 
    int count = 0;  // 입력해준 num보다 한자리작을때 나올수있는 최대갯수
    int total = 0;  // 최종값
    int nine = 9;   // 계산위한 값

    int n = num;  
    while(n > 0){  	// 길이 구하기
      n /=10;
      length ++;
    }

    // 입력해준 num보다 한자리작을때 나올수있는 최대갯수
    for(int i = 1 ; i< length; i++){  
      count = nine*i + count;
      nine*=10;


    }
	
    // 입력한 num보다 한자리 작은 최대 수
    int temp = (int)(Math.pow(10,length-1)-1);
    // 구해놓은 최대 갯수(count) + num보다 한자리 작은 최대 수에서의 갯수
    total = (num-temp)*length + count;

    System.out.println(total);


  }
}