import java.util.Scanner;

class Hanoi{
	
	static void move(int no, int x, int y){
		if(no > 1)
			move(no - 1, x, 6 - x - y);

		String xName = "";
		String yName = "";

		switch(x){
			case 1:
				xName = "A";
				break;
			case 2:
				xName = "B";
				break;
			case 3:
				xName = "C";
				break;
		}
		switch(y){
			case 1:
				yName = "A";
				break;
			case 2:
				yName = "B";
				break;
			case 3:
				yName = "C";
				break;
		}
		
		System.out.println("円盤[" + no + "]を" + xName + "軸から" + yName + "軸へ移動");

		if(no > 1)
			move(no - 1, 6 - x - y, y);
	}

	public static void main(String[] args){
		Scanner stdIn = new Scanner(System.in);

		System.out.println("ハノイの塔");
		System.out.print("円盤の枚数：");
		int n = stdIn.nextInt();

		move(n, 1, 3);
	}
}