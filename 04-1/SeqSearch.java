import java.util.Scanner;
import java.util.Random;

public class SeqSearch{

    static void generateRandomValues(int[] array, int maxValue){
	Random rand = new Random();
	for(int i = 0; i < array.length; i++){
	    array[i] = rand.nextInt(maxValue);
	}
	return;
    }

    static void showArray(int[] array){
	System.out.println("要素数 = "+array.length);
	for(int i = 0; i < array.length; i++){
	    System.out.println("data["+i+"] = "+array[i]);
	}
    }

    static int seqSearch(int[] array, int n, int key){
	int i = 0;
	for(; ;){
	    if(i == n){
		i = -1;
		break;
	    }
	    if(array[i] == key) break;
	    i++;
	}
	return i;
    }

    public static void main(String[] args){
	Scanner stdIn = new Scanner(System.in);
	System.out.print("要素数の入力: ");
	int num = stdIn.nextInt();
	int[] x = new int[num];
	generateRandomValues(x, 10);
	showArray(x);
	System.out.print("探す値: ");
	int ky = stdIn.nextInt();
	int idx = seqSearch(x, num, ky);
	if(idx == -1){
	    System.out.println("その値の要素は存在しません。");
	}
	else{
	    System.out.println("その値はx[" + idx + "]にあります。");
	}
    }
}