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

import com.bsd.masterproject.utils.BoxComparator;
import com.bsd.masterproject.utils.EntryComparator;
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
			box0.setWidth(11);
			box0.setLength(17);
			box0.setHeight(6);
			box0.setCapacity(1121);
				
			
// Add Box A
			BoxVO boxA = new BoxVO();
			boxA.setName("Box A");
			boxA.setWidth(14);
			boxA.setLength(20);
			boxA.setHeight(6);
			boxA.setCapacity(1680);
			
// Add Box 000
			BoxVO box000 = new BoxVO();
			box000.setName("Box A");
			box000.setWidth(12);
			box000.setLength(20);
			box000.setHeight(9);
			box000.setCapacity(2160);
			
// Add Box AA
			BoxVO boxAA = new BoxVO();
			boxAA.setName("Box A");
			boxAA.setWidth(13);
			boxAA.setLength(17);
			boxAA.setHeight(7);
			boxAA.setCapacity(1547);

// Add Box 2A
			BoxVO box2A = new BoxVO();
			box2A.setName("Box A");
			box2A.setWidth(14);
			box2A.setLength(20);
			box2A.setHeight(12);
			box2A.setCapacity(3360);

// Add Box B
			BoxVO boxB = new BoxVO();
			boxB.setName("Box B");
			boxB.setWidth(17);
			boxB.setLength(25);
			boxB.setHeight(9);
			boxB.setCapacity(3825);

// Add Box 2B
			BoxVO box2B = new BoxVO();
			box2B.setName("Box 2B");
			box2B.setWidth(17);
			box2B.setLength(25);
			box2B.setHeight(18);
			box2B.setCapacity(7650);
			
// Add Box C
			BoxVO boxC = new BoxVO();
			boxC.setName("Box C");
			boxC.setWidth(20);
			boxC.setLength(30);
			boxC.setHeight(11);
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
		
		
		productList.add(flower);
		productList.add(bee);
//		productList.add(heartBar);
//		productList.add(heart);
//		productList.add(iceCreme);
//		productList.add(grape);
//		productList.add(strawS);
		
		return productList;
	}
	
	
	public static BoxVO chooseBox(OrderVO orderList , List<ProductVO> productListCase1){
		
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
					calSoapWrap(soap,boxFilter.get(i));
				}
			}
		}
		
		return boxChoose;
	}
	
	private static void calSoapWrap(ProductVO soap,BoxVO box){
		DecimalFormat df2 = new DecimalFormat(".#");
		//คำนวณว่ากล่องนี้ใส่สบู่ได้กี่ชิ้น
		
		//กว้าง ยาว สูง กล่อง
		double widthBox = box.getWidthInner();
		double lengthBox = box.getLengthInner();
		double heightBox = box.getHeightInner();
		
		//กว้าง ยาว สูง สบู่
		double widthSoap = soap.getWidth();
		double lengthSoap = soap.getLength();
		double heightSoap = soap.getHeight();
		
		
		//===================== ด้าน X ===================================
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
		
		System.out.println("Initial Map: " + Arrays.toString(groupDeciXMap.entrySet().toArray()));
		Set<Entry<Integer,Integer>> groupDeciXEntries = groupDeciXMap.entrySet();
		List<Entry<Integer,Integer>> groupDeciXList = new LinkedList<Entry<Integer,Integer>>(groupDeciXEntries);
		Collections.sort(groupDeciXList, new EntryComparator());
		System.out.println("Sorted Map: " + Arrays.toString(groupDeciXList.toArray()));
		
		//===================== ด้าน Y ===========================================
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
		
		System.out.println("Initial Map: " + Arrays.toString(groupDeciYMap.entrySet().toArray()));
		Set<Entry<Integer,Integer>> groupDeciYEntries = groupDeciYMap.entrySet();
		List<Entry<Integer,Integer>> groupDeciYList = new LinkedList<Entry<Integer,Integer>>(groupDeciYEntries);
		Collections.sort(groupDeciYList, new EntryComparator());
		System.out.println("Sorted Map: " + Arrays.toString(groupDeciYList.toArray()));
		
		//=================== ด้าน Z =====================================
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
		Map<Integer,Integer> fracZMap = new HashMap<Integer,Integer>();
		fracZMap.put(1,decimalZ1);
		fracZMap.put(2,decimalZ2);
		fracZMap.put(3,decimalZ3);
		System.out.println("Initial Map: " + Arrays.toString(fracZMap.entrySet().toArray()));
		Set<Entry<Integer,Integer>> fracZMapEntries = fracZMap.entrySet();
		List<Entry<Integer,Integer>> fracZList = new LinkedList<Entry<Integer,Integer>>(fracZMapEntries);
		Collections.sort(fracZList, new EntryComparator());
		System.out.println("Sorted Map: " + Arrays.toString(fracZList.toArray()));
		
		
		//Check Duplicate side box
		if(groupDeciXList.get(0).getKey() == groupDeciYList.get(0).getKey()){
//			if(groupNumXList.get(0).getValue() < groupDeciYList.get(0).getKey()){
//				
//			}
		}
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
}
