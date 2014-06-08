public class IntChainHash {
    class Node{
	private int key;
	private Node next;

	Node(int key, Node next){
	    this.key = key;
	    this.next = next;
	}

	int getKey(){ return key; }

	public int hashCode(){ return key; }
    }

    private int size;
    private Node[] table;

    public IntChainHash(int capacity){
	try {
	    table = new Node[capacity];
	    this.size = capacity;
	} catch(OutOfMemoryError e) {
	    this.size = 0;
	}
    }

    public int hashValue(Object key){
	return key.hashCode() % size;
    }

    public boolean search(int key){
	int hash = hashValue(key);
	Node p = table[hash];
	while(p != null){
	    if(p.getKey() == (key))
		return true;
	    p = p.next;
	}
	return false;
    }

    public boolean add(int key){
	int hash = hashValue(key);
	Node p = table[hash];
	while (p != null) {
	    if(p.getKey() == key)
		return true;
	    p = p.next;
	}
	Node temp = new Node(key, table[hash]);
	table[hash] = temp;
	return false;
    }

    public boolean remove(int key){
	int hash = hashValue(key);
	Node p = table[hash];
	Node pp = null;
	while(p != null){
	    if(p.getKey() == key){
		if(pp == null)
		    table[hash] = p.next;
		else
		    pp.next = p.next;
		return true;
	    }
	    pp = p;
	    p = p.next;
	}
	return false;
    }

    public void dump(){
	for(int i = 0; i < size; i++){
	    Node p = table[i];
	    System.out.printf("%02d  ", i);
	    while(p != null){
		System.out.printf("→ %s ", p.getKey());
		p = p.next;
	    }
	    System.out.println();
	}
    }
}