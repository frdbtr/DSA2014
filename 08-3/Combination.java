import java.util.Scanner;

class Combination{

    static int combination(int n, int r){
	if(n <= 0 || r <= 0 || n == r)
	    return 1;
	else
	    return combination(n-1, r) + combination(n-1, r-1);
    }

    public static void main(String[] args){
	Scanner stdIn = new Scanner(System.in);

	System.out.print("n = ");
	int x = stdIn.nextInt();
	System.out.print("r = ");
	int y = stdIn.nextInt();

	System.out.println(x + "C" + y +" = " + combination(x, y));

    }
}