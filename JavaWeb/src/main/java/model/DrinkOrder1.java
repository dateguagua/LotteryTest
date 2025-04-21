package model;

import java.util.Map;

public class DrinkOrder1{
	private String type;
	private String size;
	private boolean ice ;
	private int price;
	
	private static final Map<String, Map<String, Integer>>priceTable = Map.of(
			"greentea", Map.of("S" ,30, "M" ,50 ,"L" ,50),
			"blacktea", Map.of("S" ,45, "M" ,55 ,"L" ,65),
			"milktea", Map.of("S" ,40, "M" ,45 ,"L" ,60));
	
	private static final Map<String,String>sizeTable =Map.of("S","小","M","中","L","大");
	private static final Map<Boolean, String> iceTable =Map.of(true,"yes",false,"no");
	
	public DrinkOrder1(String type, String size,String ice ){ //欄位是你的物件有什麼屬性 建構子是你建立物件時怎麼把值裝進這些欄位裡
		this.type=type;
		this.size=size;
		this.ice =Boolean.parseBoolean(ice); //如果字串是 "true"（大小寫不拘），回傳 true
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
	
	public boolean isIce() {
		return ice;
	}

	public String getIceText() {
		return iceTable.get(ice);
	}
	
	public String getInfo() {
		String sizeText =sizeTable.get(size);
		String iceText =iceTable.get(ice);
		return String.format("您點了一杯 %s %s 飲料(%s) 價格：%d", type,sizeText,iceText,price);
		
	}

}
