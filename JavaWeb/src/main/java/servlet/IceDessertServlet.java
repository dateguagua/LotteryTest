package servlet;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import case03.IceOrder;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.GuestBook;


@WebServlet("/Ice")
public class IceDessertServlet extends HttpServlet {

	private static final List<IceOrder> iceOrders = new CopyOnWriteArrayList<>(); //解決同時讀寫List 的問題
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//String indexStr = req.getParameter(req.getContextPath() + "index");
		//Servlet 去找 "JavaWebindex" 這個參數（找不到），所以 indexStr == null，根本不會進入刪除流程！
		String indexStr = req.getParameter("index");
		if(indexStr != null) { //==null就不用刪
			try {
				int index = Integer.parseInt(indexStr);
				if (index >= 0 && index < iceOrders.size()) { //檢查這個 index 是不是有效範圍
					iceOrders.remove(index);
				}
			} catch (NumberFormatException e) {
				System.out.println("刪除失敗：index 格式錯誤");
			}
		
			resp.sendRedirect(req.getContextPath() + "/Ice"); //刪除完後重新導向 /Ice，重新整理頁面
			return;
		}
		// 沒有要刪除，就單純顯示列表
		req.setAttribute("iceOrders", iceOrders);
		req.getRequestDispatcher("/WEB-INF/ice_dessert_form.jsp").forward(req, resp);
	}
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		// 取得表單參數
		String mainDishName= req.getParameter("mainDish"); //單選項的輸入
		String[] toppingArray= req.getParameterValues("toppings"); //多選項的輸入
		
		//建立IceOrder
		IceOrder iceOrder =new IceOrder(mainDishName, toppingArray);
		
		//建立到訂單集合
		iceOrders.add(iceOrder);
		
		RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/ice_dessert_result.jsp");
		req.setAttribute("iceOrders", iceOrders); 
		rd.forward(req, resp);
	}
}
