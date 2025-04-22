package model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;

/*
 * 可擴充: add(...)
 * 邏輯可分離: 條件與邏輯分開
 * 容易測試
 * 可以利用 lambda 開發與理解上較為值觀
 * */
public class CoffeeMaker_1 {
	private Double milk;
	private Double coffee;
	
	// 建立一個內部類別來代表一種咖啡類型的判斷規則
	static class CoffeeRule {
		// 咖啡類型名稱
		private String type;
		// 咖啡描述
		private String description;
		// 條件的判斷邏輯
		private BiPredicate<Double, Double> condition; //一個可以接收兩個 Double 數字，並回傳 true 或 false 的條件判斷邏輯
		
		public CoffeeRule(String type, String description, BiPredicate<Double, Double> condition) {
			this.type = type;
			this.description = description;
			this.condition = condition;
		}
		
		// 符合比對
		public boolean matches(Double milk, Double coffee) {
			return condition.test(milk, coffee);
		} //會根據你先前設定的 condition（一個 BiPredicate<Double, Double>）來測試兩個數值是否符合某個邏輯條件
		
		public String getResult() {
			return type + ": " + description;
		}
		
	}
	
	// 可以儲存所有咖啡規則的清單
	private static final List<CoffeeRule> rules = new ArrayList<>();
	
	// 類別資料初始化區段
	static {
		// 初始化規則 當這個類別第一次被載入時（class loading），這段區塊就會被執行一次
		rules.add(new CoffeeRule("濃郁的拿鐵", "牛奶的比例遠高於咖啡，味道偏向牛奶。", 
				(milk, coffee) -> milk >= 3 * coffee));
		rules.add(new CoffeeRule("平衡的拿鐵咖啡", "牛奶與咖啡的比例較為平衡，風味溫和。", 
				(milk, coffee) -> milk >= 1.5 * coffee));
		rules.add(new CoffeeRule("標準卡布奇諾", "牛奶與咖啡的比例恰到好處，典型的卡布奇諾", 
				(milk, coffee) -> milk.equals(coffee))); // milk == coffee
		rules.add(new CoffeeRule("濃縮咖啡", "咖啡的比例遠高於牛奶，口感濃烈，偏向純咖啡。", 
				(milk, coffee) -> coffee >= 3 * milk));
		rules.add(new CoffeeRule("普通咖啡", "牛奶與咖啡的比例較為普通，適合日常飲用。", 
				(milk, coffee) -> true));
		
	}
	
	// Coffee 建構子
	public CoffeeMaker_1(Double milk, Double coffee) {
		this.milk = milk;
		this.coffee = coffee;
	}
	
	public CoffeeMaker_1(String milk, String coffee) {
		this(Double.parseDouble(milk), Double.parseDouble(coffee));
	}
	
	// 判斷咖啡類型
	public String getCoffeeType() {
		return rules.stream()
					.filter(rule -> rule.matches(milk, coffee)) // 找出符合條件的規則
					.findFirst()                                // 取得第一筆匹配的
					//.map(CoffeeRule::getResult)               // 傳換成字串
					.map(rule -> rule.getResult())              // 傳換成字串
					.orElse("無法辨識的咖啡類型");
	}
	
	// Getter
	public Double getMilk() {
		return milk;
	}
	
	public Double getCoffee() {
		return coffee;
	}
	
}