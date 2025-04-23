package case03;

import java.util.Map;

public class MainDish {

	private String name;
	private int price;
	
	private static final Map<String, Integer>Price_MAP =Map.of("挫冰", 50, "豆花", 40);
	
	public MainDish(String name) 
	{
		this.name =name;
		this.price =Price_MAP.get(name) ;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}
	
}
