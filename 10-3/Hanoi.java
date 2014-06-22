import java.util.Scanner;

class HanoiStick{

	int[] discs;
	int max;
	int ptr;
	String stickName;

	HanoiStick(String name, int max){
		stickName = name;
		discs = new int[max];
		ptr = 0;
	}

	void push(int disc){
		discs[ptr] = disc;
		ptr++;
		return;
	}

	void pop(){
		ptr--;
		return;
	}

	void dump(){
		System.out.print(stickName + "軸： ");

		for(int i = 0; i < ptr; i++)
			System.out.print(discs[i] + " ");
		System.out.println();
	}
}

public class Hanoi{
	
	static HanoiStick A;
	static HanoiStick B;
	static HanoiStick C;

	static void move(int no, int x, int y){
		if(no > 1)
			move(no - 1, x, 6 - x - y);

		String xName = "";
		String yName = "";

		switch(x){
			case 1:
				xName = "A";
				A.pop();
				break;
			case 2:
				xName = "B";
				B.pop();
				break;
			case 3:
				xName = "C";
				C.pop();
				break;
		}
		switch(y){
			case 1:
				yName = "A";
				A.push(no);
				break;
			case 2:
				yName = "B";
				B.push(no);
				break;
			case 3:
				yName = "C";
				C.push(no);
				break;
		}
		
		System.out.println("円盤[" + no + "]を" + xName + "軸から" + yName + "軸へ移動");

		A.dump();
		B.dump();
		C.dump();

		if(no > 1)
			move(no - 1, 6 - x - y, y);
	}

	public static void main(String[] args){
		Scanner stdIn = new Scanner(System.in);

		System.out.println("ハノイの塔");
		System.out.print("円盤の枚数：");
		int n = stdIn.nextInt();

		A = new HanoiStick("A", n);
		B = new HanoiStick("B", n);
		C = new HanoiStick("C", n);

		for(int i = n; i > 0; i--)
			A.push(i);
		A.dump();
		B.dump();
		C.dump();

		move(n, 1, 3);
	}
}