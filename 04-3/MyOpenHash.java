// �I�[�v���A�h���X�@�ɂ��n�b�V��

public class MyOpenHash<K,V> {

	//--- �o�P�b�g�̏�� ---//
	enum Status {OCCUPIED, EMPTY, DELETED};	// {�f�[�^�i�[, ��, �폜�ς�}

	//--- �o�P�b�g ---//
	static class Bucket<K,V> {
		private K key;						// �L�[�l
		private V data;					// �f�[�^
		private Status stat;				// ���

		//--- �R���X�g���N�^ ---//
		Bucket() {
			stat = Status.EMPTY;	// �o�P�b�g�͋�
		}

		//--- �S�t�B�[���h�ɒl��ݒ� ---//
		void set(K key, V data, Status stat) {
			this.key  = key;			// �L�[�l
			this.data = data;			// �f�[�^
			this.stat = stat;			// ���
		}

		//--- ��Ԃ�ݒ� ---//
		void setStat(Status stat) {
			this.stat = stat;
		}

		//--- �L�[�l��Ԃ� ---//
		K getKey() {
			return key;
		}

		//--- �f�[�^��Ԃ� ---//
		V getValue() {
			return data;
		}

		//--- �L�[�̃n�b�V���l��Ԃ� ---//
		public int hashCode() {
			return key.hashCode();
		}
	}

	private int size;						// �n�b�V���\�̑傫��
	private Bucket<K,V>[] table;		// �n�b�V���\

	//--- �R���X�g���N�^ ---//
	public MyOpenHash(int size) {
		try {
			table = new Bucket[size];
			for (int i = 0; i < size; i++)
				table[i] = new Bucket<K,V>();
			this.size = size;
		} catch (OutOfMemoryError e) {		// �\�𐶐��ł��Ȃ�����
			this.size = 0;
		}
	}

	//--- �n�b�V���l�����߂� ---//
	public int hashValue(Object key) {
		return key.hashCode() % size;
	}

	//--- �ăn�b�V���l�����߂� ---//
	public int rehashValue(int hash) {
		return (hash + 1) % size;
	}

	//--- �L�[�lkey�����o�P�b�g�̒T�� ---//
	private Bucket<K,V> searchNode(K key) {
		int hash = hashValue(key);			// �T������f�[�^�̃n�b�V���l
		Bucket<K,V> p = table[hash];		// ���ڃo�P�b�g

		for (int i = 0; p.stat != Status.EMPTY && i < size; i++) {
			if (p.stat == Status.OCCUPIED && p.getKey().equals(key))
				return p;
			hash = rehashValue(hash);		// �ăn�b�V��
			p = table[hash];
		}
		return null;
	}

	//--- �L�[�lkey�����v�f�̒T���i�f�[�^��ԋp�j---//
	public V search(K key) {
		Bucket<K,V> p = searchNode(key);
		if (p != null)
			return p.getValue();
		else
			return null;
	}

	//--- �L�[�lkey�E�f�[�^data�����v�f�̒ǉ� ---//
	public int add(K key, V data) {
		if (search(key) != null)
			return 1;							// ���̃L�[�l�͓o�^�ς�

		int hash = hashValue(key);			// �ǉ�����f�[�^�̃n�b�V���l
		Bucket<K,V> p = table[hash];		// ���ڃo�P�b�g
		for (int i = 0; i < size; i++) {
			if (p.stat == Status.EMPTY || p.stat == Status.DELETED) {
				p.set(key, data, Status.OCCUPIED);
				return 0;
			}
			hash = rehashValue(hash);		// �ăn�b�V��
			p = table[hash];
		}
		return 2;								// �n�b�V���\�����t
	}

	//--- �L�[�lkey�����v�f�̍폜 ---//
	public int remove(K key) {
		Bucket<K,V> p = searchNode(key);	// ���ڃo�P�b�g
		if (p == null)
			return 1;							// ���̃L�[�l�͓o�^����Ă��Ȃ�

		p.setStat(Status.DELETED);
		return 0;
	}

	//--- �n�b�V���\���_���v ---//
	public void dump() {
		for (int i = 0; i < size; i++) {
			System.out.printf("%02d ", i);
			switch (table[i].stat) {
			 case OCCUPIED : 
				System.out.printf("%s\n", 
										table[i].getValue());
				break;

			 case EMPTY :
			 	System.out.println("-- ���o�^ --");	break;

			 case DELETED :
			 	System.out.println("-- �폜�� --");	break;
			}
		}
	}
}
