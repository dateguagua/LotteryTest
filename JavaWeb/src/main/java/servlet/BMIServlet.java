package servlet;

import java.io.IOException;

import util.Util;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/BMI")
public class BMIServlet extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//設定編碼（中文）
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		String height=req.getParameter("h");
		String weight=req.getParameter("w");
		
		if (!(Util.isDouble(height)&&(Util.isDouble(weight)))) {
			resp.getWriter().print("身高體重輸入錯誤");
			return;
		}
		//計算bmi
		double h=Double.parseDouble(height);
		double w=Double.parseDouble(weight);
		double bmiValue = getBMIValue(h,w);
		String result = getBMIResult(bmiValue);
		
		resp.getWriter().print("BMI值＝"+bmiValue+"("+result+")");
		
		}
		
		private double getBMIValue(double h, double w) {
		return w / Math.pow(h/100, 2) ;
	}
		private String getBMIResult(double bmiValue) {
			return bmiValue <= 18 ? "過輕":(bmiValue > 23)? "過重" : "正常" ;
		}
}


