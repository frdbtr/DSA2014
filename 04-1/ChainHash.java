// �`�F�C���@�ɂ��n�b�V��

public class ChainHash<Integer,String> {

	//--- �n�b�V�����\������m�[�h ---//
	class Node<Integer,String> {
		private Integer key;					// �L�[�l
		private String data;				// �f�[�^
		private Node<Integer,String> next;		// �㑱�m�[�h�ւ̎Q��

		//--- �R���X�g���N�^ ---//
		Node(Integer key, String data, Node<Integer,String> next) {
			this.key  = key;
			this.data = data;
			this.next = next;
		}

		//--- �L�[�l��Ԃ� ---//
		Integer getKey() {
			return key;
		}

		//--- �f�[�^��Ԃ� ---//
		String getValue() {
			return data;
		}

		//--- �L�[�̃n�b�V���l��Ԃ� ---//
		public int hashCode() {
			return key.hashCode();
		}
	}

	private int	size;						// �n�b�V���\�̑傫��
	private Node<Integer,String>[] table;			// �n�b�V���\

	//--- �R���X�g���N�^ ---//
	public ChainHash(int capacity) {
		try {
			table = new Node[capacity];
			this.size = capacity;
		} catch (OutOfMemoryError e) {		// �\�𐶐��ł��Ȃ�����
			this.size = 0;
		}
	}

	//--- �n�b�V���l�����߂� ---//
	public int hashValue(Object key) {
		return key.hashCode() % size;
	}

	//--- �L�[�lkey�����v�f�̒T���i�f�[�^��ԋp�j ---//
	public String search(int key) {
		int hash = hashValue(key);			// �T������f�[�^�̃n�b�V���l
		Node<Integer,String> p = table[hash];			// ���ڃm�[�h

		while (p != null) {
			if (p.getKey().equals(key))
				return p.getValue();			// �T������
			p = p.next;							// �㑱�m�[�h�ɒ���
		}
		return null;							// �T�����s
	}

	//--- �L�[�lkey�E�f�[�^data�����v�f�̒ǉ� ---//
	public int add(Integer key, String data) {
		int hash = hashValue(key);			// �ǉ�����f�[�^�̃n�b�V���l
		Node<Integer,String> p = table[hash];			// ���ڃm�[�h

		while (p != null) {
			if (p.getKey().equals(key))	// ���̃L�[�l�͓o�^�ς�
				return 1;
			p = p.next;							// �㑱�m�[�h�ɒ���
		}
		Node<Integer,String> temp = new Node<Integer,String>(key, data, table[hash]);
		table[hash] = temp;					// �m�[�h��}��
		return 0;
	}

	//--- �L�[�lkey�����v�f�̍폜 ---//
	public int remove(Integer key) {
		int hash = hashValue(key);			// �폜����f�[�^�̃n�b�V���l
		Node<Integer,String> p = table[hash];			// ���ڃm�[�h
		Node<Integer,String> pp = null;					// �O��̒��ڃm�[�h

		while (p != null) {
			if (p.getKey().equals(key)) {	// ��������
				if (pp == null)
					table[hash] = p.next;
				else
					pp.next = p.next;
				return 0;
			}
			pp = p;
			p = p.next;							// �㑱�m�[�h�ɒ���
		}	
		return 1;								// ���̃L�[�l�͑��݂��Ȃ�
	}

	//--- �n�b�V���\���_���v ---//
	public void dump() {
		for (int i = 0; i < size; i++) {
			Node<Integer,String> p = table[i];
			System.out.printf("%02d  ", i);
			while (p != null) {
				System.out.printf("�� %s (%s)  ", p.getKey(), p.getValue());
				p = p.next;
			}
			System.out.println();
		}
	}
}
