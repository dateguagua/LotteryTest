package case03;

import java.util.List;
import java.util.Arrays;

public class Topping {
	private List<String> toppings; //配料集合
	private static final int TOPPING_PRICE =10; //final是確保後面不能改
	
	public Topping(String[] toppingArray) 
	//用 new Topping(...) 建立物件時，
	//這段程式會執行，將傳進來的陣列（String[] toppingArray）轉換成 List<String>，存到物件的屬性 toppings 裡
	{
		this.toppings =(toppingArray == null) ? null : Arrays.asList(toppingArray);
	}//條件 ? 成立時的值 : 不成立時的值
	
	public List<String> getToppings()
	{
		return toppings;
	}
	
	//計算配料金額
	public int calculateToppingPrice()
	{
		return(toppings == null)? 0 :toppings.size()*TOPPING_PRICE;
	}
} 
