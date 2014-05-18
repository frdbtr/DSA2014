import java.util.Scanner;

class BinSearchX{
    
    static int binSearchX(int[] a, int n, int key){
	int pl = 0;
	int pr = n - 1;
	int pc;

	do{
	    pc = (pl + pr) / 2;
	    System.out.println("{pl, pc, pr} = {"+pl+", "+pc+", "+pr+"}");
	    if(a[pc] == key)
		return pc;
	    else if(a[pc] < key)
		pl = pc + 1;
	    else
		pr = pc - 1;
	}while(pl <= pr);

	return -1;
    }

    static int seqSearch(int[] array, int n, int key){
	int result = 0;

	for(int i = n; i < array.length; i++){
	    if(array[i] == key) result = i;
	}
	return result;
    }

    public static void main(String[] args){
	Scanner stdIn = new Scanner(System.in);

	System.out.print("要素数 : ");
	int num = stdIn.nextInt();
	int[] x = new int[num];

	System.out.println("昇順に入力してください。");

	System.out.print("x[0] : ");
	x[0] = stdIn.nextInt();

	for(int i = 1; i < num; i++){
	    do{
		System.out.print("x[" + i + "] : ");
		x[i] = stdIn.nextInt();
	    } while (x[i] < x[i - 1]);
	}

	System.out.print("探す値 : ");
	int ky = stdIn.nextInt();

	int idx = binSearchX(x, num, ky);

	if(idx != -1) idx = seqSearch(x, idx, ky);

	if(idx == -1)
	    System.out.println("その値の要素は存在しません。");
	else
	    System.out.println("その値はx[" + idx + "]にあります。");
    }
}
