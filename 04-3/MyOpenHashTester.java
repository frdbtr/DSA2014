// オープンアドレス法によるハッシュの利用例

import java.util.Scanner;

public class MyOpenHashTester {

	static Scanner stdIn = new Scanner(System.in);

	//--- データ（会員番号＋氏名） ---//
	static class Data {
		static final int NO   = 1;		// 番号を読み込むか？
		static final int NAME = 2;		// 氏名を読み込むか？
		static final int HOMETOWN = 3;		// 出身地を読み込むか？
		static final int AGE = 4;		// 年齢を読み込むか？

		private Integer no;				// 会員番号（キー値）
		private String  name;			// 氏名
		private String hometown; //出身地
		private Integer age; //年齢

		//--- キー値 ---//
		String keyCode() {
			return name;
		}

		//--- 文字列表現を返す ---//
		public String toString() {
			return name + "(hometown:" + hometown + ", age:" + age + ")";
		}

		//--- データの読込み ---//
		void scanData(String guide, int sw) {
			System.out.println(guide + "するデータを入力してください。");

			if ((sw & NO) == NO) {
				System.out.print("番号：");
				no = stdIn.nextInt();
			}
			if ((sw & NAME) == NAME) {
				System.out.print("名前：");
				name = stdIn.next();
			}
			if ((sw & HOMETOWN) == HOMETOWN) {
				System.out.print("出身地：");
				hometown = stdIn.next();
			}
			if ((sw & AGE) == AGE) {
				System.out.print("年齢：");
				age = stdIn.nextInt();
			}
		}
	}

	//--- メニュー列挙型 ---//
	enum Menu {
		ADD(      "データ追加"),
		REMOVE(   "データ削除"),
		SEARCH(   "データ探索"),
		DUMP(     "全データ表示"),
		TERMINATE("終了");

		private final String message;			// 表示用文字列

		static Menu MenuAt(int idx) {			// 序数がidxである列挙を返す
			for (Menu m : Menu.values())
				if (m.ordinal() == idx)
					return m;
			return null;
		}

		Menu(String string) {					// コンストラクタ
			message = string;
		}

		String getMessage() {					// 表示用文字列を返す
			return message;
		}
	}

	//--- メニュー選択 ---//
	static Menu SelectMenu() {
		int key;
		do {
			for (Menu m : Menu.values()) {
				System.out.printf("(%d) %s  ", m.ordinal(), m.getMessage());
				if ((m.ordinal() % 3) == 2 &&
					  m.ordinal() != Menu.TERMINATE.ordinal())
					System.out.println();
			}
			System.out.print("：");
			key = stdIn.nextInt();
		} while (key < Menu.ADD.ordinal() || key > Menu.TERMINATE.ordinal());

		return Menu.MenuAt(key);
	}

	public static void main(String[] args) {
		Menu menu;					// メニュー
		Data data;					// 追加用データ参照
		Data temp = new Data();	// 読込み用データ

		MyOpenHash<String, Data> hash = new MyOpenHash<String, Data>(13);

		do {
			switch (menu = SelectMenu()) {
			 case ADD :									// 追加
				data = new Data();
				data.scanData("追加", Data.NO | Data.NAME | Data.HOMETOWN | Data.AGE);
			 	int k = hash.add(data.keyCode(), data);
			 	switch (k) {
			 	 case 1: System.out.println("そのキー値は登録済みです。");
			 	 			break;
			 	 case 2: System.out.println("ハッシュ表が満杯です。");
			 	 			break; 
			 	}
			 	break;

			 case REMOVE :								// 削除
			 	temp.scanData("削除", Data.NAME);
			 	hash.remove(temp.keyCode());
			 	break;

			 case SEARCH :								// 探索
				temp.scanData("探索", Data.NAME);
			 	Data t = hash.search(temp.keyCode());
			 	if (t != null)
			 		System.out.println("そのキーをもつデータは" + t + "です。");
				else
		 			System.out.println("該当するデータはありません。");
			 	break;

			 case DUMP : 								// 表示
			 	hash.dump();
			 	break;
			}
		} while (menu != Menu.TERMINATE);
	}
}