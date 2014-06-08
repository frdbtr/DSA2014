import java.util.Scanner;

class Fibonacci{

    static int fibonacci(int n){
	if(n <= 0)
	    return 0;
	else if(n == 1)
	    return 1;
	else
	    return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args){
	Scanner stdIn = new Scanner(System.in);

	System.out.print("n = ");
	int n = stdIn.nextInt();

	for(int i = 0; i <= n; i++){
	    System.out.print(fibonacci(i) + ", ");
	}
	System.out.println();
    }
}