package servlet;

import java.io.IOException;
import model.DrinkOrder1;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/DrinkOrder")
public class DrinkOrderServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 設定編碼（中文）
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		String type = req.getParameter("type");
		String size = req.getParameter("size");
		String ice = req.getParameter("ice");
		
		if (type==null||size==null||ice==null) { 
		resp.getWriter().print("輸入參數不正確");
		return; //「這裡就結束方法，不繼續往下執行。」
		}
		
		DrinkOrder1 drinkOrder =new DrinkOrder1(type, size, ice);
		//resp.getWriter().print(drinkOrder.getinfo()); 
		//想把資料傳給 JSP 顯示 這行先確定有沒有成功
		
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/drink_order.jsp");
		req.setAttribute("drinkOrder", drinkOrder);
		rd.forward(req, resp); //正式把 request + response 導向剛剛指定的 JSP 頁面，並結束 Servlet 執行流程
	}

}
