public class StringStack {
    private int max;
    private int ptr;
    private String[] stk;

    public class EmptyIntStackException extends RuntimeException{
	public EmptyIntStackException() { }
    }

    public class OverflowIntStackException extends RuntimeException {
	public OverflowIntStackException() { }
    }

    public StringStack(int capacity) {
	ptr = 0;
	max = capacity;
	try{
	    stk = new String[max];
	} catch(OutOfMemoryError e){
	    max = 0;
	}
    }

    public String push(String x) throws OverflowIntStackException{
	if(ptr >= max)
	    throw new OverflowIntStackException();
	return stk[ptr++] = x;
    }

    public String pop() throws EmptyIntStackException{
	if(ptr <= 0)
	    throw new EmptyIntStackException();
	return stk[--ptr];
    }

    public String peek() throws EmptyIntStackException{
	if(ptr <= 0)
	    throw new EmptyIntStackException();
	return stk[ptr - 1];
    }

    public int indexOf(String x){
	for(int i = ptr - 1; i >= 0; i--)
	    if(stk[i] == x)
		return i;
	return -1;
    }

    public void clear() {
	ptr = 0;
    }

    public int capacity(){
	return max;
    }

    public int size(){
	return ptr;
    }

    public boolean isEmpty(){
	return ptr <= 0;
    }

    public boolean isFull(){
	return ptr >= max;
    }

    public void dump() {
	if(ptr <= 0)
	    System.out.println("スタックは空です。");
	else {
	    for(int i = 0; i < max; i++){
		System.out.print("[" + i + "] " + stk[i]);
		if(i == ptr)
		    System.out.print("<-- ptr");
		System.out.println();
	    }
	    System.out.println();
	}
    }
}