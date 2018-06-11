package com.bsd.masterproject.controller;

import java.util.ArrayList;
import java.util.List;

import com.bsd.masterproject.vo.BoxVO;
import com.bsd.masterproject.vo.ColorVO;
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
			ProductVO flower = new ProductVO();
			flower.setHeight(1.4);
			flower.setLength(4);
			flower.setWidth(4);
			flower.setWeight(10);
			ColorVO co = new ColorVO();
			co.setColorCode("1");
			co.setCost(10);
			co.setLeastAmt(12);
			co.setName("default");
			co.setStatus("A");
			List<ColorVO> coList = new ArrayList<ColorVO>();
			coList.add(co);
			flower.setColorList(coList);
			flower.setName("ดอกไม้");
			flower.setPackageType("W");//wrap
			flower.setProdId("FLOWER");
			flower.setProdType("R");//regular
			flower.setStatus("A");
			
			ProductVO bee = new ProductVO();
			bee.setHeight(1);
			bee.setLength(3.7);
			bee.setWidth(3.3);
			bee.setWeight(10);
			ColorVO coB = new ColorVO();
			coB.setColorCode("1");
			coB.setCost(6);
			coB.setLeastAmt(12);
			coB.setName("default");
			coB.setStatus("A");
			List<ColorVO> coBList = new ArrayList<ColorVO>();
			coBList.add(coB);
			bee.setColorList(coBList);
			bee.setName("รังผึ้ง");
			bee.setPackageType("W");//wrap
			bee.setProdId("BEE");
			bee.setProdType("R");//regular
			bee.setStatus("A");
			
			ProductVO grape = new ProductVO();
			grape.setHeight(3);
			grape.setLength(8.8);
			grape.setWidth(6.1);
			grape.setWeight(50);
			ColorVO coG = new ColorVO();
			coG.setColorCode("1");
			coG.setCost(59);
			coG.setLeastAmt(6);
			coG.setName("green");
			coG.setStatus("A");
			List<ColorVO> coGList = new ArrayList<ColorVO>();
			coGList.add(coG);
			grape.setColorList(coGList);
			grape.setName("องุ่น");
			grape.setPackageType("W");//wrap
			grape.setProdId("GRAPE");
			grape.setProdType("I");//irregular
			grape.setStatus("A");
			
			ProductVO iceCreme = new ProductVO();
			iceCreme.setCapacity(38);
			ColorVO coI = new ColorVO();
			coI.setColorCode("1");
			coI.setCost(15);
			coI.setLeastAmt(10);
			coI.setName("pink");
			coI.setStatus("A");
			List<ColorVO> coIList = new ArrayList<ColorVO>();
			coIList.add(coI);
			iceCreme.setColorList(coIList);
			iceCreme.setName("ไอศครีม");
			iceCreme.setPackageType("P");//package
			iceCreme.setProdId("ICECREME");
			iceCreme.setProdType("I");//irregular
			iceCreme.setStatus("A");
			
			ProductVO strawS = new ProductVO();
			strawS.setCapacity(30);
			ColorVO coS = new ColorVO();
			coS.setColorCode("1");
			coS.setCost(15);
			coS.setLeastAmt(10);
			coS.setName("default");
			coS.setStatus("A");
			List<ColorVO> coSList = new ArrayList<ColorVO>();
			coSList.add(coS);
			strawS.setColorList(coSList);
			strawS.setName("สตรอเบอรี่เล็ก");
			strawS.setPackageType("P");//package
			strawS.setProdId("STRAWS");
			strawS.setProdType("I");//irregular
			strawS.setStatus("A");
			
			ProductVO heart = new ProductVO();
			heart.setHeight(1.9);
			heart.setLength(6.2);
			heart.setWidth(6.1);
			heart.setWeight(30);
			ColorVO coH = new ColorVO();
			coH.setColorCode("1");
			coH.setCost(59);
			coH.setLeastAmt(6);
			coH.setName("ผงถ่าน");
			coH.setStatus("A");
			List<ColorVO> coHList = new ArrayList<ColorVO>();
			coHList.add(coH);
			heart.setColorList(coHList);
			heart.setName("หัวใจเหลี่ยม");
			heart.setPackageType("W");//wrap
			heart.setProdId("HEART");
			heart.setProdType("I");//irregular
			heart.setStatus("A");
			
			ProductVO heartBar = new ProductVO();
			heartBar.setCapacity(35);
			ColorVO coHB = new ColorVO();
			coHB.setColorCode("1");
			coHB.setCost(20);
			coHB.setLeastAmt(30);
			coHB.setName("blue");
			coHB.setStatus("A");
			List<ColorVO> coHBList = new ArrayList<ColorVO>();
			coHBList.add(coHB);
			heartBar.setColorList(coSList);
			heartBar.setName("สตรอเบอรี่เสียบไม้");
			heartBar.setPackageType("P");//package
			heartBar.setProdId("HEARTBAR");
			heartBar.setProdType("I");//irregular
			heartBar.setStatus("A");
			
		return listBoxVO;
	}
	
	

}
