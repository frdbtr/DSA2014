public class MyMatrix{

	static void showMatrix(int[][] array){
		int y = array.length;
		int x = array[0].length;
		for(int i = 0; i < y; i++){
			for(int j = 0; j < x; j++){
				System.out.print("\t" + array[i][j]);
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}

	static void add(int[][] a, int[][] b, int[][] c){
		int y = a.length;
		int x = a[0].length;
		for(int i = 0; i < y; i++){
			for(int j = 0; j < x; j++){
				c[i][j] = a[i][j] + b[i][j];
			}
		}
	}

	static void sub(int[][] a, int[][] b, int[][] c){
		int y = a.length;
		int x = a[0].length;
		for(int i = 0; i < y; i++){
			for(int j = 0; j < x; j++){
				c[i][j] = a[i][j] - b[i][j];
			}
		}		
	}

	public static void main(String[] args){
		int[][] mA = {{1, 2, 3}, {4, 5, 6}};
		int[][] mB = {{6, 3, 4}, {5, 1, 2}};

		int[][] mC = new int [2][3];
		int[][] mD = new int [2][3];

		System.out.println("mA");
		showMatrix(mA);
		System.out.println("mB");
		showMatrix(mB);

		add(mA, mB, mC);
		sub(mA, mB, mD);

		System.out.println("mC");
		showMatrix(mC);
		System.out.println("mD");
		showMatrix(mD);
	}
}