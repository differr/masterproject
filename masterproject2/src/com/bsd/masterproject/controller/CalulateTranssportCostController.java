package com.bsd.masterproject.controller;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.bsd.masterproject.utils.BoxComparator;
import com.bsd.masterproject.utils.ObjectUtils;
import com.bsd.masterproject.vo.BoxVO;
import com.bsd.masterproject.vo.ColorVO;
import com.bsd.masterproject.vo.OrderDetailVO;
import com.bsd.masterproject.vo.OrderVO;
import com.bsd.masterproject.vo.ProductVO;

public class CalulateTranssportCostController {

	List<BoxVO> listMiniBox = new ArrayList<BoxVO>();
	List<OrderDetailVO> listGlobalOrder = null;
	
	BigDecimal totalFreeArea = new BigDecimal(0);
	private static DecimalFormat df2 = new DecimalFormat(".##");

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

////////// Case 1
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
//////////// Case 2
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
//			
//	//////////Case 10
						OrderDetailVO tmpOrderDetailVO5 = new OrderDetailVO();
							tmpOrderDetailVO5.setProdCode("STRAWBIG");
							tmpOrderDetailVO5.setColorCode("1");
							tmpOrderDetailVO5.setOrderAmt(5);
							tmpOrderDetailVO5.setLeastAmt(1);
						
						orderDetailList.add(tmpOrderDetailVO5);
						
						OrderDetailVO tmpOrderDetailVO6 = new OrderDetailVO();
							tmpOrderDetailVO6.setProdCode("HEARTBAR");
							tmpOrderDetailVO6.setColorCode("1");
							tmpOrderDetailVO6.setOrderAmt(30);
							tmpOrderDetailVO6.setLeastAmt(1);
	
						orderDetailList.add(tmpOrderDetailVO6);
						
						OrderDetailVO tmpOrderDetailVO7 = new OrderDetailVO();
						tmpOrderDetailVO7.setProdCode("FLOWER");
						tmpOrderDetailVO7.setColorCode("1");
						tmpOrderDetailVO7.setOrderAmt(23);
						tmpOrderDetailVO7.setLeastAmt(1);

						orderDetailList.add(tmpOrderDetailVO7);
						
						OrderDetailVO tmpOrderDetailVO8 = new OrderDetailVO();
						tmpOrderDetailVO8.setProdCode("BANANA");
						tmpOrderDetailVO8.setColorCode("1");
						tmpOrderDetailVO8.setOrderAmt(5);
						tmpOrderDetailVO8.setLeastAmt(1);

						orderDetailList.add(tmpOrderDetailVO8);
						
						OrderDetailVO tmpOrderDetailVO9 = new OrderDetailVO();
						tmpOrderDetailVO9.setProdCode("GRAPE");
						tmpOrderDetailVO9.setColorCode("1");
						tmpOrderDetailVO9.setOrderAmt(6);
						tmpOrderDetailVO9.setLeastAmt(1);

						orderDetailList.add(tmpOrderDetailVO9);
						
//						//////////Case 11
//						OrderDetailVO tmpOrderDetailVO10 = new OrderDetailVO();
//						tmpOrderDetailVO10.setProdCode("STRAWPACK");
//						tmpOrderDetailVO10.setColorCode("1");
//						tmpOrderDetailVO10.setOrderAmt(12);
//						tmpOrderDetailVO10.setLeastAmt(12);
//					
//						orderDetailList.add(tmpOrderDetailVO10);
//						
//						OrderDetailVO tmpOrderDetailVO11 = new OrderDetailVO();
//						tmpOrderDetailVO11.setProdCode("ICECREME");
//						tmpOrderDetailVO11.setColorCode("1");
//						tmpOrderDetailVO11.setOrderAmt(12);
//						tmpOrderDetailVO11.setLeastAmt(12);
//					
//						orderDetailList.add(tmpOrderDetailVO11);
//						
//						OrderDetailVO tmpOrderDetailVO12 = new OrderDetailVO();
//						tmpOrderDetailVO12.setProdCode("GRAPE");
//						tmpOrderDetailVO12.setColorCode("1");
//						tmpOrderDetailVO12.setOrderAmt(5);
//						tmpOrderDetailVO12.setLeastAmt(5);
			//
//						orderDetailList.add(tmpOrderDetailVO12);
			
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
			flower.setHeight(1.9);
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
				banana.setHeight(3.5);
				banana.setLength(9.7);
				banana.setWidth(7.5);
				banana.setWeight(30);
				banana.setCapacity(276.45);
				banana.setColorList(coBananaList);
				banana.setName("กล้วย");
				banana.setPackageType("W");
				banana.setProdCode("BANANA");
				banana.setProdType("I");//irregular
				banana.setStatus("A");


				///////////////////////////
				List<ColorVO> coHeartPackList = new ArrayList<ColorVO>();
				
				ColorVO coHeartPack = new ColorVO();
				coHeartPack.setColorCode("1");
				coHeartPack.setCost(59);
				coHeartPack.setLeastAmt(15);
				coHeartPack.setName("red");
				coHeartPack.setStatus("A");
				coHeartPackList.add(coHeartPack);
				
				ProductVO heartPack = new ProductVO();
				heartPack.setWeight(30);
				heartPack.setCapacity(39.91);
				heartPack.setColorList(coHeartPackList);
				heartPack.setName("หัวใขซอง");
				heartPack.setPackageType("P");
				heartPack.setProdCode("HEARTPACK");
				heartPack.setProdType("I");//irregular
				heartPack.setStatus("A");
				
				
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
				productList.add(heartPack);

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
		totalFreeArea = new BigDecimal(0);
		
		// Step 0 Validate Order Data
		if ( !validateOrderData(order) ) {
			throw new Exception(" XXXX ");
		}
		
		// Step 1 Choose Some Box from All By Summary Product's Capacity
			/* P1 */
			// Step 1.1 get Total Capacity from Order  
		double totalProductCapacity = summaryCapacityOfProduct( order );
			/* P2 */
				/*P2.1*/
				// Step 1.2 get list of usable BoxVO
		List<BoxVO> listBoxVO = filterBoxByOrderCapacity( totalProductCapacity );
		//Print listBoxVO
		System.out.println("Box List of P2.1");
		if(listBoxVO != null){
			for(BoxVO b : listBoxVO){
				System.out.println(">>> "+ b.getName() + " : " + b.getCapacity());
			}
		}
		
		
		// Step 2 split way ( single box, multiple box )
		if ( listBoxVO.size() > 0 ) {
			// Case Single Box
			
			List<BoxVO> listBoxVOFinal = new ArrayList<BoxVO>();
			/* P2.2 */
			// 2.1.1 Get List ของ Product Order โดยเรียงจาก 1-สบู่แบบ Warp 2-capacityรวเยอะสุด  3-สบู่แบบPackage
			List<OrderDetailVO> listOrderDetail = getListOfProductByOrder( order );
			//Print listOrderDetail
			System.out.println("Soap List of P2.2");
			if(listOrderDetail != null){
				for(OrderDetailVO s : listOrderDetail){
					System.out.println(">>> "+ s.getProdCode());
				}
			}
			
			
			
			// 2.1.2 นำ List ของกล่องที่ได้มาพิสูจน์ ด้วยการจัดเรียง หากกล่องไหนใช้ไม่ได้ จะคัดออก
			List<OrderDetailVO> listOrderDetailTemp;
			for( BoxVO tmpBoxVO : listBoxVO ) {
				// Clone list ของ  Order ที่สำหรับใช้พิสูตรไว้ เพื่อไม่ให้กระทบกับ การพิสูจน์ ก่องใบถัดไป
				listOrderDetailTemp = (ArrayList<OrderDetailVO>)ObjectUtils.deepClone((Object)listOrderDetail);
//				listOrderDetailTemp = (ArrayList<OrderDetailVO>)listOrderDetail;
				setGlobalList( listOrderDetailTemp );
				
				/*P2.3*/
				// Add กล่องที่ใช้ได้เข้า List box Final
				if ( isBoxUsable(tmpBoxVO, listOrderDetailTemp, false) ) {
					listBoxVOFinal.add(tmpBoxVO);
				}
			}
			
/*** พิม ดู สิ  ***/
			System.out.println(" ************ This Box can arrangement of P2 ************* ");
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
			System.out.println("Capacity of "+tmpProductVO.getName()+" : "+sumCapacityUnit);
			summaryCapacity = summaryCapacity.add( sumCapacityUnit );
		}
		
		System.out.println("Total Capacity of Products : "+summaryCapacity);
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
		Map<String, ProductVO> mapProductVO = getMapAllProductType();
		
		// has soap type wrap?
		List<OrderDetailVO> listOrderDetailVO = new ArrayList<OrderDetailVO>();
//		List<OrderDetailVO> prodWrapList = new ArrayList<OrderDetailVO>();
//		List<OrderDetailVO> prodPackList = new ArrayList<OrderDetailVO>();
//		
//		
//		List<OrderDetailVO> orderDetailList = order.getOrderDetailList();
//		
//		BigDecimal unitCapacity;
//		BigDecimal unitAmt;
//		BigDecimal sumCapacityUnit;
//		ProductVO tmpProductVO;
//		
//		Comparator<Double> comparator = Double::compare;
//		Comparator<Double> reverseComparator = comparator.reversed();
//		
//		Map<Double, OrderDetailVO> mapWarpProduct = new TreeMap<Double, OrderDetailVO>(reverseComparator);
//		Map<Double, OrderDetailVO> mapPackageProduct = new TreeMap<Double, OrderDetailVO>(reverseComparator);
//		
//		Map<Double, OrderDetailVO> mapCheckKeyDup = new HashMap<>();
//		
//		for( OrderDetailVO tmpOrderDetailVO : orderDetailList ) {
//			// จำนวนสินค้า ที่ลูกค้าสั่ง ใน Order
//			unitAmt = new BigDecimal( tmpOrderDetailVO.getOrderAmt() );
//			
//			// capacity ของชนิดสินค้าที่สั่ง
//			tmpProductVO = mapProductVO.get( tmpOrderDetailVO.getProdCode() );
//			unitCapacity = new BigDecimal( tmpProductVO.getCapacity() );
//			
//				// จำนวนหน่วย * ปริมาตรต่อหน่วย
//			sumCapacityUnit = unitAmt.multiply( unitCapacity );
//			
//				// กรณี มีสินค้าที่ปริมาตร รวมเท่ากัน ให้ รายการหลัง + 0.001 เพื่อไม่ให้ซ้ำ
//			sumCapacityUnit = new BigDecimal( checkDuplicateKey( mapCheckKeyDup, sumCapacityUnit.doubleValue() ) );
//			mapCheckKeyDup.put( sumCapacityUnit.doubleValue(), tmpOrderDetailVO );
//			
//			if ( "W".equals(tmpProductVO.getPackageType()) ) {
//				mapWarpProduct.put( sumCapacityUnit.doubleValue() , tmpOrderDetailVO );
//			} else {
//				mapPackageProduct.put( sumCapacityUnit.doubleValue() , tmpOrderDetailVO );
//			}
//		}
//		
//		prodWrapList.addAll( mapWarpProduct.values() );
//		prodPackList.addAll( mapPackageProduct.values() );
//		
//		
//		listOrderDetailVO.addAll(prodWrapList);
//		listOrderDetailVO.addAll(prodPackList);
		
		
		List<OrderDetailVO> prodRegularList = new ArrayList<OrderDetailVO>();
		List<OrderDetailVO> prodIrregularWrapList = new ArrayList<OrderDetailVO>();
		List<OrderDetailVO> prodIrregularPackageList = new ArrayList<OrderDetailVO>();
		
		// สำหรับการจัดเรียง
		Comparator<Double> comparator = Double::compare;
		Comparator<Double> reverseComparator = comparator.reversed();
		Map<Double, OrderDetailVO> mapRegular = new TreeMap<Double, OrderDetailVO>(reverseComparator);
		Map<Double, OrderDetailVO> mapIrregularWrap = new TreeMap<Double, OrderDetailVO>(reverseComparator);
		Map<Double, OrderDetailVO> mapIrregularPackage = new TreeMap<Double, OrderDetailVO>(reverseComparator);
		
		List<OrderDetailVO> orderDetailList = order.getOrderDetailList();
		
		BigDecimal unitCapacity;
		BigDecimal unitAmt;
		BigDecimal sumCapacityUnit;
		ProductVO tmpProductVO;

		for( OrderDetailVO tmpOrderDetailVO : orderDetailList ) {
			// ดึงข้อมูล ของชนิดสินค้า
			tmpProductVO = mapProductVO.get( tmpOrderDetailVO.getProdCode() );
			
			if( "R".equals(tmpProductVO.getProdType())) {
				// จำนวนสินค้า ที่ลูกค้าสั่ง ใน Order
				unitAmt = new BigDecimal( tmpOrderDetailVO.getOrderAmt() );
				unitCapacity = new BigDecimal( tmpProductVO.getCapacity() );
				
				// จำนวนหน่วย * ปริมาตรต่อหน่วย
				sumCapacityUnit = unitAmt.multiply( unitCapacity );
				
				// กรณี มีสินค้าที่ปริมาตร รวมเท่ากัน ให้ รายการหลัง + 0.001 เพื่อไม่ให้ซ้ำ
				sumCapacityUnit = new BigDecimal( checkDuplicateKey( mapRegular, sumCapacityUnit.doubleValue() ) );
				mapRegular.put( sumCapacityUnit.doubleValue(), tmpOrderDetailVO );

			} else {
				if( "P".equals(tmpProductVO.getPackageType()) ) {
					// จำนวนสินค้า ที่ลูกค้าสั่ง ใน Order
					unitAmt = new BigDecimal( tmpOrderDetailVO.getOrderAmt() );
					unitCapacity = new BigDecimal( tmpProductVO.getCapacity() );
					
					// จำนวนหน่วย * ปริมาตรต่อหน่วย
					sumCapacityUnit = unitAmt.multiply( unitCapacity );
					
					// กรณี มีสินค้าที่ปริมาตร รวมเท่ากัน ให้ รายการหลัง + 0.001 เพื่อไม่ให้ซ้ำ
					sumCapacityUnit = new BigDecimal( checkDuplicateKey( mapIrregularPackage, sumCapacityUnit.doubleValue() ) );
					mapIrregularPackage.put( sumCapacityUnit.doubleValue(), tmpOrderDetailVO );
					
				} else {
					// จำนวนสินค้า ที่ลูกค้าสั่ง ใน Order
					unitAmt = new BigDecimal( tmpOrderDetailVO.getOrderAmt() );
					unitCapacity = new BigDecimal( tmpProductVO.getCapacity() );
					
					// จำนวนหน่วย * ปริมาตรต่อหน่วย
					sumCapacityUnit = unitAmt.multiply( unitCapacity );
					
					// กรณี มีสินค้าที่ปริมาตร รวมเท่ากัน ให้ รายการหลัง + 0.001 เพื่อไม่ให้ซ้ำ
					sumCapacityUnit = new BigDecimal( checkDuplicateKey( mapIrregularWrap, sumCapacityUnit.doubleValue() ) );
					mapIrregularWrap.put( sumCapacityUnit.doubleValue(), tmpOrderDetailVO );
				}
			}
		}
		
		listOrderDetailVO.addAll( mapRegular.values() );
		listOrderDetailVO.addAll( mapIrregularWrap.values() );
		listOrderDetailVO.addAll( mapIrregularPackage.values() );

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
			System.out.println(" ********** Is Mini Box ********** "  + ( boxVO.getHeight() * boxVO.getLength() * boxVO.getWidth() ));
			System.out.println(" Width = " + boxVO.getWidth() + " | Height = " + boxVO.getHeight() + " | Length = " + boxVO.getLength() );
		} else {
			System.out.println(" ***************************************************************************************************** ");
			System.out.println(" ********** Is Main Box ( " + boxVO.getName() + " ) ********** "  + ( boxVO.getHeight() * boxVO.getLength() * boxVO.getWidth() ));
			System.out.println(" ***************************************************************************************************** ");
			System.out.println(" Width = " + boxVO.getWidth() + " | Height = " + boxVO.getHeight() + " | Length = " + boxVO.getLength() );
		}
		
		double originalWidth 	= boxVO.getWidth();
		double originalHeight 	= boxVO.getHeight();
		double originalLength 	= boxVO.getLength();
		
		boolean resUsable = true;

		Map<String, ProductVO> mapProductVO = getMapAllProductType();
		Map<String, Integer> mapResultFinal = new HashMap<String, Integer>();
		int finalPoint = 0;
		
		List<OrderDetailVO> listResultOrderDetailVO = new ArrayList<OrderDetailVO>();
		List<BoxVO> listMiniBox = new ArrayList<BoxVO>(); 
		
		ProductVO tmpProductVO;
		int i = 0;
		for( OrderDetailVO tmpOrderDetailVO : listOrderDetailVO ){
			tmpProductVO = mapProductVO.get( tmpOrderDetailVO.getProdCode() );
System.out.println(i + " Product Code : " + tmpOrderDetailVO.getProdCode());
System.out.println(" Product Width = " + tmpProductVO.getWidth() + " | Height = " + tmpProductVO.getHeight() + " | Length = " + tmpProductVO.getLength() );
System.out.println(" Box Width = " + boxVO.getWidth() + " | Height = " + boxVO.getHeight() + " | Length = " + boxVO.getLength() );

			if (tmpOrderDetailVO.getOrderAmt() > 0) {
				if ("I".equals(tmpProductVO.getProdType()) && "P".equals(tmpProductVO.getPackageType())) {
					double sumCapacityAmt 		= 0;
					double sumFreeAreaCapacity 	= 0;
					
					// ตรวจสอบว่า มี รายการถัดไปใน List ที่ไม่ใช่ Package หรือไม่
					boolean hasProductNotPackage = false;
					List<OrderDetailVO> listOrderDetailVO2 = getGlobalList();	
					OrderDetailVO tmpOrderDetailVO2;
					ProductVO tmpProductVO2;
					for (int xx = 0 ; xx < listOrderDetailVO2.size() ; xx++ ) {
						tmpOrderDetailVO2 = listOrderDetailVO2.get(xx);
						tmpProductVO2 = mapProductVO.get( tmpOrderDetailVO2.getProdCode() );
						
						if ( !("I".equals(tmpProductVO2.getProdType()) && "P".equals(tmpProductVO2.getPackageType())) && (tmpOrderDetailVO2.getOrderAmt() > 0) ) {							
							hasProductNotPackage = true;
						} else {
							sumCapacityAmt += ( tmpProductVO2.getCapacity() * tmpOrderDetailVO2.getOrderAmt()  );
						}
					}

					// ถ้ามีรายการที่ไม่ใช้ Package ต่อท้าย ให้ข้าม Loop รายการนี้ไปเลย
					if(hasProductNotPackage) {
System.out.println(" @ ข้ามไปก่อนยังมี Warp ใสเหลือ ");
						i = i + 1;
						
						if ( listOrderDetailVO.size() == i ) {
							listMiniBox.add(boxVO);
						}

						continue;
					}

					sumFreeAreaCapacity += (boxVO.getWidth() * boxVO.getLength() * boxVO.getHeight());
					
					
					// แบบ Irregular || Package วนตัด ปริภมาตร ภายในออก  
//					if ( boxVO.getCapacity() >= sumCapacityAmt ) {
//						boxVO.setCapacity( boxVO.getCapacity() - tmpProductVO.getCapacity() );
System.out.println(" @ วางสินค้า แบบ Package ลงที่ว่างกล่อง จำนวน  " + tmpOrderDetailVO.getOrderAmt() + " ชิ้น ");
						resUsable = true;
						System.out.println(">>> Usable = TRUE <<<");
						return resUsable;
//					} else {
//						resUsable = false;
//						System.out.println(">>> Usable = FALSE <<<");
//						return resUsable;
//					}
					
					
					
					
				} else {
					/* P2.3.1 */
					Map<String, Integer> mapResult1 = getNumberOfUnitInLine(boxVO, tmpProductVO, "1");
					Map<String, Integer> mapResult2 = getNumberOfUnitInLine(boxVO, tmpProductVO, "2");
					Map<String, Integer> mapResult3 = getNumberOfUnitInLine(boxVO, tmpProductVO, "3");
					Map<String, Integer> mapResult4 = getNumberOfUnitInLine(boxVO, tmpProductVO, "4");
					Map<String, Integer> mapResult5 = getNumberOfUnitInLine(boxVO, tmpProductVO, "5");
					Map<String, Integer> mapResult6 = getNumberOfUnitInLine(boxVO, tmpProductVO, "6");
					
					
					// เอารูปแบบการจัดเรียง ไม่ได้ออกไป
					List<Map<String, Integer>> listMapResult1 = new ArrayList<Map<String, Integer>>();
					if ( (Integer)mapResult1.get("W_QUANTITY") > 0 ) {
						listMapResult1.add( mapResult1 );
					} 
					if ( (Integer)mapResult2.get("W_QUANTITY") > 0 ) {
						listMapResult1.add( mapResult2 );
					} 
					if ( (Integer)mapResult3.get("W_QUANTITY") > 0 ) {
						listMapResult1.add( mapResult3 );
					} 
					if ( (Integer)mapResult4.get("W_QUANTITY") > 0 ) {
						listMapResult1.add( mapResult4 );
					} 
					if ( (Integer)mapResult5.get("W_QUANTITY") > 0 ) {
						listMapResult1.add( mapResult5 );
					} 
					if ( (Integer)mapResult6.get("W_QUANTITY") > 0 ) {
						listMapResult1.add( mapResult6 );
					}
					//Print **********  P2.3.1
					System.out.println("Arrangment แบบที่ตัดจำนวนวางได้เท่ากับ 0 ออกแล้ว  of P2.3.1");
					for(Map<String, Integer> listMap : listMapResult1){
//System.out.println(">>> "+listMap.entrySet().toString());
					}
					
					if (listMapResult1.isEmpty()) {
						System.out.println(" === วางไม่ได้แลย  === ");
						listResultOrderDetailVO = listOrderDetailVO;
						resUsable = false;
						break;
					}
					
					// หาค่าจำนวนที่รูปแบบวางได้มากที่สุด
					int maximumPut = 0;
					int maxType = 0;
					int minimumBox = 999999999;
					for(Map<String, Integer> tmpMap : listMapResult1) {
						int tempCanPut = ((Integer)tmpMap.get("W_QUANTITY")) * ((Integer)tmpMap.get("L_QUANTITY")) * ((Integer)tmpMap.get("H_QUANTITY"));
						int tmpMinimumBox = ((Integer)tmpMap.get("W_REMAIN") + (Integer)tmpMap.get("L_REMAIN") + (Integer)tmpMap.get("H_REMAIN"));
						
						if (tempCanPut > maximumPut) {
							maxType = 1;
							maximumPut = tempCanPut;
						} else if (tempCanPut == maximumPut) {
							maxType = maxType + 1;
						}
						if (tmpMinimumBox < minimumBox) {
							minimumBox = tmpMinimumBox;
						}
					}
					
// เอา รูปแบบจัดเรีบงที่ใช้ได้มาเลือก โดยดูจากพื้นที่เหลือ และส่วนประกอบต่างๆ โดยการให้คะแนน
					int outArea = 0;
					boolean hasEqua = false;
					mapResultFinal = new HashMap<String, Integer>();
					finalPoint = 0;
					
					for(Map<String, Integer> tmpMap : listMapResult1) {
System.out.println(" คิดคะแนน แบบที่ " + tmpMap.get("NAME"));
						int point = 0;
	/*** กำหนดประเภท Score ***/
						// ถ้าด้านกว้าง ไม่มี เศษ และ จำนวนของสินค้าพอใส่ 
						if ( (Integer)tmpMap.get("W_REMAIN") <= 1 ) {
							point += 1;
System.out.println("  ถ้าด้านกว้าง ไม่มี เศษ   + 1 ");
						} 
						
						// ด้านกว้างวางได้เต็มแถวพอดี
						if ( ((Integer)tmpMap.get("W_QUANTITY")) % tmpOrderDetailVO.getOrderAmt() == 0 ) {
							point += 1;
System.out.println("  ด้านกว้างวางได้เต็มแถวพอดี  + 1 ");
						}	
						
						// ถ้าด้านยาว ไม่มี เศษ และ จำนวนของสินค้าพอใส่ 
						if ( (Integer)tmpMap.get("L_REMAIN") <= 1 ) {
							point += 1;
System.out.println("  ถ้าด้านยาว ไม่มี  + 1 ");
						}
						
						if ( ((Integer)tmpMap.get("L_QUANTITY")) % tmpOrderDetailVO.getOrderAmt() == 0 ) {
							point += 1;
System.out.println("  ด้านยาววางได้เต็มแถวพอดี  + 1 ");
						}	
	
						// ถ้าด้านสูง ไม่มี เศษ และ จำนวนของสินค้าพอใส่ 
						if ( (Integer)tmpMap.get("H_REMAIN") <= 1 ) {
							point += 1;
System.out.println("  ถ้าด้านสูง ไม่มี เศษ   + 1 ");
						}
						
						if ( ((Integer)tmpMap.get("H_QUANTITY")) % tmpOrderDetailVO.getOrderAmt() == 0 ) {
							point += 1;
System.out.println("  ด้านสูงวางได้เต็มแถวพอดี  + 1 ");
						}
						
//						// เพิ่ม ถ้าวางได้ เยอะสุด +1 คะนน
//						if ( maximumPut == ((Integer)tmpMap.get("W_QUANTITY")) * ((Integer)tmpMap.get("L_QUANTITY")) * ((Integer)tmpMap.get("H_QUANTITY")) ) {
//							point += 1;
//System.out.println(" วางได้เยอะที่สุด + 1 ");
//
//							if ( maxType > 1) {
//								if ( minimumBox == (Integer)tmpMap.get("W_REMAIN") + (Integer)tmpMap.get("L_REMAIN") + (Integer)tmpMap.get("H_REMAIN") ) {
//									point += 1;
//System.out.println(" พื้นที่ที่เหลือแต่ละด้าน เลือกเอาแบบที่พื้นที่เหลือมันน้อยสุด + 1 ");
//								}
//							}
//						}
//						
//						// จำนวนสินค้าใน Order ใกล้เคียงสบู่ที่จะวางจริง 
//						if ( 0 == tmpOrderDetailVO.getOrderAmt() % (Integer)tmpMap.get("W_QUANTITY")) {
//System.out.println(" จำนวนที่วางได้ ใกล้เคียงกับ ยอดสั่งซ้ือ  + 1 ");
//							point += 1;
//						}
	/*** (End) กำหนดประเภท Score ***/
	
						// ทำการเลือกวิธีการที่ไดคะแนนเยอะที่สุด
						if ( finalPoint < point ) {
							finalPoint = point;
							mapResultFinal = tmpMap;
						} else if ( finalPoint == 0 ) {
							mapResultFinal = tmpMap;
						}
						
						System.out.println(" รูปแบบการเรียง : " + tmpMap.get("NAME") + " | Point : "+point);
					}
					System.out.println(" รูปแบบการเรียงที่เลือก : " + mapResultFinal.get("NAME") + " | Final Point : "+finalPoint);
					System.out.println("Choose Arrangment");
//					System.out.println(">>> "+mapResultFinal.entrySet().toString());
					
				}
				
				// ทำการตัดจำนวนและพื้นที่
					// ประเภท การวาง
				int name = (Integer)mapResultFinal.get("NAME");
System.out.println(" รูปแบบการจัดเรียง : " + name);
					// จำนวนที่วางได้
				int quatity = getQuatityToPut(mapResultFinal, tmpOrderDetailVO);
System.out.println(" จำนวนที่วางได้  : " + quatity);

				// จำนวนที่วางได้แนวกว้าง และ สูง
				int q_length =  (Integer)mapResultFinal.get("L_QUANTITY");
				int q_width =  (Integer)mapResultFinal.get("W_QUANTITY");
				int q_height =  (Integer)mapResultFinal.get("H_QUANTITY");
				int put_quatity = 0;
				boolean fullLine = false;
				boolean fullRow = false;
				
				if (quatity < q_width) {
					fullLine = false;
					fullRow = false;
					put_quatity = quatity;
System.out.println(" @ (01) วาง 1 แถว | วางซ้อน  1 ชั้น | วางแถวละ  " + put_quatity + " ชิ้น ");
				} else {
					fullLine = true;
					if (quatity == (q_width * q_height)) {
						fullRow = true;
						
						put_quatity = (q_width * q_height);
System.out.println(" @ (02) วาง " + q_width + " แถว   |วางซ้อน  " + q_height + " ชั้น | วางแถวละ  " + q_width + " ชิ้น ");
					} else {
						int finalH = 0;
						int finalW = 0;
						boolean isResult = false;
						
						for(int w = 1; w <= q_width; w++) {
							for(int h = 1; h <= q_height; h++) {
								if(!isResult) {
									int temp_put_quatity = ((q_width * w) * h);
									
									if (temp_put_quatity <= tmpOrderDetailVO.getOrderAmt()) {
										put_quatity = temp_put_quatity;
										
										if (h == q_height) {
											finalH = h;
											finalW = w;
											isResult = true;
										}
									} else {
										finalH = h-1;
										finalW = w;
										isResult = true;
									}
								}
							}
						}
						
						if( finalH == 0) {
							finalH = q_height;
						} else {
							q_height = finalH;
						}
						
System.out.println(" @ (03) วาง " + finalW + " แถว   |วางซ้อน  " + finalH + " ชั้น | วางแถวละ  " + q_width + " ชิ้น ");
					}
					
				}

System.out.println("จำนวนที่วางจริง : "+put_quatity);
				int resultQuatity = 0; 
//				if ( tmpOrderDetailVO.getOrderAmt() < put_quatity ) {
//					resultQuatity = tmpOrderDetailVO.getOrderAmt();
//				} else {
//					resultQuatity = tmpOrderDetailVO.getOrderAmt() - quatity;
					resultQuatity = tmpOrderDetailVO.getOrderAmt() - put_quatity;
//				}
				
System.out.println(" จำนวนคงเหลือ : " + resultQuatity);
				if (resultQuatity > 0) {
					tmpOrderDetailVO.setOrderAmt(resultQuatity);
					listResultOrderDetailVO.add(tmpOrderDetailVO);
				} else {
					tmpOrderDetailVO.setOrderAmt(0);
				}

				// เตรียม ข้อมูลสบู่  ???
				double pSideW = tmpProductVO.getWidth();
				double pSideL = tmpProductVO.getLength();
				double pSideH = tmpProductVO.getHeight();
				
				double out_width = 0;
				double out_length = 0;
				double out_height = 0;
				
//				if(fullRow) {
//					out_height =  (Integer)mapResultFinal.get("H_REMAIN");
//				}

				switch (name) {
					case 1 :
//						if(fullLine) {
							out_width = Double.parseDouble( String.valueOf( boxVO.getWidth() - (pSideW * q_width)) );
//						}
						if (out_height == 0) {
							out_height = Double.parseDouble( String.valueOf( boxVO.getHeight() - (pSideH * q_height)) );
						}
						out_length = Double.parseDouble( String.valueOf( boxVO.getLength() - pSideL ) );
					break;
					case 2 :
						if(fullLine) {
							out_width = Double.parseDouble( String.valueOf( boxVO.getWidth() ) );
						}
						if (out_height == 0) {
							out_height = Double.parseDouble( String.valueOf( boxVO.getHeight() - (pSideH * q_height)) );
						}
						out_length = Double.parseDouble( String.valueOf( boxVO.getLength() - pSideW ) );
					break;
					case 3 :
						if(fullLine) {
							out_width = Double.parseDouble( String.valueOf( boxVO.getWidth()) );
						}
						if (out_height == 0) {
							out_height = Double.parseDouble( String.valueOf( boxVO.getHeight() - (pSideW * q_height)) );
						}
						out_length = Double.parseDouble( String.valueOf( boxVO.getLength() - pSideL ) );
					break;
					case 4 :
						if(fullLine) {
							out_width = Double.parseDouble( String.valueOf( boxVO.getWidth()) );
						}
						if (out_height == 0) {
							out_height = Double.parseDouble( String.valueOf( boxVO.getHeight() - (pSideW * q_height)) );
						}
						out_length = Double.parseDouble( String.valueOf( boxVO.getLength() - pSideH ) );
					break;
					case 5 :
						if(fullLine) {
							out_width = Double.parseDouble( String.valueOf( boxVO.getWidth() ) );
						}
						if (out_height == 0) {
							out_height = Double.parseDouble( String.valueOf( boxVO.getHeight() - (pSideL * q_height)) );
						}
						out_length = Double.parseDouble( String.valueOf( boxVO.getLength() - pSideH ) );
					break;
					case 6 :
						if(fullLine) {
							out_width = Double.parseDouble( String.valueOf( boxVO.getWidth() ) );
						}
						if (out_height == 0) {
							out_height = Double.parseDouble( String.valueOf( boxVO.getHeight() - (pSideL * q_height)) );
						}
						out_length = Double.parseDouble( String.valueOf( boxVO.getLength() - pSideW ) );
					break;
				}

//				out_height = (Integer)mapResultFinal.get("H_REMAIN");
				
				out_width = Double.parseDouble( df2.format(out_width) );
				out_length = Double.parseDouble( df2.format(out_length) );
				out_height = Double.parseDouble( df2.format(out_height) );
				
				
				/* P2.3.3 */
				// คำนวน สร้างกล่องย่อย
//				if (out_width <= 1) {
//					out_width = 0;
//				}
//				
//				if (out_length <= 1) {
//					out_length = 0;
//				}
//				
//				if (out_height <= 1) {
//					out_height = 0;
//				}
				
				if ( (out_width == 0) && (out_length == 0) && (out_height == 0) ) {
					// มีพื้นที่ ด้าน คงเหลือน้อยเกินไป ให้ตัดพื้นที่ทิ้ง
					System.out.println("Mini box >>> No have");
//					boxVO.setHeight(out_width);
//					boxVO.setLength(out_length);
//					boxVO.setWidth(out_length);
//System.out.println(" (1) Box W = " + boxVO.getWidth() + " Box L = " + boxVO.getLength() + " Box H = " + boxVO.getHeight() );
				} else {
					// มีพื้นที่คง เหลือ มากพอ ให้สร้างเป็น กล่องย่อย
					BoxVO miniBoxVO = new BoxVO();
					
					if (out_height > 0) {
						if (out_width > 0) {
							miniBoxVO = new BoxVO();
							miniBoxVO.setHeight( boxVO.getHeight() - out_height );
							miniBoxVO.setLength( boxVO.getLength() - out_length );
							miniBoxVO.setWidth( out_width );
							
System.out.println(" >>> Add minibox 1 :  Width = " + miniBoxVO.getWidth() + " | Height = " + miniBoxVO.getHeight() + " | Length = " + miniBoxVO.getLength() + " | totaly = " + ( miniBoxVO.getWidth() * miniBoxVO.getHeight() * miniBoxVO.getLength()) );
							listMiniBox.add(miniBoxVO);
						} 
						
						if (out_length > 0) {
							miniBoxVO = new BoxVO();
							miniBoxVO.setHeight( out_height );
							miniBoxVO.setLength( boxVO.getLength() );
							miniBoxVO.setWidth( boxVO.getWidth() );

System.out.println(" >>> Add minibox 2 :  Width = " + miniBoxVO.getWidth() + " | Height = " + miniBoxVO.getHeight() + " | Length = " + miniBoxVO.getLength() + " | totaly = " + ( miniBoxVO.getWidth() * miniBoxVO.getHeight() * miniBoxVO.getLength()) );
							listMiniBox.add(miniBoxVO);
						}

						boxVO.setHeight( boxVO.getHeight() - out_height );
						boxVO.setLength( out_length );
						boxVO.setWidth( boxVO.getWidth() );

					} else {
//						boxVO.setHeight( (Integer)mapResultFinal.get("H_REMAIN") );
						
						if ( out_width >= out_length ) {
							
							if ( out_width < boxVO.getWidth() ) {
								miniBoxVO = new BoxVO();
									miniBoxVO.setHeight( boxVO.getHeight() );
									miniBoxVO.setLength( (Integer)mapResultFinal.get("L_REMAIN") );
									miniBoxVO.setWidth( boxVO.getWidth() - out_width );

System.out.println(" >>> Add minibox 3 :  Width = " + miniBoxVO.getWidth() + " | Height = " + miniBoxVO.getHeight() + " | Length = " + miniBoxVO.getLength() + " | totaly = " + ( miniBoxVO.getWidth() * miniBoxVO.getHeight() * miniBoxVO.getLength()) );
								listMiniBox.add(miniBoxVO);
							} else {
								boxVO.setLength( out_length );
							}
							
							boxVO.setWidth( out_width );
						} else if (out_width < out_length) {
							miniBoxVO = new BoxVO();
								miniBoxVO.setHeight( boxVO.getHeight() );
								miniBoxVO.setLength( boxVO.getLength() - out_length );
								miniBoxVO.setWidth( (Integer)mapResultFinal.get("W_REMAIN") );
								
System.out.println(" >>> Add minibox 4 :  Width = " + miniBoxVO.getWidth() + " | Height = " + miniBoxVO.getHeight() + " | Length = " + miniBoxVO.getLength() + " | totaly = " + ( miniBoxVO.getWidth() * miniBoxVO.getHeight() * miniBoxVO.getLength()) );
							listMiniBox.add(miniBoxVO);
							
							boxVO.setLength( out_length );
						}
						
					}
//					System.out.println(" (2) Box W = " + boxVO.getWidth() + " Box L = " + boxVO.getLength() + " Box H = " + boxVO.getHeight() );
				}
			}
			i = i + 1;
			
			if (i == listOrderDetailVO.size() ) {
				if (!( originalWidth == boxVO.getWidth() && originalHeight == boxVO.getHeight() && originalLength == boxVO.getLength() )) {
System.out.println(">>> Add minibox 5 : width "+boxVO.getWidth()+" length "+boxVO.getLength()+" height "+boxVO.getHeight()+" == "+boxVO.getWidth()*boxVO.getLength()*boxVO.getHeight());
					listMiniBox.add( boxVO );
				}
			}
		}
		
		/* Print P2.3.3*/
//		System.out.println("List minibox of P2.3.3");
//		for(BoxVO box : listMiniBox){
//			System.out.println(">>> minibox : width "+box.getWidth()+" length "+box.getLength()+" height "+box.getHeight()+" == "+box.getWidth()*box.getLength()*box.getHeight());
//		}
		
		
		// ยอด List คงเหลือ
		int totalOutQua = 0;
		if (!listResultOrderDetailVO.isEmpty()) {
			for( OrderDetailVO tmpOrderDetailVO : listResultOrderDetailVO ){
				totalOutQua += tmpOrderDetailVO.getOrderAmt();
			}
		}
		
		
		if ( listResultOrderDetailVO.isEmpty() || totalOutQua == 0 ) {
			// ใส่กล่องได้หมดแล้ว
			resUsable = true;
			setGlobalList( listResultOrderDetailVO );
			
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
		double pSideW = productVO.getWidth();
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
				resultMap.put("W_REMAIN", 0);
				resultMap.put("L_QUANTITY", 0);
				resultMap.put("L_REMAIN", 0);
				resultMap.put("H_QUANTITY", 0);
				resultMap.put("H_REMAIN", 0);
				
			} else {
				// ใส่ได้ หาจำนวน กับพื้นที่ว่างเหลือ
				double w_quantity = Math.floor( sideW/pSideW );
				double w_remain = sideW - ( pSideW * w_quantity );
				
				double l_quantity = Math.floor( sideL/pSideL );
				double l_remain = sideL - ( pSideL * l_quantity );
				
				double h_quantity = Math.floor( sideH/pSideH );
				double h_remain = sideH - ( pSideH * h_quantity );				
				
				resultMap.put("W_QUANTITY", Integer.parseInt( String.valueOf( Math.round(w_quantity) ) ) );
				resultMap.put("W_REMAIN", Integer.parseInt( String.valueOf( Math.round(w_remain) ) ));
				
				resultMap.put("L_QUANTITY", Integer.parseInt( String.valueOf( Math.round(l_quantity) ) ) );
				resultMap.put("L_REMAIN", Integer.parseInt( String.valueOf( Math.round(l_remain) ) ));

				resultMap.put("H_QUANTITY", Integer.parseInt( String.valueOf( Math.round(h_quantity) ) ) );
				resultMap.put("H_REMAIN", Integer.parseInt( String.valueOf( Math.round(h_remain) ) ));

			}

		} else if ("2".equals(productSide)) {
			// 2 แบบวางน้อน ใช้ ยาวเทียบ
			resultMap.put("NAME", 2);
			
			// เทีบลก่อน ว่า สบู่สามารถว่างแบบนี้ได้จรงไหม
			if ((pSideL > sideW) || (pSideW > sideL) || (pSideH > sideH)) {
				// ใส่ไม่ได้
				resultMap.put("W_QUANTITY", 0);
				resultMap.put("W_REMAIN", 0);
				resultMap.put("L_QUANTITY", 0);
				resultMap.put("L_REMAIN", 0);
				resultMap.put("H_QUANTITY", 0);
				resultMap.put("H_REMAIN", 0);
				
			} else {
				// ใส่ได้ หาจำนวน กับพื้นที่ว่างเหลือ
				double w_quantity = Math.floor( sideW/pSideL );
				double w_remain = sideW - ( pSideL * w_quantity );
				
				double l_quantity = Math.floor( sideL/pSideW );
				double l_remain = sideL - ( pSideW * l_quantity );

				double h_quantity = Math.floor( sideH/pSideH );
				double h_remain = sideH - ( pSideH * h_quantity );	
				
				resultMap.put("W_QUANTITY", Integer.parseInt( String.valueOf( Math.round(w_quantity) ) ) );
				resultMap.put("W_REMAIN", Integer.parseInt( String.valueOf( Math.round(w_remain) ) ));

				resultMap.put("L_QUANTITY", Integer.parseInt( String.valueOf( Math.round(l_quantity) ) ) );
				resultMap.put("L_REMAIN", Integer.parseInt( String.valueOf( Math.round(l_remain) ) ));

				resultMap.put("H_QUANTITY", Integer.parseInt( String.valueOf( Math.round(h_quantity) ) ) );
				resultMap.put("H_REMAIN", Integer.parseInt( String.valueOf( Math.round(h_remain) ) ));

			}
			
		} else if ("3".equals(productSide)) {
			// 3 แบบวงตะแครง ใช้กว้างทียบ
			resultMap.put("NAME", 3);

			// เทีบลก่อน ว่า สบู่สามารถว่างแบบนี้ได้จรงไหม
			if ((pSideH > sideW) || (pSideL > sideL) || (pSideW > sideH)) {
				// ใส่ไม่ได้
				resultMap.put("W_QUANTITY", 0);
				resultMap.put("W_REMAIN", 0);
				resultMap.put("L_QUANTITY", 0);
				resultMap.put("L_REMAIN", 0);
				resultMap.put("H_QUANTITY", 0);
				resultMap.put("H_REMAIN", 0);
				
			} else {
				// ใส่ได้ หาจำนวน กับพื้นที่ว่างเหลือ
				double w_quantity = Math.floor( sideW/pSideH );
				double w_remain = sideW - ( pSideH * w_quantity );

				double l_quantity = Math.floor( sideL/pSideL );
				double l_remain = sideL - ( pSideL * l_quantity );

				double h_quantity = Math.floor( sideH/pSideW );
				double h_remain = sideH - ( pSideW * h_quantity );	
				
				resultMap.put("W_QUANTITY", Integer.parseInt( String.valueOf( Math.round(w_quantity) ) ) );
				resultMap.put("W_REMAIN", Integer.parseInt( String.valueOf( Math.round(w_remain) ) ));

				resultMap.put("L_QUANTITY", Integer.parseInt( String.valueOf( Math.round(l_quantity) ) ) );
				resultMap.put("L_REMAIN", Integer.parseInt( String.valueOf( Math.round(l_remain) ) ));

				resultMap.put("H_QUANTITY", Integer.parseInt( String.valueOf( Math.round(h_quantity) ) ) );
				resultMap.put("H_REMAIN", Integer.parseInt( String.valueOf( Math.round(h_remain) ) ));
			}
			
		} else if ("4".equals(productSide)) {
			// 4 แบบวงตะแครง ใช้ยาวเทียบ
			resultMap.put("NAME", 4);

			// เทีบลก่อน ว่า สบู่สามารถว่างแบบนี้ได้จรงไหม
			if ((pSideL > sideW) || (pSideH > sideL) || (pSideW > sideH)) {
				// ใส่ไม่ได้
				resultMap.put("W_QUANTITY", 0);
				resultMap.put("W_REMAIN", 0);
				resultMap.put("L_QUANTITY", 0);
				resultMap.put("L_REMAIN", 0);
				resultMap.put("H_QUANTITY", 0);
				resultMap.put("H_REMAIN", 0);
				
			} else {
				// ใส่ได้ หาจำนวน กับพื้นที่ว่างเหลือ
				double w_quantity = Math.floor( sideW/pSideL );
				double w_remain = sideW - ( pSideL * w_quantity );

				double l_quantity = Math.floor( sideL/pSideH );
				double l_remain = sideL - ( pSideH * l_quantity );

				double h_quantity = Math.floor( sideH/pSideW );
				double h_remain = sideH - ( pSideW * h_quantity );	
				
				resultMap.put("W_QUANTITY", Integer.parseInt( String.valueOf( Math.round(w_quantity) ) ) );
				resultMap.put("W_REMAIN", Integer.parseInt( String.valueOf( Math.round(w_remain) ) ));

				resultMap.put("L_QUANTITY", Integer.parseInt( String.valueOf( Math.round(l_quantity) ) ) );
				resultMap.put("L_REMAIN", Integer.parseInt( String.valueOf( Math.round(l_remain) ) ));

				resultMap.put("H_QUANTITY", Integer.parseInt( String.valueOf( Math.round(h_quantity) ) ) );
				resultMap.put("H_REMAIN", Integer.parseInt( String.valueOf( Math.round(h_remain) ) ));
			}
			
		} else if ("5".equals(productSide)) {
			// 5 แบบวางตั้ง ใช้ยาวเทียบ
			resultMap.put("NAME", 5);

			// เทีบลก่อน ว่า สบู่สามารถว่างแบบนี้ได้จรงไหม
			if ((pSideW > sideW) || (pSideH > sideL) || (pSideL > sideH)) {
				// ใส่ไม่ได้
				resultMap.put("W_QUANTITY", 0);
				resultMap.put("W_REMAIN", 0);
				resultMap.put("L_QUANTITY", 0);
				resultMap.put("L_REMAIN", 0);
				resultMap.put("H_QUANTITY", 0);
				resultMap.put("H_REMAIN", 0);

			} else {
				// ใส่ได้ หาจำนวน กับพื้นที่ว่างเหลือ
				double w_quantity = Math.floor( sideW/pSideW );
				double w_remain = sideW - ( pSideW * w_quantity );

				double l_quantity = Math.floor( sideL/pSideH );
				double l_remain = sideL - ( pSideH * l_quantity );

				double h_quantity = Math.floor( sideH/pSideL );
				double h_remain = sideH - ( pSideL * h_quantity );	
				
				resultMap.put("W_QUANTITY", Integer.parseInt( String.valueOf( Math.round(w_quantity) ) ) );
				resultMap.put("W_REMAIN", Integer.parseInt( String.valueOf( Math.round(w_remain) ) ));

				resultMap.put("L_QUANTITY", Integer.parseInt( String.valueOf( Math.round(l_quantity) ) ) );
				resultMap.put("L_REMAIN", Integer.parseInt( String.valueOf( Math.round(l_remain) ) ));

				resultMap.put("H_QUANTITY", Integer.parseInt( String.valueOf( Math.round(h_quantity) ) ) );
				resultMap.put("H_REMAIN", Integer.parseInt( String.valueOf( Math.round(h_remain) ) ));
			}

		} else if ("6".equals(productSide)) {
			// 6 แบบวางตั้ง ใช้ยาวเทียบ
			resultMap.put("NAME", 6);

			// เทีบลก่อน ว่า สบู่สามารถว่างแบบนี้ได้จรงไหม
			if ((pSideH > sideW) || (pSideW > sideL) || (pSideL > sideH)) {
				// ใส่ไม่ได้
				resultMap.put("W_QUANTITY", 0);
				resultMap.put("W_REMAIN", 0);
				resultMap.put("L_QUANTITY", 0);
				resultMap.put("L_REMAIN", 0);
				resultMap.put("H_QUANTITY", 0);
				resultMap.put("H_REMAIN", 0);

			} else {
				// ใส่ได้ หาจำนวน กับพื้นที่ว่างเหลือ
				double w_quantity = Math.floor( sideW/pSideH );
				double w_remain = sideW - ( pSideH * w_quantity );

				double l_quantity = Math.floor( sideL/pSideW );
				double l_remain = sideL - ( pSideW * l_quantity );

				double h_quantity = Math.floor( sideH/pSideL );
				double h_remain = sideH - ( pSideL * h_quantity );	
				
				resultMap.put("W_QUANTITY", Integer.parseInt( String.valueOf( Math.round(w_quantity) ) ) );
				resultMap.put("W_REMAIN", Integer.parseInt( String.valueOf( Math.round(w_remain) ) ));

				resultMap.put("L_QUANTITY", Integer.parseInt( String.valueOf( Math.round(l_quantity) ) ) );
				resultMap.put("L_REMAIN", Integer.parseInt( String.valueOf( Math.round(l_remain) ) ));

				resultMap.put("H_QUANTITY", Integer.parseInt( String.valueOf( Math.round(h_quantity) ) ) );
				resultMap.put("H_REMAIN", Integer.parseInt( String.valueOf( Math.round(h_remain) ) ));
			}
		}
		
//System.out.println(" ============ " + productSide + " ============ ");
//System.out.println(" W_QUANTITY => " + resultMap.get("W_QUANTITY"));
//System.out.println(" W_REMAIN => " + resultMap.get("W_REMAIN"));
//System.out.println(" L_QUANTITY => " + resultMap.get("L_QUANTITY"));
//System.out.println(" L_REMAIN => " + resultMap.get("L_REMAIN"));
//System.out.println(" H_QUANTITY => " + resultMap.get("H_QUANTITY"));
//System.out.println(" H_REMAIN => " + resultMap.get("H_REMAIN"));

		return resultMap;
	}
	
	
	private int getQuatityToPut(Map<String, Integer> mapResultFinal, OrderDetailVO tmpOrderDetailVO) {
		
		// เลือกประเภทการวาง
		int putQuatity = 0;

		if ( tmpOrderDetailVO.getOrderAmt() >= ((Integer)mapResultFinal.get("W_QUANTITY") * (Integer)mapResultFinal.get("H_QUANTITY")) ) {
			// กรณี ที่ จำนวนชิ้น มากกว่า จำนวนชิ้นต่อแถว
			// จำนวนแถวที่ต้องการ วาง
			int perW_quatity = (Integer)mapResultFinal.get("W_QUANTITY");
			int perH_quatity = (Integer)mapResultFinal.get("H_QUANTITY");
			int maxL_quatity = (Integer)mapResultFinal.get("L_QUANTITY");
			
			for (int x = 1 ; x <= maxL_quatity ; x++ ) {
				int total_put = ( x * ( perW_quatity * perH_quatity) );
				
				if ( tmpOrderDetailVO.getOrderAmt() > total_put ) {
					putQuatity = total_put;
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
