package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.editDAO;

/**
 * Servlet implementation class MasterController
 */
@WebServlet("/home")
public class MasterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			editDAO dao = new editDAO();
			request.setAttribute("rows", dao.select_me(1));
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// リクエストスコープへのデータ格納（リストデータの格納）
			request.setAttribute("message", "例外が発生しました");
			String view = "WEB-INF/view/error.jsp";
			// 転送オブジェクトを取得
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			// 転送
			dispatcher.forward(request, response);
		}
		
		String view = "/WEB-INF/views/home.jsp";
        request.getRequestDispatcher(view).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(request, response);
	}

}
