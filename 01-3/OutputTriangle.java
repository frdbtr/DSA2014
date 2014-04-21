class OutputTriangle{
    public static void main(String[] args){
	int i = 1;
	do{
	    int j = 0;
	    do{
		if(j != 0){
		    System.out.print("+-");
		}
		j++;
	    }while(j < i);
	    System.out.println("+-");
	    i++;
	}while(i < 5);
    }
}
		    