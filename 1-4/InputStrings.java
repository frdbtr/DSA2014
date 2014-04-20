import java.util.Scanner;

class InputStrings{
    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	String[] str = new String [5];
	String[] rstr = new String [5];
	System.out.println("5個の文字列を入力");
	str[0] = sc.next();
	str[1] = sc.next();
	str[2] = sc.next();
	str[3] = sc.next();
	str[4] = sc.next();
	System.out.println("入力順\t逆順");
	for(int i = 0; i < str.length; i++){
	    System.out.print(str[i]+"\t");
	    for(int j = 1; j <= str[i].length(); j++){
		System.out.print(str[i].charAt(str[i].length()-j));
	    }
	    System.out.print("\n");
	}
    }
}