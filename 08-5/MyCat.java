import java.io.*;

class MyCat{

    public static void main(String[] args){

	if(args.length < 1){
	    System.out.println("ファイル名がないよ。");
	    System.exit(1);
	}
	for(int i = 0; i < args.length; i++){
	    try{
		File file = new File(args[i]);
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);

		String str;
		System.out.println(args[i]);
		while((str = br.readLine()) != null){
		    System.out.println(str);
		}
		System.out.println();
		br.close();
	    }
	    catch(IOException e){
		System.out.println(e);
	    }
	}
    }
}