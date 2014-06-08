import java.util.Scanner;

class StringStackTester{
    public static void main(String[] args){
	Scanner stdIn = new Scanner(System.in);
	StringStack s = new StringStack(20);

	while(true){
	    System.out.println("現在のデータ数：" + s.size() + " / " + s.capacity());
	    System.out.print("(1)プッシュ  (2)ポップ  (3)ピーク  " + "(4)ダンプ  (0)終了：");
	    int menu = stdIn.nextInt();
	    if(menu == 0) break;

	    String x;
	    switch(menu){
	    case 1:
		System.out.print("データ：");
		x = stdIn.next();
		try{
		    s.push(x);
		}catch(StringStack.OverflowIntStackException e){
		    System.out.println("スタックが満杯です。");
		}
		break;
		
	    case 2:
		try{
		    x = s.pop();
		    System.out.println("ポップしたデータは" + x + "です。");
		}catch(StringStack.EmptyIntStackException e){
		    System.out.println("スタックが空です。");
		}
		break;

	    case 3:
		try{
		    x = s.peek();
		    System.out.println("ピークしたデータは" + x + "です。");
		}catch(StringStack.EmptyIntStackException e){
		    System.out.println("スタックが空です。");
		}
		break;

	    case 4:
		s.dump();
		break;
	    }
	}
    }
}