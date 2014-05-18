// int型スタック

public class IntStack {
	private int max;			// スタックの容量
	private int ptr;			// スタックポインタ
	private int[] stk;		// スタックの本体

	//--- 実行時例外：スタックが空 ---//
	public class EmptyIntStackException extends RuntimeException {
		public EmptyIntStackException() { }
	}

	//--- 実行時例外：スタックが満杯 ---//
	public class OverflowIntStackException extends RuntimeException {
		public OverflowIntStackException() { }
	}

	//--- コンストラクタ ---//
	public IntStack(int capacity) {
		ptr = 0;
		max = capacity;
		try {
			stk = new int[max];				// スタック本体用の配列を生成
		} catch (OutOfMemoryError e) {	// 生成できなかった
			max = 0;
		}
	}

	//--- スタックにxをプッシュ ---//
	public int push(int x) throws OverflowIntStackException {
		if (ptr >= max)									// スタックは満杯
			throw new OverflowIntStackException();
		return stk[ptr++] = x;
	}

	//--- スタックからデータをポップ（頂上のデータを取り出す） ---//
	public int pop() throws EmptyIntStackException {
		if (ptr <= 0)										// スタックは空
			throw new EmptyIntStackException();
		return stk[--ptr];
	}

	//--- スタックからデータをピーク（頂上のデータを覗き見） ---//
	public int peek() throws EmptyIntStackException {
		if (ptr <= 0)										// スタックは空
			throw new EmptyIntStackException();
		return stk[ptr - 1];
	}

	//--- スタックからxを探してインデックス（見つからなければ-1）を返す ---//
	public int indexOf(int x) {
		for (int i = ptr - 1; i >= 0; i--)		// 頂上側から線形探索
			if (stk[i] == x)
				return i;		// 探索成功
		return -1;				// 探索失敗
	}

	//--- スタックを空にする ---//
	public void clear() {
		ptr = 0;
	}

	//--- スタックの容量を返す ---//
	public int capacity() {
		return max;
	}

	//--- スタックに積まれているデータ数を返す ---//
	public int size() {
		return ptr;
	}

	//--- スタックは空であるか ---//
	public boolean isEmpty() {
		return ptr <= 0;
	}

	//--- スタックは満杯であるか ---//
	public boolean isFull() {
		return ptr >= max;
	}

	//--- スタック内の全データを底→頂上の順に表示 ---//
	public void dump() {
		if (ptr <= 0)
			System.out.println("スタックは空です。");
		else {
			for (int i = 0; i < ptr; i++)
				System.out.print(stk[i] + " ");
			System.out.println();
		}
	}
}
