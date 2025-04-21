package model;

import java.security.PrivateKey;

public class User {
	private String userName; //form表單欄位
	private String gender;
	private Integer age;
	private Double height;
	private Double weight;
	private Double bMIValue; //自建欄位
	private String result;
	
	public User(String userName, String gender, String age, String height,String weight)
	{
		this.userName =userName;
		this.gender=gender;
		this.age =Integer.parseInt(age);
		this.height=Double.parseDouble(height);
		this.weight=Double.parseDouble(weight);
		this.bMIValue=this.weight/Math.pow(this.height/100, 2);
		setResult(); //呼叫一個方法，根據 BMI 值和性別設定結果
		
	}
	
	private void setResult() {
		double min =0,max=0;
		switch(gender) {
		case "male":
			min=17.4;
			max=23.3;
			break;
		case "female":
			min=17.1;
			max=22.7;
			break;
		}
		String result = bMIValue < min ? "過瘦":bMIValue > max ? "過胖":"正常";
		this.result=result;
	}
	
	//方法封裝getter

	public String getUserName() {
		return userName;
	}

	public String getResult() {
		return result;
	}

	public String getGender() {
		return gender;
	}

	public Integer getAge() {
		return age;
	}

	public Double getHeight() {
		return height;
	}

	public Double getWeight() {
		return weight;
	}

	public Double getbMIValue() {
		return bMIValue;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", gender=" + gender + ", age=" + age + ", height=" + height + ", weight="
				+ weight + ", bMIValue=" + bMIValue + ", toString()=" + super.toString() + "]";
	}
	
	
	
}
