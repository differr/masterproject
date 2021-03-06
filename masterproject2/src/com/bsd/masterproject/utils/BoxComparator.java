package com.bsd.masterproject.utils;

import java.util.Comparator;

import com.bsd.masterproject.vo.BoxVO;

public class BoxComparator implements Comparator<BoxVO>{

	public int compare(BoxVO b1, BoxVO b2) {
		if (b1.getCapacity() < b2.getCapacity()) return -1;
        if (b1.getCapacity() > b2.getCapacity()) return 1;
		return 0;
	}

}
