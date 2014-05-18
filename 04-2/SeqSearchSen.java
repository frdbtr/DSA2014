import java.util.Scanner;
import java.util.Random;

public class SeqSearchSen{

    static void generateRandomValues(int[] array, int maxValue){
	Random rand = new Random();
	for(int i = 0; i < array.length; i++){
	    array[i] = rand.nextInt(maxValue);
	}
	return;
    }

    static void showArray(int[] array){
	System.out.println("要素数= "+(array.length-1));
	for(int i = 0; i < array.length-1; i++){
	    System.out.println("data["+i+"] = "+array[i]);
	}
    }

    static int seqSearch(int[] array, int n, int key){
	array[n] = key;
	int i = 0;
	while(true){
	    if(array[i] == key) break;
	    i++;
	}
	return i == n ? -1 : i;
    }

    public static void main(String[] args){
	Scanner stdIn = new Scanner(System.in);
	System.out.print("要素数の入力: ");
	int num = stdIn.nextInt();
	int[] x = new int[num+1];
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