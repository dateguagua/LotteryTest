package servlet;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.GuestBook;

@WebServlet("/guestbook")
public class GuestBooksServlet extends HttpServlet {

	private static final List<GuestBook> guestbooks = new CopyOnWriteArrayList<>(); //解決同時讀寫List 的問題

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("WEB-INF/guestbook_form.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String message= req.getParameter("message"); // 取得表單中的留言內容
		GuestBook guestBook = new GuestBook(message); // 建立  guestbook 物件
		guestbooks.add(guestBook); // 加入到 guestbooks 集合中
		RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/guestbook_result.jsp");
		req.setAttribute("message", message); // 本次留言
		req.setAttribute("guestbooks", guestbooks); // 歷史留言
		rd.forward(req, resp);
	}
	
	
}
