package model;

import org.apache.tomcat.util.digester.Rules;

public class CoffeeMaker {
	 private Double milk;
	 private Double coffee;
	 private String type;
	 private String describe;
	 
	public CoffeeMaker(String milk, String coffee)
	{
		//this(Double.parseDouble(milk),Double.parseDouble(coffee));
		this.milk =Double.parseDouble(milk);
		this.coffee =Double.parseDouble(coffee);
		setType();
		setDescribe();
	}

	
	public Double getMilk() {
		return milk;
	}

	public Double getCoffee() {
		return coffee;
	}

	
	public void setType() {
	    if (coffee >= milk * 3) {
	        this.type = "濃縮咖啡";
	    } else if (Math.abs(milk - coffee) < 0.01) {
	        this.type = "標準卡布奇諾";
	    } else if (milk >= coffee * 1.5 && milk < coffee * 3) {
	        this.type = "平衡的拿鐵咖啡";
	    } else if (milk >= coffee * 3) {
	        this.type = "濃郁的拿鐵";
	    } else {
	        this.type = "普通咖啡";
	    }
	}


	public void setDescribe() {
		if (coffee >= milk * 3) {
			this.describe = "咖啡的比例遠高於牛奶，口感濃烈，偏向純咖啡";
		} else if (Math.abs(milk - coffee) < 0.01) { // 用浮點誤差容忍
			this.describe = "牛奶與咖啡的比例恰到好處，典型的卡布奇諾";
		} else if (milk >= coffee * 1.5 && milk < coffee * 3) {
			this.describe = "牛奶與咖啡的比例較為平衡，風味溫和";
		} else if (milk >= coffee * 3) {
			this.describe = "牛奶的比例遠高於咖啡，味道偏向牛奶";
		} else {
			this.describe = "牛奶與咖啡的比例較為普通，適合日常飲用";
		}
	}


	public String getType() {
		return type;
	}

	public String getDescribe() {
		return describe;
	}
	
}
