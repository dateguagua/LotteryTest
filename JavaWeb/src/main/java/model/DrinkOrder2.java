package model;

import java.util.Map;

public class DrinkOrder2{
	private String type;
	private String size;
	private String ice ;
	private String sugar ;
	private int price;
	
	private static final Map<String, Map<String, Integer>>priceTable = Map.of(
			"greentea", Map.of("S" ,30, "M" ,50 ,"L" ,50),
			"blacktea", Map.of("S" ,45, "M" ,55 ,"L" ,65),
			"milktea", Map.of("S" ,40, "M" ,45 ,"L" ,60));
	
	private static final Map<String,String>sizeTable =Map.of("S","小","M","中","L","大");
	private static final Map<String, String> iceTable =Map.of("normal","正常","less","少冰","out","去冰");
	private static final Map<String, String>sugarTable =Map.of("normal","正常","less","少糖","out","無糖");
	
	public DrinkOrder2(String type, String size,String ice, String sugar ){ //欄位是你的物件有什麼屬性 建構子是你建立物件時怎麼把值裝進這些欄位裡
		this.type=type;
		this.size=size;
		this.ice =ice;
		this.sugar=sugar;
		this.price =priceTable.get(type).get(size); 
		//根據使用者選擇的 type（飲料種類）和 size（尺寸），
		//從價格對照表 priceTable 中查出正確的價格，然後指派給 this.price
		
	}

	public String getType() {
		return type;
	}
	
	public String getSizeText() {
		return sizeTable.get(size);
	}

	public String getIceText() {
		return iceTable.get(ice);
	}
	
	public String getSugarText() {
		return sugarTable.get(sugar);
	}
	
	public String getInfo() {
		String sizeText =sizeTable.get(size);
		String iceText =iceTable.get(ice);
		String sugarText=sugarTable.get(sugar);
		return String.format("您點了一杯 %s %s (%s %s) 價格：%d元", type,sizeText,iceText,sugarText,price);
		
	}

}

