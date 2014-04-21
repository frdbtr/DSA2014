import java.util.Scanner;
import java.util.Random;

public class MyArray{
    public static void main(String[] args){
	int num = 0;
	Scanner sc = new Scanner(System.in);
	do{
	    System.out.print("要素数を入力してください : ");
	    num = sc.nextInt();
	}while(num <= 0);
	int[] data = new int[num];

	generateRandomValues(data);
	show(data);

	System.out.println("\n最小値 = "+ minOf(data));
	System.out.println("最大値 = "+ maxOf(data));
	System.out.println("総和 = "+ sumOf(data) +"\n");

	reverse(data);
	System.out.println("逆順");
	show(data);
    }

    static void generateRandomValues(int[] array){
	Random rand = new Random();
	for(int i = 0;i < array.length; i++){
	    array[i] = rand.nextInt(100);
	}
    }

    static void show(int[] array){
	System.out.println("要素数 = "+array.length);
	for(int i = 0; i < array.length; i++){
	    System.out.println("data["+i+"] = "+array[i]);
	}
    }

    static void swap(int[] array, int idx1, int idx2){
	int t = array[idx1];
	array[idx1] = array[idx2];
	array[idx2] = t;
    }

    static void reverse(int[] array){
	for(int i = 0; i < array.length/2; i++){
	    swap(array, i, array.length - i - 1);
	}
    }

    static int minOf(int[] array){
	int min = array[0];
	for(int i = 1; i < array.length; i++){
	    if(array[i] < min){
		min = array[i];
	    }
	}
	return min;
    }

    static int maxOf(int[] array){
	int max = array[0];
	for(int i = 1; i < array.length; i++){
	    if(array[i] > max){
		max = array[i];
	    }
	}
	return max;
    }

    static int sumOf(int[] array){
	int sum = 0;
	for(int i = 0; i < array.length; i++){
	    sum += array[i];
	}
	return sum;
    }
}