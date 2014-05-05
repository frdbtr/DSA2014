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

	static void multiply(int[][] a, int[][] b, int[][] c){
		int y = a.length;
		int x = b[0].length;
		int by = b.length;
		int ax = a[0].length;
		for(int i = 0; i < y; i++){
			for(int j = 0; j < x; j++){
				int result = 0;
				for(int m = 0; m < ax; m++){
					result += a[i][m] * b[m][j];
				}
				c[i][j] = result;
			}
		}
	}

	public static void main(String[] args){
		int[][] mA = {{1, 2, 3}, {4, 5, 6}};
		int[][] mB = {{1, 5}, {5, 3}, {8, 1}};

		int[][] mC = new int [2][2];

		System.out.println("mA");
		showMatrix(mA);
		System.out.println("mB");
		showMatrix(mB);

		multiply(mA, mB, mC);

		System.out.println("mC");
		showMatrix(mC);
	}
}