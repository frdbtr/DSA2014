import java.util.Scanner;

class Comparison{
    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	int i = sc.nextInt();
	int j = sc.nextInt();
	if(i > j){
	    System.out.println(i+"は"+j+"より大きい値です。");
	}else if(i < j){
	    System.out.println(j+"は"+i+"より大きい値です。");
	}else {
	    System.out.println("2つの数字は同じ値です。");
	}
    }
}