// �I�[�v���A�h���X�@�ɂ��n�b�V���̗��p��

import java.util.Scanner;

public class MyOpenHashTester {

	static Scanner stdIn = new Scanner(System.in);

	//--- �f�[�^�i����ԍ��{�����j ---//
	static class Data {
		static final int NO   = 1;		// �ԍ���ǂݍ��ނ��H
		static final int NAME = 2;		// ������ǂݍ��ނ��H
		static final int HOMETOWN = 3;		// �o�g�n��ǂݍ��ނ��H
		static final int AGE = 4;		// �N���ǂݍ��ނ��H

		private Integer no;				// ����ԍ��i�L�[�l�j
		private String  name;			// ����
		private String hometown; //�o�g�n
		private Integer age; //�N��

		//--- �L�[�l ---//
		String keyCode() {
			return name;
		}

		//--- ������\����Ԃ� ---//
		public String toString() {
			return name + "(hometown:" + hometown + ", age:" + age + ")";
		}

		//--- �f�[�^�̓Ǎ��� ---//
		void scanData(String guide, int sw) {
			System.out.println(guide + "����f�[�^����͂��Ă��������B");

			if ((sw & NO) == NO) {
				System.out.print("�ԍ��F");
				no = stdIn.nextInt();
			}
			if ((sw & NAME) == NAME) {
				System.out.print("���O�F");
				name = stdIn.next();
			}
			if ((sw & HOMETOWN) == HOMETOWN) {
				System.out.print("�o�g�n�F");
				hometown = stdIn.next();
			}
			if ((sw & AGE) == AGE) {
				System.out.print("�N��F");
				age = stdIn.nextInt();
			}
		}
	}

	//--- ���j���[�񋓌^ ---//
	enum Menu {
		ADD(      "�f�[�^�ǉ�"),
		REMOVE(   "�f�[�^�폜"),
		SEARCH(   "�f�[�^�T��"),
		DUMP(     "�S�f�[�^�\��"),
		TERMINATE("�I��");

		private final String message;			// �\���p������

		static Menu MenuAt(int idx) {			// ������idx�ł���񋓂�Ԃ�
			for (Menu m : Menu.values())
				if (m.ordinal() == idx)
					return m;
			return null;
		}

		Menu(String string) {					// �R���X�g���N�^
			message = string;
		}

		String getMessage() {					// �\���p�������Ԃ�
			return message;
		}
	}

	//--- ���j���[�I�� ---//
	static Menu SelectMenu() {
		int key;
		do {
			for (Menu m : Menu.values()) {
				System.out.printf("(%d) %s  ", m.ordinal(), m.getMessage());
				if ((m.ordinal() % 3) == 2 &&
					  m.ordinal() != Menu.TERMINATE.ordinal())
					System.out.println();
			}
			System.out.print("�F");
			key = stdIn.nextInt();
		} while (key < Menu.ADD.ordinal() || key > Menu.TERMINATE.ordinal());

		return Menu.MenuAt(key);
	}

	public static void main(String[] args) {
		Menu menu;					// ���j���[
		Data data;					// �ǉ��p�f�[�^�Q��
		Data temp = new Data();	// �Ǎ��ݗp�f�[�^

		MyOpenHash<String, Data> hash = new MyOpenHash<String, Data>(13);

		do {
			switch (menu = SelectMenu()) {
			 case ADD :									// �ǉ�
				data = new Data();
				data.scanData("�ǉ�", Data.NO | Data.NAME | Data.HOMETOWN | Data.AGE);
			 	int k = hash.add(data.keyCode(), data);
			 	switch (k) {
			 	 case 1: System.out.println("���̃L�[�l�͓o�^�ς݂ł��B");
			 	 			break;
			 	 case 2: System.out.println("�n�b�V���\�����t�ł��B");
			 	 			break; 
			 	}
			 	break;

			 case REMOVE :								// �폜
			 	temp.scanData("�폜", Data.NAME);
			 	hash.remove(temp.keyCode());
			 	break;

			 case SEARCH :								// �T��
				temp.scanData("�T��", Data.NAME);
			 	Data t = hash.search(temp.keyCode());
			 	if (t != null)
			 		System.out.println("���̃L�[�����f�[�^��" + t + "�ł��B");
				else
		 			System.out.println("�Y������f�[�^�͂���܂���B");
			 	break;

			 case DUMP : 								// �\��
			 	hash.dump();
			 	break;
			}
		} while (menu != Menu.TERMINATE);
	}
}