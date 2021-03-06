package com.bsd.masterproject.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.logging.Logger;

import com.bsd.masterproject.utils.BoxComparator;
import com.bsd.masterproject.utils.EntryComparator;
import com.bsd.masterproject.utils.EntryDescComparator;
import com.bsd.masterproject.vo.BoxVO;
import com.bsd.masterproject.vo.ColorVO;
import com.bsd.masterproject.vo.OrderDetailVO;
import com.bsd.masterproject.vo.OrderVO;
import com.bsd.masterproject.vo.ProductVO;

public class OrderController {

	
	public static void main(String[] args) {

		// Case1  ดอกไม้ 20  , รังผึ้ง12
		OrderVO order = new OrderVO();
		List<OrderDetailVO> orderDetailList = new ArrayList<OrderDetailVO>();
		OrderDetailVO orderDetail1 = new OrderDetailVO();
		orderDetail1.setColorCode("default");
		orderDetail1.setLeastAmt(12);
		orderDetail1.setOrderAmt(20);
		orderDetail1.setProdCode("FLOWER");
		
		OrderDetailVO orderDetail2 = new OrderDetailVO();
		orderDetail2.setColorCode("default");
		orderDetail2.setLeastAmt(12);
		orderDetail2.setOrderAmt(12);
		orderDetail2.setProdCode("BEE");
		
		orderDetailList.add(orderDetail1);
		orderDetailList.add(orderDetail2);
		
		order.setOrderDetailList(orderDetailList);
		
		chooseBox(order, getProductListCase1());
		
		
		
		
		
	}
	
	public static List<BoxVO> getBoxList() {
		List<BoxVO> listBoxVO = new ArrayList<BoxVO>();
		
// Add Box 0
		BoxVO box0 = new BoxVO();
			box0.setName("Box 0");
			box0.setWidth(11-0.2);
			box0.setLength(17-0.2);
			box0.setHeight(6-0.2);
			box0.setCapacity(1121);
				
			
// Add Box A
			BoxVO boxA = new BoxVO();
			boxA.setName("Box A");
			boxA.setWidth(14-0.2);
			boxA.setLength(20-0.2);
			boxA.setHeight(6-0.2);
			boxA.setCapacity(1680);
			
// Add Box 000
			BoxVO box000 = new BoxVO();
			box000.setName("Box A");
			box000.setWidth(12-0.2);
			box000.setLength(20-0.2);
			box000.setHeight(9-0.2);
			box000.setCapacity(2160);
			
// Add Box AA
			BoxVO boxAA = new BoxVO();
			boxAA.setName("Box A");
			boxAA.setWidth(13-0.2);
			boxAA.setLength(17-0.2);
			boxAA.setHeight(7-0.2);
			boxAA.setCapacity(1547);

// Add Box 2A
			BoxVO box2A = new BoxVO();
			box2A.setName("Box A");
			box2A.setWidth(14-0.2);
			box2A.setLength(20-0.2);
			box2A.setHeight(12-0.2);
			box2A.setCapacity(3360);

// Add Box B
			BoxVO boxB = new BoxVO();
			boxB.setName("Box B");
			boxB.setWidth(17-0.2);
			boxB.setLength(25-0.2);
			boxB.setHeight(9-0.2);
			boxB.setCapacity(3825);

// Add Box 2B
			BoxVO box2B = new BoxVO();
			box2B.setName("Box 2B");
			box2B.setWidth(17-0.2);
			box2B.setLength(25-0.2);
			box2B.setHeight(18-0.2);
			box2B.setCapacity(7650);
			
// Add Box C
			BoxVO boxC = new BoxVO();
			boxC.setName("Box C");
			boxC.setWidth(20-0.2);
			boxC.setLength(30-0.2);
			boxC.setHeight(11-0.2);
			boxC.setCapacity(6600);
		
			listBoxVO.add(box0);
			listBoxVO.add(box2A);
			listBoxVO.add(box2B);
			listBoxVO.add(boxA);
			listBoxVO.add(boxAA);
			listBoxVO.add(boxB);
			listBoxVO.add(boxC);
			listBoxVO.add(box000);
			
		return listBoxVO;
	}
	
	public static List<ProductVO> getProductListCase1(){
		List<ProductVO> productList = new ArrayList<ProductVO>();
		//Add Soap 
		ProductVO flower = new ProductVO();
		flower.setHeight(1.4);
		flower.setLength(4);
		flower.setWidth(4);
		flower.setWeight(10);
		flower.setCapacity(flower.getWidth()*flower.getHeight()*flower.getLength());
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
		flower.setProdCode("FLOWER");
		flower.setProdType("R");//regular
		flower.setStatus("A");
		
		ProductVO bee = new ProductVO();
		bee.setHeight(1);
		bee.setLength(3.7);
		bee.setWidth(3.3);
		bee.setWeight(10);
		bee.setCapacity(bee.getWidth()*bee.getHeight()*bee.getLength());
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
		bee.setProdCode("BEE");
		bee.setProdType("R");//regular
		bee.setStatus("A");
		bee.setCapacity(bee.getWidth()*bee.getHeight()*bee.getLength());
		
		ProductVO grape = new ProductVO();
		grape.setHeight(3);
		grape.setLength(8.8);
		grape.setWidth(6.1);
		grape.setWeight(50);
		grape.setCapacity(grape.getWidth()*grape.getHeight()*grape.getLength());
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
		grape.setProdCode("GRAPE");
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
		iceCreme.setProdCode("ICECREME");
		iceCreme.setProdType("I");//irregular
		iceCreme.setStatus("A");
		iceCreme.setWeight(15);
		
		
		ProductVO strawS = new ProductVO();
		strawS.setCapacity(30);
		strawS.setWeight(15);
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
		strawS.setProdCode("STRAWS");
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
		heart.setProdCode("HEART");
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
		heartBar.setProdCode("HEARTBAR");
		heartBar.setProdType("I");//irregular
		heartBar.setStatus("A");
		
//		productList.add(flower);
//		productList.add(bee);
//		productList.add(heartBar);
//		productList.add(heart);
//		productList.add(iceCreme);
		productList.add(grape);
//		productList.add(strawS);
		
		return productList;
	}
	
	
	public static BoxVO chooseBox(OrderVO order , List<ProductVO> productListCase1){
		
		BoxVO boxChoose = new BoxVO();
		
		//Loop soap list for sum capacity
		double totalCapacity = 0;
		for(ProductVO prod : productListCase1){
			totalCapacity += prod.getCapacity();
		}
		
		//filter box by capacity and sort
		List<BoxVO> boxFilter = filterBoxByCapacity(totalCapacity);
		
		//Loop box filter เลือกกล่องที่เรียงจากน้อยไปมากมา  แต่ยังไม่ได้คิดเงื่อนไขการเลือก เช่น เอามาสองอันดับ ??
		for(int i=0;i<boxFilter.size();i++){
			//Loop soap
			List<ProductVO> productListClone =  productListCase1;
			for(int j=0;j<productListClone.size();j++){
				ProductVO soap = chooseSoapByOrder(productListClone);
				System.out.println("Name soap : "+productListClone.get(j).getName());
				productListClone.remove(soap);
				
				//check soap type is package choose box min capa
				if("P".equals(soap.getPackageType())){
					boxChoose = boxFilter.get(i);
				}else{
					//cal soap wrap
					//Map resultMap =  HashMap<Boolean,Integer>();
					//1. คำนวณว่ากล่องนี้ใส่สบู่ได้กี่ชิ้น
					List<Integer> result = calAmtContain(soap,boxFilter.get(i));
					//จำนวนที่วางได้เป็น 0 หรือไม่
					if(result.get(0) != 0){
						int amtSoap = getAmtSoap(order, soap);
						if(result.get(0) >= getAmtSoap(order, soap)){
							//1. หาพื้นที่ที่เหลือ
							//List<double[]> areaFullList = calRemainAreaFullAmt(boxFilter.get(i),soap,result);
							//List<double[]> areaNoFullList = calRemainAreaNoFullAmt(boxFilter.get(i),soap,result,amtSoap);
							//2. ลบจำนวนสบู่ในออเดอร์
						}else{
							if(boxFilter.get(i++) != null){
								//break
								j = productListClone.size();
							}else{
								boxChoose = null;
							}
						}
					}
				}
				
			}
			
		}
		
		return boxChoose;
	}
	
	private static List<Integer> calAmtContain(ProductVO soap,BoxVO box){
		DecimalFormat df2 = new DecimalFormat(".#");
		
		//กว้าง ยาว สูง กล่อง
		double widthBox = box.getWidth();
		double lengthBox = box.getLength();
		double heightBox = box.getHeight();
		
		//กว้าง ยาว สูง สบู่
		double widthSoap = soap.getWidth();
		double lengthSoap = soap.getLength();
		double heightSoap = soap.getHeight();
		
		
		//============================= ด้าน X ===================================//
		double bx1 = Double.valueOf(df2.format(widthBox/widthSoap));
		String bx1Str = String.valueOf(bx1);
		int numX1 = Integer.valueOf(bx1Str.substring(0,bx1Str.indexOf(".")));
		int decimalX1 = Integer.valueOf(bx1Str.substring(bx1Str.indexOf(".")).substring(1));

		
		double bx2 = Double.valueOf(df2.format(widthBox/lengthSoap));
		String bx2Str = String.valueOf(bx2);
		int numX2 = Integer.valueOf(bx2Str.substring(0,bx2Str.indexOf(".")));
		int decimalX2 = Integer.valueOf(bx2Str.substring(bx2Str.indexOf(".")).substring(1));
		
		double bx3 = Double.valueOf(df2.format(widthBox/heightSoap));
		String bx3Str = String.valueOf(bx3);
		int numX3 = Integer.valueOf(bx3Str.substring(0,bx3Str.indexOf(".")));
		int decimalX3 = Integer.valueOf(bx3Str.substring(bx3Str.indexOf(".")).substring(1));
		
		//sort value decimal
		Map<Integer,Integer> groupNumXMap = new HashMap<Integer,Integer>();
		groupNumXMap.put(1,numX1);
		groupNumXMap.put(2,numX2);
		groupNumXMap.put(3,numX3);
		Map<Integer,Integer> groupDeciXMap = new HashMap<Integer,Integer>();
		groupDeciXMap.put(1,decimalX1);
		groupDeciXMap.put(2,decimalX2);
		groupDeciXMap.put(3,decimalX3);
		
		System.out.println("================ X ===============");
		System.out.println("Initial NumberMap: " + Arrays.toString(groupNumXMap.entrySet().toArray()));
		System.out.println("Initial DecimalMap: " + Arrays.toString(groupDeciXMap.entrySet().toArray()));
		Set<Entry<Integer,Integer>> groupDeciXEntries = groupDeciXMap.entrySet();
		List<Entry<Integer,Integer>> deciXSortedList = new LinkedList<Entry<Integer,Integer>>(groupDeciXEntries);
		Collections.sort(deciXSortedList, new EntryComparator());
		System.out.println("Sorted DecimalMap: " + Arrays.toString(deciXSortedList.toArray()));
		
		
		//sort number when decimal is equal
		int dupValX = -1;
		int intValX = 0;
		//ลิสของ index ที่มี decimal ซ้ำ
		List<Integer> dupDeciIndexXList = new ArrayList();
		for(int i = 0; i < deciXSortedList.size();i++){
			if(i == 0){
				intValX = deciXSortedList.get(i).getValue();
			}else{
				if(intValX == deciXSortedList.get(i).getValue()){
					dupValX = deciXSortedList.get(i).getValue();
				}else{
					intValX = deciXSortedList.get(i).getValue();
				}
			}
		}
		
		
		Map<Integer,Integer> groupNumXSortedMap = new HashMap<Integer,Integer>();
		if(dupValX != -1){
			//add index ที่มี decimal ซ้ำ
			for(int i = 0; i < deciXSortedList.size();i++){
				if(dupValX == deciXSortedList.get(i).getValue()){
					dupDeciIndexXList.add(deciXSortedList.get(i).getKey());
				}
			}
			
			//สร้าง Map ของ index กับ number ที่ decimal ซ้ำ
			HashMap<Integer,Integer> dupNumIndexXMap = new HashMap<Integer,Integer>();
			for(int i=0;i<dupDeciIndexXList.size();i++){
				dupNumIndexXMap.put(dupDeciIndexXList.get(i),
									groupNumXMap.get(dupDeciIndexXList.get(i)));
			}
			//sort number ที่มี decimal ซ้ำ จากมากไปน้อย
			System.out.println("Initial DupNumberMap: " + Arrays.toString(dupNumIndexXMap.entrySet().toArray()));
			Set<Entry<Integer,Integer>> dupNumIndexXEntries = dupNumIndexXMap.entrySet();
			List<Entry<Integer,Integer>> dupNumIndexXSortedList = new LinkedList<Entry<Integer,Integer>>(dupNumIndexXEntries);
			Collections.sort(dupNumIndexXSortedList, new EntryDescComparator());
			System.out.println("Sorted DupNumberMap: " + Arrays.toString(dupNumIndexXSortedList.toArray()));
		
		}	

		
		//============================= ด้าน Y ===================================//
		double by1 = Double.valueOf(df2.format(lengthBox/widthSoap));
		String by1Str = String.valueOf(by1);
		int numY1 = Integer.valueOf(by1Str.substring(0,by1Str.indexOf(".")));
		int decimalY1 = Integer.valueOf(by1Str.substring(by1Str.indexOf(".")).substring(1));
			
		double by2 = Double.valueOf(df2.format(lengthBox/lengthSoap));
		String by2Str = String.valueOf(by2);
		int numY2 = Integer.valueOf(by2Str.substring(0,by2Str.indexOf(".")));
		int decimalY2 = Integer.valueOf(by2Str.substring(by2Str.indexOf(".")).substring(1));
			
		double by3 = Double.valueOf(df2.format(lengthBox/heightSoap));
		String by3Str = String.valueOf(by3);
		int numY3 = Integer.valueOf(by3Str.substring(0,by3Str.indexOf(".")));
		int decimalY3 = Integer.valueOf(by3Str.substring(by3Str.indexOf(".")).substring(1));
		
		//sort value decimal
		Map<Integer,Integer> groupNumYMap = new HashMap<Integer,Integer>();
		groupNumYMap.put(1,numY1);
		groupNumYMap.put(2,numY2);
		groupNumYMap.put(3,numY3);
		Map<Integer,Integer> groupDeciYMap = new HashMap<Integer,Integer>();
		groupDeciYMap.put(1,decimalY1);
		groupDeciYMap.put(2,decimalY2);
		groupDeciYMap.put(3,decimalY3);
		
		System.out.println("================ Y ===============");
		System.out.println("Initial NumberMap: " + Arrays.toString(groupNumYMap.entrySet().toArray()));
		System.out.println("Initial DecimalMap: " + Arrays.toString(groupDeciYMap.entrySet().toArray()));
		Set<Entry<Integer,Integer>> groupDeciYEntries = groupDeciYMap.entrySet();
		List<Entry<Integer,Integer>> deciYSortedList = new LinkedList<Entry<Integer,Integer>>(groupDeciYEntries);
		Collections.sort(deciYSortedList, new EntryComparator());
		System.out.println("Sorted DecimalMap: " + Arrays.toString(deciYSortedList.toArray()));
		
		
		//sort number when decimal is equal
		int dupValY = -1;
		int intValY = 0;
		//ลิสของ index ที่มี decimal ซ้ำ
		List<Integer> dupDeciIndexYList = new ArrayList();
		for(int i = 0; i < deciYSortedList.size();i++){
			if(i == 0){
				intValY = deciYSortedList.get(i).getValue();
			}else{
				if(intValY == deciYSortedList.get(i).getValue()){
					dupValY = deciYSortedList.get(i).getValue();
				}else{
					intValY = deciYSortedList.get(i).getValue();
				}
			}
		}
		
		if(dupValY != -1){
			//add index ที่มี decimal ซ้ำ
			for(int i = 0; i < deciYSortedList.size();i++){
				if(dupValY == deciYSortedList.get(i).getValue()){
					dupDeciIndexYList.add(deciYSortedList.get(i).getKey());
				}
			}
			
			//สร้าง Map ของ index กับ number ที่ decimal ซ้ำ
			HashMap<Integer,Integer> dupNumIndexYMap = new HashMap<Integer,Integer>();
			for(int i=0;i<dupDeciIndexYList.size();i++){
				dupNumIndexYMap.put(dupDeciIndexYList.get(i),
									groupNumYMap.get(dupDeciIndexYList.get(i)));
			}
			//sort number ที่มี decimal ซ้ำ จากมากไปน้อย
			System.out.println("Initial DupNumberMap: " + Arrays.toString(dupNumIndexYMap.entrySet().toArray()));
			Set<Entry<Integer,Integer>> dupNumIndexYEntries = dupNumIndexYMap.entrySet();
			List<Entry<Integer,Integer>> dupNumIndexYSortedList = new LinkedList<Entry<Integer,Integer>>(dupNumIndexYEntries);
			Collections.sort(dupNumIndexYSortedList, new EntryDescComparator());
			System.out.println("Sorted DupNumberMap: " + Arrays.toString(dupNumIndexYSortedList.toArray()));
			
		}
		
		
				
		
		//============================= ด้าน Z ===================================//
		double bz1 = Double.valueOf(df2.format(heightBox/widthSoap));
		String bz1Str = String.valueOf(bz1);
		int numZ1 = Integer.valueOf(bz1Str.substring(0,bz1Str.indexOf(".")));
		int decimalZ1 = Integer.valueOf(bz1Str.substring(bz1Str.indexOf(".")).substring(1));
			
		double bz2 = Double.valueOf(df2.format(heightBox/lengthSoap));
		String bz2Str = String.valueOf(bz2);
		int numZ2 = Integer.valueOf(bz2Str.substring(0,bz2Str.indexOf(".")));
		int decimalZ2 = Integer.valueOf(bz2Str.substring(bz2Str.indexOf(".")).substring(1));
			
		double bz3 = Double.valueOf(df2.format(heightBox/heightSoap));
		String bz3Str = String.valueOf(bz3);
		int numZ3 = Integer.valueOf(bz3Str.substring(0,bz3Str.indexOf(".")));
		int decimalZ3 = Integer.valueOf(bz3Str.substring(bz3Str.indexOf(".")).substring(1));
			
		//sort value decimal
		Map<Integer,Integer> groupNumZMap = new HashMap<Integer,Integer>();
		groupNumZMap.put(1,numZ1);
		groupNumZMap.put(2,numZ2);
		groupNumZMap.put(3,numZ3);
		Map<Integer,Integer> groupDeciZMap = new HashMap<Integer,Integer>();
		groupDeciZMap.put(1,decimalZ1);
		groupDeciZMap.put(2,decimalZ2);
		groupDeciZMap.put(3,decimalZ3);
		
		
		System.out.println("================ Z ===============");
		System.out.println("Initial NumberMap: " + Arrays.toString(groupNumZMap.entrySet().toArray()));
		System.out.println("Initial DecimalMap: " + Arrays.toString(groupDeciZMap.entrySet().toArray()));
		Set<Entry<Integer,Integer>> groupDeciZEntries = groupDeciZMap.entrySet();
		List<Entry<Integer,Integer>> deciZSortedList = new LinkedList<Entry<Integer,Integer>>(groupDeciZEntries);
		Collections.sort(deciZSortedList, new EntryComparator());
		System.out.println("Sorted DecimalMap: " + Arrays.toString(deciZSortedList.toArray()));
		
		
		//sort number when decimal is equal
		int dupValZ = -1;
		int intValZ = 0;
		//ลิสของ index ที่มี decimal ซ้ำ
		List<Integer> dupDeciIndexZList = new ArrayList();
		for(int i = 0; i < deciZSortedList.size();i++){
			if(i == 0){
				intValZ = deciZSortedList.get(i).getValue();
			}else{
				if(intValZ == deciZSortedList.get(i).getValue()){
					dupValZ = deciZSortedList.get(i).getValue();
				}else{
					intValZ = deciZSortedList.get(i).getValue();
				}
			}
		}
		
		if(dupValZ != -1){
			//add index ที่มี decimal ซ้ำ
			for(int i = 0; i < deciZSortedList.size();i++){
				if(dupValZ == deciZSortedList.get(i).getValue()){
					dupDeciIndexZList.add(deciZSortedList.get(i).getKey());
				}
			}
			
			//สร้าง Map ของ index กับ number ที่ decimal ซ้ำ
			HashMap<Integer,Integer> dupNumIndexZMap = new HashMap<Integer,Integer>();
			for(int i=0;i<dupDeciIndexZList.size();i++){
				dupNumIndexZMap.put(dupDeciIndexZList.get(i),
									groupNumZMap.get(dupDeciIndexZList.get(i)));
			}
			//sort number ที่มี decimal ซ้ำ จากมากไปน้อย
			System.out.println("Initial DupNumberMap: " + Arrays.toString(dupNumIndexZMap.entrySet().toArray()));
			Set<Entry<Integer,Integer>> dupNumIndexZEntries = dupNumIndexZMap.entrySet();
			List<Entry<Integer,Integer>> dupNumIndexZSortedList = new LinkedList<Entry<Integer,Integer>>(dupNumIndexZEntries);
			Collections.sort(dupNumIndexZSortedList, new EntryDescComparator());
			System.out.println("Sorted DupNumberMap: " + Arrays.toString(dupNumIndexZSortedList.toArray()));
			
		}
		
		
		
		
		
		//****************** Start Check Duplicate side box ***********************//
		Map<String,Integer> indexMap = new HashMap<String,Integer>();
		//Check index X , Y
		if(deciXSortedList.get(0).getKey() == deciYSortedList.get(0).getKey()){
			
			if(deciXSortedList.get(0).getValue() == deciYSortedList.get(0).getValue()){
				if(groupNumXMap.get(deciXSortedList.get(0).getKey()) >= groupNumYMap.get(deciXSortedList.get(0).getKey())){
					indexMap.put("X", deciXSortedList.get(0).getKey());
					indexMap.put("Y", deciYSortedList.get(1).getKey());
				}else{
					indexMap.put("Y", deciYSortedList.get(0).getKey());
					indexMap.put("X", deciXSortedList.get(1).getKey());
				}
			}else if(deciXSortedList.get(0).getValue() < deciYSortedList.get(0).getValue()){
				indexMap.put("X", deciXSortedList.get(0).getKey());
				indexMap.put("Y", deciYSortedList.get(1).getKey());
			}else{
				indexMap.put("Y", deciYSortedList.get(0).getKey());
				indexMap.put("X", deciXSortedList.get(1).getKey());
			}
			
		}else{
			indexMap.put("X", deciXSortedList.get(0).getKey());
			indexMap.put("Y", deciYSortedList.get(0).getKey());
		}
		
		//Check index Y , Z
		if(indexMap.get("Y") == deciZSortedList.get(0).getKey()){
			//Check Y Decimal == Z Decimal
			if(groupDeciYMap.get(indexMap.get("Y")) == groupDeciXMap.get(deciZSortedList.get(0).getValue())){
				//Check Number
				if(groupNumYMap.get(indexMap.get("Y")) >= groupNumZMap.get(indexMap.get("Y"))){
					indexMap.put("Z", deciZSortedList.get(1).getKey());
				}else{
					indexMap.put("Z", deciZSortedList.get(0).getKey());
					//check last index of Y
					if(indexMap.get("Y") == deciYSortedList.get(0).getKey()){
						indexMap.remove(indexMap.get("Y"));
						indexMap.put("Y", deciYSortedList.get(1).getKey());
					}else if(indexMap.get("Y") == deciYSortedList.get(1).getKey()){
						indexMap.remove(indexMap.get("Y"));
						indexMap.put("Y", deciYSortedList.get(2).getKey());
					}
				}
			
			// Check Y Decimal < Z Decimal
			}else if(groupDeciYMap.get(indexMap.get("Y")) < deciZSortedList.get(0).getValue()){
				indexMap.put("Z", deciZSortedList.get(1).getKey());
			
			// Check Y Decimal > Z Decimal
			}else{
				indexMap.remove(indexMap.get("Y"));
				indexMap.put("Y", deciYSortedList.get(2).getKey());
			}
		}else{
			indexMap.put("Z", deciZSortedList.get(0).getKey());
		}
		
		//Check index Z , X
		if(indexMap.get("Z") == indexMap.get("X")){
			//Check Z Decimal == X Decimal
			if(groupDeciZMap.get(indexMap.get("Z")) == groupDeciXMap.get(indexMap.get("X"))){
				//check number
				if(groupNumZMap.get(indexMap.get("Z")) >= groupNumXMap.get(indexMap.get("X"))){
					indexMap.remove(indexMap.get("X"));
					indexMap.put("X", deciXSortedList.get(2).getKey());
				}else{
					//check last index of Z
					if(indexMap.get("Z") == deciZSortedList.get(0).getKey()){
						indexMap.remove(indexMap.get("Z"));
						indexMap.put("Z", deciZSortedList.get(1).getKey());
					}else if(indexMap.get("Z") == deciZSortedList.get(1).getKey()){
						indexMap.remove(indexMap.get("Z"));
						indexMap.put("Z", deciZSortedList.get(2).getKey());
					}
				}
			}
		}
		//****************** End Check Duplicate side box ***********************//
		
		
		//Print Log
		int amount = 1;
		
		int r1 = 0;
		int r2 = 0;
		int r3 = 0;
		for(Map.Entry<String, Integer> m : indexMap.entrySet()){
			if("X".equals(m.getKey())){
				System.out.println("Key : "+m.getKey()+" , Value : "+m.getValue()
				+" , Number : "+groupNumXMap.get(m.getValue())
				+" , Decimal : "+deciXSortedList.get(1).getValue());
				amount = amount * groupNumXMap.get(m.getValue());
				r1 = groupNumXMap.get(m.getValue());
			}
			if("Y".equals(m.getKey())){
				System.out.println("Key : "+m.getKey()+" , Value : "+m.getValue()
				+" , Number : "+groupNumYMap.get(m.getValue())
				+" , Decimal : "+groupDeciYMap.get(m.getValue()));
				amount = amount * groupNumYMap.get(m.getValue());
				r2 = groupNumYMap.get(m.getValue());
			}
			if("Z".equals(m.getKey())){
				System.out.println("Key : "+m.getKey()+" , Value : "+m.getValue()
				+" , Number : "+groupNumZMap.get(m.getValue())
				+" , Decimal : "+deciZSortedList.get(1).getValue());
				amount = amount * groupNumZMap.get(m.getValue());
				r3 = groupNumZMap.get(m.getValue());
			}
		}
		
		System.out.println("Amount ==> "+ amount);
		List<Integer> resultList = new ArrayList();
		resultList.add(amount);
		resultList.add(r1);
		resultList.add(r2);
		resultList.add(r3);
		
		return resultList;
	}
	
	private static ProductVO chooseSoapByOrder(List<ProductVO> productListCase1) {
		// has soap type wrap?
		List<ProductVO> prodWrapList = new ArrayList<ProductVO>();
		List<ProductVO> prodPackList = new ArrayList<ProductVO>();
		for(ProductVO p : productListCase1){
			if("W".equals(p.getPackageType())){
				prodWrapList.add(p);
			}else{
				prodPackList.add(p);
			}
		}
		
		ProductVO maxProduct = new ProductVO();
		double maxCapa = 0;
		if(prodWrapList.size() > 0){
			//get max capacity of soap wrap
			for(ProductVO p : prodWrapList){
				if(p.getCapacity() > maxCapa){
					maxCapa = p.getCapacity();
					maxProduct = p;
				}
			}
		}else{
			for(ProductVO p : prodPackList){
				if(p.getCapacity() > maxCapa){
					maxCapa = p.getCapacity();
					maxProduct = p;
				}
			}
		}
		
		return maxProduct;
	}

	public static List<BoxVO> filterBoxByCapacity(double totalCapacity) {
		List<BoxVO> boxList = getBoxList();
		List<BoxVO> boxFilter = new ArrayList<BoxVO>();
		
		for(BoxVO b : boxList){
			if(b.getCapacity() > totalCapacity){
				boxFilter.add(b);
			}
		}
		//sort asc
		Collections.sort(boxFilter, new BoxComparator());
		
		return boxFilter;
	}

	private static int getAmtSoap(OrderVO order , ProductVO soap){
		List<OrderDetailVO> orderDetailList = order.getOrderDetailList();
		int amt = 0;
		for(int i=0;i<orderDetailList.size();i++){
			if(orderDetailList.get(i).getProdCode().equals(soap.getProdCode())){
				amt = orderDetailList.get(i).getOrderAmt();
			}
		}
		return amt;
	}

	private static List<double[]> calRemainAreaFullAmt(BoxVO box ,ProductVO soap, List<Integer> amtList){
		double bx = box.getWidth();
		double by = box.getLength();
		double bz = box.getHeight();
		
		double sx = soap.getWidth();
		double sy = soap.getLength();
		double sz = soap.getHeight();
		
		int r1 = amtList.get(1);
		int r2 = amtList.get(2);
		int r3 = amtList.get(3);
		
		double cx = bx - (sx * r1);
		double cy = by - (sy * r2);
		double cz = bz - (sz * r3);
		
		double[] area1 = {cx,by,bz};
		double[] area2 = {(bx-cx),cy,bz};
		double[] area3 = {bx-cx,by-cy,cz};
		
		List<double[]> areaList = new ArrayList();
		areaList.add(area1);
		areaList.add(area2);
		areaList.add(area3);
		
		return areaList;
	}
	
	
	private static List<double[]> calRemainAreaNoFullAmt(BoxVO box ,ProductVO soap, List<Integer> amtList,int amtSoap){
		double sx = soap.getWidth();
		double sy = soap.getLength();
		double sz = soap.getHeight();
		
		//จำนวนแถว
		int bx = amtList.get(1);
		//วางได้แถวละ
		int by = amtList.get(2);
		//วางได้กี่ชั่น
		int bz = amtList.get(3);
		
		List<List<RowNotFullInfo>> floorMapList = new ArrayList();
		List<RowNotFullInfo> rowList = new ArrayList<RowNotFullInfo>();
		int amtRemain = amtSoap;
		//Loop bz
		for(int i=0;i<bz;i++){
			if(i==0){
				//คำนวณว่าชั้น i มีแถวที่วางไม่เต็มแถวไหนบ้าง  และ จำนวนสบู่ที่เหลือ
				rowList = loopBx(box,amtRemain,bx,by);
				//คำนวณหาแถวที่ว่างทั้งแถว
				if(rowList.size() > 0){
					int numRowEmpty = bx - rowList.size();
					if(numRowEmpty > 0){
						int index = rowList.size();
						for(int j=0;j<numRowEmpty;i++){
							RowNotFullInfo row = new RowNotFullInfo();
							row.setRowNum(index);
							row.setAmtEmpty(by);
							rowList.add(row);
							index++;
						}
					}
				}
				
				floorMapList.add(rowList);
			}
		}
		
		//คำนวณพื้นที่ที่เหลือ
		for(int i=0;i<floorMapList.size();i++){
			for(int j=0;j<floorMapList.get(i).size();j++){
				if(floorMapList.get(i).get(j).getAmtEmpty() == by){
					
				}
			}
		}
		
		
		return null;
	}
	
	private static List<RowNotFullInfo> loopBx(BoxVO box,int amt,int bx,int by){
		int amtRemain = amt;
		
		List<RowNotFullInfo> rowList = new ArrayList<>();
		for(int i=0;i<bx;i++){
			if(amtRemain > bx){
				amtRemain = amtRemain - bx;
			}else{
				if(amtRemain > 0){
					RowNotFullInfo row = new RowNotFullInfo();
					row.setRowNum(i);
					row.setAmtEmpty(by-amtRemain);
					rowList.add(row);
				}else{
					break;
				}
			}
		}
		
		return rowList;
		
	}
}
