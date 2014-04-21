import java.util.Scanner;

public class StarPira{
    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	int dan;
	do{
	    System.out.print("段数？");
	    dan = sc.nextInt();
	}while(dan <= 0);
	spira(dan);
    }

    static void spira(int d){
	int width;
	for(int i = 0; i < d; i++){
	    width = (d - i) * 2 - 1;
	    for(int j = 0; j < i; j++){
		System.out.print(" ");
	    }
	    for(int j = 0; j < width; j++){
		System.out.print("*");
	    }
	    System.out.print("\n");
	}
    }
}