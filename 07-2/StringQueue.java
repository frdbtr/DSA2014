public class StringQueue{
    private int max;
    private int front;
    private int rear;
    private int num;
    private String[] que;

    public class EmptyIntQueueException extends RuntimeException{
	public EmptyIntQueueException() { }
    }

    public class OverflowIntQueueException extends RuntimeException{
	public OverflowIntQueueException() { }
    }

    public StringQueue(int capacity){
	num = front = rear = 0;
	max = capacity;
	try{
	    que = new String[max];
	}catch(OutOfMemoryError e){
	    max = 0;
	}
    }

    public String enque(String x) throws OverflowIntQueueException{
	if(num >= max)
	    throw new OverflowIntQueueException();
	que[rear++] = x;
	num++;
	if(rear == max)
	    rear = 0;
	return x;
    }

    public String deque() throws EmptyIntQueueException{
	if(num <= 0)
	    throw new EmptyIntQueueException();
	String x = que[front++];
	num--;
	if(front == max)
	    front = 0;
	return x;
    }

    public String peek() throws EmptyIntQueueException{
	if(num <= 0)
	    throw new EmptyIntQueueException();
	return que[front];
    }

    public int indexOf(String x) {
	for(int i = 0; i < num; i++){
	    int idx = (i + front) % max;
	    if(que[idx] == x)
		return idx;
	}
	return -1;
    }

    public void clear() {
	num = front = rear = 0;
    }

    public int capacity(){
	return max;
    }

    public int size(){
	return num;
    }

    public boolean isEmpty() {
	return num<= 0;
    }

    public boolean isFull() {
	return num >= max;
    }

    public void dump() {
	for(int i = 0; i < max; i++){
	    System.out.print(i + ": " + que[i] + " ");
	    if(i == front)
		System.out.print("(front)");
	    if(i == rear)
		System.out.print("(rear)");
	    System.out.println();
	}
    }
}