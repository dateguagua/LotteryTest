package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.CoffeeMaker;
import model.User;

@WebServlet("/CoffeeMaker")
public class CoffeeMakerServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/coffee_form.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1 請求編碼
		req.setCharacterEncoding("UTF-8");
		// 2 接收參數
		String milk = req.getParameter("milk");
		String coffee = req.getParameter("coffee");

		// 3 將參數資料注入到model中（User.java)
		CoffeeMaker coffeeType  = new CoffeeMaker(milk, coffee);

		// 4 分派到/WEB-INF/user_result.jsp
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/coffee_result.jsp");
		req.setAttribute("CoffeeMaker", coffeeType); // 將資料送給jsp
		rd.forward(req, resp);
	}

	
}
