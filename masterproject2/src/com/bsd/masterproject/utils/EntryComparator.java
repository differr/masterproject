package com.bsd.masterproject.utils;

import java.util.Comparator;
import java.util.Map.Entry;

public class EntryComparator implements Comparator<Entry<Integer, Integer>>{
	public int compare(Entry<Integer, Integer> ele1,Entry<Integer, Integer> ele2) {
        return ele1.getValue().compareTo(ele2.getValue());
    }
}
