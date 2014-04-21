import java.util.Scanner;

public class CardConv{
    public static void main(String[] args){

	Scanner sc = new Scanner(System.in);
	int no;
	int cd;
	int dno;
	char[] cno = new char[32];

	do{
	    System.out.print("変換する非負の整数 : ");
	    no = sc.nextInt();
	}while(no <= 0);
	do{
	    System.out.print("何進数に変換しますか ");
	    cd = sc.nextInt();
	}while(cd <= 0);
	dno = cardConv(no, cd, cno);
	System.out.print(no+"は"+cd+"進数では");
	for(int i = cno.length - dno; i < cno.length; i++){
	    System.out.print(cno[i]);
	}
	System.out.println("です");
    }

    static int cardConv(int x, int r, char[] d){
	int digits = 0;
	String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	do{
	    System.out.println(r + " | " + x + "\n  +-----");
	    d[digits++] = dchar.charAt(x % r);
	    x /= r;
	}while(x != 0);
	reverse(d);
	return digits;
    }

    static void swap(char[] array, int idx1, int idx2){
	char t = array[idx1];
	array[idx1] = array[idx2];
	array[idx2] = t;
    }

    static void reverse(char[] array){
	for(int i = 0; i < array.length/2; i++){
	    swap(array, i, array.length - i - 1);
	}
    }
}