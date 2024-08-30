package edu.kh.jdbc.controller;

import java.io.IOException;
import java.util.List;

import edu.kh.jdbc.dto.User;
import edu.kh.jdbc.service.UserService;
import edu.kh.jdbc.service.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/search")
public class SearchServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			// 파라미터 얻어오기
			String searchId = req.getParameter("searchId");
			
			// 검색어가 아이디에 포함된 사용자 모두 조회하는
			// 서비스 호출후 결과 반환받기 
			
			// 몇명을 받을지 모르겠다면 List<?> ㄱㄱ
			UserService service = new UserServiceImpl();
			List<User> userList = service.search(searchId);
			
			// request scope에 userList 세팅
			req.setAttribute("userList", userList);
			
			// forward할 jps경로
			String path = "/WEB-INF/views/selectAll.jsp";
			req.getRequestDispatcher(path).forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
