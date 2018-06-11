package com.bsd.masterproject.controller;

import java.util.ArrayList;
import java.util.List;

import com.bsd.masterproject.vo.BoxVO;
import com.bsd.masterproject.vo.ProductVO;

public class OrderController {

	
	public static void main(String[] args) {

		List<BoxVO> boxList = getBoxList();
		
		System.out.println(" boxList Size = " + boxList.size() );
	}
	
	public static List<BoxVO> getBoxList() {
		List<BoxVO> listBoxVO = new ArrayList<BoxVO>();
		
// Add Box 0
		BoxVO box0 = new BoxVO();
			box0.setName("Box 0");
			box0.setWidth(11);
			box0.setLength(17);
			box0.setHeight(6);
				
			
// Add Box A
			BoxVO boxA = new BoxVO();
			box0.setName("Box A");
			box0.setWidth(11);
			box0.setLength(17);
			box0.setHeight(6);
			

// Add Box AA
			BoxVO boxAA = new BoxVO();
			box0.setName("Box A");
			box0.setWidth(13);
			box0.setLength(17);
			box0.setHeight(7);

// Add Box 2A
			BoxVO box2A = new BoxVO();
			box0.setName("Box A");
			box0.setWidth(14);
			box0.setLength(20);
			box0.setHeight(12);

// Add Box B
			BoxVO boxB = new BoxVO();
			box0.setName("Box B");
			box0.setWidth(17);
			box0.setLength(25);
			box0.setHeight(9);

// Add Box 2B
			BoxVO box2B = new BoxVO();
			box0.setName("Box 2B");
			box0.setWidth(17);
			box0.setLength(25);
			box0.setHeight(18);	
			
// Add Box C
			BoxVO boxC = new BoxVO();
			box0.setName("Box C");
			box0.setWidth(20);
			box0.setLength(30);
			box0.setHeight(11);	
		
			listBoxVO.add(box0);
			listBoxVO.add(box2A);
			listBoxVO.add(box2B);
			listBoxVO.add(boxA);
			listBoxVO.add(boxAA);
			listBoxVO.add(boxB);
			listBoxVO.add(boxC);
			
//Add Soap 
			ProductVO product = new ProductVO();
			product.setHeight(height);
			product.setLength(length);
			product.setWidth(width);
			product.setWeight(weight);
			
			
		return listBoxVO;
	}
	
	

}
