package util;

import java.awt.List;

//工具類
public class Util {

	//判斷是否為數字
		public static boolean isNumber(String data) {
			try {
				Integer.parseInt(data);
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		
		//判斷是否為數字
		public static boolean isNumber2(String data) {
			if(data == null)return false;
			return data.matches("\\d+");
		}
		
		//判斷是否為浮點數字
		public static boolean isDouble(String data) {
			try {
				Double.parseDouble(data);
				return true;
			} catch (Exception e) {
				return false;
			}
		}

}
