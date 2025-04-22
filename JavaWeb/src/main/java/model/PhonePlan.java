package model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;

public class PhonePlan {
	private Integer min; //通話分鐘
	private Integer flow; //流量
	
	static class phoneFt{
		// 方案類型名稱
		private String type;
		private Integer price;
		// 條件的判斷邏輯
		private BiPredicate<Integer,Integer> condition;
		
		public phoneFt(String type, Integer price ,BiPredicate<Integer,Integer> condition) {
			this.type = type;
			this.price = price;
			this.condition = condition;
		}

		// 符合比對
		public boolean matches(Integer min, Integer flow) {
			return condition.test(min, flow);
		}
		
		public String getResult() {
			return type + ":$" + price ;
		}
	}
		// 可以儲存所有方案規則的清單
		private static final List<phoneFt> rules = new ArrayList<>();
		
		// 類別資料初始化區段
		static {
			// 初始化規則
			rules.add(new phoneFt("商務型",1499, 
					(min, flow) -> min >1000 || flow >50));
			rules.add(new phoneFt("一般用戶型",660, 
					(min, flow) -> min >500 && flow >10));
			rules.add(new phoneFt("長輩節省型",200, 
					(min, flow) -> min <200 && flow <1));
		}
		//建構子
		public PhonePlan(Integer min, Integer flow) { //建構子的名稱必須跟你外部類別的名稱一致（這裡是 PhonePlan）
			this.min =min;
			this.flow=flow;
		}
		
		// 推薦方案
		public String getPhoneFt() {
			return rules.stream()
						.filter(rule -> rule.matches(min, flow)) // 找出符合條件的規則
						.findFirst()                                // 取得第一筆匹配的
						//.map(CoffeeRule::getResult)                // 傳換成字串
						.map(rule -> rule.getResult())   			// 傳換成字串
						.orElse("無適合方案");
		}
		
		// Getter
		public Integer getMin() {
			return min;
		}
		
		public Integer getFlow() {
			return flow;
		}
}
