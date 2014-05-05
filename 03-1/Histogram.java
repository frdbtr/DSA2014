import java.util.Scanner;
import java.util.Random;

public class Histogram{

	static void generateRandomValues(int[] array, int maxValue){
		Random rand = new Random();
		for(int i = 0; i < array.length; i++){
			array[i] = rand.nextInt(maxValue);
		}
		return;
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		System.out.print("乱数の個数nの入力: ");
		int n = sc.nextInt();

		System.out.print("乱数の最大値maxの入力: ");
		int max = sc.nextInt();

		int[] numarray = new int[n];
		generateRandomValues(numarray, max);

		for(int i = 0; i < numarray.length; i++){
			int num = 0;
			for(int j = 0; j < numarray.length; j++){
				if(i == numarray[j]){
					num++;
				}
			}
			System.out.print(i + ": " + num + " ");
			for(int j = 0; j < num; j++){
				System.out.print("*");
			}
			System.out.print("\n");
		}
	}
}