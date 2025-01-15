package hashing;

public class MyHashDoubleHashing {

	int[] table;
	int size;
	int capacity;

	public MyHashDoubleHashing(int capacity) {
		this.capacity = capacity;
		this.table = new int[capacity];
		this.size = 0;

		for (int i = 0; i < capacity; i++) {
			table[i] = -1;
		}

	}

	int primaryHash(int key) {
		return key % capacity;
	}

	int secondaryHash(int key) {
		return 7 - (key % 7);
	}

	boolean insert(int key) {
		if (size == capacity)
			return false;// means table is full
		int index = primaryHash(key);
		int step = secondaryHash(key);
		// -2 when element is deleted
		while (table[index] != -1 && table[index] != -2) {
			// in linear probing we were using 1 instead of setp
			index = (index + step) % capacity;
		}

		table[index] = key;
		size++;
		return true;
	}
	
	boolean search(int key) {
		int index = primaryHash(key);
		int step = secondaryHash(key);
		int origIdx = index;
		while(table[index]!=-1) {
			if(table[index]==key) {
				return true;
			}
			
			index = index + step % capacity;
			
			if(index == origIdx)return false;
			
		}
		
		return false;
	}
	
	boolean delete(int key) {
		int index = primaryHash(key);
		int step = secondaryHash(key);
		int origIdx = index;
		
		while(table[index]!=-1) {
			if(table[index]==key) {
				table[index]=-2;
				return true;
			}
			
			index = (index + step) % capacity;
			if(index == origIdx) return false;
		}
		
		return false;
	}
	
	void printTable() {
		for(int i=0;i<capacity;i++) {
			if(table[i]==-1) {
				System.out.print("[]");
			}if(table[i]==-2) {
				System.out.print("[DEL]");
			}else {
				System.out.print("["+table[i]+"]");
			}
		}
		System.out.println();
	}

}
