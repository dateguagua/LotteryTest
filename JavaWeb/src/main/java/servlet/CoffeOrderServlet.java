package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.Util;
import model.CoffeOrder1;

@WebServlet("/CoffeeOrder")
public class CoffeOrderServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 設定編碼（中文）
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");

		String type = req.getParameter("type");
		String size = req.getParameter("size");
		String sugar = req.getParameter("sugar");
		
		//判斷參數
		if (type==null || size==null || sugar==null) {
			resp.getWriter().print("參數輸入不正確");
			return;
		}
		//進行商業邏輯
		CoffeOrder1 coffeOrder = new CoffeOrder1(type,size,sugar);
		//resp.getWriter().print(coffeOrder.getInfo());
		
		RequestDispatcher rd=req.getRequestDispatcher("/WEB-INF/coffee_order.jsp");
		req.setAttribute("coffeOrder", coffeOrder);
		rd.forward(req, resp);
	}

}
	

