package hashing;

//in linerar probing ya to element us index p hga ni to linarly search kro array m k wo khn h
public class MyHashLinearProbing {

	int[] table;// array to store keys
	int cap;// to track capacity
	int size;// to track size

	public MyHashLinearProbing(int capacity) {
		this.cap = capacity;
		this.size = 0;
		this.table = new int[capacity];
		// Initialize all slots to -1 (indicating empty slots)
		for (int i = 0; i < capacity; i++) {
			table[i] = -1;
		}
	}
	
	
	boolean remove(int key) {
		int hash = hashFunc(key);
		int i = hash;
		
		while(table[i]!=-1) {
			if(table[i]==key) {
				table[i]=-2;
				return true;
			}
			i= (i+1) % cap;
			if(i==hash) return false;
		}
		return false;
	}

	// phle humko us index p phochna hga jhn insert krna h whn p agr same keu h to
	// return false otherwise insert it
	boolean insert(int key) {
		if (size == cap)
			return false;
		int index = hashFunc(key);
		while (table[index] != -1 && table[index] != -2 && table[index] != key) {
			index = (index + 1) % cap;
		}

		if (table[index] == key) {
			return false;
		} else {
			table[index] = key;
			size++;
			return true;

		}

	}

	boolean search(int key) {
		int index = hashFunc(key);
		int i = index;
		while (table[i] != -1) {
			if (table[i] == key) {
				return true;
			}

			i = (i + 1) % cap; // ye islie kra h kioki hum circularly check kr rhe h array m

			if (i == index) // ye condition true hgi jb element nhi hga array m to ye index ghum k wahi aa
							// jaega
				return false;
		}
		return false;
	}
	
	void printTable() {
		if(size>0) {
			for(int i=0; i<table.length;i++) {
				System.out.println(table[i]+" ");
			}
		}
	}

	int hashFunc(int key) {
		return key % cap;
	}

	public static void main(String[] args) {
		
		
		MyHashLinearProbing mhp = new MyHashLinearProbing(7);
		mhp.insert(34);
		mhp.insert(23);
		System.out.println(mhp.search(23));
		//mhp.printTable();
	}

}
