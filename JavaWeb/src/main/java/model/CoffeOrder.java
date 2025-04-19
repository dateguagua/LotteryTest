package model;

import java.util.Map;

public class CoffeOrder {
	private String type;
	private String size;
	private boolean sugar;
	private int price;
	
	//價格對照表
	private static final Map<String, Map<String, Integer>> priceTable =Map.of( //final找的速度最快
			"Latte", Map.of("S", 50, "M", 70, "L", 90),
			"Mocha", Map.of("S", 45, "M", 55, "L", 65),
			"Americano", Map.of("S", 40, "M", 45, "L", 60),
			"Cappuccino", Map.of("S", 55, "M", 80, "L", 100));
	private static final Map<String, String>sizeTable = Map.of("S","小","M","中","L","大");
	private static final Map<Boolean, String>sugarTable = Map.of(true,"有糖",false,"無糖");
	
	public CoffeOrder(String type,String size, String sugar) {
		this.type=type;
		this.size=size;
		this.sugar = Boolean.parseBoolean(sugar);
		this.price = priceTable.get(type).get(size);
	} 
	
	public String getInfo() {
		String sizeText =sizeTable.get(size);
		String sugarText =sugarTable.get(sugar);
		return String.format("您點了一杯 %s %s 咖啡(%s) 價格：%d元", size,type,sugar,price);
	}
}
