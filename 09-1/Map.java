import java.util.Random;

class Map{
    static int width,height;
    static int[][] map;

    public static void generateMap(){
	map = new int[height][width];
	Random rnd = new Random();
	for(int i = 0; i < height; i++){
	    for(int j = 0; j < width; j++){
		if(i == 0 || i == height - 1 || j == 0 || j == width - 1){
		    map[i][j] = 0;
		}else{
		    map[i][j] = rnd.nextInt(11) - 5;
		}
	    }
	}
    }

    public static void showMapValue()
    {
	for(int i = 0; i < height; i++){
	    for(int j = 0; j < width; j++){
		System.out.printf("%3d", map[i][j]);
	    }
	    System.out.println();
	}
    }

    public static void showMap(){
	for(int i = 0; i < height; i++){
	    for(int j = 0; j < width; j++){
		if(map[i][j] > 0)
		    System.out.print(" ");
		else if(map[i][j] < 0)
		    System.out.print("■");
		else
		    System.out.print("□");
		System.out.print(" ");
	    }
	    System.out.println();
	}
    }

    public static void main(String[] args){
	width = 21;
	height = 21;
	generateMap();
	showMapValue();
	showMap();
    }
}