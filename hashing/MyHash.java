package hashing;

import java.util.ArrayList;
import java.util.LinkedList;

//in this class we will make hashmap using chaining
public class MyHash {
	int bucket;// this is size of arraylist;
	ArrayList<LinkedList<Integer>> table;

	MyHash(int b) {
		this.bucket = b;
		this.table = new ArrayList<LinkedList<Integer>>();

		for (int i = 0; i < b; i++) {
			table.add(new LinkedList<Integer>());
		}

	}
	
	void insert(int key) {
		int index = key % bucket;
		table.get(index).add(key);
	}
	
	void remove(int key) {
		int index = key % bucket;
		table.get(index).remove((Integer)index);
	}
	
	boolean search(int key) {
		int index = key % bucket;
		return table.get(index).contains(key);
	}
	
	void printTable() {
		for(int i=0;i<table.size();i++) {
			for(int j=0;j<table.get(i).size();j++) {
				System.out.println(table.get(i).get(j));
			}
		}
	}

	public static void main(String[] args) {
		
		
		MyHash mh = new MyHash(7);
		mh.insert(3);
		mh.insert(2);
		mh.insert(1);
		mh.printTable();
	
		mh.printTable();
		System.out.println(mh.search(3));
	}

}
