class TextAnalyzer{

    public static boolean isDigits(String str){
	String nums = "1234567890";
	for(int i = 0; i < str.length(); i++){
	    for(int j = 0; j < nums.length(); j++){
		if(str.charAt(i) == nums.charAt(j))
		    return true;
	    }
	}
	return false;
    }

    public static void main(String[] args){
	String target = "Today is May 20 2013";

	String[] tokens = target.split(" ");
	int tokenNum = tokens.length;

	System.out.println("target = " + target);
	System.out.println("tokenNum = " + tokenNum);

	for(int i=0; i<tokenNum; i++){
	    System.out.print(i + ":" + tokens[i]);
	    if(isDigits(tokens[i]))
		System.out.println(" (digit)");
	    else
		System.out.println();
	}
    }
}