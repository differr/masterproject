package com.bsd.masterproject.utils;

import java.util.Comparator;
import java.util.Map.Entry;
import java.util.TreeMap;


public class HashMapComparator implements Comparator<TreeMap<Integer, Integer>>{

	public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
		return o1.getValue().compareTo(o2.getValue());
	}

	public int compare(TreeMap<Integer, Integer> o1, TreeMap<Integer, Integer> o2) {
		// TODO Auto-generated method stub
		
		return 0;
	}

}
