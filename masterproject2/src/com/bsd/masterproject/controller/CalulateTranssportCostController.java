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
import com.bsd.masterproject.utils.ObjectUtils;
import com.bsd.masterproject.vo.BoxVO;
import com.bsd.masterproject.vo.ColorVO;
import com.bsd.masterproject.vo.OrderDetailVO;
import com.bsd.masterproject.vo.OrderVO;
import com.bsd.masterproject.vo.ProductVO;

public class CalulateTranssportCostController {

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
		productList.add(flower);
		productList.add(bee);
		productList.add(heartBar);
		productList.add(heart);
		productList.add(iceCreme);
		productList.add(grape);
		productList.add(strawS);
		
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

		// Step 0 Validate Order Data
		if ( validateOrderData(order) ) {
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
				listOrderDetailTemp = (ArrayList<OrderDetailVO>)ObjectUtils.deepClone((Object)listOrderDetail);
				
				// Add กล่องที่ใช้ได้เข้า List box Final
				if ( isBoxUsable(tmpBoxVO, listOrderDetailTemp) ) {
					listBoxVOFinal.add(tmpBoxVO);
				}
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
	private boolean isBoxUsable(BoxVO boxVO, List<OrderDetailVO> listOrderDetailVO ) {
		
		boolean resUsable = true;
		Map<String, ProductVO> mapProductVO = getMapAllProductType();
		
		ProductVO tmpProductVO;
		for( OrderDetailVO tmpOrderDetailVO : listOrderDetailVO ){
			tmpProductVO = mapProductVO.get( tmpOrderDetailVO.getProdCode() );
			
			if ("P".equals(tmpProductVO.getPackageType())) {
				// แบบ Package วนตัด ปริภมาตร ภายในออก 
				if ( boxVO.getCapacity() >= tmpProductVO.getCapacity() ) {
					boxVO.setCapacity( boxVO.getCapacity() - tmpProductVO.getCapacity() );
				} else {
					resUsable = false;
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
				
				// เอา รูปแบบจัดเรีบงที่ใช้ได้มาเลือก โดยดูจากพื้นที่เหลือ
				
				
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
		
		// รูปแบบการเรียงสบู่ มี 4 แบบ
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
				
			} else {
				// ใส่ได้ หาจำนวน กับพื้นที่ว่างเหลือ
				double w_quantity = Math.round( sideW/pSideW );
				double w_point = sideW - ( pSideW * w_quantity );
				
				double l_quantity = Math.round( sideL/pSideL );
				double l_point = sideL - ( pSideL * l_quantity );
				
				resultMap.put("W_QUANTITY", Integer.parseInt( String.valueOf( w_quantity ) ) );
				resultMap.put("W_POINT", Integer.parseInt( String.valueOf( w_point ) ));
				
				resultMap.put("L_QUANTITY", Integer.parseInt( String.valueOf( l_quantity ) ) );
				resultMap.put("L_POINT", Integer.parseInt( String.valueOf( l_point ) ));
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
				
			} else {
				// ใส่ได้ หาจำนวน กับพื้นที่ว่างเหลือ
				double w_quantity = Math.round( sideW/pSideL );
				double w_point = sideW - ( pSideL * w_quantity );
				
				double l_quantity = Math.round( sideL/pSideW );
				double l_point = sideL - ( pSideW * l_quantity );
				
				resultMap.put("W_QUANTITY", Integer.parseInt( String.valueOf( w_quantity ) ) );
				resultMap.put("W_POINT", Integer.parseInt( String.valueOf( w_point ) ));

				resultMap.put("L_QUANTITY", Integer.parseInt( String.valueOf( l_quantity ) ) );
				resultMap.put("L_POINT", Integer.parseInt( String.valueOf( l_point ) ));
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

			} else {
				// ใส่ได้ หาจำนวน กับพื้นที่ว่างเหลือ
				double quantity = Math.round( sideW/pSideH );
				double point = sideW - ( pSideH * quantity );

				double l_quantity = Math.round( sideL/pSideL );
				double l_point = sideL - ( pSideL * l_quantity );
				
				resultMap.put("QUANTITY", Integer.parseInt( String.valueOf( quantity ) ) );
				resultMap.put("POINT", Integer.parseInt( String.valueOf( point ) ));

				resultMap.put("L_QUANTITY", Integer.parseInt( String.valueOf( l_quantity ) ) );
				resultMap.put("L_POINT", Integer.parseInt( String.valueOf( l_point ) ));
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

			} else {
				// ใส่ได้ หาจำนวน กับพื้นที่ว่างเหลือ
				double quantity = Math.round( sideW/pSideL );
				double point = sideW - ( pSideL * quantity );

				double l_quantity = Math.round( sideL/pSideH );
				double l_point = sideL - ( pSideH * l_quantity );
				
				resultMap.put("QUANTITY", Integer.parseInt( String.valueOf( quantity ) ) );
				resultMap.put("POINT", Integer.parseInt( String.valueOf( point ) ));

				resultMap.put("L_QUANTITY", Integer.parseInt( String.valueOf( l_quantity ) ) );
				resultMap.put("L_POINT", Integer.parseInt( String.valueOf( l_point ) ));
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

			} else {
				// ใส่ได้ หาจำนวน กับพื้นที่ว่างเหลือ
				double quantity = Math.round( sideW/pSideW );
				double point = sideW - ( pSideW * quantity );

				double l_quantity = Math.round( sideL/pSideH );
				double l_point = sideL - ( pSideH * l_quantity );
				
				resultMap.put("QUANTITY", Integer.parseInt( String.valueOf( quantity ) ) );
				resultMap.put("POINT", Integer.parseInt( String.valueOf( point ) ));

				resultMap.put("L_QUANTITY", Integer.parseInt( String.valueOf( l_quantity ) ) );
				resultMap.put("L_POINT", Integer.parseInt( String.valueOf( l_point ) ));
				
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

			} else {
				// ใส่ได้ หาจำนวน กับพื้นที่ว่างเหลือ
				double quantity = Math.round( sideW/pSideH );
				double point = sideW - ( pSideH * quantity );

				double l_quantity = Math.round( sideL/pSideW );
				double l_point = sideL - ( pSideW * l_quantity );
				
				resultMap.put("QUANTITY", Integer.parseInt( String.valueOf( quantity ) ) );
				resultMap.put("POINT", Integer.parseInt( String.valueOf( point ) ));

				resultMap.put("L_QUANTITY", Integer.parseInt( String.valueOf( l_quantity ) ) );
				resultMap.put("L_POINT", Integer.parseInt( String.valueOf( l_point ) ));
				
			}
		}
		
		
		return resultMap;
	}
}
