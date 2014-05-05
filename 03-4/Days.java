import java.util.Scanner;

public class Days{

	static int[][] mdays = {
		{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},
		{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}
	};

	static int isLeap(int year){
		return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? 1 : 0;
	}

	static int getDays(int y, int m, int d){
		int dy = (y-1) * 365;
		int dl = y/4 - y/100 + y/400;
		int dm = 0;
		for(int i = 1; i < m; i++){
			dm += mdays[isLeap(y)][i - 1];
		}
		return dy+dl+dm+d-1;
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		System.out.println("1つ目の日付");
		System.out.print("西暦: ");
		int y1 = sc.nextInt();
		System.out.print("月: ");
		int m1 = sc.nextInt();
		System.out.print("日 ");	
		int d1 = sc.nextInt();

		System.out.println("2つ目の日付");
		System.out.print("西暦: ");
		int y2 = sc.nextInt();
		System.out.print("月: ");
		int m2 = sc.nextInt();
		System.out.print("日 ");	
		int d2 = sc.nextInt();

		System.out.println(y1+"/"+m1+"/"+d1+"～"+y2+"/"+m2+"/"+d2 + " は " + (getDays(y2, m2, d2) - getDays(y1, m1, d1)) + "日です。");

	}
}