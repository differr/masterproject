package com.bsd.masterproject.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.bsd.masterproject.utils.BoxComparator;
import com.bsd.masterproject.vo.BoxVO;
import com.bsd.masterproject.vo.ColorVO;
import com.bsd.masterproject.vo.OrderDetailVO;
import com.bsd.masterproject.vo.OrderVO;
import com.bsd.masterproject.vo.ProductVO;

public class CalulateTranssportCostController {

	List<BoxVO> listMiniBox = new ArrayList<BoxVO>();
	List<OrderDetailVO> listGlobalOrder = null;

	public static void main(String[] args) {

		// Get Order From Customer
		OrderVO order = getListProductOrder();
		
		// Calulate and Get List of Choice Transportation And Box
		try {
			CalulateTranssportCostController thisObject = new CalulateTranssportCostController();
			thisObject.getListChoiceTransporterAndPoint(order);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	
	/*
	 * When Test  : for Generate List Of Order Product 
	 */
	public static OrderVO getListProductOrder() {
		OrderVO order = new OrderVO();
			// Set Main data of Order
		
			// Set Product List in Order
			List<OrderDetailVO> orderDetailList = new ArrayList<OrderDetailVO>();

//////////// Case 1
//			OrderDetailVO tmpOrderDetailVO1 = new OrderDetailVO();
//				tmpOrderDetailVO1.setProdCode("FLOWER");
//				tmpOrderDetailVO1.setColorCode("1");
//				tmpOrderDetailVO1.setOrderAmt(20);
//				tmpOrderDetailVO1.setLeastAmt(12);
//			
//			orderDetailList.add(tmpOrderDetailVO1);
//			
//			OrderDetailVO tmpOrderDetailVO2 = new OrderDetailVO();
//				tmpOrderDetailVO2.setProdCode("BEE");
//				tmpOrderDetailVO2.setColorCode("1");
//				tmpOrderDetailVO2.setOrderAmt(12);
//				tmpOrderDetailVO2.setLeastAmt(12);
//		
//			orderDetailList.add(tmpOrderDetailVO2);
//			
//////////// Case 1
//		OrderDetailVO tmpOrderDetailVO3 = new OrderDetailVO();
//			tmpOrderDetailVO3.setProdCode("GRAPE");
//			tmpOrderDetailVO3.setColorCode("1");
//			tmpOrderDetailVO3.setOrderAmt(7);
//			tmpOrderDetailVO3.setLeastAmt(1);
//		
//		orderDetailList.add(tmpOrderDetailVO3);
//		
//		OrderDetailVO tmpOrderDetailVO4 = new OrderDetailVO();
//			tmpOrderDetailVO4.setProdCode("ICECREME");
//			tmpOrderDetailVO4.setColorCode("1");
//			tmpOrderDetailVO4.setOrderAmt(21);
//			tmpOrderDetailVO4.setLeastAmt(12);
//	
//		orderDetailList.add(tmpOrderDetailVO4);
//			
////////// Case 3
//			OrderDetailVO tmpOrderDetailVO5 = new OrderDetailVO();
//				tmpOrderDetailVO5.setProdCode("STRAWS");
//				tmpOrderDetailVO5.setColorCode("1");
//				tmpOrderDetailVO5.setOrderAmt(20);
//				tmpOrderDetailVO5.setLeastAmt(1);
//			
//			orderDetailList.add(tmpOrderDetailVO5);
//			
//			OrderDetailVO tmpOrderDetailVO6 = new OrderDetailVO();
//				tmpOrderDetailVO6.setProdCode("HEART");
//				tmpOrderDetailVO6.setColorCode("1");
//				tmpOrderDetailVO6.setOrderAmt(5);
//				tmpOrderDetailVO6.setLeastAmt(1);
//	
//			orderDetailList.add(tmpOrderDetailVO6);
//
//			OrderDetailVO tmpOrderDetailVO7 = new OrderDetailVO();
//				tmpOrderDetailVO7.setProdCode("HEART");
//				tmpOrderDetailVO7.setColorCode("1");
//				tmpOrderDetailVO7.setOrderAmt(30);
//				tmpOrderDetailVO7.setLeastAmt(1);
//	
//			orderDetailList.add(tmpOrderDetailVO7);
//
//////////// Case 4
//				OrderDetailVO tmpOrderDetailVO5 = new OrderDetailVO();
//					tmpOrderDetailVO5.setProdCode("STRAWBIG");
//					tmpOrderDetailVO5.setColorCode("1");
//					tmpOrderDetailVO5.setOrderAmt(4);
//					tmpOrderDetailVO5.setLeastAmt(1);
//				
//				orderDetailList.add(tmpOrderDetailVO5);
//				
//				OrderDetailVO tmpOrderDetailVO6 = new OrderDetailVO();
//					tmpOrderDetailVO6.setProdCode("WATERMELON");
//					tmpOrderDetailVO6.setColorCode("1");
//					tmpOrderDetailVO6.setOrderAmt(4);
//					tmpOrderDetailVO6.setLeastAmt(1);
//	
//				orderDetailList.add(tmpOrderDetailVO6);
//			
//////////Case 5
//		OrderDetailVO tmpOrderDetailVO5 = new OrderDetailVO();
//			tmpOrderDetailVO5.setProdCode("STRAWBIG");
//			tmpOrderDetailVO5.setColorCode("1");
//			tmpOrderDetailVO5.setOrderAmt(2);
//			tmpOrderDetailVO5.setLeastAmt(1);
//		
//		orderDetailList.add(tmpOrderDetailVO5);
//		
//		OrderDetailVO tmpOrderDetailVO6 = new OrderDetailVO();
//			tmpOrderDetailVO6.setProdCode("WATERMELON");
//			tmpOrderDetailVO6.setColorCode("1");
//			tmpOrderDetailVO6.setOrderAmt(4);
//			tmpOrderDetailVO6.setLeastAmt(1);
//
//		orderDetailList.add(tmpOrderDetailVO6);

//////////Case 6
//		OrderDetailVO tmpOrderDetailVO5 = new OrderDetailVO();
//			tmpOrderDetailVO5.setProdCode("DURIAN");
//			tmpOrderDetailVO5.setColorCode("1");
//			tmpOrderDetailVO5.setOrderAmt(5);
//			tmpOrderDetailVO5.setLeastAmt(1);
//		
//		orderDetailList.add(tmpOrderDetailVO5);
//		
//		OrderDetailVO tmpOrderDetailVO6 = new OrderDetailVO();
//			tmpOrderDetailVO6.setProdCode("BANANA");
//			tmpOrderDetailVO6.setColorCode("1");
//			tmpOrderDetailVO6.setOrderAmt(5);
//			tmpOrderDetailVO6.setLeastAmt(1);
//
//		orderDetailList.add(tmpOrderDetailVO6);
			
////////////Case 7
//			OrderDetailVO tmpOrderDetailVO5 = new OrderDetailVO();
//				tmpOrderDetailVO5.setProdCode("BANANA");
//				tmpOrderDetailVO5.setColorCode("1");
//				tmpOrderDetailVO5.setOrderAmt(5);
//				tmpOrderDetailVO5.setLeastAmt(1);
//			
//			orderDetailList.add(tmpOrderDetailVO5);
//			
//			OrderDetailVO tmpOrderDetailVO6 = new OrderDetailVO();
//				tmpOrderDetailVO6.setProdCode("FLOWER");
//				tmpOrderDetailVO6.setColorCode("1");
//				tmpOrderDetailVO6.setOrderAmt(20);
//				tmpOrderDetailVO6.setLeastAmt(1);
//
//			orderDetailList.add(tmpOrderDetailVO6);

//////////Case 8
//				OrderDetailVO tmpOrderDetailVO5 = new OrderDetailVO();
//					tmpOrderDetailVO5.setProdCode("BANANA");
//					tmpOrderDetailVO5.setColorCode("1");
//					tmpOrderDetailVO5.setOrderAmt(5);
//					tmpOrderDetailVO5.setLeastAmt(1);
//				
//				orderDetailList.add(tmpOrderDetailVO5);
//				
//				OrderDetailVO tmpOrderDetailVO6 = new OrderDetailVO();
//					tmpOrderDetailVO6.setProdCode("FLOWER");
//					tmpOrderDetailVO6.setColorCode("1");
//					tmpOrderDetailVO6.setOrderAmt(20);
//					tmpOrderDetailVO6.setLeastAmt(1);
//
//				orderDetailList.add(tmpOrderDetailVO6);
//				
//				OrderDetailVO tmpOrderDetailVO7 = new OrderDetailVO();
//					tmpOrderDetailVO7.setProdCode("STRAWS");
//					tmpOrderDetailVO7.setColorCode("1");
//					tmpOrderDetailVO7.setOrderAmt(20);
//					tmpOrderDetailVO7.setLeastAmt(1);
//
//				orderDetailList.add(tmpOrderDetailVO7);
	
//////////Case 9
//					OrderDetailVO tmpOrderDetailVO5 = new OrderDetailVO();
//						tmpOrderDetailVO5.setProdCode("STRAWBIG");
//						tmpOrderDetailVO5.setColorCode("1");
//						tmpOrderDetailVO5.setOrderAmt(5);
//						tmpOrderDetailVO5.setLeastAmt(1);
//					
//					orderDetailList.add(tmpOrderDetailVO5);
//					
//					OrderDetailVO tmpOrderDetailVO6 = new OrderDetailVO();
//						tmpOrderDetailVO6.setProdCode("HEARTBAR");
//						tmpOrderDetailVO6.setColorCode("1");
//						tmpOrderDetailVO6.setOrderAmt(30);
//						tmpOrderDetailVO6.setLeastAmt(1);
//
//					orderDetailList.add(tmpOrderDetailVO6);

			
	order.setOrderDetailList(orderDetailList);
	
		
		return order;
	}
	
	/*
	 * When Test :  for Simulate All Type of Box data
	 */
	public static List<BoxVO> getAllBoxType() {
		
		List<BoxVO> listBoxVO = new ArrayList<BoxVO>();
			listBoxVO.add( new BoxVO("Box 0", 11-0.2, 17-0.2, 6-0.2, 1121) );
			listBoxVO.add( new BoxVO("Box A", 14-0.2, 20-0.2, 6-0.2, 1680) );
			listBoxVO.add( new BoxVO("Box 000", 12-0.2, 20-0.2, 9-0.2, 2160) );
			listBoxVO.add( new BoxVO("Box AA", 13-0.2, 17-0.2, 7-0.2, 1547) );
			listBoxVO.add( new BoxVO("Box 2A", 14-0.2, 20-0.2, 12-0.2, 3360) );
			listBoxVO.add( new BoxVO("Box B", 17-0.2, 25-0.2, 9-0.2, 3825) );
			listBoxVO.add( new BoxVO("Box 2B", 17-0.2, 25-0.2, 18-0.2, 7650) );
			listBoxVO.add( new BoxVO("Box C", 20-0.2, 30-0.2, 11-0.2, 6600) );
	
		return listBoxVO;
	}
	
	
	/*
	 * When Test :  for Simulate All Type of Product data
	 */
	public static List<ProductVO> getAllProductType() {
		
		List<ProductVO> productList = new ArrayList<ProductVO>();
		//Add Soap 
		List<ColorVO> coList = new ArrayList<ColorVO>();

		ColorVO co = new ColorVO();
			co.setColorCode("1");
			co.setCost(10);
			co.setLeastAmt(12);
			co.setName("default");
			co.setStatus("A");
		coList.add(co);
		
		ProductVO flower = new ProductVO();
			flower.setHeight(1.4);
			flower.setLength(4);
			flower.setWidth(4);
			flower.setWeight(10);
			flower.setCapacity(flower.getWidth()*flower.getHeight()*flower.getLength());
			flower.setColorList(coList);
			flower.setName("ดอกไม้");
			flower.setPackageType("W");//wrap
			flower.setProdCode("FLOWER");
			flower.setProdType("R");//regular
			flower.setStatus("A");
			
///////////////////////////
		List<ColorVO> coBList = new ArrayList<ColorVO>();

		ColorVO coB = new ColorVO();
			coB.setColorCode("1");
			coB.setCost(6);
			coB.setLeastAmt(12);
			coB.setName("default");
			coB.setStatus("A");
		coBList.add(coB);
		
		ProductVO bee = new ProductVO();
			bee.setHeight(1);
			bee.setLength(3.7);
			bee.setWidth(3.3);
			bee.setWeight(10);
			bee.setCapacity(bee.getWidth()*bee.getHeight()*bee.getLength());
			bee.setColorList(coBList);
			bee.setName("รังผึ้ง");
			bee.setPackageType("W");//wrap
			bee.setProdCode("BEE");
			bee.setProdType("R");//regular
			bee.setStatus("A");
			bee.setCapacity(bee.getWidth()*bee.getHeight()*bee.getLength());
			
///////////////////////////
		List<ColorVO> coGList = new ArrayList<ColorVO>();

		ColorVO coG = new ColorVO();
			coG.setColorCode("1");
			coG.setCost(59);
			coG.setLeastAmt(6);
			coG.setName("green");
			coG.setStatus("A");
		coGList.add(coG);
			
		ProductVO grape = new ProductVO();
			grape.setHeight(3);
			grape.setLength(8.8);
			grape.setWidth(6.1);
			grape.setWeight(50);
			grape.setCapacity(grape.getWidth()*grape.getHeight()*grape.getLength());
			grape.setColorList(coGList);
			grape.setName("องุ่น");
			grape.setPackageType("W");//wrap
			grape.setProdCode("GRAPE");
			grape.setProdType("I");//irregular
			grape.setStatus("A");
			
///////////////////////////
		List<ColorVO> coIList = new ArrayList<ColorVO>();
		
		ColorVO coI = new ColorVO();
			coI.setColorCode("1");
			coI.setCost(15);
			coI.setLeastAmt(10);
			coI.setName("pink");
			coI.setStatus("A");
		coIList.add(coI);
			
		ProductVO iceCreme = new ProductVO();
			iceCreme.setCapacity(38);
			iceCreme.setColorList(coIList);
			iceCreme.setName("ไอศครีม");
			iceCreme.setPackageType("P");//package
			iceCreme.setProdCode("ICECREME");
			iceCreme.setProdType("I");//irregular
			iceCreme.setStatus("A");
			iceCreme.setWeight(15);
			
///////////////////////////
		List<ColorVO> coSList = new ArrayList<ColorVO>();

		ColorVO coS = new ColorVO();
			coS.setColorCode("1");
			coS.setCost(15);
			coS.setLeastAmt(10);
			coS.setName("default");
			coS.setStatus("A");		
		coSList.add(coS);

		ProductVO strawS = new ProductVO();
			strawS.setCapacity(30);
			strawS.setWeight(15);
			strawS.setColorList(coSList);
			strawS.setName("สตรอเบอรี่เล็ก");
			strawS.setPackageType("P");//package
			strawS.setProdCode("STRAWS");
			strawS.setProdType("I");//irregular
			strawS.setStatus("A");

///////////////////////////
		List<ColorVO> coHList = new ArrayList<ColorVO>();
		
		ColorVO coH = new ColorVO();
			coH.setColorCode("1");
			coH.setCost(59);
			coH.setLeastAmt(6);
			coH.setName("ผงถ่าน");
			coH.setStatus("A");		
		coHList.add(coH);
			
		ProductVO heart = new ProductVO();
			heart.setHeight(1.9);
			heart.setLength(6.2);
			heart.setWidth(6.1);
			heart.setWeight(30);
			heart.setColorList(coHList);
			heart.setName("หัวใจเหลี่ยม");
			heart.setPackageType("W");//wrap
			heart.setProdCode("HEART");
			heart.setProdType("I");//irregular
			heart.setStatus("A");

///////////////////////////
		List<ColorVO> coHBList = new ArrayList<ColorVO>();
		
		ColorVO coHB = new ColorVO();
			coHB.setColorCode("1");
			coHB.setCost(20);
			coHB.setLeastAmt(30);
			coHB.setName("blue");
			coHB.setStatus("A");
		coHBList.add(coHB);
			
		ProductVO heartBar = new ProductVO();
			heartBar.setCapacity(35);
			heartBar.setColorList(coSList);
			heartBar.setName("สตรอเบอรี่เสียบไม้");
			heartBar.setPackageType("P");//package
			heartBar.setProdCode("HEARTBAR");
			heartBar.setProdType("I");//irregular
			heartBar.setStatus("A");

///////////////////////////
			List<ColorVO> coSBList = new ArrayList<ColorVO>();
			
			ColorVO coSB = new ColorVO();
			coHB.setColorCode("1");
			coHB.setCost(59);
			coHB.setLeastAmt(15);
			coHB.setName("default");
			coHB.setStatus("A");
			coSBList.add(coSB);
			
			ProductVO strawBig = new ProductVO();
			strawBig.setCapacity(644.8);
			strawBig.setColorList(coSBList);
			strawBig.setName("สตรอเบอรี่ใหญ่");
			strawBig.setPackageType("P");//package ตาข่าย
			strawBig.setProdCode("STRAWBIG");
			strawBig.setProdType("I");//irregular
			strawBig.setStatus("A");
			
///////////////////////////
			List<ColorVO> coWatermList = new ArrayList<ColorVO>();
			
			ColorVO coWaterm = new ColorVO();
			coWaterm.setColorCode("1");
			coWaterm.setCost(59);
			coWaterm.setLeastAmt(15);
			coWaterm.setName("default");
			coWaterm.setStatus("A");
			coWatermList.add(coWaterm);
			
			ProductVO waterMelon = new ProductVO();
			waterMelon.setCapacity(514);
			waterMelon.setColorList(coWatermList);
			waterMelon.setName("แตงโม");
			waterMelon.setPackageType("P");//package ตาข่าย
			waterMelon.setProdCode("WATERMELON");
			waterMelon.setProdType("I");//irregular
			waterMelon.setStatus("A");
			
///////////////////////////
			List<ColorVO> coDurianList = new ArrayList<ColorVO>();
			
			ColorVO coDurian = new ColorVO();
			coDurian.setColorCode("1");
			coDurian.setCost(59);
			coDurian.setLeastAmt(15);
			coDurian.setName("default");
			coDurian.setStatus("A");
			coDurianList.add(coDurian);
			
			ProductVO durian = new ProductVO();
			durian.setCapacity(365.6);
			durian.setColorList(coDurianList);
			durian.setName("ทุเรียน");
			durian.setPackageType("P");
			durian.setProdCode("DURIAN");
			durian.setProdType("I");//irregular
			durian.setStatus("A");
			
///////////////////////////
			List<ColorVO> coBananaList = new ArrayList<ColorVO>();
			
			ColorVO coBanana = new ColorVO();
			coBanana.setColorCode("1");
			coBanana.setCost(59);
			coBanana.setLeastAmt(15);
			coBanana.setName("default");
			coBanana.setStatus("A");
			coBananaList.add(coBanana);
			
			ProductVO banana = new ProductVO();
			banana.setCapacity(292.5);
			banana.setColorList(coBananaList);
			banana.setName("กล้วย");
			banana.setPackageType("P");
			banana.setProdCode("BANANA");
			banana.setProdType("I");//irregular
			banana.setStatus("A");


///////////////////////////
		productList.add(flower);
		productList.add(bee);
		productList.add(heartBar);
		productList.add(heart);
		productList.add(iceCreme);
		productList.add(grape);
		productList.add(strawS);
		productList.add(heart);
		productList.add(heartBar);
		productList.add(strawBig);
		productList.add(waterMelon);
		productList.add(durian);
		productList.add(banana);

		return productList;
	}
	
	
	/*
	 *  For Convert List all product to Map
	 */
	public static Map<String, ProductVO> getMapAllProductType() {
		Map<String, ProductVO> mapAllProduct = new HashMap<String, ProductVO>();
		
		List<ProductVO> listAllProduct = getAllProductType();
		for (ProductVO tmpProductVO : listAllProduct ) {
			mapAllProduct.put( tmpProductVO.getProdCode() , tmpProductVO );
		}

		return mapAllProduct;
	}
	
	
	/*
	 * List Transporter and Price
	 */
	public List<Object> getListChoiceTransporterAndPoint( OrderVO order ) throws Exception {

		listGlobalOrder = null;
		
		// Step 0 Validate Order Data
		if ( !validateOrderData(order) ) {
			throw new Exception(" XXXX ");
		}
		
		// Step 1 Choose Some Box from All By Summary Product's Capacity
			// Step 1.1 get Total Capacity from Order
		double totalProductCapacity = summaryCapacityOfProduct( order );
			// Step 1.2 get list of usable BoxVO
		List<BoxVO> listBoxVO = filterBoxByOrderCapacity( totalProductCapacity );
		
		
		// Step 2 split way ( single box, multiple box )
		if ( listBoxVO.size() > 0 ) {
			// Case Single Box
			
			List<BoxVO> listBoxVOFinal = new ArrayList<BoxVO>();
			
			// 2.1.1 Get List ของ Product Order โดยเรียงจาก 1-สบู่แบบ Warp 2-capacityรวเยอะสุด  3-สบู่แบบPackage
			List<OrderDetailVO> listOrderDetail = getListOfProductByOrder( order );
			
			// 2.1.2 นำ List ของกล่องที่ได้มาพิสูจน์ ด้วยการจัดเรียง หากกล่องไหนใช้ไม่ได้ จะคัดออก
			List<OrderDetailVO> listOrderDetailTemp;
			for( BoxVO tmpBoxVO : listBoxVO ) {
				// Clone list ของ  Order ที่สำหรับใช้พิสูตรไว้ เพื่อไม่ให้กระทบกับ การพิสูจน์ ก่องใบถัดไป
//				listOrderDetailTemp = (ArrayList<OrderDetailVO>)ObjectUtils.deepClone((Object)listOrderDetail);
				listOrderDetailTemp = (ArrayList<OrderDetailVO>)listOrderDetail;
				
				// Add กล่องที่ใช้ได้เข้า List box Final
				if ( isBoxUsable(tmpBoxVO, listOrderDetailTemp, false) ) {
					listBoxVOFinal.add(tmpBoxVO);
				}
			}
			
/*** พิม ดู สิ  ***/
			System.out.println(" ************ This Box can use ************* ");
			for (BoxVO allowedBoxVO : listBoxVOFinal) {
				System.out.println(" Box Name : " + allowedBoxVO.getName() );
			}
			
			
			// 2.2  นำ List ของ Box ที่ใส่ได้ และ น้ำหนัก ไป Cross join กับ เงื่อนไขการขนส่ง

			
		} else {
			// Case Multiple Box
			
		}
		
		return null;
	}
	
	
	
	
	
	/*
	 * For Validate 
	 */
	private boolean validateOrderData( OrderVO order ) {
		return true;
	}
	
	
	/*
	 * Calulate All Product Capacity 
	 */
	private double summaryCapacityOfProduct( OrderVO order ) {
		BigDecimal summaryCapacity = new BigDecimal(0);
		
		Map<String, ProductVO> mapProductVO = getMapAllProductType();
		
		List<OrderDetailVO> orderDetailList = order.getOrderDetailList();
		
		BigDecimal unitCapacity;
		BigDecimal unitAmt;
		BigDecimal sumCapacityUnit;
		
		ProductVO tmpProductVO;

		for(OrderDetailVO tmpOrderDetailVO : orderDetailList) {
			// จำนวนสินค้า ที่ลูกค้าสั่ง ใน Order
			unitAmt = new BigDecimal( tmpOrderDetailVO.getOrderAmt() );
			
			// capacity ของชนิดสินค้าที่สั่ง
			tmpProductVO = mapProductVO.get( tmpOrderDetailVO.getProdCode() );
			unitCapacity = new BigDecimal( tmpProductVO.getCapacity() );
			
				// จำนวนหน่วย * ปริมาตรต่อหน่วย
			sumCapacityUnit = unitAmt.multiply( unitCapacity );
			
			summaryCapacity = summaryCapacity.add( sumCapacityUnit );
		}
		
		
		return summaryCapacity.doubleValue();
	}
	

	/*
	 * Filter Box choose only (Box's Capacity > orderCapacity) 
	 */
	private List<BoxVO> filterBoxByOrderCapacity(double orderCapacity) {
		List<BoxVO> listBoxFilter = new ArrayList<BoxVO>();
		
		List<BoxVO> listBox = getAllBoxType();
		for ( BoxVO tmpBoxVO : listBox ) {
			if ( tmpBoxVO.getCapacity() >= orderCapacity ) {
				listBoxFilter.add( tmpBoxVO );
			}
		}
		
		// Sort Minimum capacity to Maximum capacity
		Collections.sort(listBoxFilter, new BoxComparator());

		return listBoxFilter;
	}
	
	
	/*
	 * Get List of Order Product with Condition 
	 */
	private List<OrderDetailVO> getListOfProductByOrder( OrderVO order ) {
		// has soap type wrap?
		List<OrderDetailVO> listOrderDetailVO = new ArrayList<OrderDetailVO>();
		List<OrderDetailVO> prodWrapList = new ArrayList<OrderDetailVO>();
		List<OrderDetailVO> prodPackList = new ArrayList<OrderDetailVO>();
		
		Map<String, ProductVO> mapProductVO = getMapAllProductType();
		
		List<OrderDetailVO> orderDetailList = order.getOrderDetailList();
		
		BigDecimal unitCapacity;
		BigDecimal unitAmt;
		BigDecimal sumCapacityUnit;
		ProductVO tmpProductVO;
		
		Comparator<Double> comparator = Double::compare;
		Comparator<Double> reverseComparator = comparator.reversed();
		
		Map<Double, OrderDetailVO> mapWarpProduct = new TreeMap<Double, OrderDetailVO>(reverseComparator);
		Map<Double, OrderDetailVO> mapPackageProduct = new TreeMap<Double, OrderDetailVO>(reverseComparator);
		
		Map<Double, OrderDetailVO> mapCheckKeyDup = new HashMap<>();
		
		for( OrderDetailVO tmpOrderDetailVO : orderDetailList ) {
			// จำนวนสินค้า ที่ลูกค้าสั่ง ใน Order
			unitAmt = new BigDecimal( tmpOrderDetailVO.getOrderAmt() );
			
			// capacity ของชนิดสินค้าที่สั่ง
			tmpProductVO = mapProductVO.get( tmpOrderDetailVO.getProdCode() );
			unitCapacity = new BigDecimal( tmpProductVO.getCapacity() );
			
				// จำนวนหน่วย * ปริมาตรต่อหน่วย
			sumCapacityUnit = unitAmt.multiply( unitCapacity );
			
				// กรณี มีสินค้าที่ปริมาตร รวมเท่ากัน ให้ รายการหลัง + 0.001 เพื่อไม่ให้ซ้ำ
			sumCapacityUnit = new BigDecimal( checkDuplicateKey( mapCheckKeyDup, sumCapacityUnit.doubleValue() ) );
			mapCheckKeyDup.put( sumCapacityUnit.doubleValue(), tmpOrderDetailVO );
			
			if ( "W".equals(tmpProductVO.getPackageType()) ) {
				mapWarpProduct.put( sumCapacityUnit.doubleValue() , tmpOrderDetailVO );
			} else {
				mapPackageProduct.put( sumCapacityUnit.doubleValue() , tmpOrderDetailVO );
			}
		}
		
		prodWrapList.addAll( mapWarpProduct.values() );
		prodPackList.addAll( mapPackageProduct.values() );
		
		listOrderDetailVO.addAll(prodWrapList);
		listOrderDetailVO.addAll(prodPackList);
		
		return listOrderDetailVO;
	}
	
	
	private double checkDuplicateKey( Map<Double, OrderDetailVO> mapCheckKeyDup, double sumCapacityUnit ) {
		
		if ( mapCheckKeyDup.get( sumCapacityUnit ) != null ) {
			sumCapacityUnit += 0.001;
			
			sumCapacityUnit = checkDuplicateKey( mapCheckKeyDup, sumCapacityUnit );
		}
		
		return sumCapacityUnit;
	}
	
	
	/*
	 * Get Result of Usable this BOX 
	 */
	private boolean isBoxUsable(BoxVO boxVO, List<OrderDetailVO> listOrderDetailVO, boolean isMiniBox ) {
		
		if ( isMiniBox ) {
			System.out.println(" ********** Is Mini Box ********** " + ( boxVO.getHeight() * boxVO.getLength() * boxVO.getWidth() ));
		} else {
			System.out.println(" ********** Is Main Box ********** " + ( boxVO.getHeight() * boxVO.getLength() * boxVO.getWidth() ));
		}
		
		boolean resUsable = true;

		Map<String, ProductVO> mapProductVO = getMapAllProductType();
		Map mapResultFinal = new HashMap();
		int finalPoint = 0;
		
		List<OrderDetailVO> listResultOrderDetailVO = new ArrayList<OrderDetailVO>();
		List<BoxVO> listMiniBox = new ArrayList<BoxVO>(); 
		
		ProductVO tmpProductVO;
		for( OrderDetailVO tmpOrderDetailVO : listOrderDetailVO ){
			tmpProductVO = mapProductVO.get( tmpOrderDetailVO.getProdCode() );

			if (tmpOrderDetailVO.getOrderAmt() > 0) {
				if ("P".equals(tmpProductVO.getPackageType())) {
					// แบบ Package วนตัด ปริภมาตร ภายในออก 
					if ( boxVO.getCapacity() >= ( tmpProductVO.getCapacity() * tmpOrderDetailVO.getOrderAmt()  ) ) {
						boxVO.setCapacity( boxVO.getCapacity() - tmpProductVO.getCapacity() );
						resUsable = true;
						return resUsable;
					} else {
						resUsable = false;
						return resUsable;
					}
				} else {
					int orderAmt =	tmpOrderDetailVO.getOrderAmt();
					
					Map mapResult1 = getNumberOfUnitInLine(boxVO, tmpProductVO, "1");
					Map mapResult2 = getNumberOfUnitInLine(boxVO, tmpProductVO, "2");
					Map mapResult3 = getNumberOfUnitInLine(boxVO, tmpProductVO, "3");
					Map mapResult4 = getNumberOfUnitInLine(boxVO, tmpProductVO, "4");
					Map mapResult5 = getNumberOfUnitInLine(boxVO, tmpProductVO, "5");
					Map mapResult6 = getNumberOfUnitInLine(boxVO, tmpProductVO, "6");
					
					
					// เอารูปแบบการจัดเรียง ไม่ได้ออกไป
					List<Map> listMapResult1 = new ArrayList<Map>();
					if ( (Integer)mapResult1.get("W_QUANTITY") > 0 ) {
						listMapResult1.add( mapResult1 );
					} else if ( (Integer)mapResult2.get("W_QUANTITY") > 0 ) {
						listMapResult1.add( mapResult2 );
					} else if ( (Integer)mapResult3.get("W_QUANTITY") > 0 ) {
						listMapResult1.add( mapResult3 );
					} else if ( (Integer)mapResult4.get("W_QUANTITY") > 0 ) {
						listMapResult1.add( mapResult4 );
					} else if ( (Integer)mapResult5.get("W_QUANTITY") > 0 ) {
						listMapResult1.add( mapResult5 );
					} else if ( (Integer)mapResult6.get("W_QUANTITY") > 0 ) {
						listMapResult1.add( mapResult6 );
					}
					
					if (listMapResult1.isEmpty()) {
						resUsable = false;
						break;
					}
					
					// เอา รูปแบบจัดเรีบงที่ใช้ได้มาเลือก โดยดูจากพื้นที่เหลือ และส่วนประกอบต่างๆ โดยการให้คะแนน
					List<Map> listMapResult2 = new ArrayList<Map>();
					for(Map tmpMap : listMapResult1) {
						int point = 0;
	/*** กำหนดประเภท Score ***/
						// ถ้าด้านกว้าง ไม่มี เศษ และ จำนวนของสินค้าพอใส่ 
						if ( (Integer)tmpMap.get("W_POINT") <= 1 ) {
							point += 1;
	
							if ( ((Integer)tmpMap.get("W_QUANTITY")) % tmpOrderDetailVO.getOrderAmt() == 0 ) {
								point += 2;
							}					
						} else {
							if ( ((Integer)tmpMap.get("W_QUANTITY")) % tmpOrderDetailVO.getOrderAmt() == 0 ) {
								point += 1;
							}
						}
						
						// ถ้าด้านยาว ไม่มี เศษ และ จำนวนของสินค้าพอใส่ 
						if ( (Integer)tmpMap.get("L_POINT") <= 1 ) {
							point += 1;
	
							if ( ((Integer)tmpMap.get("L_QUANTITY")) % tmpOrderDetailVO.getOrderAmt() == 0 ) {
								point += 2;
							}					
						} else {
							if ( ((Integer)tmpMap.get("L_QUANTITY")) % tmpOrderDetailVO.getOrderAmt() == 0 ) {
								point += 1;
							}
						}
	
						// ถ้าด้านสูง ไม่มี เศษ และ จำนวนของสินค้าพอใส่ 
						if ( (Integer)tmpMap.get("H_POINT") <= 1 ) {
							point += 1;
	
							if ( ((Integer)tmpMap.get("H_QUANTITY")) % tmpOrderDetailVO.getOrderAmt() == 0 ) {
								point += 2;
							}					
						} else {
							if ( ((Integer)tmpMap.get("H_QUANTITY")) % tmpOrderDetailVO.getOrderAmt() == 0 ) {
								point += 1;
							}
						}
	/*** (End) กำหนดประเภท Score ***/
	
						// ทำการเลือกวิธีการที่ไดคะแนนเยอะที่สุด
						if ( finalPoint < point ) {
							finalPoint = point;
							mapResultFinal = tmpMap;
						} else if ( finalPoint == 0 ) {
							mapResultFinal = tmpMap;
						}
					}
				}
				
				
				// ทำการตัดจำนวนและพื้นที่
					// ประเภท การวาง
				int name = (Integer)mapResultFinal.get("NAME");
System.out.println(" รูปแบบการจัดเรียง : " + name);
					// จำนวนที่วางได้
				int quatity = getQuatityToPut(mapResultFinal, tmpOrderDetailVO);
System.out.println(" จำนวนที่วางได้  : " + quatity);
				int resultQuatity = tmpOrderDetailVO.getOrderAmt() - quatity;
System.out.println(" จำนวนคงเหลือ : " + resultQuatity);
				if (resultQuatity > 0) {
					tmpOrderDetailVO.setOrderAmt(resultQuatity);
					listResultOrderDetailVO.add(tmpOrderDetailVO);
				}
				
					// คำนวน สร้างกล่องย่อย
				double out_width =  boxVO.getWidth() - (Integer)mapResultFinal.get("W_POINT");
				double out_length = boxVO.getLength() - (Integer)mapResultFinal.get("L_POINT");
				double out_height = boxVO.getHeight() - (Integer)mapResultFinal.get("H_POINT");
				
				if (out_width <= 1) {
					out_width = 0;
				}
				
				if (out_length <= 1) {
					out_length = 0;
				}
				
				if (out_height <= 1) {
					out_height = 0;
				}
				
				if ((out_width == 0) || (out_length == 0) || (out_height == 0)) {
					// มีพื้นที่ ด้าน คงเหลือน้อยเกินไป ให้ตัดพื้นที่ทิ้ง
					
					boxVO.setHeight(0);
					boxVO.setLength(0);
					boxVO.setWidth(0);
					
				} else {
					// มีพื้นที่คง เหลือ มากพอ ให้สร้างเป็น กล่องย่อย
					BoxVO miniBoxVO = new BoxVO();
					
					if (out_height > 0) {
						boxVO.setHeight( out_height );
						boxVO.setLength( boxVO.getLength() );
						boxVO.setWidth( boxVO.getWidth() );
						
						if (out_width > 0) {
							miniBoxVO = new BoxVO();
							miniBoxVO.setHeight( (Integer)mapResultFinal.get("H_POINT") );
							miniBoxVO.setLength( (Integer)mapResultFinal.get("L_POINT") );
							miniBoxVO.setWidth( out_width );
							
							listMiniBox.add(miniBoxVO);
						} 
						
						if (out_length > 0) {
							miniBoxVO = new BoxVO();
							miniBoxVO.setHeight( (Integer)mapResultFinal.get("H_POINT") );
							miniBoxVO.setLength( out_length );
							miniBoxVO.setWidth( (Integer)mapResultFinal.get("W_POINT") );
							
							listMiniBox.add(miniBoxVO);
						}
					} else {
//						boxVO.setHeight( (Integer)mapResultFinal.get("H_POINT") );
						
						if (out_width >= out_length) {
							boxVO.setLength( out_length );

							miniBoxVO = new BoxVO();
							miniBoxVO.setHeight( boxVO.getHeight() );
							miniBoxVO.setLength( (Integer)mapResultFinal.get("L_POINT") );
							miniBoxVO.setWidth( out_width );

							listMiniBox.add(miniBoxVO);
						} else if (out_width < out_length) {
							boxVO.setWidth( out_width );
							
							miniBoxVO = new BoxVO();
							miniBoxVO.setHeight( boxVO.getHeight() );
							miniBoxVO.setLength( out_length );
							miniBoxVO.setWidth( (Integer)mapResultFinal.get("W_POINT") );
							
							listMiniBox.add(miniBoxVO);
						}
						
					}
					
				}
			}
		}

		// ยอด List คงเหลือ
		if ( listResultOrderDetailVO.isEmpty() ) {
			// ใส่กล่องได้หมดแล้ว
			resUsable = true;

		} else {
			setGlobalList( listResultOrderDetailVO );
			
			// ใส่กล่องได้ไม่หมด
			if ( listMiniBox.isEmpty() ) {
				//  ไม่มีกล่องย้อยเหลือ
				resUsable = false;
			} else {
				// มีกล่องย่อยเหลือ
				
				for( BoxVO tmpBoxVO : listMiniBox ) {
					listResultOrderDetailVO = getGlobalList();
					isBoxUsable(tmpBoxVO, listResultOrderDetailVO, true);
				}
				
				listResultOrderDetailVO = getGlobalList();
				
				if ( !listResultOrderDetailVO.isEmpty() ) {
					resUsable = false;
				}
			}
		}
		
		return resUsable;
	}
	
	
	private Map<String, Integer> getNumberOfUnitInLine(BoxVO boxVO, ProductVO productVO, String productSide ) {
		Map<String, Integer> resultMap = new HashMap<String, Integer>();
		
		double sideW = boxVO.getWidth();
		double sideL = boxVO.getLength();
		double sideH = boxVO.getHeight();
				
		// เตรียม ข้อมูลสบู่
		double pSideW = productVO.getWeight();
		double pSideL = productVO.getLength();
		double pSideH = productVO.getHeight();
		
		// รูปแบบการเรียงสบู่ มี 6 แบบ
		if ("1".equals(productSide)) {
			// 1 แบบวางนอน ใช้ กว้าง เทียบ
			resultMap.put("NAME", 1);
			
			// เทีบลก่อน ว่า สบู่สามารถว่างแบบนี้ได้จรงไหม
			if ((pSideW > sideW) || (pSideL > sideL) || (pSideH > sideH)) {
				// ใส่ไม่ได้
				
				resultMap.put("W_QUANTITY", 0);
				resultMap.put("W_POINT", 0);
				resultMap.put("L_QUANTITY", 0);
				resultMap.put("L_POINT", 0);
				resultMap.put("H_QUANTITY", 0);
				resultMap.put("H_POINT", 0);
				
			} else {
				// ใส่ได้ หาจำนวน กับพื้นที่ว่างเหลือ
				double w_quantity = Math.round( sideW/pSideW );
				double w_point = sideW - ( pSideW * w_quantity );
				
				double l_quantity = Math.round( sideL/pSideL );
				double l_point = sideL - ( pSideL * l_quantity );
				
				double h_quantity = Math.round( sideH/pSideH );
				double h_point = sideL - ( pSideH * h_quantity );				
				
				resultMap.put("W_QUANTITY", Integer.parseInt( String.valueOf( Math.round(w_quantity) ) ) );
				resultMap.put("W_POINT", Integer.parseInt( String.valueOf( Math.round(w_point) ) ));
				
				resultMap.put("L_QUANTITY", Integer.parseInt( String.valueOf( Math.round(l_quantity) ) ) );
				resultMap.put("L_POINT", Integer.parseInt( String.valueOf( Math.round(l_point) ) ));

				resultMap.put("H_QUANTITY", Integer.parseInt( String.valueOf( Math.round(h_quantity) ) ) );
				resultMap.put("H_POINT", Integer.parseInt( String.valueOf( Math.round(h_point) ) ));

			}

		} else if ("2".equals(productSide)) {
			// 2 แบบวางน้อน ใช้ ยาวเทียบ
			resultMap.put("NAME", 2);
			
			// เทีบลก่อน ว่า สบู่สามารถว่างแบบนี้ได้จรงไหม
			if ((pSideL > sideW) || (pSideW > sideL) || (pSideH > sideH)) {
				// ใส่ไม่ได้
				resultMap.put("W_QUANTITY", 0);
				resultMap.put("W_POINT", 0);
				resultMap.put("L_QUANTITY", 0);
				resultMap.put("L_POINT", 0);
				resultMap.put("H_QUANTITY", 0);
				resultMap.put("H_POINT", 0);
				
			} else {
				// ใส่ได้ หาจำนวน กับพื้นที่ว่างเหลือ
				double w_quantity = Math.round( sideW/pSideL );
				double w_point = sideW - ( pSideL * w_quantity );
				
				double l_quantity = Math.round( sideL/pSideW );
				double l_point = sideL - ( pSideW * l_quantity );

				double h_quantity = Math.round( sideH/pSideH );
				double h_point = sideL - ( pSideH * h_quantity );	
				
				resultMap.put("W_QUANTITY", Integer.parseInt( String.valueOf( Math.round(w_quantity) ) ) );
				resultMap.put("W_POINT", Integer.parseInt( String.valueOf( Math.round(w_point) ) ));

				resultMap.put("L_QUANTITY", Integer.parseInt( String.valueOf( Math.round(l_quantity) ) ) );
				resultMap.put("L_POINT", Integer.parseInt( String.valueOf( Math.round(l_point) ) ));

				resultMap.put("H_QUANTITY", Integer.parseInt( String.valueOf( Math.round(h_quantity) ) ) );
				resultMap.put("H_POINT", Integer.parseInt( String.valueOf( Math.round(h_point) ) ));

			}
			
		} else if ("3".equals(productSide)) {
			// 3 แบบวงตะแครง ใช้กว้างทียบ
			resultMap.put("NAME", 3);

			// เทีบลก่อน ว่า สบู่สามารถว่างแบบนี้ได้จรงไหม
			if ((pSideH > sideW) || (pSideL > sideL) || (pSideW > sideH)) {
				// ใส่ไม่ได้
				resultMap.put("W_QUANTITY", 0);
				resultMap.put("W_POINT", 0);
				resultMap.put("L_QUANTITY", 0);
				resultMap.put("L_POINT", 0);
				resultMap.put("H_QUANTITY", 0);
				resultMap.put("H_POINT", 0);
				
			} else {
				// ใส่ได้ หาจำนวน กับพื้นที่ว่างเหลือ
				double w_quantity = Math.round( sideW/pSideH );
				double w_point = sideW - ( pSideH * w_quantity );

				double l_quantity = Math.round( sideL/pSideL );
				double l_point = sideL - ( pSideL * l_quantity );

				double h_quantity = Math.round( sideH/pSideW );
				double h_point = sideL - ( pSideW * h_quantity );	
				
				resultMap.put("QUANTITY", Integer.parseInt( String.valueOf( Math.round(w_quantity) ) ) );
				resultMap.put("POINT", Integer.parseInt( String.valueOf( Math.round(w_point) ) ));

				resultMap.put("L_QUANTITY", Integer.parseInt( String.valueOf( Math.round(l_quantity) ) ) );
				resultMap.put("L_POINT", Integer.parseInt( String.valueOf( Math.round(l_point) ) ));

				resultMap.put("H_QUANTITY", Integer.parseInt( String.valueOf( Math.round(h_quantity) ) ) );
				resultMap.put("H_POINT", Integer.parseInt( String.valueOf( Math.round(h_point) ) ));
			}
			
		} else if ("4".equals(productSide)) {
			// 4 แบบวงตะแครง ใช้ยาวเทียบ
			resultMap.put("NAME", 4);

			// เทีบลก่อน ว่า สบู่สามารถว่างแบบนี้ได้จรงไหม
			if ((pSideL > sideW) || (pSideH > sideL) || (pSideW > sideH)) {
				// ใส่ไม่ได้
				resultMap.put("W_QUANTITY", 0);
				resultMap.put("W_POINT", 0);
				resultMap.put("L_QUANTITY", 0);
				resultMap.put("L_POINT", 0);
				resultMap.put("H_QUANTITY", 0);
				resultMap.put("H_POINT", 0);
				
			} else {
				// ใส่ได้ หาจำนวน กับพื้นที่ว่างเหลือ
				double w_quantity = Math.round( sideW/pSideL );
				double w_point = sideW - ( pSideL * w_quantity );

				double l_quantity = Math.round( sideL/pSideH );
				double l_point = sideL - ( pSideH * l_quantity );

				double h_quantity = Math.round( sideH/pSideW );
				double h_point = sideL - ( pSideW * h_quantity );	
				
				resultMap.put("QUANTITY", Integer.parseInt( String.valueOf( Math.round(w_quantity) ) ) );
				resultMap.put("POINT", Integer.parseInt( String.valueOf( Math.round(w_point) ) ));

				resultMap.put("L_QUANTITY", Integer.parseInt( String.valueOf( Math.round(l_quantity) ) ) );
				resultMap.put("L_POINT", Integer.parseInt( String.valueOf( Math.round(l_point) ) ));

				resultMap.put("H_QUANTITY", Integer.parseInt( String.valueOf( Math.round(h_quantity) ) ) );
				resultMap.put("H_POINT", Integer.parseInt( String.valueOf( Math.round(h_point) ) ));
			}
			
		} else if ("5".equals(productSide)) {
			// 5 แบบวางตั้ง ใช้ยาวเทียบ
			resultMap.put("NAME", 5);

			// เทีบลก่อน ว่า สบู่สามารถว่างแบบนี้ได้จรงไหม
			if ((pSideW > sideW) || (pSideH > sideL) || (pSideL > sideH)) {
				// ใส่ไม่ได้
				resultMap.put("W_QUANTITY", 0);
				resultMap.put("W_POINT", 0);
				resultMap.put("L_QUANTITY", 0);
				resultMap.put("L_POINT", 0);
				resultMap.put("H_QUANTITY", 0);
				resultMap.put("H_POINT", 0);

			} else {
				// ใส่ได้ หาจำนวน กับพื้นที่ว่างเหลือ
				double w_quantity = Math.round( sideW/pSideW );
				double w_point = sideW - ( pSideW * w_quantity );

				double l_quantity = Math.round( sideL/pSideH );
				double l_point = sideL - ( pSideH * l_quantity );

				double h_quantity = Math.round( sideH/pSideL );
				double h_point = sideL - ( pSideL * h_quantity );	
				
				resultMap.put("QUANTITY", Integer.parseInt( String.valueOf( Math.round(w_quantity) ) ) );
				resultMap.put("POINT", Integer.parseInt( String.valueOf( Math.round(w_point) ) ));

				resultMap.put("L_QUANTITY", Integer.parseInt( String.valueOf( Math.round(l_quantity) ) ) );
				resultMap.put("L_POINT", Integer.parseInt( String.valueOf( Math.round(l_point) ) ));

				resultMap.put("H_QUANTITY", Integer.parseInt( String.valueOf( Math.round(h_quantity) ) ) );
				resultMap.put("H_POINT", Integer.parseInt( String.valueOf( Math.round(h_point) ) ));
			}

		} else if ("6".equals(productSide)) {
			// 6 แบบวางตั้ง ใช้ยาวเทียบ
			resultMap.put("NAME", 6);

			// เทีบลก่อน ว่า สบู่สามารถว่างแบบนี้ได้จรงไหม
			if ((pSideH > sideW) || (pSideW > sideL) || (pSideL > sideH)) {
				// ใส่ไม่ได้
				resultMap.put("W_QUANTITY", 0);
				resultMap.put("W_POINT", 0);
				resultMap.put("L_QUANTITY", 0);
				resultMap.put("L_POINT", 0);
				resultMap.put("H_QUANTITY", 0);
				resultMap.put("H_POINT", 0);

			} else {
				// ใส่ได้ หาจำนวน กับพื้นที่ว่างเหลือ
				double w_quantity = Math.round( sideW/pSideH );
				double w_point = sideW - ( pSideH * w_quantity );

				double l_quantity = Math.round( sideL/pSideW );
				double l_point = sideL - ( pSideW * l_quantity );

				double h_quantity = Math.round( sideH/pSideL );
				double h_point = sideL - ( pSideL * h_quantity );	
				
				resultMap.put("QUANTITY", Integer.parseInt( String.valueOf( Math.round(w_quantity) ) ) );
				resultMap.put("POINT", Integer.parseInt( String.valueOf( Math.round(w_point) ) ));

				resultMap.put("L_QUANTITY", Integer.parseInt( String.valueOf( Math.round(l_quantity) ) ) );
				resultMap.put("L_POINT", Integer.parseInt( String.valueOf( Math.round(l_point) ) ));

				resultMap.put("H_QUANTITY", Integer.parseInt( String.valueOf( Math.round(h_quantity) ) ) );
				resultMap.put("H_POINT", Integer.parseInt( String.valueOf( Math.round(h_point) ) ));
			}
		}
		
		
		return resultMap;
	}
	
	
	private int getQuatityToPut(Map<String, Object> mapResultFinal, OrderDetailVO tmpOrderDetailVO) {
		
		// เลือกประเภทการวาง
		int name = (Integer)mapResultFinal.get("NAME");
		int putQuatity = 0;

		if ( tmpOrderDetailVO.getOrderAmt() >= ((Integer)mapResultFinal.get("W_QUANTITY") * (Integer)mapResultFinal.get("H_QUANTITY")) ) {
			// กรณี ที่ จำนวนชิ้น มากกว่า จำนวนชิ้นต่อแถว
			// จำนวนแถวที่ต้องการ วาง
			int count_rows = 0;
			int perW_quatity = (Integer)mapResultFinal.get("W_QUANTITY");
			int perH_quatity = (Integer)mapResultFinal.get("H_QUANTITY");
			int maxL_quatity = (Integer)mapResultFinal.get("L_QUANTITY");
			for (int x = 1 ; x <= maxL_quatity ; x++ ) {
				int total_put = ( x * ( perW_quatity * perH_quatity) );
				
				if ( tmpOrderDetailVO.getOrderAmt() > total_put ) {
					continue;
				} else if ( tmpOrderDetailVO.getOrderAmt() == total_put || x == maxL_quatity ) {
					putQuatity = total_put;
				} else if ( tmpOrderDetailVO.getOrderAmt() < total_put ) {
					putQuatity = ( (x - 1) * ( perW_quatity * perH_quatity) );
					break;
				}
			}
			
		} else {
			// กรณี จำนวนชิ้น น้อยกว่าจำนวนต่อแถว
			putQuatity = tmpOrderDetailVO.getOrderAmt();
		}

		return putQuatity;
	}
	
	
	private void setGlobalList(List<OrderDetailVO> inlistGlobalOrder) {
		listGlobalOrder = inlistGlobalOrder;
	}
	
	private List<OrderDetailVO> getGlobalList() {
		return listGlobalOrder;
	}
}
